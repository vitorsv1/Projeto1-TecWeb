package br.edu.insper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditaNota
 */
@WebServlet("/EditaNota")
public class EditaNota extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditaNota() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idCateg = Integer.parseInt(request.getParameter("IdCategoria"));
		Integer idNota = Integer.parseInt(request.getParameter("IdNota"));
		
		DAO dao = new DAO();
		
		Notas nota = new Notas();
		
		nota.setIdNota(idNota);
		nota.setIdCategoria(idCateg);
		nota.setConteudo(request.getParameter("ConteudoNota"));
		
		dao.alteraNota(nota);
		
		dao.close();
		
		request.setAttribute("idCategoria", idCateg);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
}
