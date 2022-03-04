package fr.eni.projetencheres.dal;

import fr.eni.projetencheres.bo.Utilisateur;

public interface UtilisateurDAO {
	public Utilisateur seConnecter(String pseudo, String mot_de_passe, boolean email);
	public Utilisateur insert (Utilisateur user);
	public Utilisateur selectById(int no_utilisateur);
	public Utilisateur update (Utilisateur user);
	public void delete(int no_utilisateur);

}
