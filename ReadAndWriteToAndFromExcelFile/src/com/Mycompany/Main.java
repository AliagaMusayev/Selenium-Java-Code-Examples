package com.Mycompany;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, InvalidFormatException {

        File txtFile = new File((System.getProperty("user.dir") + "" + "\\src\\Files\\test.txt"));
        if(!txtFile.exists()){
            txtFile.createNewFile();
        }

        System.out.println(System.getProperty("user.name"));
        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet sheet1 = workBook.createSheet("FirstTest");
        Row row0 = sheet1.createRow(0);
        Cell cell0 = row0.createCell(0);
        Cell cell1 = row0.createCell(1);
        cell0.setCellValue("Test");
        cell1.setCellValue("Test2");
        File excelFile = new File(System.getProperty("user.dir")+"\\src\\Files\\myTestFile.xlsx");

        FileOutputStream file = new FileOutputStream(excelFile);
//        if(!excelFile.exists()){
//            FileOutputStream files = new FileOutputStream(excelFile);
//            BufferedWriter writer = new BufferedWriter(files);
//        }

        workBook.write(file);
        file.close();
        System.out.println("Excel file created");

        // Reading from Excel File
        File existedExcelFile = new File(System.getProperty("user.dir")+"\\src\\Files\\SeleniumExcelLastVersion.xls");
        if(existedExcelFile.exists()){
            FileInputStream readFile = new FileInputStream(existedExcelFile);

            Workbook workbook = WorkbookFactory.create(readFile);
            Sheet customerSheet = workbook.getSheet("CreditCard");
            for (Row rows:customerSheet) {
                for(Cell cells:rows){
                    switch (cells.getCellType()){
                        case Cell.CELL_TYPE_STRING:
                            System.out.println(cells.getStringCellValue()+"\t");
                            break;


                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.println(cells.getNumericCellValue()+"\t");
                            break;

                        case Cell.CELL_TYPE_BLANK:
                            System.out.println("*****"+"\t");
                            break;

                    }

                }
                System.out.println("");
            }


        }
    }
}
