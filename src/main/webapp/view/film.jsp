<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%@include file="/view/head.jsp" %>
<div class="container">
	<header>
		<%@include file="/view/nav.jsp" %>
		<c:if test="${op == 'new'}">
			<h1>Crear Película</h1>
		</c:if>
		<c:if test="${op == 'edit'}">
			<h1>Editar Película</h1>
		</c:if>
		
	</header>
	<main>
		<form class="form" action="${pageContext.request.contextPath}/film?op=${op}" method="post">
			<input type="hidden" value="${film.getFilmId()}" id="filmId" name="filmId">
			<div class="mb-3">
				<label for="title" class="form-label">Titulo:</label>
				<input type="text" class="form-control" id="title" name="title" placeHolder="Los Inmortales: la vengaza del muerto"
					value="${film.getTitle()}">
			</div>
			<div class="mb-3">
				<label for="description" class="form-label">Descripción:</label>
				<input type="text" class="form-control" id="description" name="description" placeHolder="Una muy mala película de acción (Clase B)"
					value="${film.getDescription()}">
			</div>
			<div class="mb-3">
				<label for="releaseYear" class="form-label">Año:</label>
				<input type="number" class="form-control" id="releaseYear" name="releaseYear" placeHolder="2001"
					value="${film.getReleaseYear()}">
			</div>
			<div class="mb-3">
				<label for="rating" class="form-label">Censura:</label>
				<input type="text" class="form-control" id="rating" name="rating" placeHolder="PG-13"
					value="${film.getRating()}">
			</div>
			<div class="mb-3">
				<label for="specialFeatures" class="form-label">Especiales:</label>
				<input type="text" class="form-control" id="specialFeatures" name="specialFeatures" placeHolder="Trailers"
					value="${film.getSpecialFeatures()}">
			</div>
			<div class="mb-3">
				<div><button type="submit" class="btn btn-primary">Guardar <i class="fa-solid fa-floppy-disk"></i></button></div>
				<div><button type="reset" class="btn btn-secondary">Limpiar <i class="fa-solid fa-broom"></i></button></div>
			</div>
		
		</form>	
	</main>
	
</div>
<%@include file="/view/footer.jsp" %>
	