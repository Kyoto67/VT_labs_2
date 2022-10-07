package exception;

public class WrongValueException extends Exception{
    public WrongValueException(String ErrorMessage){
        super(ErrorMessage);
    }
}
