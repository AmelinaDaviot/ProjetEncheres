package fr.eni.projetencheres.bo;

import java.time.LocalDate;

public class Article {

	private int noArticle;
	private String nom;
	private String description;
	private LocalDate dateDebutEnchere;
	private LocalDate dateFinEnchere;
	private int prixInitial;
	private int prixVente;
	private int noUtilisateur;
	private int noCategorie;
	private char etatVente;
	private String image;

	// CONSTRUCTEURS
	public Article(String nom, String description, LocalDate dateDebutEnchere, LocalDate dateFinEnchere,
			int prixInitial, int prixVente, int noUtilisateur, int noCategorie, char etatVente, String image) {
		this.nom = nom;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
		this.etatVente = etatVente;
		this.image = image;
	}

	public Article(int noArticle, String nom, String description, LocalDate dateDebutEnchere, LocalDate dateFinEnchere,
			int prixInitial, int prixVente, int noUtilisateur, int noCategorie, char etatVente, String image) {
		this(nom, description, dateDebutEnchere, dateFinEnchere, prixInitial, prixVente, noUtilisateur, noCategorie,
				etatVente, image);
		this.noArticle = noArticle;
	}

	// GETTERS ET SETTERS
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEnchere() {
		return dateDebutEnchere;
	}

	public void setDateDebutEnchere(LocalDate dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}

	public LocalDate getDateFinEnchere() {
		return dateFinEnchere;
	}

	public void setDateFinEnchere(LocalDate dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}

	public int getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public char getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(char etatVente) {
		this.etatVente = etatVente;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	// METHODE TOSTRING
	
	@Override
	public String toString() {
		return "Article [noArticle=" + noArticle + ", nom=" + nom + ", description=" + description
				+ ", dateDebutEnchere=" + dateDebutEnchere + ", dateFinEnchere=" + dateFinEnchere + ", prixInitial="
				+ prixInitial + ", prixVente=" + prixVente + ", noUtilisateur=" + noUtilisateur + ", noCategorie="
				+ noCategorie + ", etatVente=" + etatVente + ", image=" + image + "]";
	}

}
