package cardoso.felipe.exceptions;

public class NotAllowedTransactionException extends RuntimeException {
    public NotAllowedTransactionException(String message) {

        System.out.println("NotAllowedTransactionException: " + message);
    }
}
