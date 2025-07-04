package com.entrata.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelDataProvider {
    public static Object[][] getDataAsMap(String filePath, String sheetName, int headerRowIndex) {
        List<Object[]> dataList = new ArrayList<>();
        try (Workbook wb = new XSSFWorkbook(new FileInputStream(filePath))) {
            Sheet sheet = wb.getSheet(sheetName);
            DataFormatter formatter = new DataFormatter();
            Row headerRow = sheet.getRow(headerRowIndex);

            for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                Map<String,String> rowMap = new LinkedHashMap<>();
                for (Cell cell : row) {
                    String key = headerRow.getCell(cell.getColumnIndex()).getStringCellValue();
                    String value = formatter.formatCellValue(cell);
                    rowMap.put(key, value);
                }
                dataList.add(new Object[]{rowMap});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList.toArray(new Object[0][]);
    }
}
