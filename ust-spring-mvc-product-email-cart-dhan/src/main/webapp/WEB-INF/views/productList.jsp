<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
</head>
<body bgcolor="skyblue">
<body>


<%-- <h2>Your product with product ${productId} successfully added to the cart</h2>





Product ID : ${productId}
Product Name : ${product.productName}
Quality On Hand :${product.quantityOnHand}
Price : ${product.price} --%>
	<br>
	<h1><marquee behavior="scroll" direction="left">City Mall</marquee>
	<marquee behavior="scroll" direction="left">
		welcome <font color="red">${username} </font> to shopping product world!
		<font color="red">${moreproducts} </font></marquee>
		
	</h1>
	
	<style>
.btn-group button {
  background-color: #04AA6D; /* Green background */
  border: 1px solid green; /* Green border */
  color: white; /* White text */
  padding: 10px 24px; /* Some padding */
  cursor: pointer; /* Pointer/hand icon */
  float: left; /* Float the buttons side by side */
}

/* Clear floats (clearfix hack) */
.btn-group:after {
  content: "";
  clear: both;
  display: table;
}

.btn-group button:not(:last-child) {
  border-right: none; /* Prevent double borders */
}

/* Add a background color on hover */
.btn-group button:hover {
  background-color: #3e8e41;
}
</style>
<body>



<div class="btn-group">
  <button><a href="/cartList">Cart</a></button>
  <button><a href="/logout">Logout</a></button>
  <button><a href="/product">ADD</a></button>
</div>

</body>
	
	<body bgcolor="blue">



	<h1>Product List</h1>
	<form:form >
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<!-- <th></th> -->
				<th><font color="red">Product ID</font></th>
				<th><font color="green">Product Name</font></th>
				<th><font color="yellow">Quantity On Hand</font></th>
				<th><font color="pink">Price</font></th>
				
				
			</tr>
			<c:forEach var="prod" items="${products}">
				<tr>

					<%-- <td><form:checkbox path="productId" value="${prod.productId }" /></td> --%>
					<td>${prod.productId }</td>
					
					<td>${prod.productName }</td>
					
					<td>${prod.quantityOnHand }</td>
					<!-- <td>${prod.quantityOnHand }</td>-->
					<td>${prod.price }</td>
					<!-- <td>${prod.price }</td>-->
					<td><a href="/editProduct/${prod.productId}">Update</a></td>
					<td><a href="/deleteProduct/${prod.productId}">Delete</a></td>
					<td><a href="/saveCart/${prod.productId}">AddToCart</a></td>
				</tr>

			</c:forEach>
			
		</table><br>

	</form:form>
	
</body>
</html>