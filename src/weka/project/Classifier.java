package weka.project;

import data.PixelVector;
import exceptions.MnistIOException;
import exceptions.ModelNotTrainedException;

public interface Classifier {
    
    void train(String arffPath) throws MnistIOException;
    
    int predict(PixelVector v) throws ModelNotTrainedException;
    
    double getAccuracy();
    
    String getModelName();
}