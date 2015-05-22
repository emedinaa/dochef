<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


		<!--  div class="row menu">
			<div class="col-xs-6 col-lg-3">
				<a href="#">
					Tipo de Plato <span class="caret"></span>
				</a>
			</div>
			<div class="col-xs-6 col-lg-3">
				<a href="#">
					Tipo de Dieta <span class="caret"></span>
				</a>
			</div>
			<div class="col-xs-6 col-lg-3">
				<a href="#">
					Tipo de Plato <span class="caret"></span>
				</a>
			</div>
			<div class="col-xs-6 col-lg-3">
				<a href="#">
					Tipo de Dieta <span class="caret"></span>
				</a>
			</div>
			<div class="col-xs-6 col-lg-3">
				<a href="#">
					Tipo de Dieta <span class="caret"></span>
				</a>
			</div>
			<div class="col-xs-6 col-lg-3">
				<a href="#">
					Tipo de Plato <span class="caret"></span>
				</a>
			</div>
		</div-->
		
		
		
		<div class="row posts">
			<div class="col-md-12">
			
			<c:forEach items="${planes}" var="plan" varStatus="status">
                           
				<div class="row post">
					<div class="col-lg-12">
						<div class="post-title">
							<a href="<c:url value="/public/planes/${plan.id}"/>">${plan.titulo}</a>
						</div>
					</div>
					<div class="col-lg-2">
							<img src="<c:url value='/resources/img/posts/${plan.imagen}' />" class="full-width">
					</div>						
					                     
                           
                    <div class="col-lg-7">
                    	<p>
                    		${plan.descripcionCorta}
                    	</p>	
						<div class="row post-footer">
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
                    </div>    
                    
               


					<div class="col-lg-3 post-tags">
						<a href="#">Cabello</a>,
						<a href="#">U�as</a>,
						<a href="#">Vit. A</a>,
						<a href="#">Vit. B</a>,
						<a href="#">Col�geno</a>,
						<a href="#">H�gado</a>,
						<a href="#">Est�mago</a>,
						<a href="#">Gastritis</a>,
						<a href="#">Anemia</a>
					</div>
				
                </div>
                           
            </c:forEach>               
			


		</div>
		
	</div>	