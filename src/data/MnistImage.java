package data;

public class MnistImage {
    
    private int[] pixels;
    private int label;

   
    public MnistImage(int[] pixels, int label) {
        this.pixels = pixels;
        this.label = label;
    }

    
    public int[] getPixels() {
        return pixels;
    }

    public void setPixels(int[] pixels) {
        this.pixels = pixels;
    }

    
    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }
 
    public PixelVector toPixelVector() {
        return new PixelVector(this.pixels);
    }
}