package test.AutomationPizza;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Functions extends Driver{

static String path = System.getProperty("user.dir");


public Functions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
	}





public void Click(String locator, String locatorValue) throws InterruptedException {
	WebElement element = Locators.createWebElement(locator,locatorValue);
	element.click();
	Thread.sleep(1000);
}


	boolean isDisplayedCSS(String locator,String value) {
		boolean status = false;
		try {
		WebElement x = Locators.createWebElement(locator,value);
		
			x.isDisplayed();
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}

	boolean Clickable(String locator,String value) {
		boolean status = false;
		try {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(value)));
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}
	
	String GetText(String locator,String value) {

		
			WebElement x = Locators.createWebElement(locator,value);
			String res = x.getText();
			System.out.println(res);
			return res;
		} 
		
	
	/*
	 * @Author :Anand
	 * This method is use to enter text
	 * @id
	 */
		

	void EnterText(String locator, String locatorvalue, String value) {
		WebElement x = Locators.createWebElement(locator,locatorvalue);
		x.sendKeys(value);
	}



	/*
	 * @Author :Anand
	 * This method is use to wait till element visible
	 * @csslocator
	 */
	public enum typeOflocator{
		Xpathlocator , CSSlocator, Id, Name, ClassName;
	}		

	boolean ExplicitWaitTillVisible(String locator , String element) {
		boolean status = false;
		try {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		switch(typeOflocator.valueOf(locator)){
			case Xpathlocator:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
			status = true;
			break;
			case CSSlocator:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
			status = true;
			break;
		default:
			break;
		
		
		}	
		return status;
		}
		catch(Exception e)
		{
			System.out.println("No element found");
		}
	
		return status;
		
	}

	static /*
	 * @Author :Anand
	 * This method is use to enter url
	 * @csslocator
	 */
		
	void OpenUrl(String url) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
	}




	
	
//	void orderPizza() throws InterruptedException
//	{
//		
//		EnterText("Xpathlocator", Repositories.Inputbox_msg, "I want to order pizza");
//		Click("Xpathlocator", Repositories.send_msg_btn);
//		ExplicitWaitTillVisible("Xpathlocator", Repositories.suggestions_veg);
//	}


	void selectToppings() throws InterruptedException, IOException
	{
		Click("Xpathlocator", Repositories.toppings_beacons);
		Click("Xpathlocator", Repositories.submit);
		ExplicitWaitTillVisible("Xpathlocator", Repositories.sucessfully_beacon_selected);
	
	}

	void scrollToElement(String locator,String locatorpath) throws InterruptedException
	{
		WebElement element = Locators.createWebElement(locator,locatorpath);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
	}
	static boolean isElementPresent(String locator, String locatorpath){
	    try{
	    	WebElement element = Locators.createWebElement(locator,locatorpath);
	        return true;
	    }
	    catch(NoSuchElementException e){
	        return false;
	    }
	}
	
}
