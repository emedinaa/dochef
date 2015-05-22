<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>





<div class="container" ng-app="doChefApp">
	<div ng-controller="LoginController">
		<legend> Inicie Sesión </legend>

		<c:if test="${param.error eq 'bad_credentials'}">
			<div class="error">
				Tus datos son incorrectos. Prueba otra vez o <a
					href="<c:url value="/signup" />">Registrate</a>.
			</div>
		</c:if>

		<div class="alert alert-danger"
			ng-class="{'': displayLoginError == true, 'none': displayLoginError == false}">
			Usuario o Password Inválidos.</div>

		<form method="post" action="j_spring_security_check">
			<div>
				<input name="j_username" id="j_username" type="text" size="25"
					placeholder="<spring:message code='sample.email' /> "><br />
				<input name="j_password" id="j_password" type="password"
					size="25" placeholder="Password"><br /> <br>
				<button type="submit" name="submit" class="btn btn-default">Inicie
					Sesión</button>
			</div>
		</form>

		<br>
		<p>Si eres nuevo usuario <a href="<c:url value="/signup"/>">registrate</a>.</p>
	</div>

	<div>

		<h3>Ingrese con su cuenta de Facebook:</h3>

		<!-- FACEBOOK SIGNIN -->
		<p>
			<a href="<c:url value="/auth/facebook"/>"><img
				src="<c:url value="/resources/img/social/facebook/sign-in-with-facebook.png"/>"
				border="0" /></a><br />
		</p>


	</div>

</div>



<script src="<c:url value='/resources/js/pages/login.js' />"></script>


