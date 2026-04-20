import java.util.List;

public class ExcelDataSource extends DataSource {

    public ExcelDataSource(String filePath) {
        super(filePath);
    }

    @Override
    public List<MnistImage> readData() throws MnistIOException {
        
        return null;
    }

    @Override
    public void writeData(List<MnistImage> data) throws MnistIOException {
        
    }
}