package fr.eni.projetencheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.utils.ConnectionProvider;

public class UtilisateurImplJdbcDAO implements UtilisateurDAO {
	
	private final static String SE_CONNECTER = 
			"SELECT no_utilisateur, pseudo, nom, prenom, email "
			+ "FROM UTILISATEURS "
			+ "WHERE pseudo = ? AND mot_de_passe = ?";
	
	private final static String INSERT_NOUVEL_UTILISATEUR = 
			"INSERT INTO UTILISATEURS"
			+ "(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

	Connection cnx;
	
	public UtilisateurImplJdbcDAO() throws SQLException {
		cnx = ConnectionProvider.getConnection();
	}
	
	/**
	 * Methode seConnecter
	 * @return user
	 */
	@Override
	public Utilisateur seConnecter(String pseudo, String mot_de_passe) {
		Utilisateur user = null;
		try {
			PreparedStatement stmt = cnx.prepareStatement(SE_CONNECTER);
			stmt.setString(1, pseudo);
			stmt.setString(2, mot_de_passe);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				user = new Utilisateur(rs.getInt("no_utilisateur"),
						rs.getString("pseudo"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("email"),
						rs.getString("telephone"),
						rs.getString("rue"),
						rs.getString("code_postal"),
						rs.getString("ville"),
						null
						);
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
	 * Procédure insertion
	 * Insérer un nouvel utilisateur (inscription)
	 */
	@Override
	public void insert(Utilisateur user) {
		try {
			PreparedStatement stmt = cnx.prepareStatement(INSERT_NOUVEL_UTILISATEUR);
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

}
