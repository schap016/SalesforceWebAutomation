package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utils.SetUp;

public class CommonOperations {

  WebDriver driver;
  
  
	@FindBy(how = How.XPATH, using = "//div[@class='slds-icon-waffle']")
	public WebElement appLauncherButton;
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search apps and items...']")
	public WebElement appSearchBox;
	
	@FindBy(how = How.XPATH, using = "//span[contains(@class,'appName')]/span[contains(@class,'slds-truncate')]")
	public WebElement appNameTitle;
	
	@FindBy(how = How.XPATH,using="//span[@class='uiImage']/img[@alt='User']")
	public WebElement profileImage;
	
	
	
	

	// constructor for common operations class
	public CommonOperations() {


	}

	public String getPageTitle(WebDriver driver) {

	return driver.getTitle();

	}

	public static boolean webElementIsDisplayed(WebElement element) {


		if (element.isDisplayed()) {

			return true;

		}

		return false;
	}

	public boolean WebElementIsDisplayed(List<WebElement> elements) {
		boolean a = false;
		for (WebElement element : elements) {

			if (element.isDisplayed()) {

				a = true;
			}

		}

		return a;

	}
	
	

	public void sendText(WebElement element, String text) {

		element.sendKeys(text);
	
		

	}

	public  void elementClick(WebElement element) {

		element.click();
	
	}

	public  boolean elementIsChecked(WebElement element) {

		if (element.isSelected()) {

			return true;
		}

		return false;
	}

	public void sendEnter(WebElement element) {
		
		element.sendKeys(Keys.ENTER);
		
	}
	
	public String getAttributeValue(WebElement element, String attributeName) {
		String value = element.getAttribute(attributeName);
		
		return value;
	}
	
	
	
	
	
}
