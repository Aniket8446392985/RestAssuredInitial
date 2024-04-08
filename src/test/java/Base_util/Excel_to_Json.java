package Base_util;
import org.apache.poi.ss.usermodel.*;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
public class Excel_to_Json {

    public static JSONObject convertExcelToJson(String filePath, String sheetName, int parameterColumnIndex, int valueColumnIndex) {
        JSONObject jsonObject = new JSONObject();
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            Iterator<Row> rowIterator = sheet.iterator();

            // Skip header row if necessary
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Cell parameterCell = row.getCell(parameterColumnIndex);
                Cell valueCell = row.getCell(valueColumnIndex);

                if (parameterCell != null && valueCell != null) {
                    String parameter = parameterCell.getStringCellValue();
                    String value;
                    switch (valueCell.getCellType()) {
                        case STRING:
                            value = valueCell.getStringCellValue();
                            break;
                        default:
                            value = "";
                    }
                    jsonObject.put(parameter, value);
                }
            }
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static void main(String[] args) {
        String filePath = "src/test/Test_Data/Post_Hit _Excel.xlsx";
        String sheetName = "QA";
        int parameterColumnIndex = 0;
        int valueColumnIndex = 1;
        JSONObject jsonObject = convertExcelToJson(filePath, sheetName, parameterColumnIndex, valueColumnIndex);
        System.out.println(jsonObject.toJSONString());
    }
}
