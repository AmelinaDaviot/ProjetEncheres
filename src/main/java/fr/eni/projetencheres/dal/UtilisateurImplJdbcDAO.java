package fr.eni.projetencheres.dal;

public class UtilisateurImplJdbcDAO implements UtilisateurDAO {
	
	private final static String INSERT_NOUVEL_UTILISATEUR = 
			"INSERT INTO UTILISATEURS"
			+ "(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

	@Override
	public void insert(Utilisateur user) {
		// TODO Auto-generated method stub
		
	}

}
