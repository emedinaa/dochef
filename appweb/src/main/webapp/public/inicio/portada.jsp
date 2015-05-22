<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


		<div class="row">
			<div class="col-lg-7">
				<img src="<c:url value='/resources/img/home/computer-and-food.png' />" alt="Intro" class="full-width">
			</div>

			<div class="col-lg-5">
				<h2>Un Sistema Colaborativo</h2>
				<p>
					'doChef' es una plataforma que bajo el esquema de una red social colaborativa y especializada, 
					integra y facilita la disposición del conocimiento de profesionales de la salud, nutrición, 
					gastronomía  y de cualquier interesado en compartir información y cocimiento sobre alimentos 
					funcionales, así como alternativas gastronómicas innovadoras para su consumo.
				</p>

			</div>
		</div>

		<div class="row m-t">
			<div class="col-lg-7">
				<div class="row">
					<div class="col-sm-4">
						<sec:authorize ifNotGranted="ROLE_FREE,ROLE_PREMIUM">
						<a href="<c:url value="/login"/>" class="btn btn-lg btn-block btn-default btn-round">
							<div><span>Iniciar Sesión</span></div>
						</a>						
						</sec:authorize>
						
						<sec:authorize ifAnyGranted="ROLE_FREE,ROLE_PREMIUM">
						<a href="<c:url value="/logout"/>" class="btn btn-lg btn-block btn-default btn-round">
							<div><span>Cerrar Sesión</span></div>
						</a>						
						</sec:authorize>
												
					</div>
					<div class="col-sm-4">
						<sec:authorize ifNotGranted="ROLE_FREE,ROLE_PREMIUM">
						<a href="<c:url value='/signup' />" class="btn btn-lg btn-block btn-default btn-round">
							<div><span>Regístrate</span></div>
						</a>
						</sec:authorize>
						<sec:authorize ifAnyGranted="ROLE_FREE,ROLE_PREMIUM">
						<a href="#" class="btn btn-lg btn-block btn-default btn-round">
							<div><span>Regístrate</span></div>
						</a>						
						</sec:authorize>
						
					</div>
					<div class="col-sm-4">
						<a href="<c:url value="/accesoDenegado"/>" class="btn btn-lg btn-block btn-default btn-round">
							<div><span>Suscríbete</span></div>
						</a>
					</div>
				</div>
			</div>
			
			<div class="col-lg-5 app-container">
				<div class="row">
					<div class="col-lg-12 app-header">
						Descarga el App
					</div>
				</div>
				<div class="row app-body">
					<div class="col-lg-4 col-xs-6">
						<!--a href="#/apple-store"-->
							<!--img src="<c:url value='/resources/img/home/apple.png' />">
							<div>Apple Store</div-->
						<!--/a-->
					</div>
					<div class="col-lg-4 col-xs-6">
						<a href="#/google-play">
							<img src="<c:url value='/resources/img/home/play.png' />">
							<div>Google Play</div>
						</a>
					</div>
					<div class="col-lg-4 col-xs-12">
						<!--a href="#/kindle-fire"-->
							<!--img src="<c:url value='/resources/img/home/kindle.png' />">
							<div>Kindle Fire</div-->
						<!--/a-->
					</div>
				</div>
			</div>
		</div>