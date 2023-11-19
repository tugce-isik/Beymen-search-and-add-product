import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcellDataconfig {

    XSSFWorkbook wb;
    XSSFSheet sheet1;

    public ExcellDataconfig(String excelpath) throws IOException {
        File src = new File(excelpath);
        FileInputStream fis = new FileInputStream(src);
        wb = new XSSFWorkbook(fis);
    }

    public String getData(int sheetNumber, int row, int column) {
        sheet1 = wb.getSheetAt(0);
        String data = sheet1.getRow(row).getCell(column).getStringCellValue();
        return data;
    }
}
