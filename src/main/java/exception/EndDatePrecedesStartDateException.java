package exception;

public class EndDatePrecedesStartDateException extends RuntimeException {
    public EndDatePrecedesStartDateException(String message) {
        super(message);
    }
}
