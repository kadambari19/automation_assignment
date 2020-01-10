package com.app.objectRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.library.CommonLib;
import com.app.library.FilePath;
import com.app.library.GenericLib;

/**
 * 
 * @author Kadambari Shastry
 *
 */

public class AmazonHomePage {

	private WebDriver driver;
	private CommonLib common;

	public AmazonHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		common= new CommonLib();
	}
	
	//search btn
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBtn;
	
	public void clickOnSearchBtn(String fPath,String sheet,int rowNum,int cellNum)
	{
		
		common.waitForElementToBePresent(searchBtn);
		try {
			searchBtn.click();
			searchBtn.sendKeys(GenericLib.getData(fPath, sheet, rowNum, cellNum),Keys.ENTER);
		} catch (Throwable e) {
			
		}	
	}
	
	//getting text
	@FindBy(xpath="//span[text()='Apple iPhone XR (64GB) - Yellow']/../../../../../../..//span[@class='a-price-whole']")
	private WebElement priceTag;
	
	public int getPriceTag()
	{
		int amazonPrice =Integer.parseInt(priceTag.getText()) ;
		return amazonPrice;
	}
	
	//navigate to new tab
	public void navigateToNewTab(String Url,String title)
	{
		Robot rob = null;
		try {
			rob = new Robot();
		} catch (AWTException e1) {
			
		}
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_T);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_T);
		common.switchToChildWindow(title);
		String url;
		try {
			url = GenericLib.getValue(FilePath.propPath,Url);
			driver.get(url);
		} catch (Throwable e) {
			
		}	
	}
}
