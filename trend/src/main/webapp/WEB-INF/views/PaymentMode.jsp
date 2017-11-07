<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<spring:url value="/resources/css" var="css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope,$http) {
	$http.get("http://localhost:7012/trend/SendMail")
});
</script>

<head>
<title>TREND TODAY</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${css}/PaymentMode.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
	background-image: url("${img}/2017-07-23 (3).png")
}
</style>
<body>
	<div class="container">
		<div class="row">
			<div class="paymentCont">
				<div class="headingWrap">
					<b><h1 class="headingTop text-center">Select Your Payment
							Method</h1></b> <br> <br>


					<div class="row">
						<div class="col-sm-3"></div>
						<div class="col-sm-3">
							<a href="<c:url value='#'/>" class="btn primary"> <label
								class="btn paymentMethod" data-target="#collapseOne"
								data-toggle="collapse" aria-expanded="false"
								aria-controls="collapseOne"> <img src="${img}/cod.png"
									alt="Chania" width="150" height="150">
									<input type="radio" value="1" name="payb" />
							</label>
							</a>
						</div>
						<div class="col-sm-1"></div>
						<div class="col-sm-3">
							<label class="btn paymentMethod" data-target="#collapseTwo"
								data-toggle="collapse" aria-expanded="false"
								aria-controls="collapseTwo"> <a
								href="<c:url value='#'/>" class="btn primary"> <img
									src="${img}/credit_cards_card-512.png" alt="Chania" width="150"
									height="150">
                                <input type="radio" value="2" name="payb" />
							</a>
							</label>
						</div>
						<div class="col-sm-2"></div>
					</div>



<div class="container"> 

		<div id="collapseOne" aria-expanded="false" class="collapse">
		
			<div class="well">Your one time password has been sent to your
				registered mail id.</div>
			Enter the OTP:<input ng-app="myApp" ng-controller="myCtrl"
				type="text" name="otp">
		</div>
	</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>

<div class="container">
		<div id="collapseTwo" aria-expanded="false" class="collapse">
		
		
          <script src='https://js.stripe.com/v2/' type='text/javascript'></script>
          <c:url value="/ConfirmationMail" var="payment"/>
          <form action="${payment}" id="payment-form" method="post" commandName="card"><div style="margin:0;padding:0;display:inline">  
          </div>

          
            <div class='form-row'>
              <div class='col-xs-12 form-group required'>
                <label class='control-label'>Name on Card</label>
                <input class='form-control' size='4' type='text' path="card_name"/>
              </div>
            </div>
            <div class='form-row'>
              <div class='col-xs-12 form-group card required'>
                <label class='control-label'>Card Number</label>
                <input autocomplete='off' class='form-control card-number' size='20' type='text' path="card_id"/>
              </div>
            </div>
            <div class='form-row'>
              <div class='col-xs-4 form-group cvc required'>
                <label class='control-label'>CVC</label>
                <input autocomplete='off' class='form-control card-cvc'  placeholder='ex. 311' size='4' type='text' path="card_no"/>
              </div>
              <div class='col-xs-4 form-group expiration required'>
                <label class='control-label'>Expiration</label>
                <input class='form-control card-expiry-month' placeholder='MM' size='2' type='text' path="card_expiry_month"/>
              </div>
              <div class='col-xs-4 form-group expiration required'>
                <label class='control-label'></label>
                <input class='form-control card-expiry-year' placeholder='YYYY' size='4' type='text' path="card_expiry_year"/>
              </div>
            </div>
            <div class='form-row'>
              <div class='col-md-12'>
                <div class='form-control total btn btn-info'>
                  Total:
                  <span class='amount'>${cart.getGrand_total()}</span>
                </div>
              </div>
            </div>
            <div class='form-row'>
              <div class='col-md-12 form-group'>
              <div class='form-control total btn btn-info'>
<%--                <a href="<c:url value="/ConfirmationMail"/>" class="btn paymentMethod" data-target="#collapseTwo" --%>
<!-- 								data-toggle="collapse" aria-expanded="false" -->
<!-- 								aria-controls="collapseOne"> <span class='amount'>Pay</span> -->
               <input type="submit" value="Pay">
              </div>
            </div>
            </div>
            <div class='form-row'>
              <div class='col-md-12 error form-group hide'>
                <div class='alert-danger alert'>
                  Please correct the errors and try again.
                </div>
              </div>
            </div>
          </form>
        </div>
        <
        <div class='col-md-4'></div>
    </div>
</div>
	

		
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-3">
			<a href="<c:url value='/myhompg'/>"
				class="btn btn-primary btn-primary" role="button">CONTINUE
				SHOPPING</a>
		</div>
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <a
			href="<c:url value="/Thankyou"/>" class="btn btn-primary btn-primary"
			role="button">CHECKOUT</a>

		<div class="col-sm-3"></div>
	</div>
	</div>



</body>