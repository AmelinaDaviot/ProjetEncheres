package fr.eni.projetencheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.projetencheres.bo.Article;

public class ArticleImplJdbcDAO implements ArticleDAO {

	private final static String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS "
			+ "(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, "
			+ "etat_vente, image) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	
	private final static String SELECT_ARTICLE = "SELECT ARTICLES_VENDUS.*, CATEGORIES.* "
			+ "FROM ARTICLES_VENDUS INNER JOIN CATEGORIES "
			+ "ON ARTICLES_VENDUS.no_article = CATEGORIES.no_categorie "
			+ "WHERE ARTICLES_VENDUS.no_categorie = ?";
	
	Connection cnx;
	
	@Override
	public Article insert(Article art) throws DALException {
		try {
			PreparedStatement stmt = cnx.prepareStatement(INSERT_ARTICLE);
			System.out.println(art.toString());
			stmt.setString(1, art.getNom());
			stmt.setString(2, art.getDescription());
			stmt.setDate(3, Date.valueOf(art.getDateDebutEnchere()));
			stmt.setDate(4, Date.valueOf(art.getDateFinEnchere()));
			stmt.setInt(5, art.getPrixInitial());
			stmt.setInt(6, art.getPrixVente());
			stmt.setString(7, String.valueOf(art.getEtatVente()));
			stmt.setString(8, art.getImage());
			
			stmt.executeUpdate();
			
			stmt.close();
		} catch (SQLException e) {
			throw new DALException("Erreur de mise en vente : " + e.getMessage());
		}
		return art;
	}

}
