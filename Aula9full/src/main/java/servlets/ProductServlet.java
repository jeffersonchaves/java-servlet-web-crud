package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Product;
import repository.ProductRepository;

@WebServlet(name = "products" ,urlPatterns = {"", "/products"})
public class ProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductRepository repository = new ProductRepository();
		
		List<Product> products = new ArrayList<>();
		
		try {
		
			products = repository.findAll();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		req.setAttribute("products", products);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("products.jsp");
		dispatcher.forward(req, resp);
		
	}

}
