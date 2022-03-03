package fr.eni.projetencheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		/*
		 * String pseudo = request.getParameter("pseudo"); String nom =
		 * request.getParameter("nom"); String prenom = request.getParameter("prenom");
		 * String email = request.getParameter("email"); String tel =
		 * request.getParameter("tel"); String rue = request.getParameter("rue"); String
		 * cpo = request.getParameter("cpo"); String ville =
		 * request.getParameter("ville"); String mdp = request.getParameter("mdp");
		 * String confirmation = request.getParameter("confirmation");
		 */

		UtilisateurManager um = UtilisateurManager.getInstance();
		try {
			um.sInscrire(request.getParameter("pseudo"), request.getParameter("nom"), request.getParameter("prenom"),
					request.getParameter("email"), request.getParameter("tel"), request.getParameter("rue"),
					request.getParameter("cpo"), request.getParameter("ville"), request.getParameter("mdp"),
					request.getParameter("confirmation"));
			// um.sInscrire(pseudo, nom, prenom, email, tel, rue, cpo, ville, mdp,
			// confirmation);

			// Si creation du profil est validee, l'utilisateur est redirige vers la page
			// d'accueil
			response.sendRedirect(request.getContextPath() + "/accueillir");
		} catch (Exception e) {
			// TODO renvoyer � la page d'inscription si pseudo existant ou email existant +
			// message d'erreur associe

			response.sendRedirect(request.getContextPath() + "/WEB-INF/jsp/inscription.jsp");
		}

	}

}
