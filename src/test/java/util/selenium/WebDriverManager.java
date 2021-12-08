package util.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class WebDriverManager {
	
	WebDriver driver;
	
	public WebDriver launchBrowser(String browserName){
		if(browserName.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver"	, "src/test/resources/drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
			Assert.fail("Invalid browser name");
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}
