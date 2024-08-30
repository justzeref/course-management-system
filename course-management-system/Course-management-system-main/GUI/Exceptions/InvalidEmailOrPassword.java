package GUI.Exceptions;

public class InvalidEmailOrPassword extends RuntimeException{
    private static final long serialVersionUID = 1L;

	public InvalidEmailOrPassword(String errorMessage) {  
        super(errorMessage);  
        }  
}

