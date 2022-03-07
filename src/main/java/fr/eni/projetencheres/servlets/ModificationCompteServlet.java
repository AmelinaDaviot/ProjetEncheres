package fr.eni.projetencheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetencheres.bll.BLLException;
import fr.eni.projetencheres.bll.UtilisateurManager;
import fr.eni.projetencheres.bo.Utilisateur;

/**
 * Servlet implementation class ModificationCompteServlet
 */
@WebServlet("/modification-profil")
public class ModificationCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Suppresion du compte

		UtilisateurManager um = UtilisateurManager.getInstance();
		um.supprimerCompte((int) request.getSession().getAttribute("noUtilisateur"));
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath() + "/accueillir");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Enregistrer les modifications du compte

		// Recuperation des donnees enregistrees par l'utilisateur et création de
		// l'utilisateur pour l'utilisateur manager

		Utilisateur user = new Utilisateur(request.getParameter("pseudo"), request.getParameter("nom"),
				request.getParameter("prenom"), request.getParameter("email"), request.getParameter("tel"),
				request.getParameter("rue"), request.getParameter("cpo"), request.getParameter("ville"),
				request.getParameter("new-mdp"));

		UtilisateurManager um = UtilisateurManager.getInstance();
		try {
			user = um.modifierCompte(user, request.getParameter("confirmation"), request.getParameter("mdp"));
		} catch (BLLException e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("utilisateur", user);
		response.sendRedirect(request.getContextPath() + "/profil");

	}

}
