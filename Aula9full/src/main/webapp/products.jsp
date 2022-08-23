<%@page import="java.text.DecimalFormat"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="repository.ProductRepository"%>
<%@page import="org.apache.catalina.startup.ClassLoaderFactory.Repository"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="models.Product, java.util.List"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
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
      <h5 class="display-4 fw-normal">Tabela de Preços</h5>
      <p class="fs-5 text-muted">
      	Aplicação para listagem de preços feito em Java. <br />
      	funcionalidades: cadastrar (não), listar, editar e excluir.
      </p>
    </div>
  </header>
  
  
   <a class="btn btn-primary" href="<%= request.getContextPath() %>/products/register">novo produto</a>


	<% List<Product> products = (List<Product>) request.getAttribute("products"); %>

	<table class="table">
		<thead>
			<tr>
				<td>#id</td>
				<td>name</td>
				<td>price</td>
				<td>description</td>
				<td>imageUri</td>
				<td>opções</td>
				
			</tr>
		</thead>
		
		<tbody>
	
			<% for (Product p : products) { %>
			<tr>
				<td><%= p.getId()%></td>
				<td><%= p.getName()%></td>
				<td>R$ <% out.print(new DecimalFormat("#,##0.00").format(p.getPrice())); %></td>
				<td><%= p.getResumedDescription()%></td>
				<td class="product-img-td"><img class="product-img" src="<%= request.getContextPath() %>/public/<%= p.getImageUri()%>" alt="" /></td>
				<td><a href="<%= request.getContextPath() %>/products/edit?id=<%= p.getId()%>">editar</a> | <a href="<%= request.getContextPath() %>/products/delete?id=<%= p.getId()%>">excluir</a></td>
			</tr>
			<% } %>
		</tbody>

	</table>




</div>
</body>
</html>