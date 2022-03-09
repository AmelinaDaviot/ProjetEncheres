package fr.eni.projetencheres.bo;

import java.time.LocalDate;

public class Enchere {
	
	private LocalDate dateEnchere;
	private int montantEnchere;
	private Article article;
	private Utilisateur vendeur;
	private Utilisateur acheteur;
	
	
	public Enchere(LocalDate dateEnchere, int montantEnchere, Article article, Utilisateur vendeur,
			Utilisateur acheteur) {
		
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.article = article;
		this.vendeur = vendeur;
		this.acheteur = acheteur;
	}


	public LocalDate getDateEnchere() {
		return dateEnchere;
	}


	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}


	public int getMontantEnchere() {
		return montantEnchere;
	}


	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}


	public Article getArticle() {
		return article;
	}


	public void setArticle(Article article) {
		this.article = article;
	}


	public Utilisateur getVendeur() {
		return vendeur;
	}


	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}


	public Utilisateur getAcheteur() {
		return acheteur;
	}


	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}


	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + ", article=" + article
				+ ", vendeur=" + vendeur + ", acheteur=" + acheteur + "]";
	}
	
	
	
	

}
