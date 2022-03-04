package fr.eni.projetencheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetencheres.bo.Utilisateur;

/**
 * Servlet implementation class ProfilServlet
 */
@WebServlet("/profil")
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rq = request.getRequestDispatcher("/WEB-INF/jsp/profil.jsp");
		if (rq != null) {
//			Utilisateur user = null;
//			request.setAttribute("pseudo", user.getPseudo());
//			request.setAttribute("nom", user.getNom());
//			request.setAttribute("prenom", user.getPrenom());
//			request.setAttribute("email", user.getEmail());
//			request.setAttribute("telephone", user.getTelephone());
//			request.setAttribute("pseudo", user.getPseudo());
			rq.forward(request, response);
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.sendRedirect(request.getContextPath() + "/modification-profil");
		RequestDispatcher rq = request.getRequestDispatcher("/WEB-INF/jsp/modification-supression-profil.jsp");
		if (rq != null) {
			rq.forward(request, response);
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

}
