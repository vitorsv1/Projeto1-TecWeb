<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
    <nav class="navbar board">Teepo</nav> 
    <nav class="navbar">Board</nav>
    <div class="listas">
    	<%String link = "home.jsp"; %>
    	<div class="cria-categoria">
	    	<form action="CriaCategoria2">
		   		<h3>Titulo da Categoria: <input type='text' name='tituloCategoria'></h3>
		   		<a href=<%=link %>><button type="submit">Criar Categoria</button></a>
		   	</form>
    	</div>
        
        <div class="lista">
            <header>Categoria1</header>
            	<ul>
		             <li>Cartão</li>
		             <li>Cartão2</li>
             	</ul>
            <footer name='adiciona-nota'>Adicionar Nota..</footer>
        </div>
    </div>
</div>
</body>
</html>