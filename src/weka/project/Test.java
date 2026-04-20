package weka.project;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Test {
	public static void main(String[] args) {
		try {
			DataSource source = new DataSource("data.arff");
			Instances data = source.getDataSet();
			System.out.println(data);
			} catch (Exception e) {
			e.printStackTrace();
			}
			}
			}


