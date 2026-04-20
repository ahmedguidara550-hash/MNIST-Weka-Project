import java.util.List;
public class BinaryDataSource extends DataSource {
	public BinaryDataSource(String filePath) {
		super(filePath);
	}
	
	@Override
	public List<MnistImage> readData() throws MnistIOException{
		return null;
	}
	
	@Override
	public void writeData(List<MnistImage> data) throws MnistIOException{
		
	}
	

}
