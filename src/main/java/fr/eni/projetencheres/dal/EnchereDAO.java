package fr.eni.projetencheres.dal;

import java.sql.ResultSet;
import fr.eni.projetencheres.bo.Enchere;


public interface EnchereDAO {
	
	public Enchere encherir (Enchere enchere) throws DALException;
	public Enchere selectByIdArticle(int no_article);
	public Enchere selectByIdVendeur(int no_utilisateur);
	public Enchere update (Enchere enchere, ResultSet rs) throws DALException;
	public void delete(int no_article) throws DALException;

}
