package fr.eni.projetencheres.dal;

import java.sql.Connection;
import java.sql.SQLException;

import fr.eni.projetencheres.bo.Enchere;
import fr.eni.projetencheres.utils.ConnectionProvider;

public class EnchereImplJdbcDAO implements EnchereDAO {
	
	private final static String SELECT_ENCHERE = "select "
			+ "	art.description 'description article', art.date_debut_enchere 'debut enchère',"
			+ "	art.date_fin_enchere 'fin enchères',art.etat_vente 'etat de vente',"
			+ "	cat.libelle 'libelle de categorie', cat.no_categorie 'no catégorie',"
			+ "	vendeur.pseudo 'pseudo vendeur',"
			+ "	ench.date_enchere 'date encherissement', ench.montant_enchere 'montant enchere',"
			+ "	encherisseur.pseudo 'pseudo acheteur'"
			+ "		from ARTICLES_VENDUS as art"
			+ "		inner join CATEGORIES as cat"
			+ "			on art.no_categorie = cat.no_categorie"
			+ "		inner join UTILISATEURS as vendeur"
			+ "			on vendeur.no_utilisateur = art.no_utilisateur"
			+ "		left outer join ENCHERES as ench "
			+ "			on ench.no_article = art.no_article"
			+ "		inner join Utilisateurs as encherisseur"
			+ "			on encherisseur.no_utilisateur = ench.no_utilisateur"
			+ "		where (getdate() between art.date_debut_enchere and art.date_fin_enchere) and art.etat_vente in ('EC')";
	
	private final static String SELECT_BY_NO_ARTICLE = "select "
			+ "	art.description 'description article', art.date_debut_enchere 'debut enchère',"
			+ "	art.date_fin_enchere 'fin enchères',art.etat_vente 'etat de vente',"
			+ "	cat.libelle 'libelle de categorie', cat.no_categorie 'no catégorie',"
			+ "	vendeur.pseudo 'pseudo vendeur',"
			+ "	ench.date_enchere 'date encherissement', ench.montant_enchere 'montant enchere',"
			+ "	encherisseur.pseudo 'pseudo acheteur'"
			+ "		from ARTICLES_VENDUS as art"
			+ "		inner join CATEGORIES as cat"
			+ "			on art.no_categorie = cat.no_categorie"
			+ "		inner join UTILISATEURS as vendeur"
			+ "			on vendeur.no_utilisateur = art.no_utilisateur"
			+ "		left outer join ENCHERES as ench "
			+ "			on ench.no_article = art.no_article"
			+ "		inner join Utilisateurs as encherisseur"
			+ "			on encherisseur.no_utilisateur = ench.no_utilisateur"
			+ "		where (getdate() between art.date_debut_enchere and art.date_fin_enchere) and art.no_article = ?";
	
	
	private final static String ENCHERIR;
	
	
	Connection cnx;
	
	public EnchereImplJdbcDAO() throws SQLException {
		cnx = ConnectionProvider.getConnection();
	}
	
	@Override
	public Enchere encherir(Enchere enchere) throws DALException {
		Enchere enchereUpdate = null;
		return enchereUpdate;
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

	@Override
	public Enchere update(int no_article) throws DALException {
		Enchere enchere = null;
		return enchere;
	}
	
@Override
	public void delete(int no_article) throws DALException {

	}

}
