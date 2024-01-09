<%@page import="java.text.DecimalFormat"%>
        <%@page import="com.model.*" %>
        <%@page import="java.util.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%
	DecimalFormat dcf = new DecimalFormat("#.##");
	request.setAttribute("dcf", dcf);
	

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
	<div class="container">
		<div class="card-header my-3">All Orders</div>
		<table class="table table-light">
			<thead>
				<tr>
					
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
			
			<%
				if (cart_list != null) {
					for (Cart c : cartProduct) {
				%>
					<tr>
						
						<td><%=c.getName() %></td>
						<td><%=c.getCategory() %></td>
						<td><%=c.getQuantity() %></td>
						<td><%=c.getPrice()%></td>
						<td><a class="btn btn-sm btn-danger" href="cancel-order?id=<%%>">Cancel Order</a></td>
					</tr>
				<%}
			}
			%>
			
			</tbody>
		</table>
	</div>
	<%@include file="/includes/footer.jsp"%>
</body>
</html>