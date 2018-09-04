<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Bem-vindo ao Teepo!</title>
</head>
<body>
	<%@ page import= "java.util.*, br.edu.insper.*" %>
	<div>
		<form action="login">
			<br>Usuário: <input type="text" name="nomePessoa"/> <br/>
		 	<br>Senha: <input type="text" name="senha"/> <br/> 
			<input type="submit" value="Entrar!"/>
		</form>
		<% DAO dao = new DAO();
		   List<Pessoas> pessoas = dao.getPessoas();
		   %>
	</div>
</body>
</html>