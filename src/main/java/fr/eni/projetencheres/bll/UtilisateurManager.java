package fr.eni.projetencheres.bll;

import fr.eni.projetencheres.bo.Utilisateur;
import fr.eni.projetencheres.dal.DALException;
import fr.eni.projetencheres.dal.DAOFactory;
import fr.eni.projetencheres.dal.UtilisateurDAO;

public class UtilisateurManager {

	private static UtilisateurManager instance;

	private UtilisateurDAO dao;

	// constructeur + conncetion avec DAO
	public UtilisateurManager() throws BLLException {
		try {
			dao = DAOFactory.createUtilisateurDAO();
		} catch (DALException e) {
			throw new BLLException(e.getMessage());
		}
	}

	// singleton
	public static UtilisateurManager getInstance() throws BLLException {
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
	 * @throws BLLException = cas ou pseudo ou email deja existants
	 * @throws BLLException
	 * @throws BLLException = cas ou motDePasse et confirmation ne sont PAS EGAUX
	 */
	public Utilisateur sInscrire(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, String confirmation) throws BLLException {
		Utilisateur user = null;

		user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);

		try {

			if (!motDePasse.equals(confirmation)) {
				throw new BLLException(
						"Echec de l'inscription : le mot de passe et la confirmation sont " + "diff�rents !");
			}

			dao.insert(user);

		} catch (DALException e) {
			throw new BLLException(e.getMessage());
		}

		return user;
	}

	/**
	 * M�thode pour modifier le compte de l'utilisateur verifie si le nouveau mdp et
	 * la confriamtion sont égaux si oui : fait la requete de mise a jour si non :
	 * souleve et propage une BLLException
	 * 
	 * @param user, confirmation
	 * @return user
	 * @throws BLLException
	 */
	public Utilisateur modifierCompte(Utilisateur user, String confirmation, String mdpActuel) throws BLLException {
		if (user.getMotDePasse().equals(confirmation)) {
			try {
				user = dao.update(user, mdpActuel);
			} catch (DALException e) {
				throw new BLLException(e.getMessage());
			}
		} else {
			throw new BLLException(
					"Echec de l'inscription : le mot de passe et la confirmation sont " + "différents !");
		}
		return user;
	}

	public Utilisateur modifierCompte(Utilisateur user, String mdpActuel) throws BLLException {
		try {
			user = dao.update(user, mdpActuel);

		} catch (DALException e) {
			throw new BLLException(e.getMessage());
		}
		return user;
	}

	/**
	 * M�thode pour supprimer le compte de l'utilisateur
	 * 
	 * @param noUtilisateur
	 * @throws BLLException
	 */
	public void supprimerCompte(int noUtilisateur, String mdp) throws BLLException {
		try {
			dao.delete(noUtilisateur, mdp);
		} catch (DALException e) {
			throw new BLLException(e.getMessage());
		}
	}

}
