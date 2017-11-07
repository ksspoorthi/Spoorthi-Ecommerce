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
	<br>
	<br>

	<br>
	<br>
	<br>
	<br>

<br>
<br>
<br>


<font color="#E0E0E0">
<table class="table table-bordered">
	
    <thead>
      <tr>
        
        <th>Product name</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Description</th>
        <th>Image</th>
        <th>Edit/delete</th>
           
      </tr>
    </thead>
     <tbody>
      <c:forEach items="${cartItems}" var="d">
  			<tr>
  				<td>${d.getProduct().getProd_name()}</td>
  				<td>${d.getProduct().getProd_qty()}</td>
  				<td>${d.getProduct().getProd_price()}</td>
  				<td>${d.getProduct().getProd_desc()}</td>
  			<td><img src="<c:url value='resources/images/${d.getProduct().getProd_id()}.jpg'/>",width=50px, height=50px></td>
  				    
      			<td><a href="<c:url value='/Buy/${d.getProduct().prod_id}/${d.getCartitem_id()}'/>" class="btn btn-primary btn-xs" role="button">Buy Now</a>
      			<a href="<c:url value='/deletecartItem/${d.getCartitem_id()}'/>" class="btn btn-danger btn-xs" role="button">Remove</a>
      			</td>
      		</tr>
      </c:forEach>
        
    </tbody>
    
  </table>
  <div class="row">
  <div class="col-sm-9">
  </div>
  <div class="col-sm-3">
 <a href="<c:url value='/Buyall'/>" class="btn btn-primary btn-xs" role="button">Buy All</a>/<a href="<c:url value='/RemoveAll'/>" class="btn btn-danger btn-xs"><i class="fa fa-trash" aria-hidden="true"></i> Remove All </a>
 </div>
 </div>
 </
</div>
</div>
      
    </tbody>
  </table>
</div>
</div>
	</div>
	<div class="col-sm-1"></div>
	</div>
</body>
</html>
