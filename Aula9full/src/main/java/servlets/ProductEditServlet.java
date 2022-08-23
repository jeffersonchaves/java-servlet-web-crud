package servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import models.Product;
import repository.IProductRepository;
import repository.ProductRepository;

@MultipartConfig
@WebServlet("/products/edit")
public class ProductEditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		IProductRepository repository = new ProductRepository();

		req.setCharacterEncoding("utf-8");

		if (req.getParameter("id") != null) {

			Integer id = Integer.valueOf(req.getParameter("id"));

			Product product = repository.findById(id);

			req.setAttribute("product", product);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/edit-product.jsp");
			dispatcher.forward(req, resp);

		} else {

			Product product = new Product();

			String id = req.getParameter("field-id");

			String name = req.getParameter("field-name");

			Double price = Double.valueOf(req.getParameter("field-price"));

			String description = req.getParameter("field-description");

			product.setId(Integer.valueOf(id));
			product.setName(name);
			System.out.println(name);
			product.setPrice(price);

			String imagePath = this.uploadImage(req);

			product.setImageUri(imagePath);
			product.setDescription(description);

			repository.update(product);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/products");
			dispatcher.forward(req, resp);

		}
	}

	/* UPLOAD DE IMAGEM */
	public String uploadImage(HttpServletRequest request) {
		
		String path = getServletContext().getRealPath(File.separator) + "public" + File.separator;
		
		String fileName = null;

		Part filePart;
		
		try {
			
			filePart = request.getPart("field-image");
			
			fileName = filePart.getSubmittedFileName();

			InputStream is = filePart.getInputStream();
			
			Files.copy(is, Paths.get(path + fileName), StandardCopyOption.REPLACE_EXISTING);

		
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}

		return fileName;

	}
}
