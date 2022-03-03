package fr.eni.projetencheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetencheres.bll.UtilisateurManager;

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
		
		String pseudo = request.getParameter("pseudo");
		String mdp = request.getParameter("motDePasse");	
		
		UtilisateurManager um = UtilisateurManager.getInstance();
		try {
			um.seConnecter(pseudo, mdp);
			
			
			//Si creation du profil est validee, l'utilisateur est redirige vers la page d'accueil
			response.sendRedirect(request.getContextPath() + "/accueilConnecte.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
