package com.AutomationJiviewsGeneric;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	/**
	 * this is generic method for reading data from the property file
	 * @param key
	 * @return String
	 * @throws IOException
	 */
	public String getPropertyData(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./Configure/jiviLoginCredential.properties");
		Properties p=new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
	}
	/**
	 * this is a generic method for reading the data from excel file
	 * @param Sheet
	 * @param Row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelData(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData\\Jivi_Test_Data.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	/**
	 * this is a generic method for writing the data to the excel file
	 * @param Sheet
	 * @param Row
	 * @param cell
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void SETExcelData(String sheet,int row,int cell,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData\\Jivi_Test_Data.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(data);
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData\\Jivi_Test_Data.xlsx");
		wb.write(fos);
		wb.close();
	}
}
