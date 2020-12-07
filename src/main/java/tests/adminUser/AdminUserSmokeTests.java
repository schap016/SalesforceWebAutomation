package tests.adminUser;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.CPQPage;
import pageObjects.CommonOperations;
import pageObjects.SetUpPage;
import pageObjects.SFLoginPage;
import utils.GlobalVariables;
import org.openqa.selenium.WebElement;
import utils.LoggerClass;
import utils.SetUp;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.ITestResult;

public class AdminUserSmokeTests {

	WebDriver driver;
	CommonOperations commOps;
	WebDriverWait driverwait;
	SetUpPage setUpPage;
	SFLoginPage sfLoginPage;
	GlobalVariables gv;
	CPQPage cpqPage;
	boolean loginSuccess = false;

	SetUp setUp = new SetUp();
	static JavascriptExecutor js;

	private static Logger logger = LogManager.getLogger(LoggerClass.class);
 
	@BeforeClass
	public void setup() throws Exception {
		try {
		driver = setUp.SetUp(driver);

		js = (JavascriptExecutor) driver;

		sfLoginPage = PageFactory.initElements(driver, SFLoginPage.class);
		setUpPage = PageFactory.initElements(driver, SetUpPage.class);
		commOps = PageFactory.initElements(driver, CommonOperations.class);
		cpqPage = PageFactory.initElements(driver,CPQPage.class);
		driverwait = new WebDriverWait(driver, Duration.ofSeconds(10));

		commOps.sendText(sfLoginPage.username,GlobalVariables.adminUserName);
		commOps.sendText(sfLoginPage.password,GlobalVariables.adminPassword);
		commOps.elementClick(sfLoginPage.loginButton);

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(commOps.appLauncherButton));
		boolean a = commOps.webElementIsDisplayed(commOps.appLauncherButton);
		if (a==true) {

			loginSuccess = true;

		} else {
			driver.quit();
			Assert.assertFalse(true);
			logger.info("Home page did not load");
		}}catch(Exception e) {
		//	System.out.println("Exception caught:"+e);
			logger.error("Failure in test launch" +e);
			driver.quit();
			Assert.assertFalse(true);
		}

	}

	@Test
	public void testDeveloperConsoleIsVisible() {
		try {

			if (loginSuccess == true) {

				boolean a, b;

				a = commOps.webElementIsDisplayed(setUpPage.setupbutton);

				commOps.elementClick(setUpPage.setupbutton);

				b = commOps.webElementIsDisplayed(setUpPage.devConsole);
				
				System.out.println(GlobalVariables.testdata.get("testDeveloperConsoleIsVisible"));

				if (a == true && b == true) {

					Assert.assertTrue(true);

				} else {

					Assert.assertTrue(false);
				}

			}

			Assert.assertTrue(loginSuccess);
		} catch (Exception e) {
			logger.error(e);

		}

	}

	@Test
	public void verifyAdminIsAbleToNavigateToCPQApp() {

		try {
			boolean a, b, c, d;

			a = commOps.webElementIsDisplayed(commOps.appLauncherButton);
			
			Thread.sleep(5000);
			logger.info("App Launcher button displayed");
			
			commOps.elementClick(commOps.appLauncherButton);
			
			logger.info("App Launcher button clicked");
			
			Thread.sleep(10000);
			b = commOps.webElementIsDisplayed(commOps.appSearchBox);

			logger.info("App appSearchBox displayed");
			commOps.sendText(commOps.appSearchBox, "Salesforce CPQ");

			commOps.sendEnter(commOps.appSearchBox);
			logger.info("Salesforce CPQ entered");
			Thread.sleep(10000);
			c = commOps.webElementIsDisplayed(commOps.appNameTitle);
			logger.info("Salesforce CPQ title displayed");
			Thread.sleep(2000);
			String appTitle = commOps.getAttributeValue(commOps.appNameTitle, "innerText");
			
			
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(cpqPage.productsLink));
			
			d = commOps.webElementIsDisplayed(cpqPage.productsLink);
			
			logger.info("products link is displayed"+d);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", cpqPage.productsLink);
			//commOps.elementClick(cpqPage.productsLink);
			
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(cpqPage.productsTitle));
			
			commOps.elementClick(cpqPage.productsListViewControl);
			
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(cpqPage.selectAllProducts));
			
			commOps.elementClick(cpqPage.selectAllProducts);
			
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(4000);
			WebElement productTable  = driver.findElement(By.xpath("//tbody"));
			List<WebElement> productRows = productTable.findElements(By.tagName("tr"));
			System.out.println(productRows.size());
		

			if (a == true && b == true && c == true && d ==true) {
				Assert.assertEquals(appTitle, "Salesforce CPQ");

			} else {

				logger.error("Test : verifyAdminIsAbleToNavigateToCPQApp failed");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {

			// System.out.println(e);
			logger.error(e);
			Assert.assertTrue(false);
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
        //System.out.println("Enter afterMethod");
		
        
        
        
        
	}
	
	@AfterSuite
	public void tearDownAfterSuite() {
        System.out.println("Enter tearDownAfterSuite");

		driver.quit();
		System.out.println("Exit tearDownAfterSuite");
	}
	

}
