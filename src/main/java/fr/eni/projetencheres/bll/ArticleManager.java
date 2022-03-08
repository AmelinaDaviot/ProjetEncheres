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
	 * @param dateDebutEnchere
	 * @param dateFinEnchere
	 * @param prixInitial
	 * @param user
	 * @param cat
	 * @param etatVente
	 * @param image
	 * @return art
	 */
//	public Article vendre(String nom, String description, LocalDate dateDebutEnchere, LocalDate dateFinEnchere,
//			int prixInitial, Utilisateur user, Categorie cat, char etatVente, String image) {
//		
//		Article art = null;
//
//		art = new Article(nom, description, dateDebutEnchere, dateFinEnchere, prixInitial, prixInitial, user, 
//				cat, etatVente, image);
//
//		return art;
//
//	}

	public Article vendre(String nom, String description, int codeCategorie, String libelle, String image,
			int prixInitial, LocalDate dateDebutEnchere, LocalDate dateFinEnchere, String rue, String cpo, String ville,
			Utilisateur user) {

//		Article a;
//		Retrait r;

		Article a = new Article(nom, description, image, prixInitial, dateDebutEnchere, dateFinEnchere);
		Retrait r = new Retrait(rue, cpo, ville);
		Categorie c = new Categorie(codeCategorie, libelle);
		
		a.setRetrait(r);
		a.setCategorie(c);
		a.setVendeur(user);
		
		return a;

	}

}
