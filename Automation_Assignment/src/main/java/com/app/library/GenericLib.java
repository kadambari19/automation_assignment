package com.app.library;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Kadambari Shastry
 *
 */
public class GenericLib {

	private static Workbook workbook;
	private static Sheet sheet;
	private static String path;
	public static Properties properties;


	/**
	 * Open and load properties file
	 * @param filePath
	 * @return Properties file loaded
	 * @throws Throwable
	 */
	public static String getValue(String fPath,String key)  {
		properties = new Properties();
		try {
			properties.load(new FileInputStream(fPath));
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		String value = properties.getProperty(key);
		return value;
	}

	
	/**
	 *  get the excel sheet
	 */
	public static String getData(String filePath, String sheetName,int rowNum, int celNum) {
		path = filePath;
		try {
			workbook = WorkbookFactory.create(new FileInputStream(filePath));
		} catch (EncryptedDocumentException e) {
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		String data = row.getCell(celNum).getStringCellValue();
		return data; 
	}
	
	
	
	/**
	 * Close the workbook
	 * @throws Throwable
	 */
	public void closeSheet() throws Throwable {
		workbook.close();
	}
	
	/**
	 * set the data in excel
	 * @param rowNum
	 * @param colNum
	 * @param data
	 * @throws Throwable
	 */
	public void setData(int rowNum, int celNum, String data) throws Throwable {
		Row row = sheet.getRow(rowNum);
		Cell cel = row.createCell(celNum);
		cel.setCellValue(data);
		workbook.write(new FileOutputStream(path));
	}
}
