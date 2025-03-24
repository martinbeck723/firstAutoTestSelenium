package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private static Workbook workbook;

    // Load Excel file
    public static void loadExcel(String filePath) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(file);
    }

    // Get data from Excel
    public static String getCellData(String sheetName, int row, int col) {
        Sheet sheet = workbook.getSheet(sheetName);
        Cell cell = sheet.getRow(row).getCell(col);
        return cell.getStringCellValue();
    }

    // Get total row count
    public static int getRowCount(String sheetName) {
        return workbook.getSheet(sheetName).getLastRowNum();
    }
}
