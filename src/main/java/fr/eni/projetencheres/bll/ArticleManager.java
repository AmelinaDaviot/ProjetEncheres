package fr.eni.projetencheres.bll;

import java.time.LocalDate;

import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.dal.ArticleDAO;
import fr.eni.projetencheres.dal.DAOFactory;

public class ArticleManager {

	private static ArticleManager instance;
	private ArticleDAO articleDAO;

	// CONSTRUTEUR
	public ArticleManager() {
		articleDAO = DAOFactory.createArticleDAO();
	}

	// SINGLETON
	public static ArticleManager getInstance() {
		if (instance == null) {
			instance = new ArticleManager();
		}
		return instance;
	}

	public Article vendre(String nom, String description, LocalDate dateDebutEnchere, LocalDate dateFinEnchere,
			int prixInitial, int noUtilisateur, int noCategorie, char etatVente, String image) {
		Article art = null;

		art = new Article(nom, description, dateDebutEnchere, dateFinEnchere, prixInitial, noUtilisateur,
				noCategorie, etatVente, image);

		return art;

	}

}
