package exceptions;

public class DimensionMismatchException extends Exception {
	public DimensionMismatchException(String message) {
        super(message);
    }
	public DimensionMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

}

