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
}
