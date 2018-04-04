package org.bootcamp;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public final class Main {
    private static final int EXCEL_INFORMATION_SHEET = 0;

    public static void main(String[] args) {

        if (args.length > 0) {
            try {
                InputStream inputStream = new FileInputStream(args[0]);
                Workbook workbook = new XSSFWorkbook(inputStream);
                Sheet datatypeSheet = workbook.getSheetAt(EXCEL_INFORMATION_SHEET);
                Iterator<Row> iterator = datatypeSheet.iterator();

                while (iterator.hasNext()) {

                    Row currentRow = iterator.next();
                    Iterator<Cell> cellIterator = currentRow.iterator();

                    while (cellIterator.hasNext()) {

                        Cell currentCell = cellIterator.next();

                        if (currentCell.getCellTypeEnum() == CellType.STRING) {
                            System.out.print(currentCell.getStringCellValue() + " ");
                        } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                            System.out.print(currentCell.getNumericCellValue() + " ");
                        }

                    }
                    System.out.println();

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("To few arguments to continue");
        }
    }
}
