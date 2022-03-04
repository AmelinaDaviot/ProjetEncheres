package fr.eni.projetencheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccueillirServlet
 */
@WebServlet("/accueillir")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rq = null;
		if (request.getSession().getAttribute("utilisateur") != null) {
			rq = request.getRequestDispatcher("/WEB-INF/jsp/accueilConnecte.jsp");
		} else {
			rq = request.getRequestDispatcher("/WEB-INF/jsp/accueilNonConnecte.jsp");
		}
		if (rq != null) {
			rq.forward(request, response);
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
