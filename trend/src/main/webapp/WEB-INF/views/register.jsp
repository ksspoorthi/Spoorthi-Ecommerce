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
				<c:if test="${pageContext.request.userPrincipal.name==null}">
				<li class="active"><a href="register"><span
						class="glyphicon glyphicon-registration-mark"></span>Register</a></li>
				<li class="active"><a href="loginpage"><span
						class="glyphicon glyphicon-log-in"></span> Log-in</a></li>
				</c:if>
				 <c:if test="${pageContext.request.userPrincipal.name!=null}">
				<li class="active"><a href="CartForm"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
</c:if>
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
		<br> <font color="#CFD8DC"> <c:url value='/adduser'
				var="add" /> 
				<form:form action="${add}" method="post" commandName="user">
              
               <div class="col-sm-1"></div>
               <div class="col-sm-4">
				<div class="form-group collapse">
					<label for="id">UserId:</label> <br>
					<form:input type="text" class="form-control" name="userid"
						placeholder="id" path="user_id" />
				</div>

				<div class="form-group">
					<label for="usr">Username:</label> <br>
					<form:input type="text" class="form-control" name="username"
						placeholder="username" path="user_name" required="required"/>
				</div>

				<div class="form-group">
					<label for="pwd">Password:</label> <br>
					<form:input type="password" class="form-control" name="pwd"
						placeholder="password" path="user_password" required="required" />
				</div>




				<div class="form-group">
					<label for="pwd">Email-id:</label> <br>
					<form:input type="email" class="form-control" name="email"
						placeholder="email" path="user_emailid" required="required"/>
				</div>

<!-- 				<div class="form-group collapse"> -->
<!-- 					<label for="address">Address:</label> <br> -->
<%-- 					<form:input type="text" class="form-control" name="address" --%>
<%-- 						placeholder="address" path="user_address" /> --%>
<!-- 				</div> -->


				<div class="form-group">
					<label for="ph">Contact-no:</label> <br>
					<form:input type="text" class="form-control" name="contactno"
						placeholder="mobile" path="user_phno" />
				</div>
				
				
				
				 <div class="form-group">
					<label for="enable">Role:</label> <br>
					<form:input type="text" class="form-control" name="role"
						placeholder="role" path="user_role" />
				</div>
				</div>
				<div class="col-sm-2"></div>
				
				
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
					<label for="ph"> locality</label> <br>
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
					
			</form:form>

		</font> <br>

	</div>
</body>
</html>
