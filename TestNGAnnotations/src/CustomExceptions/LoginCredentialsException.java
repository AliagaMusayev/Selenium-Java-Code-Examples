package CustomExceptions;

public class LoginCredentialsException extends Exception {

    public LoginCredentialsException(){ }

    public LoginCredentialsException(String message){
        super(message);
    }
}
