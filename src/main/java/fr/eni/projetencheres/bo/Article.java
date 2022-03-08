package fr.eni.projetencheres.bo;

import java.time.LocalDate;

public class Article {

	// ATTRIBUTS
	private int noArticle;
	private String nom;
	private String description;
	private LocalDate dateDebutEnchere;
	private LocalDate dateFinEnchere;
	private int prixInitial;
	private int prixVente;

	private int noUtilisateur;
	private int noCategorie;

	private Utilisateur user;
	private Categorie c;
	private Retrait r;

	private String etatVente;
	private String image;

	// CONSTRUCTEURS
	public Article(String nom, String description, LocalDate dateDebutEnchere, LocalDate dateFinEnchere,
			int prixInitial, int prixVente, String etatVente, String image) {
		this.nom = nom;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.image = image;
	}

	public Article(int noArticle, String nom, String description, LocalDate dateDebutEnchere, LocalDate dateFinEnchere,
			int prixInitial, int prixVente, String etatVente, String image) {
		this(nom, description, dateDebutEnchere, dateFinEnchere, prixInitial, prixVente, etatVente, image);
		this.noArticle = noArticle;
	}

	public Article(String nom, String description, LocalDate dateDebutEnchere, LocalDate dateFinEnchere,
			int prixInitial, String image) {
		this(nom, description, dateDebutEnchere, dateFinEnchere, prixInitial, prixInitial, description, image);
	}

	// GETTERS ET SETTERS
	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

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

	public String getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

//	public void setNoUtilisateur(int noUtilisateur) {
//		this.noUtilisateur = noUtilisateur;
//	}

	public int getNoCategorie() {
		return noCategorie;
	}

//	public void setNoCategorie(int noCategorie) {
//		this.noCategorie = noCategorie;
//	}

	// METHODE TO_STRING

	// METHODES SET
	public void setRetrait(Retrait r) {
		this.r = new Retrait(r.getRue(), r.getCodePostal(), r.getVille());
	}

	public void setCategorie(Categorie c) {
		this.c = new Categorie(c.getNoCategorie(), c.getLibelle());
	}

	public void setVendeur(Utilisateur user) {
		this.noUtilisateur = user.getNoUtilisateur();
	}

}
