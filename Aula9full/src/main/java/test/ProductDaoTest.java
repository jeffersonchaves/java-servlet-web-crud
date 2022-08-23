package test;

import models.Product;
import repository.IProductRepository;
import repository.ProductRepository;

public class ProductDaoTest {
	
	IProductRepository repository;
	
	public ProductDaoTest() {
		this.repository = new ProductRepository();
	}
	
	public static void main(String[] args) {
		ProductDaoTest teste = new ProductDaoTest();
		//teste.insert();
		
		//teste.delete();
		
		teste.update();
	}

	public void insert() {
		
		Product p = new Product();
		
		p.setName("produto 1");
		p.setPrice(99.0);
		p.setDescription("Product description");
		p.setImageUri("src/image");
		
		repository.insert(p);
		
	}
	
	public void delete() {
		repository.deleteById(2);
	}
	
	public void update() {
		
		Product p = new Product();
		
		p.setId(10);
		
		p.setName("Produto 10");
		p.setPrice(199.0);
		p.setDescription("Product description");
		p.setImageUri("src/image");
		
		repository.update(p);
	}
	
}
