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
	public Utilisateur seConnecter(String login, String motDePasse) {
		Utilisateur user;
		user = dao.seConnecter(login, motDePasse);
		return user;
	}

}
