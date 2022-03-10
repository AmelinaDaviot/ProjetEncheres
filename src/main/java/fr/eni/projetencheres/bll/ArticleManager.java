package fr.eni.projetencheres.bll;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.bo.Categorie;
import fr.eni.projetencheres.bo.Retrait;
import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.dal.ArticleDAO;
import fr.eni.projetencheres.dal.DALException;
import fr.eni.projetencheres.dal.DAOFactory;

public class ArticleManager {

	private static ArticleManager instance;
	private ArticleDAO articleDAO;

	// CONSTRUTEUR
	public ArticleManager() {
		try {
			articleDAO = DAOFactory.createArticleDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// SINGLETON
	public static ArticleManager getInstance() {
		if (instance == null) {
			instance = new ArticleManager();
		}
		return instance;
	}

	/**
	 * Permettre la mise en vente d'un article
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
		Retrait r = new Retrait(rue, cpo, ville);
		Categorie c = new Categorie(codeCategorie, libelle);

		a.setRetrait(r);
		a.setCategorie(c);
		a.setVendeur(user);

		System.out.println("BLL : ça marche");
		System.out.println(a.toString());

		try {
			articleDAO.insert(a, r);
			System.out.println("entrée dans l'insertion");
		} catch (DALException e) {
			System.out.println("erreur BLL" + e.getMessage());
		}

		return a;
	}

	/**
	 * Récupérer les articles par le noArticle
	 * @param noArticle
	 * @return art
	 * @throws BLLException
	 */
	public Article getArticleById(int noArticle) throws BLLException {
		Article art = null;
		try {
			art = articleDAO.selectById(noArticle);
			System.out.println("BLL : selection reussie");
		} catch (DALException e) {
			throw new BLLException("Echec getArticleById : " + e.getMessage());
		}
		return art;
	}

	/**
	 * Liste des articles en vente
	 * @return articles
	 * @throws BLLException
	 */
	public List<Article> getArticles() throws BLLException {
		List<Article> articles = null;
		try {
			articles = articleDAO.selectAll();
		} catch (DALException e) {
			throw new BLLException("Echec getArticles : " + e.getMessage());
		}
		return articles;
	}

	/**
	 * Permettre l'annulation d'une vente
	 * @param no_article
	 * @throws BLLException
	 */
	public void annulerVente(int no_article) throws BLLException {
		try {
			articleDAO.delete(no_article);
		} catch (DALException e) {
			throw new BLLException(e.getMessage());
		}
	}

}
