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
		String pseudo = null;
		String nom = null;
		String prenom = null;
		String email = null;
		String tel = null;
		String rue = null;
		String cpo = null;
		String ville = null;
		String newMDP = null;

		if (request.getParameter("pseudo").trim().isEmpty() || request.getParameter("pseudo") == null) {
			pseudo = (String) request.getSession().getAttribute("pseudo");
		} else {
			pseudo = request.getParameter("pseudo");
		}

		if (request.getParameter("nom").trim().isEmpty() || request.getParameter("nom") == null) {
			nom = (String) request.getSession().getAttribute("nom");
		} else {
			nom = request.getParameter("nom");
		}

		if (request.getParameter("prenom").trim().isEmpty() || request.getParameter("prenom") == null) {
			prenom = (String) request.getSession().getAttribute("prenom");
		} else {
			prenom = request.getParameter("prenom");
		}

		if (request.getParameter("email").trim().isEmpty() || request.getParameter("email") == null) {
			email = (String) request.getSession().getAttribute("email");
		} else {
			email = request.getParameter("email");
		}

		if (request.getParameter("tel").trim().isEmpty() || request.getParameter("tel") == null) {
			tel = (String) request.getSession().getAttribute("tel");
		} else {
			tel = request.getParameter("tel");
		}

		if (request.getParameter("rue").trim().isEmpty() || request.getParameter("rue") == null) {
			rue = (String) request.getSession().getAttribute("rue");
		} else {
			rue = request.getParameter("rue");
		}
		if (request.getParameter("cpo").trim().isEmpty() || request.getParameter("cpo") == null) {
			cpo = (String) request.getSession().getAttribute("cpo");
		} else {
			cpo = request.getParameter("cpo");
		}
		if (request.getParameter("ville").trim().isEmpty() || request.getParameter("ville") == null) {
			ville = (String) request.getSession().getAttribute("ville");
		} else {
			ville = request.getParameter("ville");
		}
		if (request.getParameter("newMDP").trim().isEmpty() || request.getParameter("newMDP") == null) {
			newMDP = (String) request.getSession().getAttribute("newMDP");
		} else {
			newMDP = request.getParameter("newMDP");
		}

		Utilisateur user = new Utilisateur((int) request.getSession().getAttribute("noUtilisateur"), pseudo, nom,
				prenom, email, tel, rue, cpo, ville, newMDP);

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
