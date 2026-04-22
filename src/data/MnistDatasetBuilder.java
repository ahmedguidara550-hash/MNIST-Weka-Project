package data;

import java.util.ArrayList;
import java.util.List;

public class MnistDatasetBuilder {

    public static List<MnistImage> createDataset(List<MnistImage> allImages, int n) {
        List<MnistImage> filteredList = new ArrayList<>();
        int count3 = 0;
        int count5 = 0;

        for (MnistImage img : allImages) {
            if (img.getLabel() == 3 && count3 < n) {
                filteredList.add(img);
                count3++;
            } else if (img.getLabel() == 5 && count5 < n) {
                filteredList.add(img);
                count5++;
            }
            
            
            if (count3 == n && count5 == n) {
                break;
            }
        }
        
        System.out.println("   -> Dataset filtré créé : " + count3 + " images de '3' et " + count5 + " images de '5'.");
        return filteredList;
    }
}