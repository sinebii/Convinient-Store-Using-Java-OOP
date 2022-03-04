package exceptions;

public class CustomerAlreadyInQueueException extends RuntimeException{

    public CustomerAlreadyInQueueException(String message){
        super(message);
    }
}
