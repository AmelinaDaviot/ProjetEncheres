package fr.eni.projetencheres.bll;

import java.sql.SQLException;

import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.dal.DALException;
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
	/**
	 * 
	 * @param identifiant
	 * @param motDePasse
	 * @return user
	 * @throws BLLException = echec de connexion (identifiant ou mdp incorrects)
	 */
	public Utilisateur seConnecter(String identifiant, String motDePasse) throws BLLException {
		Utilisateur user = null;
		try {
			user = dao.seConnecter(identifiant, motDePasse, identifiant.contains("@"));
			if (user == null) {
				// Attraper la DALException et la personnaliser en BLLException
				throw new BLLException("Echec de la connexion : identifiant ou mot de passe incorrects");
			}
		} catch (DALException e) {
			throw new BLLException("Echec de la connexion");
		}
		return user;
	}

	/**
	 * Methode permettant a l'utilisateur de s'inscrire
	 * 
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 * @param confirmation
<<<<<<< HEAD
	 * @throws BLLException = cas ou pseudo ou email deja existants
=======
	 * @throws BLLException
	 * @throws BLLException = cas ou motDePasse et confirmation ne sont PAS EGAUX
>>>>>>> branch 'master' of https://github.com/AmelinaDaviot/ProjetEncheres
	 */
	public Utilisateur sInscrire(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, String confirmation) throws BLLException {
		Utilisateur user = null;

		user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
		
		try {			

			if (!motDePasse.equals(confirmation)) {
				throw new BLLException("Echec de l'inscription : le mot de passe et la confirmation sont "
						+ "différents !");
			} 
			
			dao.insert(user);
			
		} catch (DALException e) {
			System.out.println("erreur BLL " + e.getMessage());
			throw new BLLException(e.getMessage());
		}
<<<<<<< HEAD
		
=======

		if (motDePasse.equals(confirmation)) {
		}
//		else {
//			Exception BLLException = new Exception("mots de passe different");
//			throw BLLException;
//
//		}
>>>>>>> branch 'master' of https://github.com/AmelinaDaviot/ProjetEncheres
		return user;
	}

	/**
	 * Mï¿½thode pour modifier le compte de l'utilisateur
	 * 
	 * @param user
	 * @return
	 */
	public Utilisateur modifierCompte(Utilisateur user, String confirmation) {
		if (user.getMotDePasse().equals(confirmation)) {
			user = dao.update(user);

		} else {
//TODO exception BLLEception (mdp et confirm diff)
		}
		return user;
	}

	/**
	 * Mï¿½thode pour supprimer le compte de l'utilisateur
	 * 
	 * @param noUtilisateur
	 */
	public void supprimerCompte(int noUtilisateur) {
		dao.delete(noUtilisateur);
	}

}
