package weka.project;

import java.util.Random;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;

public class Test {

    
    public static void trainAndEvaluate(Instances dataset) {
        try {
            System.out.println("🤖 Début de l'entraînement de l'IA (Algorithme J48)...");
            
            
            J48 classifier = new J48();
            
            
            Evaluation eval = new Evaluation(dataset);
            eval.crossValidateModel(classifier, dataset, 10, new Random(1));
            
            
            classifier.buildClassifier(dataset);
            
            
            System.out.println("✅ Entraînement terminé !");
            System.out.println("\n=== RÉSUMÉ DES PERFORMANCES ===");
            System.out.println(eval.toSummaryString());
            
            System.out.println("\n=== MATRICE DE CONFUSION ===");
            System.out.println(eval.toMatrixString());
            
        } catch (Exception e) {
            System.out.println("❌ Erreur lors de l'entraînement : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
