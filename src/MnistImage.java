import exceptions.*;
public class MnistImage {
	private int[] pixels;
	private int label;
	
	public MnistImage(int[] pixels,int label) throws DimensionMismatchException {
		if(pixels.length != 784) {
			throw new DimensionMismatchException("Erreur de dimension : Une image MNIST doit avoir exactement 784 pixels.");
			
		}
		this.pixels = pixels;
		this.label = label;
	}
	public int[] getPixels() {
		return pixels;
	}
	public int getLabel() {
		return label;
	}
	@Override
	public String toString() {
		return "MnistImage [Chiffre = " + label + ", Taille = " + pixels.length + " pixels]";
	}
	public PixelVector toPixelVector() {
		return new PixelVector(this.pixels,this.label);
	}
	
}
