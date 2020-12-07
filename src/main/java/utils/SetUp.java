package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.GlobalVariables;


public class SetUp {
	
	WebDriver driver;
	GlobalVariables gv;

	public WebDriver SetUp(WebDriver driver) {	
		
		
		
		this.driver = driver;
		final String PROJECT_PATH = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saman\\Downloads\\WebAutomationTestNg-master\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get(gv.URL);
		driver.manage().window().maximize();
			
		return driver;
		
		
	}
	 

}

