package br.edu.insper;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/criaNota")  // Falta adicionar nota na categoria selecionada
public class CriaNota extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response)
						 throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("Conteudo: <input type='text' name='conteudo'><br>");
		out.println("Categoria: <input type='text' name='titulo'><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("<body><html>");
	 }
	
	@Override
	protected void doPost(HttpServletRequest request,
					      HttpServletResponse response)
					      throws ServletException, IOException {
		
		DAO dao = new DAO();
		 
		Notas nota = new Notas();
		Categorias categ = new Categorias();
		
		nota.setConteudo(request.getParameter("conteudo"));
		categ.getIdCategoria();
		
		dao.adicionaNota(nota);
		 
		 PrintWriter out = response.getWriter();
		 out.println("<html><body>");
		 out.println("adicionado" + nota.getConteudo() + "na Categoria" + categ.getTitulo());
		 out.println("</body></html>");		 
		 dao.close();
}
}