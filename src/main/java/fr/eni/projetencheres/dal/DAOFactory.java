package fr.eni.projetencheres.dal;

import java.sql.SQLException;

public class DAOFactory {

	public static UtilisateurDAO createUtilisateurDAO() throws SQLException {
		return new UtilisateurImplJdbcDAO();
	}
	
	public static ArticleDAO createArticleDAO() throws SQLException {
		return new ArticleImplJdbcDAO();
	}
	
	public static EnchereDAO createEnchereDAO () throws SQLException {
		return new EnchereImplJdbcDAO();
	}
}
