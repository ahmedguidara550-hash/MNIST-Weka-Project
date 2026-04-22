package data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import exceptions.MnistIOException;

public class ExcelDataSource extends DataSource {

    public ExcelDataSource(String filePath) {
        super(filePath);
    }

    @Override
    public List<MnistImage> readData() throws MnistIOException {
        throw new UnsupportedOperationException("La lecture de fichiers Excel n'est pas implémentée.");
    }

    @Override
    public void writeData(List<MnistImage> data) throws MnistIOException {
        
        System.out.println("   -> Création du fichier Excel en cours (limité aux 1000 premières images)...");
        
        
        try (Workbook workbook = new XSSFWorkbook()) {
            
            
            Sheet sheet = workbook.createSheet("Dataset MNIST");

            
            CellStyle greenStyle = workbook.createCellStyle();
            greenStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
            greenStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle orangeStyle = workbook.createCellStyle();
            orangeStyle.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
            orangeStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            
            int limit = Math.min(data.size(), 1000);
            
            for (int rowIndex = 0; rowIndex < limit; rowIndex++) {
                MnistImage img = data.get(rowIndex);
                Row row = sheet.createRow(rowIndex);
                int[] pixels = img.getPixels();

                
                for (int i = 0; i < pixels.length; i++) {
                    Cell cell = row.createCell(i);
                    cell.setCellValue(pixels[i]);
                }

                
                Cell labelCell = row.createCell(pixels.length);
                labelCell.setCellValue(img.getLabel());

                
                if (img.getLabel() == 3) {
                    labelCell.setCellStyle(greenStyle);
                } else if (img.getLabel() == 5) {
                    labelCell.setCellStyle(orangeStyle);
                }
            }

            
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
                System.out.println("   -> ✅ Fichier Excel généré avec succès !");
            }

        } catch (IOException e) {
            throw new MnistIOException("Erreur lors de la création du fichier Excel", e);
        }
    }
}