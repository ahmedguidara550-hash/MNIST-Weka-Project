package data;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import exceptions.MnistIOException;

public class TextDataSource extends DataSource {

    public TextDataSource(String filePath) {
        super(filePath);
    }

    @Override
    public List<MnistImage> readData() throws MnistIOException {
        throw new UnsupportedOperationException("La lecture CSV n'est pas encore implémentée.");
    }

    @Override
    public void writeData(List<MnistImage> data) throws MnistIOException {
        System.out.println("   -> Génération du fichier CSV...");
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            
            for (int i = 0; i < 784; i++) {
                writer.print("pixel_" + i + ",");
            }
            writer.println("class");

            
            for (MnistImage img : data) {
                int[] pixels = img.getPixels();
                for (int p : pixels) {
                    writer.print(p + ",");
                }
                
                
                if (img.getLabel() == 3) {
                    writer.println("trois");
                } else if (img.getLabel() == 5) {
                    writer.println("cinq");
                } else {
                    writer.println(img.getLabel());
                }
            }
            System.out.println("   -> ✅ Fichier CSV créé : " + filePath);
        } catch (Exception e) {
            throw new MnistIOException("Erreur lors de l'écriture du CSV", e);
        }
    }
}