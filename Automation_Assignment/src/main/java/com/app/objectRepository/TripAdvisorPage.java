package com.app.objectRepository;

import org.openqa.selenium.Keys;
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
public class TripAdvisorPage {
	
	private WebDriver driver;
	private CommonLib common;
	
	public TripAdvisorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		common= new CommonLib();
	}
	
	@FindBy(xpath="//div[@class='brand-global-nav-action-search-Search__searchButton--b9-IK']") 	////div[text()='Search']
	private WebElement searchBtn;
	
	public void clickOnSearchBtn(String fPath,String sheet,int rowNum,int cellNum)
	{
		
		common.waitForElementToBePresent(searchBtn);
		try {
			searchBtn.click();
			searchBtn.sendKeys(GenericLib.getData(fPath, sheet, rowNum, cellNum));
		} catch (Throwable e) {
			
		}		
	}
	
	//searched suggestion
	@FindBy(xpath="//span[text()='Madikeri, India']")
	private WebElement searchSuggest;
	public void clickOnSuggestion()
	{
		searchSuggest.click();
	}
	
	//clicking on write review
	@FindBy(xpath="//a[text()='Write a review']")
	private WebElement writeReview;
	
	public void clickOnWriteReview()
	{
		writeReview.click();
	}
	
	//overall rating section
	@FindBy(id="bubble_rating")
	private WebElement rating;
	
	public boolean moveOnRating()
	{
		common.moveElement(rating);
		boolean selected = rating.isSelected();
		rating.click();
		return selected;
	}
	
	// title of review section
	@FindBy(id="ReviewTitle")
	private WebElement TitleReview;
	
	public void writeReview(String fPath,String sheet,int rowNum,int cellNum)
	{
		TitleReview.sendKeys(GenericLib.getData(fPath, sheet, rowNum, cellNum));
	}
	
	// review section
	@FindBy(id="ReviewText")
	private WebElement review;
	
	public void review(String fPath,String sheet,int rowNum,int cellNum)
	{
		review.sendKeys(GenericLib.getData(fPath, sheet, rowNum, cellNum));
	}
	
	//hotel rating section
	@FindBy(xpath="//span[@date-name='Service']")
	private WebElement service;
	
	public boolean service()
	{
		common.moveElement(service);
		boolean select = service.isSelected();
		service.click();
		return select;
	}
	
	//location rating section
	@FindBy(xpath="//span[@date-name='Location']")
	private WebElement location;
	
	public boolean location()
	{
		common.moveElement(location);
		boolean locSelect = location.isSelected();
		location.click();
		return locSelect;
	}
	
	//room rating section
	@FindBy(xpath="//span[@date-name='Rooms']")
	private WebElement room;
	
	public boolean rooms()
	{
		common.moveElement(room);
		boolean roomSelect = room.isSelected();
		room.click();
		return roomSelect;
	}
	
	//checkbox
	@FindBy(id="noFraud")
	private WebElement checkbox;
	
	public void clickCheckbox()
	{
		checkbox.click();
	}

}
