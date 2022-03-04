package fr.eni.projetencheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetencheres.bll.UtilisateurManager;
import fr.eni.projetencheres.bo.Utilisateur;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher connexion = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		if (connexion != null) {
			connexion.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UtilisateurManager um = UtilisateurManager.getInstance();
		try {
			Utilisateur user = null;
			user = um.seConnecter(request.getParameter("identifiant"), request.getParameter("motDePasse"));
			request.setAttribute("utilisateur", user);
			RequestDispatcher rq = request.getRequestDispatcher("/WEB-INF/jsp/accueilConnecte.jsp");
			if (rq != null) {
				HttpSession session = request.getSession();
				session.setAttribute("pseudo", user.getPseudo());
				session.setAttribute("nom", user.getNom());
				session.setAttribute("prenom", user.getPrenom());
				session.setAttribute("email", user.getEmail());
				session.setAttribute("telephone", user.getTelephone());
				session.setAttribute("rue", user.getRue());
				session.setAttribute("codePostal", user.getCodePostal());
				session.setAttribute("ville", user.getVille());
				session.setAttribute("credit", user.getCredit());
				session.setAttribute("noUtilisateur", user.getNoUtilisateur());
				rq.forward(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
