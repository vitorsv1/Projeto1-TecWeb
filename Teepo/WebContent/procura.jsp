<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>TecWeb- Projeto 1</title>
<link rel="stylesheet" type="text/css" href="settings.css">
</head>
<body>
	<%@ page import="java.util.*,br.edu.insper.*"%>
	<div class="init">
    <nav class="navbar">Teeppo</nav> 
    <nav class="navbar board">Board</nav>
    <div class="listas">
    	<a href="home.jps"><button>Home</button></a>
	    <div class="searchBar">
			<form action="ProcuraNota">
				<input type="text" name="BuscaNota" placeholder="Search..">
			</form>
		</div>
		<div class="lista">
			<%
				DAO dao = new DAO();
				List<Categorias> categorias = dao.getCategorias();
				
				for (Categorias categ: categorias){
					List<Notas> notas = dao.notasCategoria(categ);
	   				String IdCategoria = categ.getIdCategoria().toString();			
			%>
			<!-- Falta colocar o que foi achado no DAO e comparar com o for -->
			<!-- Caso não tenho precisa mostrar uma mensagem -->
		</div>
    <% } %>
    </div>
    </div>   
</body>
</html>