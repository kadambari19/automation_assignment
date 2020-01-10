package com.app.library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * 
 * @author Kadambari Shastry
 *
 */
public class BaseClass implements FilePath{
	
public static WebDriver driver;
	
	/**
	 * Launch the selected browser
	 * @throws Throwable
	 */
	@BeforeClass
	public void configureBeforeClass() {
		
		String url = GenericLib.getValue(FilePath.propPath,"AmazonUrl");
		String browser = GenericLib.getValue(FilePath.propPath,"browser");

		if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		try{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//driver.manage().window().maximize();
			driver.get(url);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	/**
	 * close the selected browser
	 * 
	 */
	@AfterClass
	public void configureafterClass() {
		
	try{
		driver.quit();
	}catch (Exception e) {
		
	}
	}

}
