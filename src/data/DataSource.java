package data;
import java.util.List;

import exceptions.MnistIOException;
public abstract class DataSource {
	protected String filePath;
	
	public DataSource(String filePath) {
		this.filePath = filePath;
	}
	
	public abstract List<MnistImage> readData() throws MnistIOException;
	public abstract void writeData(List<MnistImage> data) throws MnistIOException;
	
	public String getFilePath() {
		return filePath;
	}

}
