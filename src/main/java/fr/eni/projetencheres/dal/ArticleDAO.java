package fr.eni.projetencheres.dal;

import java.util.List;

import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.bo.Retrait;

public interface ArticleDAO {
	
	public Article insert(Article art, Retrait r) throws DALException;
	public Article selectById(int noArticle) throws DALException;
	public List<Article> selectAll() throws DALException;
	public void delete(int no_article) throws DALException;


}
