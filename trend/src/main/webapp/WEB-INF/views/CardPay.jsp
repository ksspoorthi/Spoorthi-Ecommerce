  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- to convert normal form to spring form -->
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>  
<html>   
<head>
<spring:url value="/resources/images" var="img" />
<spring:url value="/resources/css" var="css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script>
 var app = angular.module('myApp', []);
 app.controller('myCtrl', function($scope, $http){
	 $http.get("http://localhost:7012/trend/SendMail")
	 });
  </script> </head>

    <div class="container">
    <div class='row'>
        <div class='col-md-4'></div>
        <div class='col-md-4'>
          <script src='https://js.stripe.com/v2/' type='text/javascript'></script>
          <c:url value="/payment" var="payment"/>
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
               <a href="<c:url value="/payment"/>"> <span class='amount'>Pay</span></a>
               <div class="container">
		<div id="collapseTwo" aria-expanded="false" class="collapse">
			<div class="well">Your one time password has been sent to your
				registered mail id.</div>
			Enter the OTP:<input ng-app="myApp" ng-controller="myCtrl"
				type="text" name="otp">
		</div>
	</div>
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
        <div class='col-md-4'></div>
    </div>
</div>
</html>
