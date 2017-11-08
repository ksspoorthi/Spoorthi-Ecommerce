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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
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
 
  .container{
        max-width: 500px;
}
 .bg-4 { 
      background-color:#B0BEC5;
	  }
  body{
   background-image:url("${img}/icon4.jpg")
  }   	


  </style>
</head>
<body style="background-color: #CACFD2">

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
    <li class="active"><a href="register"><span class="glyphicon glyphicon-registration-mark"></span>Register</a></li>
    <li class="active"><a href="loginpage"><span class="glyphicon glyphicon-log-in"></span> Log-in</a></li>
     <c:if test="${pageContext.request.userPrincipal.name!=null}"><li class="active"><a href="CartForm"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
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
<br>
<br>
<font color="#CFD8DC">
<div class="container" style= "background-color: #474e5d" >
  
<br>
<h4> <b><strong> Enter your username and password:</strong></b></h4>
<br>
<c:url value='/j_spring_security_check' var='add'/>
  <form:form action="${add}" method="post">
    <div class="form-group">
      <label><strong> Username:</strong></label>
<br>

 <input type="text" class="form-control"  placeholder="username" name="j_username" required="required"/>
    </div>
<br>
    <div class="form-group">
      <label>Password:</label>
<br>
      <input type="password" class="form-control"  placeholder="password" name="j_password" required="required"/>
    </div>
    
    <input type="submit" class="btn btn-default" value="login"/>
  </form:form>

<div class="checkbox">
      <label><input type="checkbox"> Remember me</label>
    </div>
    
    </font>
<br>

<br>
<br>
</div>
</body>
</html>

