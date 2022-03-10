package fr.eni.projetencheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetencheres.bo.Article;
import fr.eni.projetencheres.bo.Retrait;
import fr.eni.projetencheres.utils.ConnectionProvider;

public class ArticleImplJdbcDAO implements ArticleDAO {

	private final static String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS "
			+ "(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, "
			+ "no_utilisateur, no_categorie, etat_vente, image) " + "VALUES(?, ?, ?, ?, ?, ?, ?, DEFAULT, ?)";

	private final static String INSERT_RETRAIT = "INSERT INTO RETRAITS " + "(no_article, rue, code_postal, ville) "
			+ "VALUES (?, ?, ?, ?)";

	private final static String SELECT_ARTICLE_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?";

	private final static String SELECT_ALL_ARTICLE = "SELECT * FROM ARTICLES_VENDUS"
			+ "WHERE etat_vente = 'EC'";

//			"SELECT ARTICLES_VENDUS.*, CATEGORIES.* "
//			+ "FROM ARTICLES_VENDUS INNER JOIN CATEGORIES "
//			+ "ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie " 
//			+ "WHERE ARTICLES_VENDUS.no_article = ?";
//	
	private final static String DELETE_ARTICLE = "DELETE FROM ARTICLES_VENDUS WHERE no_article = ?";

	Connection cnx;

	public ArticleImplJdbcDAO() throws SQLException {
		cnx = ConnectionProvider.getConnection();
	}

	@Override
	public Article insert(Article art, Retrait r) throws DALException {
		try {
			System.out.println("DAL : entrée dans l'insertion");
			PreparedStatement stmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			System.out.println(art.toString());
			stmt.setString(1, art.getNom());
			stmt.setString(2, art.getDescription());
			stmt.setDate(3, Date.valueOf(art.getDateDebutEnchere()));
			stmt.setDate(4, Date.valueOf(art.getDateFinEnchere()));
			stmt.setInt(5, art.getPrixInitial());
//			stmt.setInt(6, art.getPrixVente());
			stmt.setInt(6, art.getVendeur().getNoUtilisateur());
			stmt.setInt(7, art.getCategorie().getNoCategorie());
			if (art.getImage().trim().isEmpty()) {
				stmt.setString(8, null);
			} else {
				stmt.setString(8, art.getImage());
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
	public Article selectById(int noArticle) throws DALException {
		ResultSet rs = null;
		Article art = null;

		try {
			PreparedStatement stmt = cnx.prepareStatement(SELECT_ARTICLE_BY_ID);
			stmt.setInt(1, noArticle);
			rs = stmt.executeQuery();
			if (rs.next()) {
				art.setNoArticle(rs.getInt("no_article"));
				art.setNom(rs.getString("nom_article"));
				if (Integer.valueOf(art.getPrixVente()) != null) {
					art.setPrixVente(rs.getInt("prix_vente"));
				} else {
					art.setPrixInitial(rs.getInt("prix_initial"));
				}
				art.setDateFinEnchere(rs.getDate("date_fin_enchere").toLocalDate());
//				art.setVendeur(rs.getInt("no_utilisateur"));
				art.getVendeur().setNoUtilisateur(rs.getInt("no_utilisateur"));

//				art = new Article(rs.getInt("no_article"), rs.getString("nom_article"), 
//						rs.getString("description"), rs.getDate("date_debut_enchere").toLocalDate(), 
//						rs.getDate("date_fin_enchere").toLocalDate(), rs.getInt("prix_initial"),
//						rs.getInt("prix_vente"), rs.getString("etat_vente"), rs.getString("image"));
			}
			stmt.close();
		} catch (SQLException e) {
			throw new DALException("Erreur affichage article vendu" + e.getMessage());
		}

		return art;
	}

	@Override
	public List<Article> selectAll() throws DALException {

		List<Article> listeArticles = new ArrayList<Article>();
		/*
		 * (nom_article, description, date_debut_enchere, date_fin_enchere,
		 * prix_initial, " + "no_utilisateur, no_categorie, etat_vente, image)
		 */

		try {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_ARTICLE);

			while (rs.next()) {
				Article art = new Article(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getDate("date_debut_enchere").toLocalDate(),
						rs.getDate("date_fin_enchere").toLocalDate(), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"), rs.getString("etat_vente"), rs.getString("image"));
				listeArticles.add(art);
			}

		} catch (SQLException e) {
			throw new DALException("Erreur affichage liste Articles" + e.getMessage());
		}

		return listeArticles;
	}

	@Override
	public void delete(int no_article) throws DALException {
		try {
			PreparedStatement stmt = cnx.prepareStatement(DELETE_ARTICLE);
			stmt.setInt(1, no_article);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new DALException("Erreur lors de l'annulation de la vente" + e.getMessage());
		}

	}

}
