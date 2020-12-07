package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserDetailsPage {
	
	
	WebDriver driver;
	
	
	@FindBy(how = How.XPATH, using = "//td[@id='topButtonRow']/input[@name='login']")
		public WebElement userLoginButton;
	
	 @FindBy(how = How.XPATH, using = "//iframe")
		public WebElement userDetailsFrame;
	
	public UserDetailsPage(WebDriver driver) {
		
		
		this.driver = driver;
	}
	

}
