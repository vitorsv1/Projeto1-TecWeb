package br.edu.insper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CriaCategoria2
 */
@WebServlet("/CriaCategoria2")
public class CriaCategoria2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CriaCategoria2() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		DAO dao = new DAO();
		 
		Categorias categ = new Categorias();
		categ.setTitulo(request.getParameter("tituloCategoria"));
		
		dao.adicionaCategoria(categ);
		 
		dao.close();
		
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	

}
