package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.selenium.WebDriverManager;

public class NavigateToGoogle {
	
	WebDriverManager webDrvMgr;
	private WebDriver driver;
	SoftAssert sf;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(@Optional("edge")String browser){
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser(browser);  
		driver.get("https://www.google.co.in");
	}
	
	@BeforeMethod
	public void testPreq(){
		sf = new SoftAssert();
	}
	
  @Test
  public void testNavigation() {
	  System.out.println(driver.getTitle());
	  /*
	  String actualLocale = driver.findElement(By.xpath("//div[@class='uU7dJb']")).getText();
	  sf.assertEquals(actualTitle, "Google");
	  sf.assertEquals(actualLocale, "India");
	  
	  driver.navigate().to("https://www.gmail.com");
	  WebDriverWait wait = new WebDriverWait(driver, 120);
	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Forgot email?']"))));
	  driver.findElement(By.xpath("//button[text()='Forgot email?']")).click();
	  
	 sf.assertAll();
	 */
  }
  
  public void zDummyTest(){
	  sf.assertEquals("govind", "govind");
	  sf.assertEquals("vaibhav", "vaibhav");
	  sf.assertAll();
  }
  
  @AfterClass
  public void tearDown(){
	  driver.quit();
  }
}
