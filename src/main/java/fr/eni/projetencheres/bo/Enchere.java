package fr.eni.projetencheres.bo;

import java.time.LocalDate;

public class Enchere {
	
	private LocalDate dateEnchere;
	private int montantEnchere;
	private int no_article;
	private int no_acheteur;
	
	
	public Enchere(LocalDate dateEnchere, int montantEnchere, int no_article, int no_acheteur) {
		
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.no_article = no_article;
		this.no_acheteur = no_acheteur;
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


	public int getArticle() {
		return no_article;
	}


	public void setArticle(int no_article) {
		this.no_article = no_article;
	}


		public int getAcheteur() {
		return no_acheteur;
	}


	public void setAcheteur(int no_acheteur) {
		this.no_acheteur = no_acheteur;
	}


	
	

}
