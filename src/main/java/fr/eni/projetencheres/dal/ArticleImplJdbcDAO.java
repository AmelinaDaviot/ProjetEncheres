package fr.eni.projetencheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.bo.Retrait;
import fr.eni.projetencheres.utils.ConnectionProvider;

public class ArticleImplJdbcDAO implements ArticleDAO {

	private final static String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS "
			+ "(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, "
			+ "no_utilisateur, no_categorie, etat_vente, image) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, DEFAULT, ?)";

	private final static String INSERT_RETRAIT = "INSERT INTO RETRAITS "
			+ "(no_article, rue, code_postal, ville) "
			+ "VALUES (?, ?, ?, ?)";

	private final static String SELECT_ARTICLE_BY_ID = "SELECT ARTICLES_VENDUS.*, CATEGORIES.* "
			+ "FROM ARTICLES_VENDUS INNER JOIN CATEGORIES "
			+ "ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie " 
			+ "WHERE ARTICLES_VENDUS.no_article = ?";

	Connection cnx;

	public ArticleImplJdbcDAO() throws SQLException {
		cnx = ConnectionProvider.getConnection();
	}
	
	@Override
	public Article insert(Article art, Retrait r) throws DALException {
		try {
			System.out.println("DAL : entrée dans l'insertion");
			PreparedStatement stmt = cnx.prepareStatement(INSERT_ARTICLE, 
					PreparedStatement.RETURN_GENERATED_KEYS);
			System.out.println(art.toString());
			stmt.setString(1, art.getNom());
			stmt.setString(2, art.getDescription());
			stmt.setDate(3, Date.valueOf(art.getDateDebutEnchere()));
			stmt.setDate(4, Date.valueOf(art.getDateFinEnchere()));
			stmt.setInt(5, art.getPrixInitial());
			stmt.setInt(6, art.getPrixVente());
			stmt.setInt(7, art.getVendeur().getNoUtilisateur());
			stmt.setInt(8, art.getCategorie().getNoCategorie());
			if (art.getImage().trim().isEmpty()) {
				stmt.setString(9, null);
			} else {
				stmt.setString(9, art.getImage());
			}
			
			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				art.setNoArticle(rs.getInt(1));
//				int noArticle = rs.getInt(1);
//				art.setNoArticle(noArticle);
				stmt.close();
				
				stmt = cnx.prepareStatement(INSERT_RETRAIT);
				stmt.setInt(1, art.getNoArticle());
				stmt.setString(2, r.getRue());
				stmt.setString(3, r.getCodePostal());
				stmt.setString(4, r.getVille());
				stmt.executeUpdate();
				stmt.close();
				System.out.println("fermeture statement retrait");
			}
							
		} catch (SQLException e) {
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
