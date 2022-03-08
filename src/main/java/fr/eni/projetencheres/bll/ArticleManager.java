package fr.eni.projetencheres.bll;

import java.time.LocalDate;

import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.bo.Categorie;
import fr.eni.projetencheres.bo.Retrait;
import fr.eni.projetencheres.bo.Utilisateur;
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

	/**
	 * 
	 * @param nom
	 * @param description
	 * @param codeCategorie
	 * @param libelle
	 * @param image
	 * @param prixInitial
	 * @param dateDebutEnchere
	 * @param dateFinEnchere
	 * @param rue
	 * @param cpo
	 * @param ville
	 * @param user
	 * @return a
	 */
	public Article vendre(String nom, String description, int codeCategorie, String libelle, String image,
			int prixInitial, LocalDate dateDebutEnchere, LocalDate dateFinEnchere, String rue, String cpo, String ville,
			Utilisateur user) {

		Article a = new Article(nom, description, dateDebutEnchere, dateFinEnchere, prixInitial, image);
		Retrait r = null;
		Categorie c = null;
		
		a.setRetrait(r);
		a.setCategorie(c);
		a.setVendeur(user);
		
		return a;

	}

}
