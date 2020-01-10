package com.app.reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import com.app.library.FilePath;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * 
 * @author Kadambari Shastry
 *
 */
public class ExtentReport {
	
	public static ExtentReports report;
	public static ExtentTest testlog;
	public static void report(ITestContext result)
	{
		SimpleDateFormat df=new SimpleDateFormat("dd-mm-yy");
		Date date=new Date();
		
		ExtentHtmlReporter htmlreport=new ExtentHtmlReporter(FilePath.dirPath+"\\Reports\\ApplicationBuild_ "+df.format(date)+".html");
		htmlreport.config().setDocumentTitle("browser report");
		htmlreport.config().setReportName(result.getName());
		
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		testlog=report.createTest(result.getName());
		
	}

}
