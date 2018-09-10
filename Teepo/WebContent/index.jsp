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
    <div class="init">
    <nav class="navbar board">Teepo</nav> 
    <nav class="navbar">Board</nav>
    <nav class="navbar">
    	<form method='post'>
    		<ul>
    			<li>Titulo da Categoria: <input type='text' name='titulo'></li>>
    		</ul>
    	</form>
    </nav>    
    <div class="listas">
        <div class="lista">
            <header>Categoria</header>
            <ul>
             <li>Cartão</li>
             <li>Cartão2</li>
         </ul>
            <footer name='adiciona-nota'>Adicionar Nota..</footer>
        </div>
        <div class="lista">
            <header>Categoria2</header>
            	<ul>
             <li>Cartão</li>
             <li>Cartão2</li>
             </ul>
            <footer name='adiciona-nota'>Adicionar Nota..</footer>
        </div>
        <div class="lista">
        	<header name='adiciona-categoria'>Adicionar Categoria..</header>
        	<ul>
        	</ul>
        </div>
    </div>
</div>
</body>
</html>