package com.AutomationJiviewsGeneric;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;



public class ExcelUtilities {
	private static final String FILE_PATH = ".\\src\\test\\resources\\TestData\\Jivi_Test_Data.xlsx";
	private static final String FILE_PATH_EMP_V2 = ".\\src\\test\\resources\\TestData\\Employee Roster V2_E10-2949.xlsx";
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

		FileInputStream fis = new FileInputStream(FILE_PATH);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNo).getCell(columnNo).getStringCellValue();
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

		FileInputStream fis = new FileInputStream(FILE_PATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		sh.getRow(rowNo).getCell(columnNo).setCellValue(writeValue);
		FileOutputStream fos = new FileOutputStream(FILE_PATH);
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
		FileInputStream fis = new FileInputStream(FILE_PATH);
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
		FileInputStream fis = new FileInputStream(FILE_PATH);
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

	public Object[][] readTestDataForDataProvider(String sheetName) throws Throwable {
		FileInputStream fis = null;
		Workbook wb = null;

		try {
			fis = new FileInputStream(FILE_PATH);
			wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			int lastRow = sh.getLastRowNum();
			int lastCell = sh.getRow(0).getLastCellNum();
			Object[][] data = new Object[lastRow + 1][lastCell];

			for (int i = 0; i <= lastRow; i++) {
				for (int j = 0; j < lastCell; j++) {
					data[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
				}
			}
			return data;
		} finally {
			if (wb != null) {
				wb.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
	}


	public void writeDataToExcel(String existingSheetName, List<String> copiedData, String newSheetName) throws IOException {
		FileInputStream fis = new FileInputStream(FILE_PATH_EMP_V2);
		Workbook workbook = WorkbookFactory.create(fis);

		// Check if the sheet already exists
		Sheet newSheet = workbook.getSheet(newSheetName);
		if (newSheet == null) {
			// If it doesn't exist, create a new sheet
			newSheet = workbook.createSheet(newSheetName);
		}

		// Paste data into the new sheet
		for (int i = 0; i < copiedData.size(); i++) {
			String rowData = copiedData.get(i);
			String[] cells = rowData.split("\t");
			Row row = newSheet.createRow(i);

			for (int j = 0; j < cells.length; j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(cells[j].trim());
			}
		}

		// Save the changes to the workbook
		try (FileOutputStream fos = new FileOutputStream(FILE_PATH_EMP_V2)) {
			workbook.write(fos);
		}

		workbook.close();
	}

	public boolean verifyDataInSheet(String sheetName, List<String> expectedData) throws IOException {
		List<String> actualData = readDataFromExcel(sheetName);
		return actualData.equals(expectedData);
	}

	public List<String> readDataFromExcel(String sheetName) throws IOException {
		try (FileInputStream fis = new FileInputStream(FILE_PATH_EMP_V2);
				Workbook workbook = WorkbookFactory.create(fis)) {

			Sheet sheet = workbook.getSheet(sheetName);
			List<String> dataFromExcel = new ArrayList<>();

			if (sheet != null) {
				Iterator<Row> rowIterator = sheet.iterator();

				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					Iterator<Cell> cellIterator = row.cellIterator();
					StringBuilder rowData = new StringBuilder();

					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						rowData.append(cell.getStringCellValue()).append("\t");
					}

					dataFromExcel.add(rowData.toString().trim());
				}
			}

			return dataFromExcel;
		}
	}
}
