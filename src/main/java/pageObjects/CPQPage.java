package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CPQPage {
	
	WebDriver driver;
	
	//SetUp Page locators	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Products')]")
	public WebElement productsLink;
	
	@FindBy(how =How.XPATH, using = "//tbody/tr")
	public List<WebElement> productstable;
	
	@FindBy(how =How.XPATH, using = "//li/span[contains(text(),'Products')]")
	public WebElement productsTitle;
	

	@FindBy(how =How.XPATH, using = "//a[@title='Select List View']")
	public WebElement productsListViewControl;
	
	@FindBy(how =How.XPATH, using = "//span[contains(text(),'All Products')]")
	public WebElement selectAllProducts;
	
	@FindBy(how =How.XPATH, using = "//tbody/tr[1]/td[4]")
	public WebElement clickCell;
	
	@FindBy(how =How.CSS, using = "")
	public WebElement sample;
	
	

}
