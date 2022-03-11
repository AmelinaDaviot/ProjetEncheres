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
		RequestDispatcher connexion = null;
		UtilisateurManager um = null;
		try {
			um = UtilisateurManager.getInstance();
		} catch (BLLException e1) {
			connexion = request.getRequestDispatcher("/WEB-INF/jsp/gestion-profil.jsp");
			if (connexion != null) {
				request.setAttribute("error", e1);
				connexion.forward(request, response);
			}
		}

		if (request.getParameter("action").equals("MODIF")) {

			// Enregistrer les modifications du compte
			// Recuperation des donnees enregistrees par l'utilisateur et création de
			// l'utilisateur pour l'utilisateur manager

			Utilisateur user = (Utilisateur) request.getSession().getAttribute("utilisateur");
			int creditLocal = user.getCredit();
			Utilisateur newUser= new Utilisateur(user.getNoUtilisateur(), user.getPseudo(), user.getNom(), user.getPrenom(), user.getEmail(), user.getTelephone(), user.getRue(), user.getCodePostal(), user.getVille(), null);

			if (!(request.getParameter("pseudo").trim().isEmpty() || request.getParameter("pseudo") == null)) {
				newUser.setPseudo((String) request.getParameter("pseudo"));
			}

			if (!(request.getParameter("nom").trim().isEmpty() || request.getParameter("nom") == null)) {
				newUser.setNom((String) request.getParameter("nom"));
			}

			if (!(request.getParameter("prenom").trim().isEmpty() || request.getParameter("prenom") == null)) {
				newUser.setPrenom((String) request.getParameter("prenom"));
			}

			if (!(request.getParameter("email").trim().isEmpty() || request.getParameter("email") == null)) {
				newUser.setEmail((String) request.getParameter("email"));
			}

			if (!(request.getParameter("tel").trim().isEmpty() || request.getParameter("tel") == null)) {
				newUser.setTelephone((String) request.getParameter("tel"));
			}

			if (!(request.getParameter("rue").trim().isEmpty() || request.getParameter("rue") == null)) {
				newUser.setRue((String) request.getParameter("rue"));
			}

			if (!(request.getParameter("cpo").trim().isEmpty() || request.getParameter("cpo") == null)) {
				newUser.setCodePostal((String) request.getParameter("cpo"));
			}

			if (!(request.getParameter("ville").trim().isEmpty() || request.getParameter("ville") == null)) {
				newUser.setVille((String) request.getParameter("ville"));
			}

			if (request.getParameter("new-mdp").trim().isEmpty() || request.getParameter("new-mdp") == null) {
				try {
					user = um.modifierCompte(newUser, request.getParameter("mdp").toString());
					user.setCredit(creditLocal);
					request.getSession().setAttribute("utilisateur", user);
					connexion = request.getRequestDispatcher("/WEB-INF/jsp/profil.jsp");

				} catch (BLLException e2) {
					connexion = request.getRequestDispatcher("/WEB-INF/jsp/gestion-profil.jsp");
					if (connexion != null) {
						request.setAttribute("error", e2);
					}
				}
			} else {
				newUser.setMotDePasse((String) request.getParameter("new-mdp"));
				try {
					user = um.modifierCompte(newUser, (String) request.getParameter("confirmation"),
							(String) request.getParameter("mdp"));
					user.setCredit(creditLocal);
					request.getSession().setAttribute("utilisateur", user);
					connexion = request.getRequestDispatcher("/WEB-INF/jsp/profil.jsp");
				} catch (BLLException e3) {
					connexion = request.getRequestDispatcher("/WEB-INF/jsp/gestion-profil.jsp");
					if (connexion != null) {
						request.setAttribute("error", e3);
					}
				}
			}
			if (connexion != null) {
				connexion.forward(request, response);
			}
			// Suppresion du compte

		} else {
			Utilisateur user = (Utilisateur) request.getSession().getAttribute("utilisateur");
			try {
				um.supprimerCompte(user.getNoUtilisateur(), (String) request.getParameter("mdp"));
				request.getSession().invalidate();
				response.sendRedirect(request.getContextPath() + "/accueillir");
			} catch (BLLException e4) {
				connexion = request.getRequestDispatcher("/WEB-INF/jsp/gestion-profil.jsp");
				if (connexion != null) {
					request.setAttribute("error", e4);
					connexion.forward(request, response);
				}
			}
		}
	}
}
