package fr.eni.projetencheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetencheres.bll.ArticleManager;
import fr.eni.projetencheres.bll.BLLException;
import fr.eni.projetencheres.bo.Article;

/**
 * Servlet implementation class GestionArticleServlet
 */
@WebServlet("/gestion-article")
public class GestionArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ANNULATION VENTE ARTICLE
//		Article art;
//		ArticleManager am = ArticleManager.getInstance();
//		try {
//			if (art.getEtatVente().equals('CR') {
//				am.annulerVente(art.getNoArticle());
//				response.sendRedirect(request.getContextPath() + "/accueillir");
//			}
//			
//		} catch (BLLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
