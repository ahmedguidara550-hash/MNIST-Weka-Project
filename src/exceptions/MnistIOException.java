package exceptions;

public class MnistIOException extends Exception {
	public MnistIOException (String message) {
		super(message);
	}
	public MnistIOException(String message,Throwable cause ) {
		super(message,cause);
	}

}
