package pageObjects;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pageObjects.CommonOperations;

//Login page operations and actions
public class SFLoginPage{


	WebDriver driver;
	//CommonOperations commops;
	
	//SF Login Page locators	


	@FindBy(how = How.ID, using = "username")
		public WebElement username;
	@FindBy(how = How.ID, using = "password")
		public WebElement password;	
	@FindBy(how = How.ID, using = "Login")
		public WebElement loginButton;


	public SFLoginPage(WebDriver driver) {
		
		
		//super(driver);
		this.driver = driver;
	}


	

}