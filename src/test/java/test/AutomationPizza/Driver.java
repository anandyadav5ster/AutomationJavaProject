package test.AutomationPizza;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	static WebDriver driver;
	public static ExtentTest logger;
	static String path = System.getProperty("user.dir");
	
	public Driver(WebDriver driver) {
		this.logger = logger;
	}

	@BeforeMethod
	public static WebDriver setup() {
		 WebDriverManager.edgedriver();
			System.setProperty("webdriver.edge.driver","C:\\Users\\Admin\\Desktop\\Softwares\\ChromeDriver\\msedgedriver.exe");
	       EdgeOptions eoptions = new EdgeOptions();
	       eoptions.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(eoptions);
			driver.manage().window().maximize();
			return driver;
		
	}
	@AfterMethod
	public void getResult(ITestResult result) throws Exception{
	if(result.getStatus() == ITestResult.FAILURE){
	//MarkupHelper is used to display the output in different colors
	logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
	logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
	//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
	//We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method.
	//String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
	String screenshotPath = getScreenShot(driver, result.getName());
	//To add it in the extent report
	logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
	}
	else if(result.getStatus() == ITestResult.SKIP){
	logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
	}
	else if(result.getStatus() == ITestResult.SUCCESS)
	{
	logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	}
	driver.quit();
	}

	
	
	//This method is to capture the screenshot and return the path of the screenshot.
		public static String getScreenShot(WebDriver driver, String string) throws IOException, InterruptedException {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			Thread.sleep(1000);
			File source = ts.getScreenshotAs(OutputType.FILE);
	// after execution, you could see a folder "FailedTestsScreenshots" under src folder
			String destination = System.getProperty("user.dir") + "/Report/Screenshots/" + dateName + ".png";
			File finalDestination = new File(destination);
			Files.copy(source, finalDestination);
			return destination;
		}
		/*
		 * @Author :Anand
		 * This method is use to check and highlight element on page
		 * @csslocator
		 */
		void HighElement(ExtentTest logger,WebElement charbotimage) throws IOException, InterruptedException {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			Thread.sleep(1000);
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File(System.getProperty("user.dir") + "/Report/Screenshots/" + dateName + ".png");
		
			FileUtils.copyFile(source, destination);
	        //Create object of a JavascriptExecutor interface
	JavascriptExecutor js = (JavascriptExecutor) driver;
	        //use executeScript() method and pass the arguments
	        //Here i pass values based on css style. Yellow background color with solid red color border.
	js.executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px solid red;');", charbotimage);
	System.out.println(destination.getAbsolutePath());
	logger.addScreenCaptureFromPath(destination.getAbsolutePath());
	js.executeScript("arguments[0].setAttribute('style', 'background: red; border: 0px solid red;');", charbotimage);
			
		}
}
