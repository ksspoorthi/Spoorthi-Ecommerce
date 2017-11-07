<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> <!-- to convert normal form to spring form -->
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<!-- spring url for static resources -->
<spring:url value="/resources/images" var="img" />
<head>
<title>TREND TODAY</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	margin: auto;
}

.bg-1 {
	background-color: #1abc9c;
	color: #ffffff;
}

.bg-2 {
	background-color: #474e5d;
	color: #ffffff;
}

.bg-3 {
	background-color: #ffffff;
	color: #555555;
}

.container {
	max-width:1000px;
}

.bg-4 {
	background-color: #CACFD2;
	color: #555555;
}

body {
	background-image: url("${img}/icon4.jpg")
}
</style>



</head>
<body style="background-color: #474e5d">


	<nav class="navbar navbar-inverse navbar-fixed-top ">
		<div class="container-fluid bg-2">
			<img src="${img}/cloth.png" class="img-rounded" alt="icon"
				width="100" height="50">
				&nbsp &nbsp 
		
		<!-- to make category,product,supplier pages visible to only admin -->		
			<c1:if test="${pageContext.request.userPrincipal.name!=null}">
			<security:authorize access="hasRole('ROLE_ADMIN')"> 
			<a href="<c:url value="/SupplierForm"/>"><font color="white">Supplier</a></font>&nbsp
			&nbsp <a href="<c:url value="/CategoryForm"/>"><font
				color="white">Category</a></font> &nbsp &nbsp <a
				href="<c:url value="/ProductForm"/>"><font color="white">Product</a></font>
			
			</security:authorize>
			</c1:if>
			
			
						<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="myhompg"><span
						class="glyphicon glyphicon-home"></span>Home</a></li>
				<li class="active"><a href="aboutus"><span
						class="glyphicon glyphicon-user"></span>About us</a></li>
				<li class="active"><a href="contactus"><span
						class="glyphicon glyphicon-earphone"></span>Contact us</a></li>
				<li class="active"><a href="register"><span
						class="glyphicon glyphicon-registration-mark"></span>Register</a></li>
				<li class="active"><a href="loginpage"><span
						class="glyphicon glyphicon-log-in"></span> Log-in</a></li>
				<li class="active"><a href="CartForm"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>

			</ul>
		</div>
	</nav>
	<br>
	<br>

	<br>
	<br>
	<br>
	<br>

	
	<div class="container" style="background-color: #474e5d">
		<div class="col-sm-4"></div>
				
				
				<div class="col-sm-4">
				<div class="form-group">
					<label for="enable">door no:</label> <br>
					<form:input type="text" class="form-control" 
						placeholder="dno" path="billingAddress.b_dno" />
				</div>
				 <div class="form-group">
					<label for="enable">street</label> <br>
					<form:input type="text" class="form-control" name="dstreet"
						placeholder="role" path="billingAddress.b_street" />
				</div>
				<div class="form-group">
					<label for="ph">locality</label> <br>
					<form:input type="text" class="form-control" name="d locality"
						 path="billingAddress.b_locality" />
				</div>
				
				
				<div class="form-group">
					<label for="enable">city</label> <br>
					<form:input type="text" class="form-control" name="dcity"
						 path="billingAddress.b_city" />
				</div>
				 <div class="form-group">
					<label for="enable">state</label> <br>
					<form:input type="text" class="form-control" name="dstate"
						 path="billingAddress.b_state" />
				</div>
				<div class="form-group">
					<label for="enable">pincode</label> <br>
					<form:input type="text" class="form-control" name="pincode"
						 path="billingAddress.b_pincode" />
				</div>
				</div>
				
				<div class ="col-sm-1"></div>
				
				
				
				
				<br>

				<div>
						<center>
							<input type="submit" class="btn btn-default" value="register"/>
						</center>
					</div>
		
	
	