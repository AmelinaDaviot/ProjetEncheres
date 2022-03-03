package fr.eni.projetencheres.bll;

import java.sql.SQLException;

import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.dal.DAOFactory;
import fr.eni.projetencheres.dal.UtilisateurDAO;

public class UtilisateurManager {

	private static UtilisateurManager instance;

	private UtilisateurDAO dao;

	// constructeur + conncetion avec DAO
	public UtilisateurManager() {
		try {
			dao = DAOFactory.createUtilisateurDAO();
		} catch (SQLException e) {

		}
	}

	// singleton
	public static UtilisateurManager getInstance() {
		if (instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}

	// methode de verification de connection
	// TODO Gestion d'erreur
	public Utilisateur seConnecter(String pseudo, String motDePasse) {
		Utilisateur user = null;
		user = dao.seConnecter(pseudo, motDePasse);
		return user;
	}

	public void sInscrire (String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, String confirmation) throws Exception {
		if (motDePasse.equals(confirmation)) {
		Utilisateur user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
		dao.insert(user);
		} else {
			Exception BLLException = new Exception("mots de passes différent");
			throw BLLException;
			
		} 
			
			}

}
