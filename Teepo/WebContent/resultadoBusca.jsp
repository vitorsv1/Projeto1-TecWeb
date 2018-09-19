<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>TecWeb - Projeto 1</title>
		<link rel="stylesheet" type="text/css" href="settings.css">
	</head>
	<body>
		<%@ page import="java.util.*, br.edu.insper.*"%>
		<div class="init">
        <nav class="navbar">Teeppo</nav> 
        <nav class="navbar board">Board</nav>  
        <%
        	DAO dao = new DAO();
        	if (dao.procuraNota("oi")!= null){
        		List<Notas> notas = dao.procuraNota("oi");
        		
        %>
       <div class="lista">
       		<ul>
       			<%
       				for (Notas nota: notas){
       					String IdNota = nota.getIdNota().toString();
       					String IdCategoria = nota.getIdCategoria().toString();
       			%>
       			<li>
       				<%=nota.getConteudo()%>
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
           			</ul>
           		<footer><%=nota.getDataCriacao() %></footer>
           		<% }
       			}
       			%>
       </div>
	</body>
</html>