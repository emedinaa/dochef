<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header>
	<h1>
		<a href="<c:url value="/"/>"><img
			src="<c:url value='/resources/img/shared/logo.png' />" alt="doChef"></a>
			
			<sec:authorize access="isAuthenticated()">
  			<span style="float: right;font-size: 0.7em">Bienvenido(a) <sec:authentication property="principal.username"/> - <a href="<c:url value="/logout"/>">Salir</a></span>
			</sec:authorize>			
	</h1>
	<ul class="nav nav-pills nav-justified">
		<sec:authorize ifNotGranted="ROLE_FREE,ROLE_PREMIUM">
			<li><a href="<c:url value="/signup"/>">Regístrate</a></li>
		</sec:authorize>
		<sec:authorize ifAnyGranted="ROLE_FREE,ROLE_PREMIUM">
			<li><a href="#">Regístrate</a></li>
		</sec:authorize>
		<li><a href="<c:url value="/public/recetas"/>">Recetas Diarias</a></li>
		<li class="active"><a href="<c:url value="/public/consejos"/>">Consejos Alimenticios</a></li>
		<li><a href="<c:url value="/public/planes"/>">Planes Alimenticios</a></li>					
	</ul>
</header>
