<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%@include file="/view/head.jsp" %>
<div class="container">
	<header>
		<%@include file="/view/nav.jsp" %>
		<h1>Actores y Actrices</h1>
	</header>
	
	<main>
	
		<table class="table">
			<thead class="table-dark">
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Apellido</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="actor" items="${actors}">
				<tr>
					<th><c:out value="${actor.getActorId()}"></c:out></th>
					<td><c:out value="${actor.getFirstName()}"></c:out></td>
					<td><c:out value="${actor.getLastName()}"></c:out></td>
				</tr>
				</c:forEach>
				
			</tbody>		
		</table>
	
	</main>
	
</div>
<%@include file="/view/footer.jsp" %>
