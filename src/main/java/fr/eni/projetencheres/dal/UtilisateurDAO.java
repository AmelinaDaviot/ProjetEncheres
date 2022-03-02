package fr.eni.projetencheres.dal;

import fr.eni.projetencheres.bo.Utilisateur;

public interface UtilisateurDAO {
	public Utilisateur seConnecter(String pseudo, String mot_de_passe);
	public void insert (Utilisateur user);

}
