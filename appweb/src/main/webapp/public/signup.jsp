<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h3>Registrese</h3>

<c:if test="${not empty message}">
<div class="${message.type.cssClass}">${message.text}</div>
</c:if>

<c:url value="/signup" var="signupUrl" />
<form:form id="signup" action="${signupUrl}" method="post" modelAttribute="signupForm">
	<div class="formInfo">
		<s:bind path="*">
			<c:choose>
				<c:when test="${status.error}">
					<div class="error">No es posible registrarse. Por favor, repare los errores y vuelva a intentarlo.</div>
				</c:when>
			</c:choose>                     
		</s:bind>
	</div>
	
	<fieldset>
		<form:label path="firstName">Nombres <form:errors path="firstName" cssClass="error" /></form:label> <br>
		<form:input path="firstName" /><br>
		<form:label path="lastName">Apellidos <form:errors path="lastName" cssClass="error" /></form:label><br>
		<form:input path="lastName" /><br>
		<form:label path="username">E-mail <form:errors path="username" cssClass="error" /></form:label><br>
		<form:input path="username" />		<br>
		<form:label path="password">Password (al menos 6 caracteres) <form:errors path="password" cssClass="error" /></form:label><br>
		<form:password path="password" /><br>
	</fieldset>
	<br>
	<p><button type="submit">Registrarse</button></p>
</form:form>
