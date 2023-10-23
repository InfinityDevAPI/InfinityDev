package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {
	
  public static void conexao() {
	 
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/gerenciamentoTg2", "gerenciamento_user", "admin123");
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("show databases;");
      System.out.println("Connected");
    } catch (Exception e) {
      System.out.println(e);
    }
  }

public static Connection getConnection() {
	// TODO Auto-generated method stub
	return null;
}
}