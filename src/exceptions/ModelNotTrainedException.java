package exceptions;

public class ModelNotTrainedException extends Exception {
    
    
    public ModelNotTrainedException(String message) {
        super(message);
    }

   
    public ModelNotTrainedException(String message, Throwable cause) {
        super(message, cause);
    }
}
