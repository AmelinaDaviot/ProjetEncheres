package fr.eni.projetencheres.dal;

import java.sql.SQLException;

public class DAOFactory {

	public static UtilisateurDAO createUtilisateurDAO() throws DALException {
		try {
			return new UtilisateurImplJdbcDAO();
		} catch (DALException e) {
			throw e;
		}
	}

	public static ArticleDAO createArticleDAO() throws DALException {
		try {
			return new ArticleImplJdbcDAO();
		} catch (DALException e) {
			throw e;
		}
		
	}

	public static EnchereDAO createEnchereDAO() throws DALException {
		try {
			return new EnchereImplJdbcDAO();
		} catch (DALException e) {
			throw e;
		}
	}
}
