

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GerenciamentoTgDAO {
    private Connection connection;
    
    public GerenciamentoTgDAO() {
        try {
            // Configurar a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:mysql://localhost/gerenciamentotg", "gerenciamento_user", "admin123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Método para inserir um novo orientador
    public void inserirOrientador(String emailFatec, String nome) {
        String sql = "INSERT INTO Orientador (emailFatec, nome) VALUES (?, ?)";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, emailFatec);
            preparedStatement.setString(2, nome);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Método para inserir uma nova turma
    public void inserirTurma(String semestre_ano) {
        String sql = "INSERT INTO Turma (semestre_ano) VALUES (?)";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, semestre_ano);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Método para inserir um novo aluno
    public void inserirAluno(String emailFatec, String emailFornecido, String nome, String orientadorEmail, int turmaId) {
        String sql = "INSERT INTO Aluno (emailFatec, emailFornecido, nome, orientador_emailFatec, turma_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, emailFatec);
            preparedStatement.setString(2, emailFornecido);
            preparedStatement.setString(3, nome);
            preparedStatement.setString(4, orientadorEmail);
            preparedStatement.setInt(5, turmaId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para inserir dados da entrega 
    public void inserirEntrega(String descricao, String dataEntrega, int turmaId, String feedback, float nota) {
        String sql = "INSERT INTO Entrega (descricao, data_entrega, turma_id, feedback, nota) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, descricao);
            preparedStatement.setString(2, dataEntrega);
            preparedStatement.setInt(3, turmaId);
            preparedStatement.setString(4, feedback);
            preparedStatement.setFloat(5, nota);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para inserir dados do TG
    public void inserirTG(String tipo, String empresaEnvolvida, String problema, String disciplina) {
        String sql = "INSERT INTO TG (tipo, empresa_envolvida, problema, disciplina) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, tipo);
            preparedStatement.setString(2, empresaEnvolvida);
            preparedStatement.setString(3, problema);
            preparedStatement.setString(4, disciplina);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Método para editar dados do TG
    public void editarOrientador(String emailFatec, String novoNome) {
        String sql = "UPDATE Orientador SET nome = ? WHERE emailFatec = ?";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, novoNome);
            preparedStatement.setString(2, emailFatec);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Método para deletar dados do TG
    public void deletarOrientador(String emailFatec) {
        String sql = "DELETE FROM Orientador WHERE emailFatec = ?";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, emailFatec);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Método para buscar dados do TG
    public List<Aluno> buscarAlunosPorTurma(int turmaId) {
    List<Aluno> alunos = new ArrayList<>();
    String sql = "SELECT * FROM Aluno WHERE turma_id = ?";
    
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setInt(1, turmaId);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {
            Aluno aluno = new Aluno(
                resultSet.getString("emailFatec"),
                resultSet.getString("emailFornecido"),
                resultSet.getString("nome"),
                resultSet.getString("orientador_emailFatec"),
                resultSet.getInt("turma_id")
            );
            alunos.add(aluno);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return alunos;
}

    public void fecharConexao() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
