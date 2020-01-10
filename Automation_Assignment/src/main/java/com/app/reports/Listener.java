package com.app.reports;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.app.library.BaseClass;
import com.aventstack.extentreports.Status;

/**
 * 
 * @author Kadambari Shastry
 *
 */
public class Listener extends ExtentReport implements ITestListener{

	public static String testCaseName;
	
	@Override
	public void onTestStart(ITestResult result) {
		testlog.log(Status.INFO, "Started "+result.getName());
		testCaseName = result.getTestClass().getName().toString();
		testCaseName = testCaseName.substring(testCaseName.lastIndexOf(".") + 1, testCaseName.length());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		testlog.log(Status.PASS, result.getName()+" is Pass");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		EventFiringWebDriver edr = new EventFiringWebDriver(BaseClass.driver);
		File srcFile = edr.getScreenshotAs(OutputType.FILE);
		String date = new Date().toString().replace(" ", "_").replace(":", "_");
		File dfile = new File("./screenshot_"+date +"/"+ testCaseName + ".png");
		try {
			FileUtils.copyFile(srcFile, dfile);
			testlog.log(Status.FAIL, "Failed "+result.getName());
		} catch (Throwable e) {
		}	
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		testlog.log(Status.SKIP, "Skipped "+result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
