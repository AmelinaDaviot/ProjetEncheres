package fr.eni.projetencheres.bo;

import java.time.LocalDate;

public class Enchere {
	
	private LocalDate dateEnchere;
	private int montantEnchere;
	private Article article;
	private Utilisateur acheteur;
	
	

	public Enchere(int montantEnchere, Article article, Utilisateur acheteur) {		
		this.montantEnchere = montantEnchere;
		this.article = article;
		this.acheteur = acheteur;
		this.dateEnchere = LocalDate.now();
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


		public Utilisateur getAcheteur() {
		return acheteur;
	}


	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}


	
	

}
