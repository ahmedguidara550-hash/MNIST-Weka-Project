import java.util.List;
public class TextDataSource extends DataSource{
	public TextDataSource(String filePath) {
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
