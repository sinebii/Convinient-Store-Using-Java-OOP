package exceptions;

public class DeclinedTransaction extends RuntimeException{

    public DeclinedTransaction(String message){

        super(message);
    }
}
