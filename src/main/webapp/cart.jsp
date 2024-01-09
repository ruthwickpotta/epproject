<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="com.model.*" %>
        <%@page import="java.util.*" %>
<%
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProduct = null;
if (cart_list != null) {
	ProductManager pDao = new ProductManager();
	cartProduct = pDao.getCartProducts(cart_list);
	int total = pDao.getTotalCartPrice(cart_list);
	
	request.setAttribute("total", total);
	request.setAttribute("cart_list", cart_list);
}

%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>E-Commerce Cart</title>
</head>
<body>
	<%@include file="/includes/navbar.jsp"%>
	<div class="container my-3" style="background-color: #f0f8ff;" /* Replace this color with your desired color code */>
		<div class="d-flex py-3"><h3>Total Price:$<%ProductManager pm=new ProductManager(); %><%=pm.getTotalCartPrice(cart_list) %></h3> <a class="mx-3 btn btn-primary" href="orders.jsp">Check Out</a></div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
				
				<%
				if (cart_list != null) {
					for (Cart c : cartProduct) {
				%>
				<tr>
					<td><%=c.getName()%></td>
					<td><%=c.getCategory()%></td>
					<td><%=c.getPrice()%></td>
					<td>
						<form action="OrderNowServlet" method="post" class="form-inline">
						<input type="hidden" name="id" value="<%= c.getId()%>" class="form-input">
							<div class="form-group d-flex justify-content-between">
								<a class="btn bnt-sm btn-incre" href="QuantityIncDecServlet?action=inc&id=<%=c.getId()%>"><i class="fas fa-plus-square"></i></a> 
								<input type="text" name="quantity" class="form-control"  value="<%=c.getQuantity()%>" readonly> 
								<a class="btn btn-sm btn-decre" href="QuantityIncDecServlet?action=dec&id=<%=c.getId()%>"><i class="fas fa-minus-square"></i></a>
							</div>
							
						</form>
					</td>
					<td><a href="RemoveFromCartServlet?id=<%=c.getId() %>" class="btn btn-sm btn-danger">Remove</a></td>
				</tr>

				<%
				}}%>
			</tbody>
		</table>
	</div>

	
	<%@include file="/includes/footer.jsp"%>
</body>
</html>
