package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductDetailsPage {
	
	
	WebDriver driver;
	
	
	
	public ProductDetailsPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	

	
	
	public boolean productPageLoaded(String productCode) {
		boolean a = false;
		
		String xpath = "//span[contains(text(),"+"'"+productCode+"'"+")]";
		
		
		WebElement b = driver.findElement(By.xpath(xpath));
		
		if(CommonOperations.webElementIsDisplayed(b)) {
			
			a = true;
		}
		
		return a;
	}

	
	

}
