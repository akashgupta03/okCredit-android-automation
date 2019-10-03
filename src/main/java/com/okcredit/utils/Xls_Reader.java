package com.okcredit.utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Xls_Reader {
    public String path;

    public FileInputStream fis = null;

    public FileOutputStream fileOut = null;

    private XSSFWorkbook workbook = null;

    private XSSFSheet sheet = null;

    private XSSFRow row = null;

    private  XSSFCell cell = null;

    public Xls_Reader(String path) {
        this.path = path;
        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // returns the row count in a sheet

    public int getRowCount(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1)
            return 0;
        else {
            sheet = workbook.getSheetAt(index);
            int number = sheet.getLastRowNum() + 1;
            return number;
        }
    }
    // returns the data from a cell
    public String getCellData(String sheetName, String colName, int rowNum) {
        CellType hg = CellType.STRING;
        try {
            if (rowNum <= 0)
                return "";
            int index = workbook.getSheetIndex(sheetName);
            int col_Num = -1;
            if (index == -1)
                return "";
            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(0);
            for (int i = 0; i < row.getLastCellNum(); i++) {
                if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                    col_Num = i;
            }
            if (col_Num == -1)
                return "";
            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(rowNum - 1);
            if (row == null)
                return "";
            cell = row.getCell(col_Num);

            if (cell == null)
                return "";
            if (cell.getCellType() == CellType.STRING)
                return cell.getStringCellValue();
            else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
                String cellText = String.valueOf(cell.getNumericCellValue());
                return cellText;
            } else if (cell.getCellType() == CellType.BLANK)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());
        } catch (Exception e) {
            e.printStackTrace();
            return "row " + rowNum + " or column " + colName + " does not exist in xls";
        }
    }

    // returns the data from a cell
    public String getCellData(String sheetName, int colNum, int rowNum) {
        try {
            if (rowNum <= 0)
                return "";
            int index = workbook.getSheetIndex(sheetName);
            if (index == -1)
                return "";
            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(rowNum - 1);
            if (row == null)
                return "";
            cell = row.getCell(colNum);
            if (cell == null)
                return "";

            if (cell.getCellType() == CellType.STRING)
                return cell.getStringCellValue();
            else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
                String cellText = String.valueOf(cell.getNumericCellValue());
                return cellText;
            } else if (cell.getCellType() == CellType.BLANK)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());
        } catch (Exception e) {
            e.printStackTrace();
            return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
        }
    }


    // returns true if sheet is created successfully else false
    public boolean addSheet(String sheetName) {
        FileOutputStream fileOut;
        try {
            workbook.createSheet(sheetName);
            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // returns true if sheet is removed successfully else false if sheet does not
    // exist
    public boolean removeSheet(String sheetName) {

        int index = workbook.getSheetIndex(sheetName);
        if (index == -1)
            return false;

        FileOutputStream fileOut;
        try {
            workbook.removeSheetAt(index);
            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    // find whether sheets exists
    public boolean isSheetExist(String sheetName) {

        int index = workbook.getSheetIndex(sheetName);
        if (index == -1) {
            index = workbook.getSheetIndex(sheetName.toUpperCase());
            if (index == -1)
                return false;
            else
                return true;
        } else
            return true;
    }

    // returns number of columns in a sheet
    public int getColumnCount(String sheetName) {

        // check if sheet exists
        if (!isSheetExist(sheetName))
            return -1;

        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(0);

        if (row == null)
            return -1;

        return row.getLastCellNum();

    }


    public int getCellRowNum(String sheetName, String colName, String cellValue) {

        for (int i = 2; i <= getRowCount(sheetName); i++) {
            if (getCellData(sheetName, colName, i).equalsIgnoreCase(cellValue)) {
                return i;
            }
        }
        return -1;

    }

    //next to add method
    //add hyperLink
    //remove Column
    //add Column
    //setCellData By sheetName, ColumnName,rowNumber, data
}