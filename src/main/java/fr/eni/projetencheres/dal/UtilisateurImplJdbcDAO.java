package fr.eni.projetencheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.utils.ConnectionProvider;

/**
 * @author adaviot2021
 *
 */
public class UtilisateurImplJdbcDAO implements UtilisateurDAO {

	private final static String SE_CONNECTER_PSEUDO = "SELECT * " + "FROM UTILISATEURS "
			+ "WHERE pseudo = ? AND mot_de_passe = ?";

	private final static String SE_CONNECTER_MAIL = "SELECT * " + "FROM UTILISATEURS "
			+ "WHERE email = ? AND mot_de_passe = ?";

	private final static String INSERT_NOUVEL_UTILISATEUR = "INSERT INTO UTILISATEURS "
			+ "(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, 100, 0)";

	private final static String SELECT_MDP_BY_ID = "SELECT mot_de_passe FROM UTILISATEURS WHERE no_utilisateur = ?";

	private final static String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";

	private final static String UPDATE_UTILISATEUR = "UPDATE UTILISATEURS "
			+ "SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, "
			+ "ville = ?, mot_de_passe = ? " + "WHERE no_utilisateur = ?";

	private final static String DELETE_UTILISATEUR = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";

	Connection cnx;

	public UtilisateurImplJdbcDAO() throws DALException {
		try {
			cnx = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			throw new DALException(e.getMessage());
		}
	}

	/**
	 * Methode seConnecter
	 * 
	 * @return user
	 * @throws DALException = r�cup�rer la violation de la cl� unique (pseudo et
	 *                      mail)
	 */
	@Override
	public Utilisateur seConnecter(String identifiant, String mot_de_passe, boolean email) throws DALException {
		Utilisateur user = null;
		try {
			PreparedStatement stmt = null;
			if (email) {
				stmt = cnx.prepareStatement(SE_CONNECTER_MAIL);
			} else {
				stmt = cnx.prepareStatement(SE_CONNECTER_PSEUDO);
			}
			stmt.setString(1, identifiant);
			stmt.setString(2, mot_de_passe);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"), null, rs.getInt("credit"));
			}
		} catch (SQLException e) {
			throw new DALException("Echec de connexion : " + e.getMessage());
		}

		if (user == null) {			
			throw new DALException("Utilisateur inconnu");
		}

		return user;
	}

	/**
	 * Procedure insertion Inserer un nouvel utilisateur (inscription)
	 * 
	 * @return
	 * @throws DALException
	 */
	@Override
	public Utilisateur insert(Utilisateur user) throws DALException {
		try {
			PreparedStatement stmt = cnx.prepareStatement(INSERT_NOUVEL_UTILISATEUR,
					PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, user.getPseudo());
			stmt.setString(2, user.getNom());
			stmt.setString(3, user.getPrenom());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getTelephone());
			stmt.setString(6, user.getRue());
			stmt.setString(7, user.getCodePostal());
			stmt.setString(8, user.getVille());
			stmt.setString(9, user.getMotDePasse());

			stmt.executeUpdate();

			user.setCredit(100);

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				user.setNoUtilisateur(rs.getInt(1));
			}

			stmt.close();

		} catch (SQLException e) {
			System.out.println("erreur" + e.getMessage());
			if (e.getMessage().contains("UQ_utilisateurs_pseudo")) {
				System.out.println("erreur pseudo");
				throw new DALException("Echec de l'inscription : pseudo d�j� utilis� !");
			}
			if (e.getMessage().contains("UQ_utilisateurs_email")) {
				System.out.println("erreur email");
				throw new DALException("Echec de l'inscription : adresse mail d�j� utilis�e !");
			}
			throw new DALException("Echec de l'inscription : " + e.getMessage());
		}
		return user;

	}

	/**
	 * @return user
	 */
	@Override
	public Utilisateur selectById(int no_utilisateur) {
		ResultSet rs = null;
		Utilisateur user = null;
		try {
			PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, no_utilisateur);
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"), null, rs.getInt("credit"));
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Utilisateur update(Utilisateur user, String mdpActuel) throws DALException {
		ResultSet rs = null;
		try {
			PreparedStatement stmt = cnx.prepareStatement(SELECT_MDP_BY_ID);
			stmt.setInt(1, user.getNoUtilisateur());
			rs = stmt.executeQuery();
			if (rs.next()) {
				String mdpBDD = rs.getString("mot_de_passe");
				if (mdpBDD.equals(mdpActuel)) {

					PreparedStatement stmt2 = cnx.prepareStatement(UPDATE_UTILISATEUR);
					stmt2.setString(1, user.getPseudo());
					stmt2.setString(2, user.getNom());
					stmt2.setString(3, user.getPrenom());
					stmt2.setString(4, user.getEmail());
					stmt2.setString(5, user.getTelephone());
					stmt2.setString(6, user.getRue());
					stmt2.setString(7, user.getCodePostal());
					stmt2.setString(8, user.getVille());
					if (user.getMotDePasse() == null) {
						stmt2.setString(9, mdpBDD);
					} else {
						stmt2.setString(9, user.getMotDePasse());
					}
					stmt2.setInt(10, user.getNoUtilisateur());

					stmt2.executeUpdate();
					stmt2.close();
				} else {
					throw new DALException("Erreur de mise a jour du profil : mot de passe actuel incorrect");
				}

			}

			stmt.close();
		} catch (SQLException e) {
			throw new DALException("Erreur lors de la mise a jour du profil : " + e.getMessage());
		}

		return user;
	}

	@Override
	public void delete(int no_utilisateur, String mdp) throws DALException {
		try {
			PreparedStatement stmt = cnx.prepareStatement(SELECT_MDP_BY_ID);
			stmt.setInt(1, no_utilisateur);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String mdpBDD = rs.getString("mot_de_passe");
				if (mdpBDD.equals(mdp)) {
					stmt = cnx.prepareStatement(DELETE_UTILISATEUR);
					stmt.setInt(1, no_utilisateur);
					stmt.executeUpdate();
					stmt.close();
				} else {
					throw new DALException("Erreur lors de la suppression du profil : Mot de passe incorrect ");
				}
			}
		} catch (SQLException e) {
			throw new DALException("Erreur lors de la suppression du profil : " + e.getMessage());
		}
	}
}
