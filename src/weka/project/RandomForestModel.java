package weka.project;

import java.util.Random;

import data.PixelVector;
import exceptions.MnistIOException;
import exceptions.ModelNotTrainedException;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.RandomForest;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class RandomForestModel implements Classifier {

    private RandomForest model;
    private boolean isTrained;
    private double accuracy;
    private Instances datasetStructure;

    public RandomForestModel() {
        this.model = new RandomForest();
        this.isTrained = false;
        this.accuracy = 0.0;
    }

    @Override
    public void train(String arffPath) throws MnistIOException {
        try {
            DataSource source = new DataSource(arffPath);
            Instances data = source.getDataSet();
            if (data.classIndex() == -1) {
                data.setClassIndex(data.numAttributes() - 1);
            }
            this.datasetStructure = data;

            Evaluation eval = new Evaluation(data);
            eval.crossValidateModel(model, data, 10, new Random(1));
            this.accuracy = eval.pctCorrect();

            model.buildClassifier(data);
            this.isTrained = true;

        } catch (Exception e) {
            throw new MnistIOException("Erreur lors de l'entraînement du modèle Random Forest", e);
        }
    }

    @Override
    public int predict(PixelVector v) throws ModelNotTrainedException {
        if (!isTrained) {
            throw new ModelNotTrainedException("Le modèle n'a pas été entraîné !");
        }
        
        try {
            Instance instance = v.toWekaInstance(datasetStructure);
            double predictionIndex = model.classifyInstance(instance);
            String predictedClass = datasetStructure.classAttribute().value((int) predictionIndex);
            
            
            if ("trois".equals(predictedClass)) {
                return 3;
            } else if ("cinq".equals(predictedClass)) {
                return 5;
            } else {
               
                return Integer.parseInt(predictedClass); 
            }
            // ----------------------
            
        } catch (Exception e) {
            System.err.println("Erreur de prédiction : " + e.getMessage());
            return -1;
        }
    }

    @Override
    public double getAccuracy() {
        return this.accuracy;
    }

    @Override
    public String getModelName() {
        return "Random Forest";
    }
}
