package exception;

public class StartDateSucceedsEndDateException extends RuntimeException {
    public StartDateSucceedsEndDateException(String message) {
        super(message);
    }
}
