package LecturaEscrituradeExcelconApachePOI;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WriteExcelFile {

    public void writeExcel(String filepath, String sheetName,String[] dataTowrite) throws IOException {

        File file =new File(filepath);

        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);

        XSSFSheet newSheet =newWorkbook.getSheet(sheetName);
        int rowCount =newSheet.getLastRowNum()-newSheet.getFirstRowNum();

        XSSFRow roe = newSheet.getRow(0);
        XSSFRow newRow= newSheet.createRow(rowCount+1);
        for (int i = 0; i < newRow.getLastCellNum(); i++) {
            XSSFCell newCell= newRow.createCell(i);
            newCell.setCellValue(dataTowrite[i]);
        }
        inputStream.close();

        FileOutputStream outputStream=new FileOutputStream(file);
        newWorkbook.write(outputStream);

        outputStream.close();
    }

    public void writeCellValue(String filepath, String sheetName,int rowNumber,int cellNumber,String resultText) throws IOException {

        File file= new File(filepath);

        FileInputStream inputStream=new FileInputStream(file);

        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);

        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

        XSSFRow row = newSheet.getRow(rowNumber);

        XSSFCell firstCell= row.getCell(cellNumber-1);

        System.out.println("first cell value is: " + firstCell.getStringCellValue());

        XSSFCell nexCell = row.createCell(cellNumber);
        nexCell.setCellValue(resultText);

        System.out.println("nextcell value:"+ nexCell.getStringCellValue());
        inputStream.close();

        FileOutputStream outputStream= new FileOutputStream(file);

        newWorkbook.write(outputStream);
        outputStream.close();

    }
}
