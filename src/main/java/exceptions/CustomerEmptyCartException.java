package exceptions;

public class CustomerEmptyCartException extends Exception{

    public CustomerEmptyCartException(String message){
        super(message);

    }
}
