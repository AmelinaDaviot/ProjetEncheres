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

		UtilisateurManager um;
		try {
			um = UtilisateurManager.getInstance();
			Utilisateur user = null;
			user = um.seConnecter(request.getParameter("identifiant"), request.getParameter("motDePasse"));
			RequestDispatcher rq = request.getRequestDispatcher("/accueillir");
			if (rq != null) {
				HttpSession session = request.getSession();
				session.setAttribute("utilisateur", user);				
				rq.forward(request, response);
			}

		} catch (BLLException e) {
			e.printStackTrace();
			RequestDispatcher connexion = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			if (connexion != null) {
				request.setAttribute("error", e);
				connexion.forward(request, response);
			}
		}

	}
}
