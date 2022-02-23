package warehouse;

import models.Product;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadDataFromSheet {

    public static Product[] readProductFromExcel() throws IOException {
        String path = "src/main/resources/products.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
        Product[] products = new Product[rowCount];
        for (int r = 1; r <= rowCount; r++){
            XSSFRow row = sheet.getRow(r);

            products[r - 1] = new Product(
                    row.getCell(1).getStringCellValue(),
                    row.getCell(2).getStringCellValue(),
                    row.getCell(3).getNumericCellValue(),
                    (int)row.getCell(4).getNumericCellValue()
            );
        }
        return products;
    }
}
