package br.edu.insper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProcuraNota")
public class ProcuraNota extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProcuraNota() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String busca = request.getParameter("BuscaNota");
		DAO dao = new DAO();
		
		dao.procuraNota(busca);
		
		dao.close();
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	
}
