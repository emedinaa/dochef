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
							<!--div class="col-xs-6 col-sm-2">
								<a href="receta.html"><i class="fa fa-thumbs-o-up"></i> 15</a>
							</div -->
							<!-- div class="col-xs-12 col-sm-7">
								<div class="row">
									<div class="col-xs-6">
										<a href="receta.html"><i class="fa fa-comment-o"></i> 5 Comentarios</a>
									</div>
									<div class="col-xs-6">
										<a href="receta.html"><i class="fa fa-heart"></i> 7 Seguidores</a>
									</div>
								</div>
							</div-->
						</div>



					</div>

				</div>

				<br>
				
				<div class="embed-responsive embed-responsive-16by9">
					<iframe class="embed-responsive-item" src="<c:url value='/resources/contenidos/${plan.video}' />"></iframe>
				</div>
				
				
				
			</div>
			
			<div class="col-lg-4">
				<div class="a-container">
					<a href="#"><img src="<c:url value='/resources/img/post/gordon.png' />" class="full-width" alt="Publicidad"></a>
				</div>
			</div>
		</div>