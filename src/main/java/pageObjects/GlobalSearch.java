package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GlobalSearch {
	
	
	WebDriver driver;
	
	// search bar page locator
	@FindBy(how = How.XPATH, using = "//input[contains(@title,'Search')]")
	public WebElement globalSearch;
	
	
	
	public GlobalSearch(WebDriver driver) {
		
		
		this.driver = driver;
		//PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);

	}
	
	
	public void clickUser(String user) {
		
		
		
		String xpath = "//*[contains(text(),"+"'"+user+"'"+")]";
		
		driver.findElement(By.xpath(xpath)).click();
		
		
		
	}
	
	public void clickOnProduct(String product) {
		
		
		 
		//span[contains(text(),'TABLET10')]/../../preceding-sibling::th
		String path = "//span[contains(text(),'"+product+"')]"+"/../../preceding-sibling::th/span/a";
		driver.findElement(By.xpath(path)).click();
		
		
	}
	
	
	

}
