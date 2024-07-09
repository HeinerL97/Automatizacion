package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Excel {
    public static ArrayList<Map<String, String>> leerDatosDeHojaExcel(String rutaDeExcel, String hojaDeExcel) throws IOException {
        ArrayList<Map<String, String>> arrayListDatoPlanTrabajo = new ArrayList<>();
        File file = new File(rutaDeExcel);

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(hojaDeExcel);
            if (sheet == null) {
                throw new IllegalArgumentException("La hoja " + hojaDeExcel + " no existe en el archivo " + rutaDeExcel);
            }

            // Suponiendo que la primera fila contiene los nombres de las columnas
            Iterator<Row> rowIterator = sheet.iterator();
            Row headerRow = rowIterator.next(); // La primera fila que contiene los nombres de las columnas

            ArrayList<String> headers = new ArrayList<>();
            Iterator<Cell> headerCellIterator = headerRow.cellIterator();
            while (headerCellIterator.hasNext()) {
                Cell headerCell = headerCellIterator.next();
                headers.add(headerCell.getStringCellValue());
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Map<String, String> informacionProyecto = new HashMap<>();

                for (int i = 0; i < headers.size(); i++) {
                    Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    switch (cell.getCellType()) {
                        case STRING:
                            informacionProyecto.put(headers.get(i), cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                informacionProyecto.put(headers.get(i), cell.getDateCellValue().toString());
                            } else {
                                informacionProyecto.put(headers.get(i), Double.toString(cell.getNumericCellValue()));
                            }
                            break;
                        case BOOLEAN:
                            informacionProyecto.put(headers.get(i), Boolean.toString(cell.getBooleanCellValue()));
                            break;
                        case BLANK:
                            informacionProyecto.put(headers.get(i), "");
                            break;
                        default:
                            informacionProyecto.put(headers.get(i), "Valor desconocido");
                            break;
                    }
                }
                arrayListDatoPlanTrabajo.add(informacionProyecto);
            }
        }
        return arrayListDatoPlanTrabajo;
    }

    public static void main(String[] args) {
        try {
            ArrayList<Map<String, String>> datos = leerDatosDeHojaExcel("src/test/resources/Data/Excel.xlsx", "Login");
            // Imprime los datos leídos
            for (Map<String, String> dato : datos) {
                System.out.println(dato);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}