package fr.eni.projetencheres.bll;

public class Test {

	public static void main(String[] args) {
		UtilisateurManager um = UtilisateurManager.getInstance();
		um.sInscrire("jean","rené" , "ploison", "blabla.moc@gmail.com", "0625644684","12 impasse Ampere", "85000", "la roche sur yon", "simple");

	}

}
