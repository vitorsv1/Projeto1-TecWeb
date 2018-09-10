package br.edu.insper;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/removeCategoria")
public class RemoveCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response)
						 throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("Remover a categoria: <input type='text' name='titulo'><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("<body><html>");
	}
	@Override
	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response)
						  throws ServletException, IOException {
		DAO dao = new DAO();
		dao.removeCategoria(String.valueOf(request.getParameter("titulo")));
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("removido");
		out.println("</body></html>");
		dao.close();
 }
}