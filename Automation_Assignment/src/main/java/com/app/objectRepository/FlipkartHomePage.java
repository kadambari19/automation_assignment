package com.app.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.library.CommonLib;
import com.app.library.GenericLib;

/**
 * 
 * @author Kadambari Shastry
 *
 */
public class FlipkartHomePage {
	
	private WebDriver driver;
	private CommonLib common;
	
	public FlipkartHomePage() {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		common= new CommonLib();
	}
	
	//close login 
	@FindBy(xpath="//button[text()='✕']")
	private WebElement closeBtn;
	
	public void clickOnCloseBtn()
	{
		common.waitForElementToBePresent(closeBtn);
		closeBtn.click();
	}
	
	//search button
	@FindBy(name="q")
	private WebElement searchBtn;
	
	public void clickOnSearchBtn(String fPath,String sheet,int rowNum,int cellNum)
	{
		
		common.waitForElementToBePresent(searchBtn);
		try {
			searchBtn.sendKeys(GenericLib.getData(fPath, sheet,rowNum, cellNum));
		} catch (Throwable e) {
			
		}	
		searchBtn.click();
	}
	
	//getting price 
	@FindBy(xpath="//div[text()='Apple iPhone XR (Yellow, 64 GB)']/../../../../../../..//div[@class='_1vC4OE _2rQ-NK']")
	private WebElement priceTag;
	
	public int getPrice()
	{
		int flipkartPrice = Integer.parseInt(priceTag.getText());
		return flipkartPrice;
	}

}
