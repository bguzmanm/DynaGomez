<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/sakila">Sakila</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a id="actor" class="nav-link" href="${pageContext.request.contextPath}/actor?op=list">Actores</a>
        </li>
        <li class="nav-item">
          <a id="film" class="nav-link" href="${pageContext.request.contextPath}/film?op=list">Películas</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
