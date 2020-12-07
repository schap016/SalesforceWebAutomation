package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;


//Home page operations and actions
public class LoginPage {

	/*
	 * HomePage(WebDriver driver) { super(driver); // TODO Auto-generated
	 * constructor stub }
	 */

	WebDriver driver;
	
	//Home Page locators	

	@FindBy(how = How.ID, using = "email")
		public WebElement emailId;
	@FindBy(how = How.ID, using = "password")
		public WebElement password;
	@FindBy(how = How.XPATH, using = "//button[@data-automation-id='sign-in-button']")
		public WebElement signInButton;
	public LoginPage(WebDriver driver) {
		
		
		this.driver = driver;
	}


	// extended super class CommonOperations driver variable  = d

	
	public boolean loginPagewebElementIsDisplayed(WebElement element) {
		  
		//WebElement element2;
		boolean a = false;
		
	//	a = webElementIsDisplayed(element);
		
		
		if (element.isDisplayed()==true) {
			a = true;
			return a;
		}
		return a;
			
	}
	
	
	
	public void loginPageElementClick(WebElement element) {
		
		//driver.findElement((By) element);
		element.click();
	
		
		
	}
	
	public void loginPageSendText(WebElement element, String keys) {
		element.sendKeys(keys);
		
	}
	
	public String loginGetPageTitle() {
		
		return driver.getTitle();
	}
	
	
}