package fr.eni.projetencheres.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetencheres.bll.ArticleManager;
import fr.eni.projetencheres.bll.BLLException;
import fr.eni.projetencheres.bo.Article;

/**
 * Servlet implementation class AccueillirServlet
 */
@WebServlet("/accueillir")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			ArticleManager am = ArticleManager.getInstance();
			List<Article> listeArticles = am.getArticles();
			request.setAttribute("listeArticles", listeArticles);

			RequestDispatcher rq = null;
			if (request.getSession().getAttribute("utilisateur") != null) {
				rq = request.getRequestDispatcher("/WEB-INF/jsp/accueilConnecte.jsp");
			} else {
				rq = request.getRequestDispatcher("/WEB-INF/jsp/accueilNonConnecte.jsp");
			}
			if (rq != null) {
				rq.forward(request, response);
			} else {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
