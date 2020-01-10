package com.app.testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.library.FilePath;
import com.app.library.BaseClass;
import com.app.library.CommonLib;
import com.app.objectRepository.AmazonHomePage;
import com.app.objectRepository.FlipkartHomePage;
import com.app.objectRepository.TripAdvisorPage;
import com.app.reports.ExtentReport;
import com.aventstack.extentreports.Status;

/**
 * 
 * @author Kadambari Shastry
 *
 */
public class ScriptTest extends BaseClass{
	
	CommonLib lib = new CommonLib();
	private AmazonHomePage ahome;
	private int amazonPrice;
	private int flipkartPrice;
	@Test
	public void productPriceCompare()
	{
		
		ahome = new AmazonHomePage(driver);
		//validation of amazon home page title
		String amazonExpTitle = "Online Shopping site";
		String amazonActTitle = driver.getTitle();
		System.out.println(amazonActTitle);
		boolean amazonTitle = amazonActTitle.contains(amazonExpTitle);
		Assert.assertTrue(amazonTitle);
		ExtentReport.testlog.log(Status.PASS, "amazon home page loaded successfully");
		ExtentReport.testlog.log(Status.FAIL, "amazon home page loading failed");
		ExtentReport.report.flush();
		ahome.clickOnSearchBtn(FilePath.excelPath,"sheet1",0, 0);
		
		//validation of amazon product page
		String expProductPageTitle = "Amazon.in:";
		String actProductPageTitle = driver.getTitle();
		boolean amazonProductPage = actProductPageTitle.contains(expProductPageTitle);
		Assert.assertTrue(amazonProductPage);
		ExtentReport.testlog.log(Status.PASS, "amazon product page loaded successfully");
		ExtentReport.testlog.log(Status.FAIL, "amazon product page loading failed");
		ExtentReport.report.flush();
	    amazonPrice = ahome.getPriceTag();
		System.out.println(amazonPrice);	
	}
	
	//switching to flipkart page
	@Test
	public void flipkartPage() {
		ahome.navigateToNewTab("FlipkartUrl","Online Shopping Site for Mobile");
		FlipkartHomePage fhome = new FlipkartHomePage();
		//validation of flipkart home page title
		String flipkartExpTitle = "Online Shopping";
		String flipkartActTitle = driver.getTitle();
		boolean flipkartTitle = flipkartActTitle.contains(flipkartExpTitle);
		Assert.assertTrue(flipkartTitle);
		ExtentReport.testlog.log(Status.PASS, "flipkart home page loaded successfully");
		ExtentReport.testlog.log(Status.FAIL, "flipkart home page loading failed");
		ExtentReport.report.flush();
		fhome.clickOnCloseBtn();
		fhome.clickOnSearchBtn(FilePath.excelPath,"sheet1",0, 0);
		
		//validation of flipkart product page
		String flipkartexpProductPageTitle = "Amazon.in:";
		String flipkartactProductPageTitle = driver.getTitle();
		boolean flipkartProductPage = flipkartactProductPageTitle.contains(flipkartexpProductPageTitle);
		Assert.assertTrue(flipkartProductPage);
		ExtentReport.testlog.log(Status.PASS, "flipkart product page loaded successfully");
		ExtentReport.testlog.log(Status.FAIL, "flipkart product page loading failed");
		ExtentReport.report.flush();
		flipkartPrice = fhome.getPrice();
		System.out.println(flipkartPrice);
		
		//validation
		
		if(amazonPrice<flipkartPrice)
		{
			ExtentReport.testlog.log(Status.INFO, "price of the product is less in amazon");
			ExtentReport.report.flush();
			System.out.println("price of the product is less in amazon compared to flipkart");
		}
		else
		{
			ExtentReport.testlog.log(Status.INFO, "price of the product is less in flipkart");
			ExtentReport.report.flush();
			System.out.println( "price of the product is less in flipkart compared to amazon");
		}
			
		
	}
	
	
    @Test 
	public void tripTest()
		{
		 //switching to tripAdvisor page
		 ahome.navigateToNewTab("tripUrl","TripAdvisor");
		TripAdvisorPage trip = new TripAdvisorPage(driver);
			
		//passing the data club mahindra
		trip.clickOnSearchBtn(FilePath.excelPath,"sheet1",0, 1);
		trip.clickOnSuggestion();
		trip.clickOnWriteReview();
		lib.switchToChildWindow("write");
		boolean value = trip.moveOnRating();
		Assert.assertTrue(value);
		ExtentReport.testlog.log(Status.PASS, "ratings are highlighted");	
		ExtentReport.testlog.log(Status.FAIL, "ratings are not highlighted");
		ExtentReport.report.flush();
		
		
		trip.writeReview(FilePath.excelPath,"sheet1",0, 1);
		trip.review(FilePath.excelPath,"sheet1",1, 0);
			
		boolean serv = trip.service();
		Assert.assertTrue(serv);
		ExtentReport.testlog.log(Status.PASS, "service ratings are highlighted");
		ExtentReport.testlog.log(Status.FAIL, "service ratings are not highlighted");
		ExtentReport.report.flush();

		boolean loc = trip.location();
		Assert.assertTrue(loc);
		ExtentReport.testlog.log(Status.PASS, "location ratings are highlighted");
		ExtentReport.testlog.log(Status.FAIL, "location ratings are not highlighted");
		ExtentReport.report.flush();

		boolean room = trip.rooms();
		Assert.assertTrue(room);
		ExtentReport.testlog.log(Status.PASS, "room ratings are highlighted");
		ExtentReport.testlog.log(Status.FAIL, "room ratings are not highlighted");
		ExtentReport.report.flush();

		trip.clickCheckbox();
		}		
}
