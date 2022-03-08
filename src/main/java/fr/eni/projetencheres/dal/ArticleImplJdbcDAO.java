package fr.eni.projetencheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.bo.Retrait;

public class ArticleImplJdbcDAO implements ArticleDAO {

	private final static String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS "
			+ "(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, "
			+ "no_utilisateur, no_categorie, etat_vente, image) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private final static String INSERT_RETRAIT = "INSERT INTO RETRAITS "
			+ "(no_article, rue, code_postal, ville) "
			+ "VALUES (?, ?, ?, ?)";

	private final static String SELECT_ARTICLE = "SELECT ARTICLES_VENDUS.*, CATEGORIES.* "
			+ "FROM ARTICLES_VENDUS INNER JOIN CATEGORIES "
			+ "ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie " 
			+ "WHERE ARTICLES_VENDUS.no_article = ?";

	Connection cnx;

	@Override
	public Article insert(Article art, Retrait r) throws DALException {
		try {
			PreparedStatement stmt = cnx.prepareStatement(INSERT_ARTICLE, 
					PreparedStatement.RETURN_GENERATED_KEYS);
			System.out.println(art.toString());
			stmt.setString(1, art.getNom());
			stmt.setString(2, art.getDescription());
			stmt.setDate(3, Date.valueOf(art.getDateDebutEnchere()));
			stmt.setDate(4, Date.valueOf(art.getDateFinEnchere()));
			stmt.setInt(5, art.getPrixInitial());
			stmt.setInt(6, art.getPrixVente());
			stmt.setInt(7, art.getNoUtilisateur());
			stmt.setInt(8, art.getNoCategorie());
			stmt.setString(9, String.valueOf(art.getEtatVente()));
			stmt.setString(10, art.getImage());

			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				int noArticle = rs.getInt(1);
				art.setNoArticle(noArticle);
				stmt.close();
				
				stmt = cnx.prepareStatement(INSERT_RETRAIT);
				stmt.setString(1, r.getRue());
				stmt.setString(2, r.getCodePostal());
				stmt.setString(3, r.getVille());
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Ca marche pas : " + e.getMessage());
			throw new DALException("Erreur de mise en vente : " + e.getMessage());
		}
		return art;
	}

	@Override
	public Article selectById(int noArticle) {
		ResultSet rs = null;
		Article art;
		return null;
	}

}
