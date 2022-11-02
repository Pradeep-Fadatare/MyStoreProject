package pradeepfadatareacademy.Data;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;


public class DataProvider {

    DataFormatter formatter=new DataFormatter();
    @org.testng.annotations.DataProvider(name = "data")
    public Object[][] login() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\m\\IdeaProjects\\SeleniumFrameworkDesign\\src\\test\\java\\pradeepfadatareacademy\\Data\\DataProviderSheet.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("login");

        int rowCount = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        int columnCount = row.getLastCellNum();
        Object[][] data = new Object[rowCount - 1][columnCount];

        for (int i = 0; i < rowCount - 1; i++) {
            row = sheet.getRow(i + 1);
            for (int j = 0; j < columnCount; j++)
            {
                XSSFCell cell = row.getCell(j);
                data[i][j] = formatter.formatCellValue(cell);
            }
        }
        return data;
    }

    @org.testng.annotations.DataProvider(name = "email")
    public Object[][] createaccout() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\m\\IdeaProjects\\SeleniumFrameworkDesign\\src\\test\\java\\pradeepfadatareacademy\\Data\\DataProviderSheet.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("NewEmail");

        int rowCount = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        int columnCount = row.getLastCellNum();
        Object[][] data = new Object[rowCount - 1][columnCount];

        for (int i = 0; i < rowCount - 1; i++) {
            row = sheet.getRow(i + 1);
            for (int j = 0; j < columnCount; j++)
            {
                XSSFCell cell = row.getCell(j);
                data[i][j] = formatter.formatCellValue(cell);
            }
        }
        return data;
    }

    @org.testng.annotations.DataProvider(name = "productdatails")
    public Object[][] product() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\m\\IdeaProjects\\SeleniumFrameworkDesign\\src\\test\\java\\pradeepfadatareacademy\\Data\\DataProviderSheet.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("ProductDetails");

        int rowCount = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        int columnCount = row.getLastCellNum();
        Object[][] data = new Object[rowCount - 1][columnCount];

        for (int i = 0; i < rowCount - 1; i++) {
            row = sheet.getRow(i + 1);
            for (int j = 0; j < columnCount; j++)
            {
                XSSFCell cell = row.getCell(j);
                data[i][j] = formatter.formatCellValue(cell);
            }
        }
        return data;
    }
}
