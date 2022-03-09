package fr.eni.projetencheres.dal;

import java.sql.Connection;
import java.sql.SQLException;

import fr.eni.projetencheres.bo.Enchere;
import fr.eni.projetencheres.utils.ConnectionProvider;

public class EnchereImplJdbcDAO implements EnchereDAO {
	
	private final static String CREER_ENCHERE = "INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) values (?, ?,getdate(),?)";
	
	private final static String UPDATE_ENCHERE = "  UPDATE ENCHERES SET no_utilisateur = ?, date_enchere = GETDATE(), montant_enchere = ? where no_article = ? "; 
	
	
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
	
	private final static String SELECT_BY_NO_ARTICLE = "select"
			+ "art.nom_article 'nom article', art.description 'description article', art.date_debut_enchere 'debut enchère',\r\n"
			+ "	art.date_fin_enchere 'fin enchères',art.etat_vente 'etat de vente',\r\n"
			+ "	cat.libelle 'libelle de categorie', cat.no_categorie 'no catégorie',\r\n"
			+ "vendeur.pseudo 'pseudo vendeur',\r\n"
			+ "ench.date_enchere 'date encherissement', ench.montant_enchere 'montant enchere',\r\n"
			+ "			encherisseur.pseudo 'pseudo acheteur',\r\n"
			+ "	rtr.rue 'rue', rtr.code_postal 'code postal', rtr.ville 'ville'\r\n"
			+ "\r\n"
			+ "	from ARTICLES_VENDUS as art\r\n"
			+ "		left join RETRAITS as rtr\r\n"
			+ "			on art.no_article = rtr.no_article\r\n"
			+ "		left join CATEGORIES as cat\r\n"
			+ "			on art.no_categorie = cat.no_categorie\r\n"
			+ "		left join UTILISATEURS as vendeur\r\n"
			+ "			on vendeur.no_utilisateur = art.no_utilisateur\r\n"
			+ "	left join ENCHERES as ench\r\n"
			+ "		on ench.no_article = art.no_article\r\n"
			+ "	left join Utilisateurs as encherisseur\r\n"
			+ "		on encherisseur.no_utilisateur = ench.no_utilisateur\r\n"
			+ "where (getdate() between art.date_debut_enchere and art.date_fin_enchere) and art.no_article = ?\r\n";
		
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
