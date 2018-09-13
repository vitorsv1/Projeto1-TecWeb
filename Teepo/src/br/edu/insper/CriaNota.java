package br.edu.insper;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CriaNota")
public class CriaNota extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public CriaNota() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	 }
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idCateg = Integer.parseInt(request.getParameter("IdCategoria"));
		
		DAO dao = new DAO();
		 
		Notas nota = new Notas();
				
		nota.setConteudo(request.getParameter("conteudoNota"));
		nota.setIdCategoria(idCateg);
		
		dao.adicionaNota(nota, idCateg);
		 	 
		dao.close();
		
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
}