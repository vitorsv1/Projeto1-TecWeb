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
    	<% String linkCategoria = "criaCategoria.jsp";%>
        <div class="init">
        <nav class="navbar">Teeppo</nav> 
        <nav class="navbar board">Board</nav>   
        <div class="listas">
        	<div class="lista">
                <a href=<%=linkCategoria%>><button>Criar Categoria</button></a>
            </div>
           <!-- AQUI TEM QUE TER O RETURN DAS CATEGORIAS COM TABELAS-->
           <%
           			DAO dao = new DAO();
           			List<Categorias> categorias = dao.getCategorias();
           			String link,linkNota;
           			
           			if (categorias != null){
           				           			
           			for (Categorias categ: categorias){
           				List<Notas> notas = dao.notasCategoria(categ);
           				String IdCategoria = categ.getIdCategoria().toString();
           				link = "editCateg.jsp?categ_id=";
           				link += categ.getIdCategoria();
           			
           %>
           <div class="lista">
           		<header><%=categ.getTitulo()%></header>
           			<ul>
           			<% 
           				
	           			for (Notas nota: notas){
	       					String IdNota = nota.getIdNota().toString();
	   						//linkNota = "editaNota.jsp?nota_id=";
	   						//linkNota += nota.getIdNota();
           			%>
           				<li>
           					<%=nota.getConteudo() %>
           					<br>
           					<div style="display: inline-block">
			           			<div style="display: inline-block">
           							<a href="editaNota.jsp"><button>Editar Nota</button></a>
        						</div>
           					</div>
           					<div style="display: inline-block">
	           					<form action="RemoveNota">
				           			<input type="hidden" name="IdNota" value="<%=IdNota%>">
				           			<input type="hidden" name="IdCategoria" value="<%=IdCategoria%>">
				           			<button type="submit">Excluir Nota</button>
				           		</form>
				           	</div>
           				</li>
           				
           			<% } %>
           			</ul>
           		<footer>Clique abaixo para criar nota..</footer>
           		<div class="container">
           			<div style="display: inline-block">
           				<a href="criaNota.jsp"><button type="submit">Criar Nota</button></a>
           			</div>
           		</div>
           		
           		<br>
           		<div class="container">
           			<div style="display: inline-block">
	           			<form action="RemoveCategoria2">
	           				<input type="hidden" name="IdCategoria" value="<%=IdCategoria %>"/>
	           				<button type="submit">Deletar Categoria</button>
	           			</form>
           			</div>
           			<div style="display: inline-block">
           				<a href="editaCategoria.jsp"><button>Editar Categoria</button></a>
        			</div>
        		</div>
           </div>
           <% }
           			}%>
        </div>
    	</div>
    </body>
</html>