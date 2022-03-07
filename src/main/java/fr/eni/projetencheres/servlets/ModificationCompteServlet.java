package fr.eni.projetencheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("action").equals("MODIF")) {

			// Enregistrer les modifications du compte
			// Recuperation des donnees enregistrees par l'utilisateur et création de
			// l'utilisateur pour l'utilisateur manager

			UtilisateurManager um = UtilisateurManager.getInstance();

			Utilisateur user = (Utilisateur) request.getSession().getAttribute("utilisateur");

			if (!(request.getParameter("pseudo").trim().isEmpty() || request.getParameter("pseudo") == null)) {
				user.setPseudo((String) request.getParameter("pseudo"));
			}

			if (!(request.getParameter("nom").trim().isEmpty() || request.getParameter("nom") == null)) {
				user.setNom((String) request.getParameter("nom"));
			}

			if (!(request.getParameter("prenom").trim().isEmpty() || request.getParameter("prenom") == null)) {
				user.setPrenom((String) request.getParameter("prenom"));
			}

			if (!(request.getParameter("email").trim().isEmpty() || request.getParameter("email") == null)) {
				user.setEmail((String) request.getParameter("email"));
			}

			if (!(request.getParameter("tel").trim().isEmpty() || request.getParameter("tel") == null)) {
				user.setTelephone((String) request.getParameter("tel"));
			}

			if (!(request.getParameter("rue").trim().isEmpty() || request.getParameter("rue") == null)) {
				user.setRue((String) request.getParameter("rue"));
			}

			if (!(request.getParameter("cpo").trim().isEmpty() || request.getParameter("cpo") == null)) {
				user.setCodePostal((String) request.getParameter("cpo"));
			}

			if (!(request.getParameter("ville").trim().isEmpty() || request.getParameter("ville") == null)) {
				user.setVille((String) request.getParameter("ville"));
			}

			if (request.getParameter("new-mdp").trim().isEmpty() || request.getParameter("new-mdp") == null) {
				try {
					user = um.modifierCompte(user, request.getParameter("mdp"));
				} catch (BLLException e) {
					RequestDispatcher connexion = request.getRequestDispatcher("/WEB-INF/jsp/gestion-profil.jsp");
					if (connexion != null) {
						request.setAttribute("error", e);
						connexion.forward(request, response);
					}
				}
			} else {
				user.setMotDePasse(request.getAttribute("new-mdp").toString());
				try {
					user = um.modifierCompte(user, request.getParameter("confirmation"), request.getParameter("mdp"));
				} catch (BLLException e) {
					RequestDispatcher connexion = request.getRequestDispatcher("/WEB-INF/jsp/gestion-profil.jsp");
					if (connexion != null) {
						request.setAttribute("error", e);
						connexion.forward(request, response);
					}
				}
				request.getSession().setAttribute("utilisateur", user);
				response.sendRedirect(request.getContextPath() + "/profil");
			}
			// Suppresion du compte
		} else {
			UtilisateurManager um = UtilisateurManager.getInstance();
			um.supprimerCompte(Integer.valueOf(request.getSession().getAttribute("noUtilisateur").toString()));
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath() + "/accueillir");
		}

	}

}