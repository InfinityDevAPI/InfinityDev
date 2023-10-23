package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import conexao.Conexao;

public class alunoDAO {
	

	public void insert(List<String[]>valoresEntreVirgula){
		
		Connection conn = Conexao.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement("INSERT INTO aluno (emailFatec, emailFornecido, nome, orientador_nome, turma_matricula),(VALUES(?,?,?,?)");
			
			for (String[] linha : valoresEntreVirgula) {
				stmt.setString(1,linha [2]);
				stmt.setString(2,linha [1]);
				stmt.setString(3,linha [3]);
				stmt.setString(4,linha [4]);
				
				stmt.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}
