package fr.eni.projetencheres.dal;

import fr.eni.projetencheres.bo.Enchere;


public interface EnchereDAO {
	
	public Enchere encherir (Enchere enchere) throws DALException;
	public Enchere selectByIdArticle(int no_article);
	public Enchere selectByIdVendeur(int no_utilisateur);
	public Enchere update (int no_article) throws DALException;
	public void delete(int no_article) throws DALException;

}
