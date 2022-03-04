package fr.eni.projetencheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetencheres.bll.BLLException;
import fr.eni.projetencheres.bll.UtilisateurManager;
import fr.eni.projetencheres.bo.Utilisateur;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Afficher la page inscription
		RequestDispatcher rq = request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp");
		if (rq != null) {
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

		// Recuperation des donnees enregistrees par l'utilisateur
		UtilisateurManager um = UtilisateurManager.getInstance();
		try {
			Utilisateur user = um.sInscrire(request.getParameter("pseudo"), request.getParameter("nom"), request.getParameter("prenom"),
					request.getParameter("email"), request.getParameter("tel"), request.getParameter("rue"),
					request.getParameter("cpo"), request.getParameter("ville"), request.getParameter("mdp"),
					request.getParameter("confirmation"));

			request.getSession().setAttribute("utilisateur", user);
			// Si creation du profil est validee, l'utilisateur est redirige vers la page
			// d'accueil
			response.sendRedirect(request.getContextPath() + "/accueillir");
//			RequestDispatcher rq = request.getRequestDispatcher("/WEB-INF/jsp/accueilConnecte.jsp");
//			if (rq != null) {			
//				rq.forward(request, response);
//			} else {
//				response.sendError(HttpServletResponse.SC_NOT_FOUND);
//			}
			
		} catch (BLLException e) {
			// TODO renvoyer a la page d'inscription si pseudo existant ou email existant +
			// message d'erreur associe
			
			RequestDispatcher rq = request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp");
			if (rq != null) {
				request.setAttribute("error", e);
				rq.forward(request, response);
			} else {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
//			response.sendRedirect(request.getContextPath() + "/WEB-INF/jsp/inscription.jsp");
		}

	}

}
