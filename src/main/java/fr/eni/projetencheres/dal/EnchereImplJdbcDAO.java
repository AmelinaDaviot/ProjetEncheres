package fr.eni.projetencheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projetencheres.bo.Enchere;
import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.utils.ConnectionProvider;

public class EnchereImplJdbcDAO implements EnchereDAO {

	private final static String CREER_ENCHERE = "INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) values (?, ?,getdate(),?)";

	private final static String UPDATE_ENCHERE = "  UPDATE ENCHERES SET no_utilisateur = ?, date_enchere = GETDATE(), montant_enchere = ? where no_article = ? ";

	private final static String SELECT_ENCHERE = "select "
			+ "	art.description 'description_article', art.date_debut_enchere 'debut_enchère',"
			+ "	art.date_fin_enchere 'fin_enchères',art.etat_vente 'etat_vente',"
			+ "	cat.libelle 'libelle_categorie', cat.no_categorie 'no_catégorie',"
			+ "	vendeur.pseudo 'pseudo_vendeur',"
			+ "	ench.date_enchere 'date_encherissement', ench.montant_enchere 'montant_enchere',"
			+ "	encherisseur.pseudo 'pseudo_acheteur'" 
			+ "		from ARTICLES_VENDUS as art"
			+ "		inner join CATEGORIES as cat" + " on art.no_categorie = cat.no_categorie"
			+ "		inner join UTILISATEURS as vendeur" + " on vendeur.no_utilisateur = art.no_utilisateur"
			+ "		left outer join ENCHERES as ench " + " on ench.no_article = art.no_article"
			+ "		inner join Utilisateurs as encherisseur" + " on encherisseur.no_utilisateur = ench.no_utilisateur"
			+ "		where (getdate() between art.date_debut_enchere and art.date_fin_enchere) and art.etat_vente in ('EC')";

	private final static String SELECT_BY_NO_ARTICLE = "select"
			+ "art.nom_article 'nom_article', art.description 'description_article', art.date_debut_enchere 'debut_enchère',"
			+ "	art.date_fin_enchere 'fin_enchères',art.etat_vente 'etat_vente',"
			+ "	cat.libelle 'libelle_categorie', cat.no_categorie 'no_catégorie',"
			+ "vendeur.pseudo 'pseudo_vendeur',"
			+ "ench.date_enchere 'date_encherissement', ench.montant_enchere 'montant_enchere',"
			+ "			encherisseur.pseudo 'pseudo_acheteur',"
			+ "	rtr.rue 'rue', rtr.code_postal 'code_postal', rtr.ville 'ville'" 
			+ "	from ARTICLES_VENDUS as art"
			+ "		left join RETRAITS as rtr" + "			on art.no_article = rtr.no_article"
			+ "		left join CATEGORIES as cat" + "			on art.no_categorie = cat.no_categorie"
			+ "		left join UTILISATEURS as vendeur" + "			on vendeur.no_utilisateur = art.no_utilisateur"
			+ "	left join ENCHERES as ench" + "		on ench.no_article = art.no_article"
			+ "	left join Utilisateurs as encherisseur" + "		on encherisseur.no_utilisateur = ench.no_utilisateur"
			+ "where art.no_article = ?";

	private Connection cnx;

	public EnchereImplJdbcDAO() throws DALException {
		try {
		cnx = ConnectionProvider.getConnection();
		}catch (SQLException e) {
			throw new DALException (e.getMessage());
		}

	}

	@Override
	public Enchere encherir(Enchere enchere) throws DALException {
		PreparedStatement stmt;
		try {
			if (Integer.valueOf(enchere.getArticle().getPrixVente()) == null) {
				stmt = cnx.prepareStatement(CREER_ENCHERE);
				stmt.setInt(1, enchere.getAcheteur().getNoUtilisateur());
				stmt.setInt(2, enchere.getArticle().getNoArticle());
				stmt.setInt(3, enchere.getMontantEnchere());
			} else {
				stmt = cnx.prepareStatement(UPDATE_ENCHERE);
				stmt.setInt(1, enchere.getAcheteur().getNoUtilisateur());
				stmt.setInt(2, enchere.getMontantEnchere());
				stmt.setInt(3, enchere.getArticle().getNoArticle());
			}
		stmt.executeUpdate();
		stmt = cnx.prepareStatement(SELECT_BY_NO_ARTICLE);
		stmt.setInt(1, enchere.getArticle().getNoArticle());
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			enchere = update(enchere, rs);			
		}
			
			
			
		} catch (SQLException e) {
			e.getMessage();
			throw new DALException("Erreur lors de la connexion a la base de donnée", e);
		}
		
	
		return enchere;
	}

	

	@Override
	public Enchere selectByIdArticle(int no_article) {
		Enchere enchere = null;
		return enchere;
	}

	@Override
	public Enchere selectByIdVendeur(int no_utilisateur) {
		Enchere enchere = null;
		return enchere;
	}


	public Enchere update(Enchere enchere, ResultSet rs) throws DALException {
		
		try {
			enchere.getAcheteur().setPseudo(rs.getString("pseudo_acheteur"));
			enchere.getArticle().setNom(rs.getString("nom_article"));
			enchere.getArticle().setDescription(rs.getString("description_article"));
			enchere.getArticle().setDateDebutEnchere(rs.getDate("debut_enchère").toLocalDate());
			enchere.getArticle().setDateFinEnchere(rs.getDate("fin_enchères").toLocalDate());
			
			
		} catch (SQLException e) {
			throw new DALException(e.getMessage());
		}
		
		
		
		return enchere;
	}

	@Override
	public void delete(int no_article) throws DALException {

	}

}
