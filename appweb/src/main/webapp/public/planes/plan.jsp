<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<div class="row">
			<div class="col-lg-8">
				<div class="row post">
					<h2>
						${plan.titulo} 
					</h2>

					<div class="col-lg-12">
						<div class="row post-subheader">
							<div class="col-xs-6 col-sm-3">
								Por: <a href="receta.html">${plan.autor.firstName}</a>
							</div>
							<div class="col-xs-6 col-sm-2">
								<a href="receta.html"><i class="fa fa-thumbs-o-up"></i> 15</a>
							</div>
							<div class="col-xs-12 col-sm-7">
								<div class="row">
									<div class="col-xs-6">
										<a href="receta.html"><i class="fa fa-comment-o"></i> 5 Comentarios</a>
									</div>
									<div class="col-xs-6">
										<a href="receta.html"><i class="fa fa-heart"></i> 7 Seguidores</a>
									</div>
								</div>
							</div>
						</div>

						<p>
							${plan.descripcion}
						</p>
						<p>
							
						</p>
						<div class="row">
							<div class="col-lg-6">
							<h3>DIA 1:</h3>
								<div class="panel panel-default">
								
									
								<c:if test="${not empty plan.antesDesayuno}">
    								<div class="panel-heading">
										${plan.lblAntesDesayuno}
									</div>
									<div class="panel-body">
										${plan.antesDesayuno}
									</div>
								</c:if>	
									
								<c:if test="${not empty plan.desayuno}">
    								<div class="panel-heading">
										${plan.lblDesayuno}
									</div>
									<div class="panel-body">
										${plan.desayuno}
									</div>
								</c:if>												
										
								<c:if test="${not empty plan.merienda1}">
    								<div class="panel-heading">
										${plan.lblMerienda1}
									</div>
									<div class="panel-body">
										${plan.merienda1}
									</div>
								</c:if>		
								
								<c:if test="${not empty plan.merienda2}">
    								<div class="panel-heading">
										${plan.lblMerienda2}
									</div>
									<div class="panel-body">
										${plan.merienda2}
									</div>
								</c:if>		
																											
											
								<c:if test="${not empty plan.almuerzo}">
    								<div class="panel-heading">
										${plan.lblAlmuerzo}
									</div>
									<div class="panel-body">
										${plan.almuerzo}
									</div>
								</c:if>		
								
											
								<c:if test="${not empty plan.mediaTarde1}">
    								<div class="panel-heading">
										${plan.lblMediaTarde1}
									</div>
									<div class="panel-body">
										${plan.mediaTarde1}
									</div>
								</c:if>		
								
								<c:if test="${not empty plan.mediaTarde2}">
    								<div class="panel-heading">
										${plan.lblMediaTarde2}
									</div>
									<div class="panel-body">
										${plan.mediaTarde2}
									</div>
								</c:if>		
								<c:if test="${not empty plan.cena}">
    								<div class="panel-heading">
										${plan.lblCena}
									</div>
									<div class="panel-body">
										${plan.cena}
									</div>
								</c:if>																				
																																						
																																																		
								</div>
							</div>
						</div>


						<h3>Servicios Premium:</h3>

						<p>
							<a href="<c:url value='/protected/planes/${plan.id}/archivos' />">Descargar el Plan Nutricional Completo </a>
						</p>
						<p>
							Solicitar un Plan Nutricional a tu Medida
						</p>						
						<p>
						    <A href="<c:url value='/protected/planes/${plan.id}/videos' />">Visualizar Video de Preparación de la Receta</a>
						</p>						
					</div>

				</div>


			</div>
			
			<div class="col-lg-4">
				<div class="a-container">
					<a href="#"><img src="<c:url value='/resources/img/post/gordon.png' />" class="full-width" alt="Publicidad"></a>
				</div>
			</div>
		</div>