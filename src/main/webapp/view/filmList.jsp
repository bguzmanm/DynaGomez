<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="/view/head.jsp"%>
<div class="container">
	<header>
		<%@include file="/view/nav.jsp"%>
		<h1>Películas</h1>
	</header>

	<main>
		<div class="row">
			<div class="col mb-3">
				<a class="btn btn-primary"
					href="${pageContext.request.contextPath}/film?op=new">Nueva Película</a>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<table class="table" id="films">
					<thead class="table-dark">
						<tr>
							<th>Id</th>
							<th>Titulo</th>
							<th>Descripción</th>
							<th>Año</th>
							<th>Censura</th>
							<th>Especiales</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="film" items="${films}">
							<tr>
								<th><c:out value="${film.getFilmId()}"></c:out></th>
								<td><c:out value="${film.getTitle()}"></c:out></td>
								<td><c:out value="${film.getDescription()}"></c:out></td>
								<td><c:out value="${film.getReleaseYear()}"></c:out></td>
								<td><c:out value="${film.getRating()}"></c:out></td>
								<td><c:out value="${film.getSpecialFeatures()}"></c:out></td>
								<td><a href="${pageContext.request.contextPath}/film?op=edit&filmId=${film.getFilmId()}">
										<i class="fa-solid fa-pen-to-square"></i></a>
									<a href="${pageContext.request.contextPath}/film?op=del&filmId=${film.getFilmId()}">
										<i class="fa-solid fa-trash"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</main>
	<script>
		$(document).ready(function() {
			$('#films').DataTable();
		});
	</script>
</div>
<%@include file="/view/footer.jsp"%>
