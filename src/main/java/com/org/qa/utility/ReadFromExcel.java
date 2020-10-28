package com.org.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

/**
 * @author Gopal Pandey
 *
 */
public class ReadFromExcel {

	
	@SuppressWarnings("resource")
	public static Object[][] excelFile(String excelPath, String excelShett) {
		File src = new File(excelPath);
		FileInputStream stream;
		HSSFWorkbook workbook;
		HSSFSheet sheet;
		try {
			stream = new FileInputStream(src);
			workbook = new HSSFWorkbook(stream);
			sheet = workbook.getSheet(excelShett);
			DataFormatter formatter = new DataFormatter();
			Object[][] Data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j <  sheet.getRow(0).getLastCellNum(); j++) {
					HSSFCell cell = sheet.getRow(i + 1).getCell(j);
					String value = formatter.formatCellValue(cell);
					Data[i][j] = value;
				}
			}
			return Data;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
//---------------------------------------------Reading a excel store in a map ------------------------------------------------------//
// 		public static Map<String,  Map<String, Object>> setMapData(String path) throws IOException {
// 		FileInputStream fis = new FileInputStream(path);
// 		Workbook workbook = new HSSFWorkbook(fis);
// 		Sheet sheet = workbook.getSheetAt(0);
// 		Map<String, Map<String, Object>> excelFileMap = new HashMap<String, Map<String,Object>>();
// 		Map<String, Object> dataMap = new HashMap<String, Object>();
// 		DataFormatter formatter = new DataFormatter();
// 		  int rowCount = sheet.getLastRowNum(); 
// 		    for(int i=1;i<=rowCount;i++){
// 		        Row row = sheet.getRow(0);
// 		        for(int j=0;j<row.getLastCellNum();j++) {
// 		            String key=row.getCell(j).getStringCellValue();
// 		            Object value= formatter.formatCellValue(sheet.getRow(i).getCell(j));
// 				    dataMap.put(key, value);
// 		        }
// 		    	excelFileMap.put("DataSheet", dataMap);
// 		    }
// 		return excelFileMap;
// 		}
// 	 Map<String, Object> m = ReadFromExcel.setMapData(path).get("DataSheet");  
//---------------------------------------------Reading a excel store in a map ------------------------------------------------------//

}
