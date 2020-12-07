package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.LoggerClass;

public class UserEnv {
	

	 WebDriver driver;
	 
	 

	
	 private static Logger logger = LogManager.getLogger(LoggerClass.class);
	
	public UserEnv(WebDriver driver) {

		this.driver = driver;
		
		
	}
	
	
	
	public boolean userLoginSuccess(String user) {
		
		String xpath = "//*[contains(text(),'Log out as"+" "+ user+"'"+")"+"]";
		
		WebElement element = driver.findElement(By.xpath(xpath));
		
		
		
		if(element.isDisplayed()) {
			
			//logger.info(".....++++element is displayed");
			return true;
		}
		
		
		return false;
		
	}
	
	

}
