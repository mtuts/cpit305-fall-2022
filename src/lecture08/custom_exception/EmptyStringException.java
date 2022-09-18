package lecture08.custom_exception;

public class EmptyStringException extends RuntimeException {

    public EmptyStringException() {
        super("Empty String Exception");
    }

    public EmptyStringException(String message) {
        super(message);
    }
}
