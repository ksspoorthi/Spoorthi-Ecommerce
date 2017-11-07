<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- to convert normal form to spring form -->
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

/* .container{ */
/* 	max-width: 500px; */
/* } */
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
				width="100" height="50"> &nbsp &nbsp

			<!-- to make category,product,supplier pages visible to only admin -->
			<c1:if test="${pageContext.request.userPrincipal.name!=null}">
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<a href="<c:url value="/SupplierForm"/>"><font color="white">Supplier</a>
					</font>&nbsp
			&nbsp <a href="<c:url value="/CategoryForm"/>"><font
						color="white">Category</a>
					</font> &nbsp &nbsp <a href="<c:url value="/ProductForm"/>"><font
						color="white">Product</a>
					</font>

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
				<li class="active"><a href="CartForm"><span
						class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>

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
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-4 ">
			<div class="container"
				style="background-color: #474e5d; max-width: 400px">
				<br> <font color="#CFD8DC"> <c:url value='/addproduct'
						var="add" /> <!-- enctype is to add images to the data file --> <form:form
						action="${add}" method="post" commandName="product"
						enctype="multipart/form-data">

						<div class="form-group collapse">
							<label for="id">Product id:</label> <br>
							<form:input type="text" class="form-control" name="prodid"
								placeholder="id" path="prod_id" />
						</div>

						<div class="form-group">
							<label>Product name :</label> <br>
							<form:input type="text" class="form-control" name="prodname"
								placeholder="name" path="prod_name" />
						</div>

						<div class="form-group">
							<label>Product Quantity</label> <br>
							<form:input type="text" class="form-control" name="prodqty"
								placeholder="Quantity" path="prod_qty" />
						</div>




						<div class="form-group">
							<label>Product price</label> <br>
							<form:input type="text" class="form-control" name="prodrice"
								placeholder="price" path="prod_price" />
						</div>

						<div class="form-group">
							<label>Product Description</label> <br>
							<form:input type="text" class="form-control" name="prodesc"
								placeholder="description" path="prod_desc" />
						</div>



						<div class="form-group">
							<label for="sel1">Supplier &nbsp &nbsp &nbsp</label> <font
								color="#2E2E2E"> <form:select path="supplier.sup_sid"
									multiple="false">
									<c:forEach items="${suppliers}" var="d">
										<form:option value="${d.getSup_sid()}"
											label="${d.getSup_name()}" />
									</c:forEach>
								</form:select>
							</font>
						</div>



						<div class="form-group">
							<label for="sel1">Category &nbsp &nbsp &nbsp</label> <font
								color="#2E2E2E"> <form:select path="category.cat_id"
									multiple="false">
									<c:forEach items="${categories}" var="d">
										<form:option value="${d.getCat_id()}"
											label="${d.getCat_name()}" />
									</c:forEach>
								</form:select>
							</font>
						</div>

						<form:input path="prod_image" type="file" name="image"
							value="upload file" />




						<br>

						<div>
							<center>
								<input type="submit" class="btn btn-default"
									value="Store Details" />
							</center>
						</div>

					</form:form>

				</font> <br>

			</div>
		</div>
		<div class="col-sm-1"></div>
		<div class="col-sm-3">
			<div class="container"
				style="background-color: #474e5d; max-width: 640px">



				<br> <font color="#E0E0E0">
					<table class="table table-bordered">

						<thead>
							<tr>

								<th>Product name</th>
								<th>Quantity</th>
								<th>Price</th>
								<th>Description</th>
								<th>Image</th>
								<th>Category</th>
								<th>Supplier</th>
								<th>Edit/delete</th>


							</tr>
						</thead>
						<tbody>
							<c:forEach items="${products}" var="d">
								<tr>
									<td>${d.getProd_name()}</td>
									<td>${d.getProd_qty()}</td>
									<td>${d.getProd_price()}</td>
									<td>${d.getProd_desc()}</td>
									<td><img
										src="<c:url value='resources/images/${d.getProd_id()}.jpg'/>"
										,width=50px, height=50px></td>
									<td>${d.getCategory().getCat_name()}</td>
									<td>${d.getSupplier().getSup_name()}</td>
									<td><a
										href="<c:url value='editproduct/${d.getProd_id()}'/>"
										class="btn btn-primary btn-xs" role="button">Edit</a> <a
										href="<c:url value='deleteproduct/${d.getProd_id()}'/>"
										class="btn btn-danger btn-xs" role="button">Delete</a></td>
								</tr>
							</c:forEach>





						</tbody>

					</table>
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
