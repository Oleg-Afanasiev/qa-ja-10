package com.academy.telesens.lesson11.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReadAllRowsDemo {
    public static void main(String[] args) {
        String path = "C:/Users/af_oleg/Documents/QA_JA_10/data/demo.xlsx";
        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            for (int r = 0; r <= sheet.getLastRowNum(); r++) {
                Row row = sheet.getRow(r);

                Cell cell1 = row.getCell(0);
                Cell cell2 = row.getCell(1);
                Cell cell3 = row.getCell(2);

                System.out.println(
                        cell1.getStringCellValue() + " " +
                                cell2.getStringCellValue() + " " +
                                cell3.getNumericCellValue()
                );
            }

            workbook.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("Ошибка " + e);
        }
    }
}
