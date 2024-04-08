package Base_util;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.Json;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.*;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Apache_Util {

    public static JSONObject ReqJson= new JSONObject();
    public static void Read_Excel(String Excel_path ,String Env, int Parameter_Column, int Value_Column) throws FileNotFoundException {

        try {

            FileInputStream FIS = new FileInputStream(new File(Excel_path));
            Workbook workbook= WorkbookFactory. create(FIS);
            Sheet sheet = workbook.getSheet(Env);
            Row row= sheet.getRow(1);
            Cell cell = row.getCell(0);


            /*

            for (Row row : sheet) {
                // Get the cell in the specified column for the current row
                Cell cell = row.getCell(Parameter_Column);
                cell.getStringCellValue();
            }
            for (Row row : sheet) {
                // Get the cell in the specified column for the current row
                Cell cell = row.getCell(Value_Column);
                cell.getStringCellValue();
            }*/

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String CreateJsonString(String jsonPath) {
        String JsonReq = null;
        try {
            File file = new File(jsonPath);
            FileInputStream FISJson = new FileInputStream(file);
            JsonReq = IOUtils.toString(FISJson,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonReq;
    }


}
