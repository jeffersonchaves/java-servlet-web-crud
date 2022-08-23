package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static Connection conn = null;
	
	//Singleton -> haverá apenas uma instância dessa classe para toda a aplicação	
	public static Connection getConnection() {
		
		if(conn == null) {
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ifpr_store", "root", "password#22");
			
			} catch (SQLException | ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return conn;
		
	}
	
	public static void close() {
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
}
