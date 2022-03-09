package fr.eni.projetencheres.bll;

import fr.eni.projetencheres.bo.Enchere;
import fr.eni.projetencheres.dal.DAOFactory;
import fr.eni.projetencheres.dal.EnchereDAO;

public class EnchereManager {

	private static EnchereManager instance;

	private EnchereDAO dao;

	public EnchereManager() {
		try {
			dao = DAOFactory.createEnchereDAO();
		} catch (Exception e) {
		}
	}

	public EnchereManager getInstance() {
		if (instance == null) {
			instance = new EnchereManager();
		}
		return instance;
	}
	
	public Enchere Encherir(Enchere enchere) {
		
		
		return enchere;
	}
}
