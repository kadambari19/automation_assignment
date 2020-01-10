package com.app.library;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonLib extends BaseClass{
	
	private JavascriptExecutor jse = (JavascriptExecutor)driver;
	private String alert;
	private String parentId;
	private String childId; 
	private Set<String> windows;
	
	
	/**
	 * executing java script
	 * @param script
	 * @return
	 */
	public Object runScript(String script) {
		return jse.executeScript(script);
	}
	
	/**
	 * wait till element gets loaded
	 * @param element
	 */
	public void waitForElementToBePresent(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * wait for element and check is it displayed
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitForElementToAppear(WebElement element) throws InterruptedException {
		int timeCount =0;
		while(timeCount<20) {
			try {
				element.isDisplayed();
				break;
			}catch (Exception e) {
				Thread.sleep(200);
				timeCount++;
			}
		}
	}
	
	public void switchToChildWindow(String title)
	{
		Set<String> windowHandles = driver.getWindowHandles();
		java.util.Iterator<String> iterator = windowHandles.iterator();
		while(iterator.hasNext()) {
		String child = iterator.next();
		driver.switchTo().window(child);
		//capture url
		String actUrl = driver.getCurrentUrl();
		if(actUrl.contains(title))
		{
			break;
		}
	}
	}
	public void moveElement(WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

}
