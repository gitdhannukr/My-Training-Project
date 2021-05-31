<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
</head>
<h1>
		<marquee behavior="scroll" direction="left">Welcome <font color="red">${username} </font> to Add Product Details</marquee>
	</h1>
<center>

<div style="width:1260px;height:150px;overflow:auto;overflow-y:hidden;white-space:nowrap;border:1px solid black;background:url('https://lh4.googleusercontent.com/-ap-iPV4koOk/UYM6kh5SN5I/AAAAAAAAFmo/lT3WE0GJHQ0/s300/Re-Loading.png') center center no-repeat #000;">

<input type=button value="Home" onCLick="history.back()">
<button ><font color="green" ><a href="http://localhost:2040/cartList" >Your Cart</a></font></button>
<a href="/logout"><button style="font-size:15px"> Logout <i class="fa fa-sign-out"></i></button></a>

<!-- Background image -->
<div class="position-relative">
  <div
    class="svg-wrapper bg-image shadow-1-strong rounded-lg"
    style="
      background-image: url('https://mdbcdn.b-cdn.net/img/new/slides/026.jpg');
      height: 100vh;
    "
  >
    <svg
      data-name="Layer 1"
      xmlns="http://www.w3.org/2000/svg"
      viewBox="0 0 1200 120"
      preserveAspectRatio="none"
      class="svg"
      style="
        height: 669px;
        width: 100%;
        fill: rgb(20, 77, 133);
        opacity: 0.8;
        transform: rotateY(0deg);
      "
    >
      <path
        d="M321.39,56.44c58-10.79,114.16-30.13,172-41.86,82.39-16.72,168.19-17.73,250.45-.39C823.78,31,906.67,72,985.66,92.83c70.05,18.48,146.53,26.09,214.34,3V0H0V27.35A600.21,600.21,0,0,0,321.39,56.44Z"
      ></path>
    </svg>
  </div>
</div>
<!-- Background image -->
<marquee behavior="scroll" direction="left" scrollamount="600" scrolldelay="5000" onmouseover="this.stop();"onmouseout="this.start();" >

<a href="http://localhost:2040/" target="blank" rel="nofollow"><img src=" D:\UST.png" title="TITLE" alt="WELCOME TO OUR PRODUCT APP" border="0px" width="1150px" height="400px"/></a> 
</marquee>
</div>
</center>
 

<body>
 
	<h2>Product Details</h2>
	
	
	
	
	<table border="7" cellspacing="8" cellspacing="10" align="center">
		<tbody>
			<%-- <c:forEach var="item" items="${products}">
				<tr>
					<td>${item.productId}</td>
					<td>${item.productName}</td>
					<td>${item.quantityOnHand}</td>
					<td>${item.price}</td>
					<td><a href="${item.productId}">Add To Cart</a></td> 
					<td><a href="/cart/{productId}">Add To Cart</a></td>			
					<td><a href="/deleteFromCart/${item.productId}">Delete deleteFromCart</a></td>
					<td><a href="/saveCart/${item.productId}">Add To Cart</a></td>
					<td><a href="/deleteProduct/${item.productId}">Delete</a></td>
				</tr>
			</c:forEach> --%>
			
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
			
		</tbody>
	</table>
	
</body>
</html>