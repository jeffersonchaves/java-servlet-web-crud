package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;

public class ConnectionTest {
	
	public static void main(String[] args) {
		
		
		//ConnectionFactory factory = new ConnectionFactory();
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM products");
			ResultSet products = stmt.executeQuery();
			
			while(products.next()) {
				Integer id = products.getInt("id");
				String name = products.getString("name");
				
				System.out.println(id + ": " + name);
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	

}
