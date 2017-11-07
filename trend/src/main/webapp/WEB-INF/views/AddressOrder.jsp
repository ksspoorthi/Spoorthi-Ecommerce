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
	max-width: 500px;
}

.bg-4 {
	background-color: #CACFD2;
	color: #555555;
}

body {
	background-image: url("${img}/2017-07-23 (3).png")
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
				
				<li class="active"><c:if test="${pageContext.request.userPrincipal.name==null}"><a href="register"><span
						class="glyphicon glyphicon-registration-mark"></span>Register</a></li>
				<li class="active"><a href="loginpage"><span
						class="glyphicon glyphicon-log-in"></span> Log-in</a></c:if></li>
				
				<li class="active"><a href="<c:url value="/ViewYourCart"/>"><span
							class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
							
				<li>  <c:if test="${pageContext.request.userPrincipal.name!=null}">
			    <a href="<c:url value="/j_spring_security_logout"/>"><span class="icon-user"></span> Logout</a> 
     </c:if></li>

			</ul>
		</div>
	</nav>
	
	
	<br><br><br><br>
	<div class="row">
	
	  <div class="col-sm-1"></div>
               <div class="col-sm-4">
               
               
	<h3 class="text-center">Billing Address</h3>

		
	
	<div class="form-group">
				<form:input type="text" path="user.user_emailid" name="email" class="form-control input-sm"					
				placeholder="Emailid" disabled="true"/> 
			</div>
		
			<div class="form-group">
				<form:input type="number" name="mono" path="user.user_phno" disabled="true"
			class="form-control input-sm" placeholder="Mobile no"/>
			</div>
		


		
			<div class="form-group">
				<form:input class="form-control" path="user.billingAddress.b_dno" disabled="true"
					placeholder="House name and number"/>                                                
                                            
			</div>
		


		
			<div class="form-group">
				<form:input type="text" name="country" disabled="true"
					class="form-control input-sm" placeholder="locality" path="user.billingAddress.b_locality" />
			</div>
		
  

			<div class="form-group">
				<form:input type="text" name="city" disabled="true"
					class="form-control input-sm" placeholder="city" path="user.billingAddress.b_city"/>
			</div>
		
			<div class="form-group">
				<form:input type="text" name="pincode" disabled="true"
					class="form-control input-sm" placeholder="pincode" path="user.billingAddress.b_pincode" />
			</div>
		
		</div>

		
	 <div class="col-sm-1">
	 </div>	
		
		
		 <div class="col-sm-4">
		
		
		<h3 class="text-center">Shipping Address</h3>

		
	<c:url value="/orderConfirm" var="a"/>
		<form:form action="${a}" method="post" commandName="shippingAddress">
		
	
		
			<div class="form-group">
				<form:input type="text" name="first_name" id="first_name"
					class="form-control input-sm" placeholder="First Name" path="user.user_name"/>
			</div>
	
		
		

		
			<div class="form-group">
				<form:input type="text" name="first_name" id="first_name"
					class="form-control input-sm" placeholder="Email id" path="user.user_emailid"/>
			</div>
		
		
			<div class="form-group">
				<form:input type="text" name="Mobile_no" 
					class="form-control input-sm" placeholder="Mobile no" path="user.user_phno"/>
			</div>
		
		
			<div class="form-group">
				<form:input type="text" class="form-control" placeholder="door no" path="s_dno"/>                                                
                                           
			</div>
		

		
		
			<div class="form-group">
				<form:input type="text" 
					class="form-control input-sm" placeholder="city" path="s_city"/>
			</div>
		
			<div class="form-group">
				<form:input type="text"
					class="form-control input-sm" placeholder="pincode" path="s_pincode" />
			</div>
			
			<input type="submit" class="btn btn-primary pull-right" value="Continue">
		</form:form>
	</div>
	</div>
	
	
</body>
