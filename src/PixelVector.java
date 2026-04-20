
public class PixelVector {
	private double[] features;
	private int label;
	
	public PixelVector(int[] pixels,int label) {
		this.features = new double[pixels.length];
		for (int i=0;i<pixels.length;i++) {
			this.features[i] = pixels[i]/ 255.0;
		}
		this.label = label;
	}
	
	public double[] getFeatures() {
		return features;
	}
	
	public int getLabel() {
		return label;
	}
}
