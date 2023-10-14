
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect{
    
    
    public static void main (String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/gerenciador";
        String username = "root";
        String password = "109081";
        String filePath = "trabalhodegraduacaoCorrigido.csv";
        int batchSize = 20;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            connection.setAutoCommit(false);

            String orientadorSQL = "insert into Orientador(emailFatec, nome) values(?,?)";
            PreparedStatement orientadorStatement = connection.prepareStatement(orientadorSQL);

            String turmaSQL = "insert into Turma(semestre_ano) values(?)";
            PreparedStatement turmaStatement = connection.prepareStatement(turmaSQL);

            String alunoSQL = "insert into Aluno(emailFatec, emailFornecido, nome, orientador_emailFatec) values(?, ?, ?, ?)";
            PreparedStatement alunoStatement = connection.prepareStatement(alunoSQL);

            String tgSQL = "insert into TG(tipo, empresa_envolvida, problema, disciplina) values(?, ?, ?, ?)";
            PreparedStatement tgStatement = connection.prepareStatement(tgSQL);

            BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
            String lineText = null;
            int count = 0;

            lineReader.readLine(); // Pular o cabeçalho
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");

                String orientadorEmailFatec = data[5];
                String orientadorNome = data[4];
                if (!isOrientadorAlreadyExist(connection, orientadorEmailFatec)) {
                    // Se o orientador não existe, insira-o na tabela Orientador
                    orientadorStatement.setString(1, orientadorEmailFatec);
                    orientadorStatement.setString(2, orientadorNome);
                    orientadorStatement.addBatch();
                }
                

                String turma = data[6];
                turmaStatement.setString(1, turma);
                turmaStatement.addBatch();

                String alunoEmailFatec = data[2];
                String alunoEmailFornecido = data[1];
                String alunoNome = data[3];

                alunoStatement.setString(1, alunoEmailFatec);
                alunoStatement.setString(2, alunoEmailFornecido);
                alunoStatement.setString(3, alunoNome);
                alunoStatement.setString(4, orientadorEmailFatec);
                
                alunoStatement.addBatch();

                String tipoTg = data[7];
                String problema = data[8];
                String empresa = data[9];
                String disciplina = data[10];


                tgStatement.setString(1, tipoTg);
                tgStatement.setString(2, empresa);
                tgStatement.setString(3, problema);
                tgStatement.setString(4, disciplina);
                tgStatement.addBatch();

                if (++count % batchSize == 0) {
                    orientadorStatement.executeBatch();
                    turmaStatement.executeBatch();
                    alunoStatement.executeBatch();
                    tgStatement.executeBatch();
                }
            }

            // Executar quaisquer lotes pendentes e confirmar a transação
            orientadorStatement.executeBatch();
            turmaStatement.executeBatch();
            alunoStatement.executeBatch();
            tgStatement.executeBatch();

            connection.commit();
            connection.close();
            System.out.println("Data has been inserted successfully.");

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    private static boolean isOrientadorAlreadyExist(Connection connection, String emailFatec) {
        try {
            String query = "SELECT emailFatec FROM Orientador WHERE emailFatec = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, emailFatec);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }    
}

