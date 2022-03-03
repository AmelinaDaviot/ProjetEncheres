package fr.eni.projetencheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetencheres.bll.UtilisateurManager;

/**
 * Servlet implementation class ModificationCompteServlet
 */
@WebServlet("/modification-profilt")
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
//		um.supprimerCompte();
		response.sendRedirect(request.getContextPath() + "/accueillir");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Enregistrer les modifications du compte
		
		// Recuperation des donnees enregistrees par l'utilisateur
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String rue = request.getParameter("rue");
		String cpo = request.getParameter("cpo");
		String ville = request.getParameter("ville");
		String mdp = request.getParameter("mdp");
		String confirmation = request.getParameter("confirmation");
		
		UtilisateurManager um = UtilisateurManager.getInstance();
//		um.modifierCompte();
		response.sendRedirect(request.getContextPath() + "/profil");
		
	}

}
