package tests.salesUser;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.CommonOperations;
import pageObjects.GlobalSearch;
import pageObjects.ProductDetailsPage;
import pageObjects.SetUpPage;
import pageObjects.UserDetailsPage;
import pageObjects.UserEnv;
import pageObjects.SFLoginPage;
import utils.GlobalVariables;
import org.openqa.selenium.interactions.Actions;

import utils.LoggerClass;
import utils.SetUp;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
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

public class SalesUserSmokeTests {

	WebDriver driver;
	CommonOperations commOps;
	WebDriverWait driverwait;
	SetUpPage setUpPage;
	SFLoginPage sfLoginPage;
	GlobalVariables gv;
	GlobalSearch gs;
	UserDetailsPage usd;
	UserEnv uenv;
	ProductDetailsPage pdp;
	//CPQPage cpqPage;
	boolean loginSuccess = false;
	boolean proxylogin = false;

	SetUp setUp = new SetUp();
	static JavascriptExecutor js;
	Actions actions;

	private static Logger logger = LogManager.getLogger(LoggerClass.class);
 
	@BeforeClass
	public void setup() throws Exception {
		try {
		driver = setUp.SetUp(driver);

		js = (JavascriptExecutor) driver;
		 actions = new Actions(driver);
		

		sfLoginPage = PageFactory.initElements(driver, SFLoginPage.class);
		setUpPage = PageFactory.initElements(driver, SetUpPage.class);
		commOps = PageFactory.initElements(driver, CommonOperations.class);
		gs = PageFactory.initElements(driver, GlobalSearch.class);
		usd = PageFactory.initElements(driver, UserDetailsPage.class);
		uenv = PageFactory.initElements(driver, UserEnv.class);
		pdp = PageFactory.initElements(driver, ProductDetailsPage.class);
		driverwait = new WebDriverWait(driver, Duration.ofSeconds(10));

		commOps.sendText(sfLoginPage.username,GlobalVariables.adminUserName);
		commOps.sendText(sfLoginPage.password,GlobalVariables.adminPassword);
		commOps.elementClick(sfLoginPage.loginButton);

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(commOps.appLauncherButton));
		boolean a = commOps.webElementIsDisplayed(commOps.appLauncherButton);
		logger.info("App Launcher button found"+a);
		if (a) {

			loginSuccess = true;
			
			

		} else {
			logger.info("Admin login failed");
			driver.quit();
			Assert.assertFalse(true);
		
			
		}
		
		
		String user = GlobalVariables.User.get("verifySalesUserAbleToViewProducts");
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);			
		
		actions.sendKeys(gs.globalSearch, user);
				
		
		commOps.sendEnter(gs.globalSearch);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
		
		gs.clickUser(user);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
				
		Thread.sleep(5000);
		
		
		driver.switchTo().frame(usd.userDetailsFrame);			
		
		
		logger.info(commOps.webElementIsDisplayed(usd.userLoginButton));
		
		js.executeScript("arguments[0].click();", usd.userLoginButton);
		
		
		Thread.sleep(5000);
		
		
		  if(uenv.userLoginSuccess(user)) {
			  logger.info("Login as Custom Sales User Success");
			  proxylogin = true;
			  
		  Assert.assertTrue(true); 
		  
		  
		  }else {
			  logger.info("Login as Custom Sales User Failed");
		  Assert.assertTrue(false);
		  
		  }
		 
		
		
		
		}catch(Exception e) {
		//	System.out.println("Exception caught:"+e);
			logger.error("Failure in test launch" +e);
			driver.quit();
			Assert.assertFalse(true);
		}

	}

	@Test
	public void testProxyLoginAsCustomSalesUser() {
		try {

			String user = GlobalVariables.User.get("testProxyLoginAsCustomSalesUser");
			
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);			
			
			actions.sendKeys(gs.globalSearch, user);
					
			
			commOps.sendEnter(gs.globalSearch);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						
			
			gs.clickUser(user);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
					
			Thread.sleep(5000);
			
			
			driver.switchTo().frame(usd.userDetailsFrame);			
			
			
			logger.info(commOps.webElementIsDisplayed(usd.userLoginButton));
			
			js.executeScript("arguments[0].click();", usd.userLoginButton);
			
			
			Thread.sleep(5000);
			
			
			  if(uenv.userLoginSuccess(user)) {
				  logger.info("Login as Custom Sales User Success");
				  
				  proxylogin = true;
			  Assert.assertTrue(true); 
			  
			  
			  }else {
				  logger.info("Login as Custom Sales User Failed");
			  Assert.assertTrue(false);
			  
			  }
			 
			
		} catch (Exception e) {
			logger.error("Test Failed testProxyLoginAsCustomSalesUser failed with exception: "+e);
			
			Assert.assertTrue(false);

		}

	}

	@Test
	public void verifySalesUserAbleToViewProducts() {
		
		logger.info("Proxy Login "+proxylogin);
		
		try {
			
			if(proxylogin) {
				boolean b = false;
				
				List<String> products  = GlobalVariables.testdata.get("verifySalesUserAbleToViewProducts");
				
				
				
				Thread.sleep(10000);

				
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				
				for(String product: products ) {
					
					
					logger.info(product);
					
					
					actions.sendKeys(gs.globalSearch, product).perform();
					
					gs.globalSearch.click();
					gs.globalSearch.clear();
					
					actions.sendKeys(gs.globalSearch, product).perform();
					
					commOps.sendEnter(gs.globalSearch);
					
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					Thread.sleep(5000);
					
					
					gs.clickOnProduct(product);	
					
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					 b = pdp.productPageLoaded(product);
					
					
									
				if(b) {
					
					Assert.assertTrue(true);
					
				}
					
									
			}	}}
			
			
			
		catch(Exception e) {
			
			logger.error("Test Failed testProxyLoginAsCustomSalesUser with exception: "+e);
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
