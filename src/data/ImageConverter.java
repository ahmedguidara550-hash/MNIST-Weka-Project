package data;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.imageio.ImageIO;

import exceptions.DimensionMismatchException;
import exceptions.MnistIOException;

public class ImageConverter {

    
    public void imageToText(String imagePath, String textPath) throws DimensionMismatchException, MnistIOException {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            
            
            if (image.getWidth() != 28 || image.getHeight() != 28) {
                throw new DimensionMismatchException("Expected 28x28 got " + image.getWidth() + "x" + image.getHeight());
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter(textPath))) {
                for (int y = 0; y < 28; y++) {
                    for (int x = 0; x < 28; x++) {
                        
                        Color color = new Color(image.getRGB(x, y));
                        int intensity = 255 - color.getRed(); 
                        writer.print(intensity + ",");
                    }
                }
                writer.println("inconnu"); 
            }
        } catch (DimensionMismatchException e) {
            throw e; 
        } catch (Exception e) {
            throw new MnistIOException("Erreur lors de la conversion de l'image en texte", e);
        }
    }

    
    public void textToImage(int[] pixels, String imagePath) throws MnistIOException {
        try {
            BufferedImage image = new BufferedImage(28, 28, BufferedImage.TYPE_INT_RGB);
            int index = 0;
            
            for (int y = 0; y < 28; y++) {
                for (int x = 0; x < 28; x++) {
                    int intensity = 255 - pixels[index++];
                    Color color = new Color(intensity, intensity, intensity);
                    image.setRGB(x, y, color.getRGB());
                }
            }
            ImageIO.write(image, "png", new File(imagePath));
            
        } catch (Exception e) {
            throw new MnistIOException("Erreur lors de la conversion du texte en image", e);
        }
    }
}