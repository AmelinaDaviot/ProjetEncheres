package fr.eni.projetencheres.dal;

import fr.eni.projetencheres.bo.Utilisateur;

public interface UtilisateurDAO {
	public Utilisateur seConnecter(String pseudo, String mot_de_passe);
	public void insert (Utilisateur user);
	public Utilisateur selectById(int no_utilisateur);
	public void update (Utilisateur user);
	public void delete(int no_utilisateur);

}
