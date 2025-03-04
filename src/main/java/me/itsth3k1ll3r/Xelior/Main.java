package me.itsth3k1ll3r;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

public class Main {
    public static String tag = "Xelior >> ";
    public static void main(String[] args) throws IOException {
        String title = "oes2025_p2";
        FileInputStream fin = new FileInputStream("src/main/resources/spreadsheet/oli_oes2025.xlsx");
        String foutPath = "xelior_"+title+".txt";


        XSSFWorkbook wb = new XSSFWorkbook(fin);

        XSSFSheet sheet = wb.getSheetAt(5);

        Iterator<Row> rowIterator = sheet.iterator();

        while(rowIterator.hasNext()) {

            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();

            while(cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                switch(cell.getCellType()) {
                    case CellType.NUMERIC:
                        try {
                            FileWriter writeToFout = new FileWriter(foutPath);
                            writeToFout.write(cell.getNumericCellValue() + " ");
                            writeToFout.close();
                            System.out.print(cell.getNumericCellValue() + " ");

                        }
                        catch(IOException e) {
                            System.out.println(tag + "Couldn't write to file");
                            e.printStackTrace();
                        }
                        break;
                    case CellType.STRING:
                        try {
                            FileWriter writeToFout = new FileWriter(foutPath);
                            writeToFout.write(cell.getStringCellValue() + " ");
                            writeToFout.close();
                            System.out.print(cell.getStringCellValue() + " ");
                        }
                        catch(IOException e) {
                            System.out.println(tag + "Couldn't write to file");
                            e.printStackTrace();
                        }

                        break;

                }
            }
            System.out.println("");
        }
        fin.close();

    }

}