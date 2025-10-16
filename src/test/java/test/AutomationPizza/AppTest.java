package test.AutomationPizza;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;

public class AppTest {

    private WebDriver driver;

    private static ExtentReports extentReport;
    private static ExtentTest test;

    @BeforeSuite
    public void setupExtent() {
       
    	extentReport = new ExtentReports(); // ✅ assign to class-level variable
        File file = new File("report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        extentReport.attachReporter(sparkReporter);

        extentReport.setSystemInfo("OS", System.getProperty("os.name"));
        extentReport.setSystemInfo("Tester", "Anand");
    }

    @AfterSuite
    public void tearDownExtent() {
    	extentReport.flush();
    }

    @BeforeMethod
    public void setup() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       
    }

    @Test
    public void testPass() throws IOException {
    	 test = extentReport.createTest("testPass"); // ✅ this is required!
    	    driver.get("https://www.google.com");
    	    test.info("Navigated to Google");

    	    assert driver.getTitle().contains("Google");

    	    String homepage = basetakeScreenshot("homepage");
    	    test.pass("Home page", MediaEntityBuilder.createScreenCaptureFromBase64String(homepage).build());

    	   
    }


    @AfterMethod
    public void tearDown() throws IOException {

        if (driver != null) {
            driver.quit();
        }
    }

    public String takeScreenshot(String testName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        File screenshotDir = new File("screenshots");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }

        File destFile = new File(screenshotDir, testName + ".png");
        FileHandler.copy(srcFile, destFile);

        return destFile.getAbsolutePath();
    }
    public String basetakeScreenshot(String testName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        String srcFile = ts.getScreenshotAs(OutputType.BASE64);

        File screenshotDir = new File("screenshots");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }

        return srcFile;
    }
}
