package weka.project;

import java.io.File;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

public class ArffBuilder {

    
    public static void convertCsvToArff(String csvPath, String arffPath) throws Exception {
        System.out.println("   -> Conversion du CSV en ARFF...");
        
        
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File(csvPath));
        Instances data = loader.getDataSet();

        
        ArffSaver saver = new ArffSaver();
        saver.setInstances(data);
        saver.setFile(new File(arffPath));
        saver.writeBatch();
        
        System.out.println("   -> ✅ Fichier ARFF généré : " + arffPath);
    }
}


