<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="/view/head.jsp"%>
<div class="container">
	<header>
		<%@include file="/view/nav.jsp"%>
		<h1>Actores y Actrices</h1>
	</header>

	<main>
		<div class="row">
			<div class="col mb-3">
				<a class="btn btn-primary"
					href="${pageContext.request.contextPath}/actor?op=new">Nuevo
					Actor u Actríz</a>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<table class="table" id="actors">
					<thead class="table-dark">
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>Apellido</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="actor" items="${actors}">
							<tr>
								<th><c:out value="${actor.getActorId()}"></c:out></th>
								<td><c:out value="${actor.getFirstName()}"></c:out></td>
								<td><c:out value="${actor.getLastName()}"></c:out></td>
								<td><a href="${pageContext.request.contextPath}/actor?op=edit&actorId=${actor.getActorId()}">
										<i class="fa-solid fa-pen-to-square"></i></a>
									<a href="${pageContext.request.contextPath}/actor?op=del&actorId=${actor.getActorId()}">
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
			$('#actors').DataTable();
		});
	</script>
</div>
<%@include file="/view/footer.jsp"%>
