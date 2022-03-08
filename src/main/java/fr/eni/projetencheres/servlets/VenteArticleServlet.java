package fr.eni.projetencheres.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetencheres.bll.ArticleManager;
import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.bo.Utilisateur;

/**
 * Servlet implementation class VenteArticleServlet
 */
@WebServlet("/vendre-article")
public class VenteArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rq = request.getRequestDispatcher("/WEB-INF/jsp/venteArticle.jsp");
		if (rq != null) {
			rq.forward(request, response);
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// INFOS ARTICLE
		String nom = request.getParameter("nom");
		String description = request.getParameter("description");
		String image = request.getParameter("image");
		int prix = Integer.valueOf(request.getParameter("prix"));
		LocalDate debutEnchere = LocalDate.parse(request.getParameter("debutEnchere"));
		LocalDate finEnchere = LocalDate.parse(request.getParameter("finEnchere"));
		
		// INFOS CATEGORIE
		String cat = request.getParameter("categorie");
		String[] categories = cat.split(":");
		int codeCategorie = Integer.valueOf(categories[0]);
		String libelle = categories[1];
		
		// INFOS RETRAIT
		String rue = request.getParameter("rue");
		String cpo = request.getParameter("cpo");
		String ville = request.getParameter("ville");
		
		// INFOS USER
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("utilisateur");
		
		ArticleManager am = ArticleManager.getInstance();
		Article a = am.vendre(nom, description, codeCategorie, libelle, image, prix, debutEnchere, finEnchere, 
				rue, cpo, ville, user);
		
		response.sendRedirect(request.getContextPath() + "/accueillir");
		
	}

}
