<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightgreen">
<body>
   
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

<style>
.btn-group button {
  background-color: #e6b3ff; /* Green background */
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
  background-color: #00FF00;
}
</style>
<body>



<div class="btn-group">
  <button><a href="/cartList">Cart</a></button>
  <button><a href="/logout">Logout</a></button>
  <button><a href="/product">ADD</a></button>
</div>

</body>
<body>
<h1>Congrats !! Your cart Item stored successfully !!</h1>



</body>
</html>