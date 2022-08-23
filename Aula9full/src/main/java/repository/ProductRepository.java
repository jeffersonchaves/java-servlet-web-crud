package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import models.Product;

public class ProductRepository implements IProductRepository {
	
	private Connection conn;
	
	public ProductRepository() {
		conn = ConnectionFactory.getConnection();
	}

	@Override
	public Product insert(Product product) {
		
		PreparedStatement statement = null;
		
		try {
			
			String sql = "INSERT INTO products (name, price, description, imageUri) VALUES(?, ?, ?, ?)";
			statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, product.getName());
			statement.setDouble(2, product.getPrice());
			statement.setString(3, product.getDescription());
			statement.setString(4, product.getImageUri());
			
			int rowsAffected = statement.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet ids = statement.getGeneratedKeys();
				
				while (ids.next()) {
					product.setId(ids.getInt(1));
				}
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return product;
	}

	@Override
	public Product update(Product product) {
		
		PreparedStatement statement = null;
				
		try {
			
			String sql = "UPDATE products "
					+ "SET name = ?, price = ?, description = ?, imageUri = ? "
					+ "WHERE id = ?";
			
			statement = conn.prepareStatement(sql);
			
			statement.setString(1, product.getName());
			statement.setDouble(2, product.getPrice());
			statement.setString(3, product.getDescription());
			statement.setString(4, product.getImageUri());
			statement.setInt(5, product.getId());
			
			statement.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return product;
	}

	@Override
	public Integer deleteById(Integer id) {
		
		PreparedStatement statement = null;
		
		try {
			
			String sql = "DELETE FROM products WHERE (id = ?)";
			statement = conn.prepareStatement(sql);
			
			statement.setInt(1, id);
			
			int rowsAffected = statement.executeUpdate();
			
			System.out.println("Rows affected: " + rowsAffected);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return id;
	}

	@Override
	public List<Product> findAll() {
		
		List<Product> products = new ArrayList<Product>();
		
		PreparedStatement stmt = null;
		ResultSet result = null;
	
		try {
			
			stmt = conn.prepareStatement("SELECT * FROM products");
			result = stmt.executeQuery();
			
			while(result.next()) {
				
				Integer id = result.getInt("id");
				String name = result.getString("name");
				Double price = result.getDouble("price");
				String description = result.getString("description");
				String imageUri = result.getString("imageUri");
				
				Product p = new Product(id, name, price, description, imageUri);
				
				products.add(p);
			}
			
			
		} catch (SQLException e) {
		
			throw new RuntimeException(e.getMessage());
		
		} finally {
						
			try {
				stmt.close();
				result.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return products;
	
	}

	@Override
	public Product findById(Integer id) {
		
		Product product = null;
		
		PreparedStatement statement = null;
		ResultSet result = null;
	
		try {
			
			statement = conn.prepareStatement("SELECT * FROM products WHERE id = ?");
			statement.setInt(1, id);

			result = statement.executeQuery();
			
			while(result.next()) {
				
				Integer pid = result.getInt("id");
				String name = result.getString("name");
				Double price = result.getDouble("price");
				String description = result.getString("description");
				String imageUri = result.getString("imageUri");
				
				product = new Product(pid, name, price, description, imageUri);
				
			}
			
		} catch (SQLException e) {
		
			throw new RuntimeException(e.getMessage());
		
		} finally {
						
			try {
				statement.close();
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return product;

	}

	@Override
	public Product findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
