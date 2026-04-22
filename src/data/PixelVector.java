package data;

import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;


public class PixelVector implements Comparable<PixelVector> {
    
    private int[] intensities;

    public PixelVector(int[] intensities) {
        this.intensities = intensities;
    }

    
    public double[] normalize() {
        double[] normalized = new double[intensities.length];
        for (int i = 0; i < intensities.length; i++) {
            normalized[i] = this.intensities[i] / 255.0;
        }
        return normalized;
    }

   
    public Instance toWekaInstance(Instances dataset) {
        Instance instance = new DenseInstance(dataset.numAttributes());
        instance.setDataset(dataset);
        
        for (int i = 0; i < intensities.length; i++) {
            instance.setValue(i, intensities[i]);
        }
        return instance;
    }

    
    @Override
    public int compareTo(PixelVector other) {
        
        return Integer.compare(this.intensities.length, other.intensities.length);
    }
    
    public int[] getIntensities() {
        return intensities;
    }
}