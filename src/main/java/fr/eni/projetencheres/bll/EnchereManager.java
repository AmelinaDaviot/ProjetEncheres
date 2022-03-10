package fr.eni.projetencheres.bll;


import java.time.LocalDate;

import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.bo.Enchere;
import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.dal.ArticleDAO;
import fr.eni.projetencheres.dal.DALException;
import fr.eni.projetencheres.dal.DAOFactory;
import fr.eni.projetencheres.dal.EnchereDAO;
import fr.eni.projetencheres.dal.UtilisateurDAO;

public class EnchereManager {

	private static EnchereManager instance;

	private EnchereDAO daoEnchere;
	private UtilisateurDAO daoUser;
	private ArticleDAO daoArticle;

	public EnchereManager() {
		try {
			daoEnchere = DAOFactory.createEnchereDAO();
		} catch (Exception e) {
		}
	}

	public EnchereManager getInstance() {
		if (instance == null) {
			instance = new EnchereManager();
		}
		return instance;
	}

	public Enchere Encherir(int montant, int no_article, int no_utilisateur) throws BLLException {
		Enchere enchere = null;
		try {
			daoArticle = DAOFactory.createArticleDAO();
			Article article = daoArticle.selectById(no_article);
			daoUser = DAOFactory.createUtilisateurDAO();
			Utilisateur acheteur = daoUser.selectById(no_utilisateur);
			enchere = new Enchere(montant, article, acheteur);
			enchere = daoEnchere.encherir(enchere);

		} catch (DALException e) {
			throw new BLLException(e.getMessage());
		}
		return enchere;
	}
}
