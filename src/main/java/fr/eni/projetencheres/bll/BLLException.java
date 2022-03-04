package fr.eni.projetencheres.bll;

public class BLLException extends Exception {
	
	public BLLException(String message) {
		super(message);
	}
	
	public BLLException(String message, Exception e) {
		super(message, e);
	}

}
