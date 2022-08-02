<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%@include file="/view/head.jsp" %>
<div class="container">
	<header>
		<%@include file="/view/nav.jsp" %>
		<c:if test="${op == 'new'}">
			<h1>Crear Actor o Actríz</h1>
		</c:if>
		<c:if test="${op == 'edit'}">
			<h1>Editar Actor o Actríz</h1>
		</c:if>
		
	</header>
	<main>
		<form class="form" action="${pageContext.request.contextPath}/actor?op=${op}" method="post">
			<input type="hidden" value="${actor.getActorId()}" id="actorId" name="actorId">
			<div class="mb-3">
				<label for="firstName" class="form-label">Nombre:</label>
				<input type="text" class="form-control" id="firstName" name="firstName" placeHolder="Silvester"
					value="${actor.getFirstName()}">
			</div>
			<div class="mb-3">
				<label for="lastName" class="form-label">Apellido:</label>
				<input type="text" class="form-control" id="lastName" name="lastName" placeHolder="Stalone"
					value="${actor.getLastName()}">
			</div>
			<div class="mb-3">
				<div><button type="submit" class="btn btn-primary">Guardar <i class="fa-solid fa-floppy-disk"></i></button></div>
				<div><button type="reset" class="btn btn-secondary">Limpiar <i class="fa-solid fa-broom"></i></button></div>
			</div>
		
		</form>	
	</main>
	
</div>
<%@include file="/view/footer.jsp" %>
	