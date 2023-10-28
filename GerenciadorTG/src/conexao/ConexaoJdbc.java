package conexao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class ConexaoJdbc {
    
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost/tg";
        String username = "gerenciamento_user";
        String password = "admin123";
        String filePath = "C://Users//paulo//Documents//arquivo.csv";
        int batchSize = 20;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(jdbcUrl, username,password);
            connection.setAutoCommit(false);

            String orientadorSQL = "INSERT IGNORE INTO Orientador(emailFatec, nome) VALUES (?, ?)";
            PreparedStatement orientadorStatement = connection.prepareStatement(orientadorSQL);

            

            String alunoSQL = "INSERT IGNORE INTO Aluno(emailFatec, emailFornecido, nome, orientador_emailFatec) VALUES (?, ?, ?, ?)";
            PreparedStatement alunoStatement = connection.prepareStatement(alunoSQL);

            String tgSQL = "INSERT IGNORE INTO Tg(tipo, empresa_envolvida, problema, disciplina) VALUES (?, ?, ?,  ?)";
            PreparedStatement tgStatement = connection.prepareStatement(tgSQL);

            Set<String> uniqueOrientadores = new HashSet<>();

            try (BufferedReader lineReader = new BufferedReader(new FileReader(filePath))) {
                String lineText = null;
                int count = 0;

                lineReader.readLine(); 
                while ((lineText = lineReader.readLine()) != null) {
                    String[] data = lineText.split(",");

                    String orientadorEmailFatec = data[5];
                    String orientadorNome = data[4];

                    
                    String orientadorKey = orientadorEmailFatec + orientadorNome;

                    if (!uniqueOrientadores.contains(orientadorKey)) {
                        uniqueOrientadores.add(orientadorKey);
                        orientadorStatement.setString(1, orientadorEmailFatec);
                        orientadorStatement.setString(2, orientadorNome);
                        orientadorStatement.addBatch();
                    }

                   

                    String alunoEmailFatec = data[2];
                    String alunoEmailFornecido = data[1];
                    String alunoNome = data[3];

                    if (!recordExists(connection, "Aluno", "emailFatec", alunoEmailFatec) &&
                        !recordExists(connection, "Aluno", "emailFornecido", alunoEmailFornecido)) {
                        alunoStatement.setString(1, alunoEmailFatec);
                        alunoStatement.setString(2, alunoEmailFornecido);
                        alunoStatement.setString(3, alunoNome);
                        alunoStatement.setString(4, orientadorEmailFatec);
                        
                        alunoStatement.addBatch();
                    }

                    String tgTipo = data[7];                    
                    String tgProblema = data[8];
                    String tgEmpresa = data[9];
                    String tgDisciplina = data[10];
                    
                    if (!recordExists(connection, "Tg", "tipo", tgTipo) &&
                        !recordExists(connection, "Tg", "empresa_envolvida", tgEmpresa) &&
                        !recordExists(connection, "Tg", "problema", tgProblema) &&
                        !recordExists(connection, "Tg", "disciplina", tgDisciplina)) {
                        tgStatement.setString(1, tgTipo);
                        tgStatement.setString(2, tgEmpresa);
                        tgStatement.setString(3, tgProblema);
                        tgStatement.setString(4, tgDisciplina);
                       
                        tgStatement.addBatch();
                    }

                    if (++count % batchSize == 0) {
                        orientadorStatement.executeBatch();

                        alunoStatement.executeBatch();
                        tgStatement.executeBatch();
                    }
                }
            }
            
            orientadorStatement.executeBatch();

            alunoStatement.executeBatch();
            tgStatement.executeBatch();

            connection.commit();
            connection.close();
            System.out.println("Dados inseridos com sucesso.");

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static boolean recordExists(Connection connection, String tableName, String columnName, String value) throws Exception {
        if (tableName.equals("Orientador") && (columnName.equals("emailFatec") || columnName.equals("nome"))) {
            String sql = "SELECT COUNT(*) AS count FROM " + tableName + " WHERE " + columnName + " = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, value);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt("count");
            resultSet.close();
            return count > 0;
        } else {
            
            String sql = "SELECT COUNT(*) AS count FROM " + tableName + " WHERE " + columnName + " = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, value);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt("count");
            resultSet.close();
            return count > 0;
        }
    }
}