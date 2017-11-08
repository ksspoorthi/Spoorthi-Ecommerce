<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
.container {
	max-width: 500px;
}

.bg-1 {
	background-color: #B0C4DE;
	color: #ffffff;
}

.bg-2 {
	background-color: #474e5d;
	color: #ffffff;
}

.bg-4 {
	background-color: #FFFFFF;
	color: #555555;
}


</style>



</head>

<body>
<br/>
<br/>
<center>
<p><h1>The order is been processed.. Click on check out.</h1></p>
</center>
</br></br></br></br></br>
<center>
<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-2">
			<a href="<c:url value='/myhompg'/>"
				class="btn btn-primary" role="button">CONTINUE
				SHOPPING</a>
		</div>
		<div class="col-sm-6"></div>
		<div class="col-sm-2">
		 <a
			href="<c:url value="/Thanku"/>" class="btn btn-primary"
			role="button">CHECKOUT</a>
</div>
		
	</div>
	<div class="col-sm-1"></div>
	</center>


</body></html>