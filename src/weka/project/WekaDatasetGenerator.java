package weka.project;

import java.util.ArrayList;
import java.util.List;

import data.MnistImage;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;

public class WekaDatasetGenerator {

   
    public static Instances createDataset(List<MnistImage> images) {
        
        
        ArrayList<Attribute> attributes = new ArrayList<>();
        
       
        for (int i = 0; i < 784; i++) {
            attributes.add(new Attribute("pixel_" + i));
        }
        
       
        ArrayList<String> classValues = new ArrayList<>();
        
        for (int i = 0; i <= 9; i++) {
            classValues.add(String.valueOf(i));
        }
        Attribute labelAttribute = new Attribute("label", classValues);
        attributes.add(labelAttribute);
        
        
        Instances dataset = new Instances("MnistDataset", attributes, images.size());
        
        
        dataset.setClassIndex(dataset.numAttributes() - 1);
        
        
        for (MnistImage img : images) {
            
            DenseInstance instance = new DenseInstance(785);
            
            
            int[] pixels = img.getPixels();
            for (int i = 0; i < pixels.length; i++) {
                instance.setValue(attributes.get(i), pixels[i]);
            }
            
            
            instance.setValue(labelAttribute, String.valueOf(img.getLabel()));
            
            
            dataset.add(instance);
        }
        
        return dataset;
    }
}