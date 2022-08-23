<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="repository.ProductRepository"%>
<%@ page import="models.Product, java.util.List"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Cadastro de produtos | IFPR</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	<link href="<%= request.getContextPath() %>/assets/css/style.css" rel="stylesheet" type="text/css" />
	
</head>
<body>
<div class="container">

<header>
    <div class="d-flex flex-column flex-md-row align-items-center pb-3 m-4 border-bottom">
            <a href="<%= request.getContextPath() %>" class="d-flex align-items-center text-dark text-decoration-none">
        <span class="fs-4">Cadastro de produtos</span>
      </a>

      <nav class="d-inline-flex mt-2 mt-md-0 ms-md-auto">
        <a class="me-3 py-2 text-dark text-decoration-none" href="#">Features</a>
        <a class="me-3 py-2 text-dark text-decoration-none" href="#">Enterprise</a>
        <a class="me-3 py-2 text-dark text-decoration-none" href="#">Support</a>
        <a class="py-2 text-dark text-decoration-none" href="#">Pricing</a>
      </nav>
    </div>

    <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
      <h1 class="display-4 fw-normal">Tabela de Preços</h1>
    </div>
  </header>
	
	<h1>Cópia do arquivo de edição, necessita implementar cadastro.</h1>


	<% Product product = (Product) request.getAttribute("product"); %>

	<form action="<%= request.getContextPath() %>/products/edit" method="post" enctype="multipart/form-data">
	
		<div class="mb-3">
		  <label for="id" class="form-label">#id</label>
		  <input type="number" name="field-id" class="form-control" id="id" value="<%=product.getId() %>" readonly>
		</div>
		
		<div class="mb-3">
		  <label for="name" class="form-label">Product Name</label>
		  <input type="text" name="field-name" class="form-control" id="name" value="<%=product.getName() %>">
		</div>
		
		<div class="mb-3">
		  <label for="price" step='0.01' class="form-label">Product price</label>
		  <input type="text" name="field-price" class="form-control" id="price" value="<%=product.getPrice()%>" >
		</div>
		
		<div class="mb-3">
		  <label for="formFile" class="form-label">Image</label>
		  
		  <div class="row img-upload-box">
		  
		  	<div class="col-3">
		  	
		  		<img width="30" src="<%= getServletContext().getContextPath() %>/public/<%= product.getImageUri() %>" alt="" />
		  	
		  	</div>
		  	
		  	<div class="col-9">
		  	
		  		<input class="form-control" name="field-image" type="file" id="formFile" value="<%= product.getImageUri() %>">
		  		
		  	</div>
		  
		  </div>
		  
		</div>
		
		<div class="mb-3">
		  <label for="description" class="form-label">Description</label>
		  <textarea class="form-control" name="field-description" id="description" rows="3"><%= product.getDescription() %></textarea>
		</div>
		
		<div class="mb-3">
			<input class="btn btn-primary" type="submit" value="atualizar" name="submit">
		</div>
	
	</form>

</div>
</body>
</html>
