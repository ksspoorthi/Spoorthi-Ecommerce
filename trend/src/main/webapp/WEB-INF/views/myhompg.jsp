<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


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
	width: 50%;
	margin: auto;
	height: 500px;
}

.cate {
	background-color: #9e9e9e;
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

.input[type=text] {
	width: 130px;
}

/* When the input field gets focus, change its width to 100% */
input[type=text]:focus {
	width: 76%;
}
</style>
</head>
<body>
	<span>
		<nav class="navbar navbar-inverse navbar-fixed-top ">
			<div class="container-fluid bg-2">
				<img src="${img}/cloth.png" class="img-rounded" alt="icon"
					width="100" height="50">&nbsp &nbsp

				<!-- to make category,product,supplier pages visible to only admin -->
				<c:if test="${pageContext.request.userPrincipal.name!=null}">
					<security:authorize access="hasRole('ROLE_ADMIN')">

						<a href="<c:url value="/SupplierForm"/>"><font color="white">Supplier</a>
						</font>&nbsp
			&nbsp <a href="<c:url value="/CategoryForm"/>"><font
							color="white">Category</a>
						</font> &nbsp &nbsp 
						
			<a href="<c:url value="/ProductForm"/>"><font color="white">Product</a>

						</font>

					</security:authorize>
				</c:if>


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

						<li class="active"><a href="<c:url value="/loginpage"/>"><span
								class="glyphicon glyphicon-log-in"></span> Log-in</a></li>
					</c:if>
					<li><c:if
							test="${pageContext.request.userPrincipal.name!=null}">
							<li class="active"><a href="<c:url value="/ViewYourCart"/>"><span
									class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
						</c:if>
					<li><c:if
							test="${pageContext.request.userPrincipal.name!=null}">
							<a href="<c:url value="/j_spring_security_logout"/>"><span
								class="icon-user"></span> Logout</a>
						</c:if></li>

				</ul>
			</div>
		</nav> <br> <br>


		<div class="container">
			<br>
			<div id="myCarousel" class="carousel slide" data-ride="carousel">

				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
					<li data-target="#myCarousel" data-slide-to="3"></li>
				</ol>


				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="${img}/Scarves-For-Women-How-To-Wear-8.jpg" alt="Chania">
					</div>

					<div class="item">
						<img
							src="${img}/Winter-2013-Outfits-for-Women-by-Stylish-Eve_06.jpg"
							alt="Chania">
					</div>

					<div class="item">
						<img
							src="${img}/Winter-2013-Outfits-for-Women-by-Stylish-Eve_13.jpg"
							alt="Flower">
					</div>

					<div class="item">
						<img src="${img}/574480_368296566597615_1429759053_n.png"
							alt="Flower">
					</div>
				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div> <br> <br>

<div class="container">    
  <div class="row">
  
  <c:forEach items="${categories}" var="c">
  <div class="btn-group">
  
  <center><a href="<c:url value='/getproductbycategory/${c.getCat_id()}'/>" class="btn btn-danger btn-xs" role="button"><b>${c.getCat_name()}</b></a></center>
  </div>
  
  </c:forEach>
 </div> 
 </div>



<div class="container">    
  <div class="row">
  <c:forEach items="${pro}" var="p">
    <div class="col-sm-4">
      <div class="panel panel-primary">
        
        <div class="panel-body"><img
										src="<c:url value='/resources/images/${p.getProd_id()}.jpg'/>"
										,width=120px, height=120px></div>
	<center><a href="<c:url value='/addtocart/${p.getProd_id()}'/>" class="btn btn-danger btn-xs" role="button"><b>Add to cart</b></a></center>
        <div class="panel-footer">${p.getProd_name()}</div>
      </div>
    </div>
    </c:forEach>
  </div>
</div><br>

<a href="<c:url value='/Thanku'/>"> thanku</a>



</body>
</html>
	
