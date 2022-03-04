package exceptions;

public class CustomerInsufficientFunds extends RuntimeException{
    public CustomerInsufficientFunds(String message){
        super(message);
    }
}
