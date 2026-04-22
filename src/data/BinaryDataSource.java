package data;


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exceptions.DimensionMismatchException;
import exceptions.InvalidMNISTFormatException;
import exceptions.MnistIOException;

public class BinaryDataSource extends DataSource {

    public BinaryDataSource(String filePath) {
        super(filePath);
    }

    @Override
    public List<MnistImage> readData() throws MnistIOException {
        List<MnistImage> images = new ArrayList<>();

        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            
            
            int magicNumber = dis.readInt();
            if (magicNumber != 2051) { 
                throw new InvalidMNISTFormatException("Expected magic 0x803, got 0x" + Integer.toHexString(magicNumber));
            }

           
            int numberOfImages = dis.readInt();
            int numRows = dis.readInt(); 
            int numCols = dis.readInt(); 

           
            for (int i = 0; i < numberOfImages; i++) {
                int[] pixels = new int[784];
                
                for (int p = 0; p < 784; p++) {
                    
                    pixels[p] = dis.readUnsignedByte(); 
                }

                
                MnistImage img = new MnistImage(pixels, 0);
                images.add(img);
            }

        } catch (InvalidMNISTFormatException e) {
            throw new MnistIOException("Erreur de format MNIST : " + e.getMessage(), e);
        } catch (IOException e) {
            throw new MnistIOException("Erreur de lecture du fichier binaire", e);
        }

        return images;
    }

   
    public void loadLabels(List<MnistImage> images, String labelFilePath) throws MnistIOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(labelFilePath))) {
            
           
            int magicNumber = dis.readInt();
            if (magicNumber != 2049) { 
                throw new InvalidMNISTFormatException("Expected magic 0x801, got 0x" + Integer.toHexString(magicNumber));
            }

           
            int numberOfLabels = dis.readInt();
            
            
            if (numberOfLabels != images.size()) {
                throw new DimensionMismatchException("Le nombre de labels (" + numberOfLabels + ") ne correspond pas au nombre d'images (" + images.size() + ").");
            }

            
            for (int i = 0; i < numberOfLabels; i++) {
                int label = dis.readUnsignedByte();
                images.get(i).setLabel(label);
            }

        } catch (InvalidMNISTFormatException | DimensionMismatchException e) {
            throw new MnistIOException("Erreur de format/dimension MNIST : " + e.getMessage(), e);
        } catch (IOException e) {
            throw new MnistIOException("Erreur de lecture du fichier des labels", e);
        }
    }

    @Override
    public void writeData(List<MnistImage> data) throws MnistIOException {
       
        throw new UnsupportedOperationException("L'écriture en format binaire MNIST n'est pas implémentée.");
    }
}