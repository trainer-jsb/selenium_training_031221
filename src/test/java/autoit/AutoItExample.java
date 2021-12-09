package autoit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.selenium.WebDriverUtil;

public class AutoItExample {

	util.selenium.WebDriverManager webDrvMgr;
	WebDriver driver;

	@BeforeClass
	public void setup() {
		webDrvMgr = new util.selenium.WebDriverManager();
		driver = webDrvMgr.launchBrowser("ff");
	}

	@Test
	public void AutoItExampleTest() 
	{
		try 
		{
			WebDriverUtil webdrvutil = new WebDriverUtil(driver);
			Actions action = new Actions(driver);
			
			driver.get("https://demoqa.com/automation-practice-form");
			WebElement oelem = driver.findElement(By.id("uploadPicture"));
			webdrvutil.scrollInView(oelem);
			action.moveToElement(oelem).perform();
			action.click().perform();
			
			Runtime.getRuntime().exec("src/test/resources/test64.exe");
			Thread.sleep(5000);
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
			Assert.fail("FAILED because of an exception");
		}
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
