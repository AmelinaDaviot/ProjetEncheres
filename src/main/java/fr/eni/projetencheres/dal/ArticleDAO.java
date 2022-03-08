package fr.eni.projetencheres.dal;

import fr.eni.projetencheres.bo.Article;

public interface ArticleDAO {
	
	public Article insert(Article art) throws DALException;
	public Article selectById(int noArticle);

}
