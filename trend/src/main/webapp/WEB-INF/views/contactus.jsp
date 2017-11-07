<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<!-- spring url for static resources -->
<spring:url value="/resources/images" var="img"/>
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
	background-color: #B0C4DE;
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

.bg-4 {
	background-color: #CACFD2;
	color: #555555;
}

body {
	background-image: url("${img}/icon4.jpg")
}
</style>
</head>
<body class="bg-4">

<nav class="navbar navbar-inverse navbar-fixed-top ">
  <div class="container-fluid bg-2">
<img src="${img}/cloth.png" class="img-rounded" alt="icon" width="100" height="50">
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
    <li class="active"><a href="myhompg"><span class="glyphicon glyphicon-home"></span>Home</a></li>
    <li class="active"><a href="aboutus"><span class="glyphicon glyphicon-user"></span>About us</a></li>
    <li class="active"><a href="contactus"><span class="glyphicon glyphicon-earphone"></span>Contact us</a></li>
    <c:if test="${pageContext.request.userPrincipal.name==null}">
    <li class="active"><a href="register"><span class="glyphicon glyphicon-registration-mark"></span>Register</a></li>
    <li class="active"><a href="loginpage"><span class="glyphicon glyphicon-log-in"></span> Log-in</a></li>
    </c:if>
    <li class="active"><a href="<c:url value="/ViewYourCart"/>"><span
							class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
    		
    <li>  <c:if test="${pageContext.request.userPrincipal.name!=null}">
			    <a href="<c:url value="/j_spring_security_logout"/>"><span class="icon-user"></span> Logout</a> 
     </c:if></li>
    
</ul>
</div>
</nav>


	<div class="container">
		<br> <br> <br> <br> <br>

		<h2>
			<font color="#CFD8DC" size="50px"><center>Contact us</center></font>
		</h2>
		<br> <br>
		<div class="row">

			<div class="col-sm-4"></div>

			<div class="col-sm-4">
				<font color="#CFD8DC" size="5px"><b>Website : </b></font><font
					color="#CFD8DC" size="3px"><u><b>http://www.TREND
							TODAY.com/<u>
					</b></font>
			</div>

			<div class="col-sm-4"></div>

		</div>

		<br>


		<div class="row">

			<div class="col-sm-4"></div>

			<div class="col-sm-4">
				<font color="#CFD8DC" size="5px"><b>Phone no : </b></font><font
					color="#CFD8DC" size="5px"><b>97432-41570</b></font>
			</div>


			<div class="col-sm-4"></div>

		</div>

		<br>

		<div class="row">

			<div class="col-sm-4"></div>

			<div class="col-sm-5">
				<font color="#CFD8DC" size="5px"><b>Email id: </b></font><font
					color="#CFD8DC" size="3px"><b><u>customercare@TREND
							TODAY.com</u></b></font>
			</div>

			<div class="col-sm-3"></div>

		</div>

		<br> <br> <br> <br>

		<div class="row">

			<div class="col-sm-2"></div>

			<div class="col-sm-4">
				<img src="${img}/Yootheme-Social-Bookmark-Social-facebook-box-blue.ico"
					class="img-rounded" alt="icon" width="70" height="30"> &nbsp
				<font color="#CFD8DC" size="3px"><u><b>facebook.com/TREND
							TODAY/ &nbsp <u>
					</b></font>
			</div>



			<div class="col-sm-4">
				&nbsp <img src="${img}/Google-plus-icon.png" class="img-rounded" alt="icon"
					width="60" height="30"> &nbsp <font color="#CFD8DC"
					size="3px"> <u><b>http://goo.gl/TREND TODAY</u></b></font>
			</div>

			<div class="col-sm-2"></div>
</body>
</html>