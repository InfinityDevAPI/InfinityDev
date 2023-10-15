
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect{
    
    
    /**
     * @param args
     */
    public static void main (String[] args ) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/alunos";
        String username = "root";
        String password = "109081";
        String filePath = "Documentos//trabalhodeGraduacao-202302.csv";
        int batchSize = 20;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            connection.setAutoCommit(false);

            String sql = "insert into alunos(emailPessal,emailFatec,nome,nomeOrientador,emailOrientador,Matriculado,Tipotg,problema,empresa,disciplina) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
            String lineText = null;
            int count = 0;

            lineReader.readLine(); // Pular o cabeçalho
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");

                String emailPessoal = data[1];
                String emailFatec = data[2];
                String nome = data[3];
                String nomeOrientador = data[4];
                String emailOrientador = data[5];
                String matriculado = data[6];
                String tipoTG = data[7];
                String problema = data[8];
                String empresa = data[9];
                String disciplina = data[10];

                statement.setString(1, emailPessoal);
                statement.setString(2, emailFatec);
                statement.setString(3,nome);
                statement.setString(4, nomeOrientador);
                statement.setString(5, emailOrientador);
                statement.setString(6, matriculado);
                statement.setString(7, tipoTG);
                statement.setString(8, problema);
                statement.setString(9, empresa);
                statement.setString(10, disciplina);

                statement.addBatch();
                if (++count % batchSize == 0) {
                    statement.executeBatch();
                }
            }

            // Executar quaisquer lotes pendentes e confirmar a transação
            lineReader.close();
            statement.executeBatch();
            connection.commit();
            System.out.println("Data has been inserted successfully.");

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
}

