package exceptions;

public class InvalidMNISTFormatException extends Exception {
	public InvalidMNISTFormatException(String message) {
        super(message);
    }

    public InvalidMNISTFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
