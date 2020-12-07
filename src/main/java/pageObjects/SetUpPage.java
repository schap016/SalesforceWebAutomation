package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pageObjects.CommonOperations;

//Login page operations and actions
public class SetUpPage{


	WebDriver driver;
	
	//SetUp Page locators	
	@FindBy(how = How.CLASS_NAME, using = "setupGear")
	public WebElement setupbutton;
	
	@FindBy(how = How.XPATH,using="//*[@class='uiMenu']/div/div/div/a/div")
	public WebElement devConsole;
	
	
	
	
	
	
	
	
	


	
	

	public SetUpPage(WebDriver driver) {
		
		
		//super(driver);
		this.driver = driver;
	}


	
	public void searchUser(String user) {
		
		
		
		String xpath = "//*[contains(text(),"+"'"+user+"'"+")]";
		
		driver.findElement(By.xpath(xpath));
		
		
	}
	
	

}