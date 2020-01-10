package com.app.library;

/**
 * 
 * @author Kadambari Shastry
 *
 */

public interface FilePath {

	String dirPath = System.getProperty("user.dir");
	String propPath = dirPath+"./src/main/resources/commonData.properties";
	String excelPath = dirPath+"./src/main/resources/excel/Data.xlsx";
	
}
