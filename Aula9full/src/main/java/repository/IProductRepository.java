package repository;

import java.util.List;

import models.Product;

public interface IProductRepository {
	
	public Product insert(Product product);
	
	public Product update(Product product);
	
	public Integer deleteById(Integer id);
	
	public List<Product> findAll();
	
	public Product findById(Integer id);
	
	public Product findByName(String name);

}
