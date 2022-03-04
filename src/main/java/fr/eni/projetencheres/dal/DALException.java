package fr.eni.projetencheres.dal;

public class DALException extends Exception {
	
	//Constructeurs
	
	public DALException() {
		super();
	}
	
	public DALException(String message) {
		super(message);
	}
	
	public DALException(String message, Throwable exception) {
		super(message, exception);
	}
	
//	@Override
//	public String getMessage() {
//		// TODO Auto-generated method stub
//		return super.getMessage();
//	}

}
