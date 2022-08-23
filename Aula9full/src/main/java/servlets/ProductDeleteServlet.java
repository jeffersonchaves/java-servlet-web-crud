package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.IProductRepository;
import repository.ProductRepository;

@WebServlet("/products/delete")
public class ProductDeleteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IProductRepository repository = new ProductRepository();
		
		Integer id = Integer.valueOf(req.getParameter("id"));
		
		repository.deleteById(id);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/products");
		dispatcher.forward(req, resp);
		
	}

}
