package com.AutomationJiviewsGeneric;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ExcelUtilities {
	/**
	 * This is a method to read data from excel file
	 * @author Rajath
	 * @param sheetName
	 * @param rowNo
	 * @param columnNo
	 * @return
	 * @throws Exception
	 */
	public String readDataFromExcelFile(String sheetName, int rowNo, int columnNo) throws Exception {

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData\\Jivi_Test_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		// int last = sh.getLastRowNum();
		String data = sh.getRow(rowNo).getCell(columnNo).getStringCellValue();
		return data;
	}

	/**
	 * This is a method to write data to excel file
	 * @author Rajath
	 * @param sheetName
	 * @param rowNo
	 * @param columnNo
	 * @param writeValue
	 * @throws Exception
	 */
	public void writeInExcelFile(String sheetName, int rowNo, int columnNo, String writeValue) throws Exception {

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData\\Jivi_Test_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		sh.getRow(rowNo).getCell(columnNo).setCellValue(writeValue);
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData\\Jivi_Test_Data.xlsx");
		wb.write(fos);
		wb.close();
	}

	/**
	 * This is a method to get last row number from excel file
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNo(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData\\Jivi_Test_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int last = sh.getLastRowNum();
		return last;
	}

	/**
	 * This is a method to read multiple data from excel file 
	 * @param sheetName
	 * @param keyCell
	 * @param valueCell
	 * @return
	 * @throws Exception
	 */
	public HashMap<String, String> readMultipleDataFromExcel(WebDriver driver,String sheetName, int keyCell, int valueCell)
			throws Exception {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData\\Jivi_Test_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();

		for (int i = 0; i <= lastRow; i++) {

			String key = sh.getRow(i).getCell(keyCell).getStringCellValue();
			String value = sh.getRow(i).getCell(valueCell).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
	
	public Object[][] readUsingDataProviderExcel(String sheetName) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData\\Jivi_Test_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		Object[][] obj=new Object [lastRow+1][lastCell]; 
		for(int i=0;i<=lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();	
			}
		}
		return obj;
	}
}
