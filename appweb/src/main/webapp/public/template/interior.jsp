<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!doctype html>
<html lang="es-pe">
<head>



<title>Do Chef</title>
<meta name="viewport" content="width=device-width,initial-scale=1">

<link rel="stylesheet"
	href="<c:url value='/resources/lib/bootstrap/css/bootstrap.min.css'  />" />
<link rel="stylesheet"
	href="<c:url value='/resources/lib/font-awesome/css/font-awesome.min.css'  />" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/fonts.css'  />">
<link rel="stylesheet"
	href="<c:url value='/resources/css/shared.css'  />" >
<link rel="stylesheet" href="<c:url value='/resources/css/recetas-diarias.css'  />">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>
<body>
	<div class="container content">
		<tiles:insertAttribute name="header" />

		<tiles:insertAttribute name="portada" />
		
		<tiles:insertAttribute name="body" />
	</div>


	<tiles:insertAttribute name="footer" />
	

		
</body>
</html>