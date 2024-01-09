<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.model.*" %>
    <%@ page import="java.util.Base64" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Product" %>
<% 
if(session.getAttribute("username")==null && session.getAttribute("adminemail")==null){
	response.sendRedirect("login.jsp");
}
%>


<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>E-Commerce Cart</title>
</head>
<body>
	<%@include file="anavbar.jsp"%>
	<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
			<%
			ProductManager pd = new ProductManager();
			List<Product> products = pd.getAllProducts();
			List<Product> recruiters = (List<Product>) request.getAttribute("list");
            if (products != null) {
            	
                for (Product p : products) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<div class="card-img-top" ><% 
                            byte[] imageBytes = p.getImage();
                            if (imageBytes != null && imageBytes.length > 0) {
                                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                                %>
                                <img src="data:image/jpeg;base64,<%= base64Image %>" alt="Company Photo" style="width: 100%; height: 200px;">
                            <% } %></div>
						
					<div class="card-body">
						<h5 class="card-title">Name:<%=p.getName() %></h5>
						<h6 class="price">Price: $<%=p.getPrice() %></h6>
						<h6 class="category">Category: <%=p.getCategory() %></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a class="btn btn-dark" href="add-to-cart?id=<%=p.getId()%>">Add to Cart</a> <a
								class="btn btn-primary" href="order-now?quantity=1&id=">Buy Now</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			} else {
			out.println("There is no products");
			
			}
			%>

		</div>
	</div>

	
	<%@include file="/includes/footer.jsp"%>
</body>
</html>