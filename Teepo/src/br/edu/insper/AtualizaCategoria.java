package br.edu.insper;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/atualizaCategoria")
public class AtualizaCategoria extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response)
						 throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("ID: <input type='number' name='idCategoria'><br>");
		out.println("Titulo da Categoria: <input type='text' name='titulo'><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("<body><html>");
		}
	
	@Override
	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response)
						  throws ServletException, IOException {
		DAO dao = new DAO();
		
		Categorias categ = new Categorias();
		categ.setTitulo(request.getParameter("titulo"));
		categ.setIdCategoria(Integer.valueOf(request.getParameter("idCategoria")));
		
		dao.alteraCategoria(categ);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("atualizado" + categ.getTitulo());
		out.println("</body></html>");
		
		dao.close();
}
	}

