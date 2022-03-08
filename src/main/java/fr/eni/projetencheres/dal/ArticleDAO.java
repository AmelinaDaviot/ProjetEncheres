package fr.eni.projetencheres.dal;

import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.bo.Retrait;

public interface ArticleDAO {
	
	public Article insert(Article art, Retrait r) throws DALException;
	public Article selectById(int noArticle);


}
