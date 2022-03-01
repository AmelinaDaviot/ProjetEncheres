package fr.eni.projetencheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.utils.ConnectionProvider;

public class UtilisateurImplJdbcDAO implements UtilisateurDAO {
	
	private final static String INSERT_NOUVEL_UTILISATEUR = 
			"INSERT INTO UTILISATEURS"
			+ "(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

	Connection cnx;
	
	public UtilisateurImplJdbcDAO() throws SQLException {
		cnx = ConnectionProvider.getConnection();
	}
	
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
