package weka.project;

import java.util.List;
import data.BinaryDataSource;
import data.MnistImage;
import data.TextDataSource;

public class Main {

    public static void main(String[] args) {
        
        try {
            
            String imagesPath = "C:/Users/ahmed/Downloads/archive/train-images.idx3-ubyte";
            String labelsPath = "C:/Users/ahmed/Downloads/archive/train-labels.idx1-ubyte";
            String csvPath = "C:/Users/ahmed/Downloads/mnist_3_5.csv";
            String arffPath = "C:/Users/ahmed/Downloads/mnist_3_5.arff";

            
            System.out.println("⏳ 1. Lecture des fichiers...");
            BinaryDataSource binarySrc = new BinaryDataSource(imagesPath);
            List<MnistImage> images = binarySrc.readData();
            binarySrc.loadLabels(images, labelsPath);

         
            System.out.println("\n⏳ 2. Préparation et Création du CSV...");
            List<MnistImage> filteredImages = data.MnistDatasetBuilder.createDataset(images, 2000); // 2000 de chaque
            
            TextDataSource textSrc = new TextDataSource(csvPath);
            textSrc.writeData(filteredImages);

            
            System.out.println("\n⏳ 3. Conversion en format ARFF...");
            ArffBuilder.convertCsvToArff(csvPath, arffPath);

            
            System.out.println("\n🚀 4. Entraînement des Modèles...");
            System.out.println("\n--- Modèle Naive Bayes ---");
            Classifier nb = new NaiveBayesModel();
            nb.train(arffPath);
            System.out.println("✅ Précision Naive Bayes : " + nb.getAccuracy() + "%");

            
            System.out.println("\n--- Modèle Random Forest ---");
            Classifier rf = new RandomForestModel();
            rf.train(arffPath); 
            System.out.println("✅ Précision Random Forest : " + rf.getAccuracy() + "%");
         
            System.out.println("\n🎨 6. Ouverture de l'interface graphique...");
           
            javax.swing.SwingUtilities.invokeLater(() -> {
                DashboardFrame frame = new DashboardFrame(nb, rf);
                frame.setVisible(true);
            });

        } catch (Exception e) {
            System.err.println("❌ Une erreur est survenue !");
            e.printStackTrace();
        }
    }
}