package test.AutomationPizza;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Locators extends Driver{


	public Locators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private static WebElement element;
	private static List<WebElement> elements;

	public enum typeOflocator{
		Xpathlocator , CSSlocator, Id, Name, ClassName;
	}
	
	public static WebElement createWebElement(String locator, String value)
	{
		element = null;
		
		switch(typeOflocator.valueOf(locator))
		{
		
		case Xpathlocator:
			element = driver.findElement(By.xpath(value));
			break;
			
		case CSSlocator:
			element= driver.findElement(By.cssSelector(value));
			break;
		
		case Id:
			element=driver.findElement(By.id(value));
			break;
			
		case ClassName:
			element = driver.findElement(By.className(value));
			break;
			
		default:
			break;
			
		}
			
		return element;
	}
	public static List<WebElement> createWebElements(String locator, String value)
	{
		elements = null;
		
		switch(typeOflocator.valueOf(locator))
		{
		
		case Xpathlocator:
			elements = driver.findElements(By.xpath(value));
			break;
			
		case CSSlocator:
			elements= driver.findElements(By.cssSelector(value));
			break;
		
		case Id:
			elements=driver.findElements(By.id(value));
			break;
			
		case ClassName:
			elements = driver.findElements(By.className(value));
			break;
			
		default:
			break;
			
		}
			
		return elements;
	}
	
}
