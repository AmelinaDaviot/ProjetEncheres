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

	private final static String INSERT_NOUVEL_UTILISATEUR = "INSERT INTO UTILISATEURS"
			+ "(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, 100, 0)";

	private final static String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";

	private final static String UPDATE_UTILISATEUR = "UPDATE FROM UTILISATEURS "
			+ "SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, "
			+ "ville = ?, mot_de_passe = ? " + "WHERE no_utilisateur = ?";

	private final static String DELETE_UTILISATEUR = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";

	Connection cnx;

	public UtilisateurImplJdbcDAO() throws SQLException {
		cnx = ConnectionProvider.getConnection();
	}

	/**
	 * Methode seConnecter
	 * 
	 * @return user
	 */
	@Override
	public Utilisateur seConnecter(String identifiant, String mot_de_passe, boolean email) {
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
						rs.getString("code_postal"), rs.getString("ville"), null);
			} else {

			}
		} catch (SQLException e) {
			System.out.println("Erreur de connexion");
			e.getMessage();
		}

		if (user == null) {
			System.out.println("Utilisateur inconnu");
		}

		return user;
	}

	/**
	 * Procedure insertion Inserer un nouvel utilisateur (inscription)
	 * @return 
	 */
	@Override
	public  Utilisateur insert(Utilisateur user) {
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

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				user.setNoUtilisateur(rs.getInt(1));
			}

			stmt.close();

		} catch (SQLException e) {

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
	public Utilisateur update(Utilisateur user) {
		try {
			PreparedStatement stmt = cnx.prepareStatement(UPDATE_UTILISATEUR);
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
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block (coder exceptions)
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void delete(int no_utilisateur) {
		try {
			PreparedStatement stmt = cnx.prepareStatement(DELETE_UTILISATEUR);
			stmt.setInt(1, no_utilisateur);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
