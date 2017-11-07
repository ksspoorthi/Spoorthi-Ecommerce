<html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- to convert normal form to spring form -->
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<spring:url value="/resources/images" var="img" />
<spring:url value="/resources/css" var="css" />
<body>
The order is been processed.. Click on check out.

<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-3">
			<a href="<c:url value='/myhompg'/>"
				class="btn btn-primary btn-primary" role="button">CONTINUE
				SHOPPING</a>
		</div>
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <a
			href="<c:url value='/payment'/>" class="btn btn-primary btn-primary"
			role="button">CHECKOUT</a>

		<div class="col-sm-3"></div>
	</div>
	</div>


</body></html>