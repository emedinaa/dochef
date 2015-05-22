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
			
			
				<c:forEach items="${consejos}" var="consejo" varStatus="status">
			

				<div class="row post">
					<div class="col-lg-12">

						<div class="post-title">
							<a href="<c:url value="/public/consejos/${consejo.id}"/>">${consejo.titulo}</a>
						</div>						
						
					</div>
					<div class="col-lg-2">
						<img src="<c:url value='/resources/img/posts/${consejo.imagen}' />" class="full-width">
					</div>
					<div class="col-lg-7">
						<p>
							${consejo.descripcionCorta}
						</p>

						<div class="row post-footer">
							<div class="col-xs-6 col-sm-3">
								Por: <a href="receta.html">${consejo.autor.firstName}</a>
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
						<a href="#">Uñas</a>,
						<a href="#">Vit. A</a>,
						<a href="#">Vit. B</a>,
						<a href="#">Colágeno</a>,
						<a href="#">Hígado</a>,
						<a href="#">Estómago</a>,
						<a href="#">Gastritis</a>,
						<a href="#">Anemia</a>
					</div>
				</div>

				</c:forEach>

	
			</div>
		</div>		