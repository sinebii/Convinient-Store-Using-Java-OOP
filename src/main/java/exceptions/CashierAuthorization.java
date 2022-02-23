package exceptions;

public class CashierAuthorization extends RuntimeException{

    public CashierAuthorization(String message){

        super(message);
    }
}
