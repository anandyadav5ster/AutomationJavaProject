package test.AutomationPizza;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.ITestResult;

import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;



public class AppTest{
	
	public WebDriver driver;
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest logger;
	public static Repositories repository;
	public static Functions function;
	public static WebElement Pizza_order_desc;
	


	
	
	@Test
	public void OpenHomePage() throws IOException, InterruptedException {
		driver = Driver.setup();
		
		logger = extent.createTest("Open Pizza charbot");
		function = new Functions(driver);
		Functions.OpenUrl(Repositories.url);

		function.ExplicitWaitTillVisible("CSSlocator",Repositories.chatbot_image);
		WebElement charbotimage = Locators.createWebElement("CSSlocator", Repositories.chatbot_image);
		function.HighElement(logger,charbotimage);
		logger.addScreenCaptureFromPath(Driver.getScreenShot(driver,"test"));
		
	
	
	
		logger = extent.createTest("verify a popup with McPizza welcome to pizza shoppe appears");
//		String welcome = Functions.GetText("CSSlocator",Repositories.welcome);
		WebElement welcome = Locators.createWebElement("CSSlocator",Repositories.welcome);
		String welcomemsg = welcome.getText();
		System.out.println(welcomemsg);
		logger.addScreenCaptureFromPath(getScreenShot(driver, welcomemsg));
		Assert.assertEquals(welcomemsg, "Welcome to Pizza Shoppe");
		function.HighElement(logger,welcome);
		
/*		logger = extent.createTest("Once it is cleared using a ‘x’ symbol provided ,verify it should vanish");
		charbotimage.click();
		WebElement getstarted = Locators.createWebElement("CSSlocator",Repositories.getstartedPopup);
		function.HighElement(logger,getstarted);
		logger.addScreenCaptureFromPath(Driver.getScreenShot(driver,"test"));
		
		
		
		logger = extent.createTest("Verify clicking on pizza symbol ,its opening a welcome page consists of ‘get started’ button");
		WebElement getstartedbtn = Locators.createWebElement("CSSlocator",Repositories.getstartedbtn);
		function.HighElement(logger,getstartedbtn);
		logger.addScreenCaptureFromPath(Driver.getScreenShot(driver,"test"));
		
		logger = extent.createTest("Verify clicking on x button closing the welcome page");
		function.Click("CSSlocator",Repositories.crossbtn);
		
		function.ExplicitWaitTillVisible("CSSlocator",Repositories.chatbot_image);
		function.HighElement(logger,charbotimage);
		logger.addScreenCaptureFromPath(Driver.getScreenShot(driver,"test"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		logger = extent.createTest("Verify clicking on get started button takes you to the details page.");
		function.Clickable("CSSlocator",Repositories.chatbot_image);
		function.Click("CSSlocator",Repositories.chatbot_image);
		if (function.isDisplayedCSS("CSSlocator",Repositories.chatbot_image)) {
			
		} 
		else
		{
			charbotimage.click();
		}
		function.ExplicitWaitTillVisible("CSSlocator",Repositories.getstartedbtn);
		getstartedbtn.click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='avaamoIframe']")));
//		function.ExplicitWaitTillVisible(Repositories.login_page);
		
		WebElement loginpage = Locators.createWebElement(Repositories.xpathlocator,Repositories.login_page);
		function.HighElement(logger,loginpage);
		logger.addScreenCaptureFromPath(Driver.getScreenShot(driver,"test"));
		
		
		function.EnterText(Repositories.xpathlocator,Repositories.username_id ,"Anand");
		function.EnterText(Repositories.xpathlocator,Repositories.email_id ,"test@gmail.com");
		function.HighElement(logger,loginpage);
		function.Click(Repositories.xpathlocator,Repositories.send_btn_xpath_btn);
//		driver.switchTo().defaultContent();
////		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='avaamoIframe']")));
		function.ExplicitWaitTillVisible(Repositories.xpathlocator,Repositories.WelcomeToOrderPizza_Page_msg);
		WebElement orderpage = Locators.createWebElement(Repositories.xpathlocator,Repositories.WelcomeToOrderPizza_Page_msg);
		String OrderWelcomemsg = orderpage.getText();
		System.out.println(OrderWelcomemsg);
		logger.addScreenCaptureFromPath(Driver.getScreenShot(driver,"test"));
		Assert.assertEquals(OrderWelcomemsg, "Welcome to McPizza Booking Journey");
		WebElement orderpagemsg = Locators.createWebElement(Repositories.xpathlocator,Repositories.WelcomeToOrderPizza_Page_msg);
		function.HighElement(logger,orderpagemsg);
		logger.addScreenCaptureFromPath(Driver.getScreenShot(driver,"test"));
		
		
		
		logger = extent.createTest("Verify it consists of Welcome to make my assignments image");
		WebElement assigmentimage = Locators.createWebElement(Repositories.xpathlocator,Repositories.assignmentsassignments_image);
		function.HighElement(logger,assigmentimage);
		logger.addScreenCaptureFromPath(Driver.getScreenShot(driver,"test"));
		
		
		
		logger = extent.createTest("Verify user name is displayed as typed on the welcome screen during login");
		function.EnterText(Repositories.xpathlocator, Repositories.Inputbox_msg, "food");
		function.Click(Repositories.xpathlocator, Repositories.send_msg_btn);
		
		
		logger = extent.createTest("Verify If the user type hi, bot replies Hi there, what can I help you with today? ");
		String usr = function.GetText(Repositories.xpathlocator, Repositories.username);
		Assert.assertEquals(usr, "Anand");
		WebElement usrname = Locators.createWebElement(Repositories.xpathlocator,Repositories.username);
		function.HighElement(logger,usrname);
		
		
//		logger = extent.createTest("Verify If the user type random text, bot replies I am sorry. I don't have an answer for that.");
//		String check = function.GetText(Repositories.xpathlocator,Repositories.sorry_msg);
//		WebElement sorry = Locators.createWebElement(Repositories.xpathlocator,Repositories.assignmentsassignments_image);
//		function.HighElement(logger,sorry);
		
		
		
		logger = extent.createTest("Verify If the user types I want to ,suggestions displays as I want to order pizza,order veg cheeze pizza,know the store details.");
		function.EnterText(Repositories.xpathlocator, Repositories.Inputbox_msg, "I want to ,suggestions displays as I want to order pizza,order veg cheeze pizza,know the store details.");
		function.Click(Repositories.xpathlocator, Repositories.send_msg_btn);
		function.ExplicitWaitTillVisible(Repositories.xpathlocator, Repositories.SelectGreat_msg);
//		List<WebElement> suggestion = Locators.createWebElements(Repositories.xpathlocator,Repositories.suggestions);
//		logger = extent.createTest(""+suggestion.size());
		
		
//		logger = extent.createTest("Verify If the user clicks I want to order pizza , bot should reply We have a wide variety of freshly backed pizza . What would you like to Order ? with veg and non veg option.");
		
//		function.orderPizza();
		
//		WebElement veg = Locators.createWebElement(Repositories.xpathlocator,Repositories.suggestions_veg);
//		function.HighElement(logger,veg);
//		WebElement nonveg = Locators.createWebElement(Repositories.xpathlocator,Repositories.suggestions_non_veg);
//		function.HighElement(logger,nonveg);
		
		
		
		
		logger = extent.createTest("Verify If a user clicks Veg ,bot should throw two options with select your topping .");	
		
//		function.Click(Repositories.xpathlocator, Repositories.suggestions_veg);
		WebElement vegitem= Locators.createWebElement(Repositories.xpathlocator,Repositories.item_image);
		function.HighElement(logger,vegitem);
		
		WebElement thincrust= Locators.createWebElement(Repositories.xpathlocator,Repositories.Thin_Crust);
		function.HighElement(logger,thincrust);
		
		if(function.ExplicitWaitTillVisible(Repositories.xpathlocator, Repositories.select_toppings_popup))
		{
			function.selectToppings();
		}
		
		logger = extent.createTest("Verify If a user select cheese topping and click on submit it should display Great you have selected the cheese as display message");
		function.Click(Repositories.xpathlocator, Repositories.Thin_Crust);
		
		
		
	
		logger = extent.createTest("Verify select crust as thin or thick.");
		
		WebElement scrollright= Locators.createWebElement(Repositories.xpathlocator,Repositories.scroll_right_btn);
		function.HighElement(logger,scrollright);
		function.Click(Repositories.xpathlocator, Repositories.scroll_right_btn);
		
		
		logger = extent.createTest("Verify there is a button to scroll right to select thick crust .");
		function.Click(Repositories.xpathlocator, Repositories.Thick_Crust);
	
		
		
		
		
		logger = extent.createTest(" Verify after selecting the crust , pizza size option should be displayed.");
		WebElement pizzasize= Locators.createWebElement(Repositories.xpathlocator,Repositories.pizza_size);
		function.HighElement(logger,pizzasize);
		
		
		logger = extent.createTest("Verify If a user is selected medium then he should gets his order overview like his pizza looks like this with the details .");
		WebElement McPizza_Order= Locators.createWebElement(Repositories.xpathlocator,Repositories.McPizza_Order);
		function.HighElement(logger,McPizza_Order);
		
		function.Click(Repositories.xpathlocator,Repositories.McPizza_Order);
//		function.Click(Repositories.xpathlocator, Repositories.suggestions_veg);
		
	
		
		
		
		logger = extent.createTest("Verify Once the user confirms the order ,bot to be replied Congrats ! order placed .");
		function.Click(Repositories.xpathlocator, Repositories.size_small);
		WebElement Pizza_order_desc= Locators.createWebElement(Repositories.xpathlocator,Repositories.Pizza_order_desc);
		function.HighElement(logger,Pizza_order_desc);
		
		function.Click(Repositories.xpathlocator, Repositories.yes_btn);
	
		WebElement Order_placed= Locators.createWebElement(Repositories.xpathlocator,Repositories.Order_placed);
		function.HighElement(logger,Order_placed);
		
	
		
		
		logger = extent.createTest("Verify giving the feedback as well.");
		
		WebElement feedback_message= Locators.createWebElement(Repositories.xpathlocator,Repositories.feedback_message);
		function.HighElement(logger,feedback_message);
		
		
		logger = extent.createTest("Verify user selects thumbs up then it will ask for to choose between Average/Good/Excellent ");
		
		WebElement feedback_Thumbsup= Locators.createWebElement(Repositories.xpathlocator,Repositories.feedback_Thumbsup);
		function.HighElement(logger,feedback_Thumbsup);
		WebElement feedback_Thumbsdown= Locators.createWebElement(Repositories.xpathlocator,Repositories.feedback_Thumbsdown);
		function.HighElement(logger,feedback_Thumbsdown);
		
		
		logger = extent.createTest("Verify once selected thank you for your support should be dipslayed.");
		function.Click(Repositories.xpathlocator,Repositories.feedback_Thumbsup);
		WebElement custom_feedback= Locators.createWebElement(Repositories.xpathlocator,Repositories.custom_feedback);
		function.HighElement(logger,custom_feedback);
		function.Click(Repositories.xpathlocator,Repositories.feedback_close_btn);
		
		
		
		logger = extent.createTest("Verify Once the user rejects the order ,bot to be wanna try again .");
		
//		function.orderPizza();
//		function.Click(Repositories.xpathlocator, Repositories.suggestions_veg);
//		if(function.ExplicitWaitTillVisible(Repositories.xpathlocator, Repositories.select_toppings_popup)) {
//			function.selectToppings();
//		}

		WebElement right_nav = Locators.createWebElement(Repositories.xpathlocator,Repositories.scroll_right_btn);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", right_nav);
//		function.Click(Repositories.xpathlocator, Repositories.scroll_right_btn);
		
		function.Click(Repositories.xpathlocator, Repositories.Thick_Crust);
		function.Click(Repositories.xpathlocator, Repositories.size_small);
		Pizza_order_desc= Locators.createWebElement(Repositories.xpathlocator,Repositories.Pizza_order_desc);
		function.HighElement(logger,Pizza_order_desc);
		function.Click(Repositories.xpathlocator, Repositories.No_btn);
		
		
		WebElement try_again_msg= Locators.createWebElement(Repositories.xpathlocator,Repositories.try_again_msg);
		function.HighElement(logger,try_again_msg);
		
		
		
		
		
		logger = extent.createTest("Verify if its yes entire step should repeat.");
		
//		function.orderPizza();
//		function.Click(Repositories.xpathlocator, Repositories.suggestions_veg);
//		if(function.ExplicitWaitTillVisible(Repositories.xpathlocator, Repositories.select_toppings_popup)) {
//			function.selectToppings();
//		}
//		function.scrollToElement(Repositories.xpathlocator,Repositories.select_toppings_popup);
//	
//		function.Click(Repositories.xpathlocator, Repositories.Thin_Crust);
//		
//		function.Click(Repositories.xpathlocator, Repositories.size_small);
//		function.Click(Repositories.xpathlocator, Repositories.yes_btn);
	
		
//		Pizza_order_desc= Locators.createWebElement(Repositories.xpathlocator,Repositories.Pizza_order_desc);
//		function.HighElement(logger,Pizza_order_desc);
//		function.Click(Repositories.xpathlocator, Repositories.suggestions_veg);
//		if(function.ExplicitWaitTillVisible(Repositories.xpathlocator, Repositories.select_toppings_popup)) {
//			function.selectToppings();
//		}
//		function.Click(Repositories.xpathlocator, Repositories.size_small);
//		function.Click(Repositories.xpathlocator,Repositories.McPizza_Order);
//		function.Click(Repositories.xpathlocator, Repositories.yes_btn);
//		
//		Order_placed= Locators.createWebElement(Repositories.xpathlocator,Repositories.Order_placed);
//		function.HighElement(Order_placed);
		
//		logger = extent.createTest("Verify if its no Thank you for your time should be displayed.");
//		function.Click(Repositories.xpathlocator,Repositories.feedback_Thumbsup);
//		function.Click(Repositories.xpathlocator, Repositories.pick_list);
//		function.Click(Repositories.xpathlocator, Repositories.pick_list_item0);
//		function.Click(Repositories.xpathlocator, Repositories.pick_list_submit);
//		WebElement thanksyou_msg= Locators.createWebElement(Repositories.xpathlocator,Repositories.thanksyou_msg);
//		function.HighElement(logger,thanksyou_msg);
//		
//		
//		logger = extent.createTest("Verify by asking bot how old are you? Get the response I don't know. My maker hasn't told me.");
//		function.EnterText(Repositories.xpathlocator, Repositories.Inputbox_msg, "how old are you ?");
//		function.Click(Repositories.xpathlocator, Repositories.send_msg_btn);
//		function.ExplicitWaitTillVisible(Repositories.xpathlocator, Repositories.last_msg);
//		check = function.GetText(Repositories.xpathlocator, Repositories.last_msg);
//		Assert.assertEquals(check, "I don't know. My maker hasn't told me.");
//		WebElement maker= Locators.createWebElement(Repositories.xpathlocator,Repositories.last_msg);
//		function.HighElement(logger,maker);
//		
//		
//		logger = extent.createTest("Verify by asking bot Are you a robot? .Get the response .Yes I am! Did I have you fooled?");
//		function.EnterText(Repositories.xpathlocator, Repositories.Inputbox_msg, "Are you a robot?");
//		function.Click(Repositories.xpathlocator, Repositories.send_msg_btn);
//		function.ExplicitWaitTillVisible(Repositories.xpathlocator, Repositories.last_msg);
//		check = function.GetText(Repositories.xpathlocator, Repositories.last_msg);
//		Assert.assertEquals(check, "Yes I am! Did I have you fooled?");
//		maker= Locators.createWebElement(Repositories.xpathlocator,Repositories.last_msg);
//		function.HighElement(logger,maker);
	*/
		
		logger.pass("Test cases completed");
		
		driver.quit();
		
	}





	//This method is to capture the screenshot and return the path of the screenshot.
	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	// after execution, you could see a folder "FailedTestsScreenshots" under src folder
	String destination = System.getProperty("user.dir") + "/Report/Screenshots/" + screenshotName + dateName + ".png";
	File finalDestination = new File(destination);
	FileUtils.copyFile(source, finalDestination);
	return destination;
	}
	
	@BeforeTest
	public void startReport() {
	         // Create an object of Extent Reports
	extent = new ExtentReports();

	spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/Report/AutomationExecutionReport.html");
	extent.attachReporter(spark);

	extent.setSystemInfo("Environment", "QA");
	extent.setSystemInfo("User Name", "Anand Yadav");
	spark.config().setDocumentTitle("Mc Pizza");
	                // Name of the report
	spark.config().setReportName("Mc Pizza Testing");
	                // Dark Theme
	spark.config().setTheme(Theme.STANDARD);
	}

	


	
	
	
	

	@AfterTest
	public void endReport() {
		extent.flush();
	}
	
	
}
