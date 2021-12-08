package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.selenium.WebDriverManager;

public class NavigateToGoogle {
	
	WebDriverManager webDrvMgr;
	private WebDriver driver;
	SoftAssert sf;
	
	@BeforeClass
	public void setUp(){
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("edge");  //chrome
		driver.get("https://www.google.co.in");
	}
	
	@BeforeMethod
	public void testPreq(){
		sf = new SoftAssert();
	}
	
  @Test
  public void testNavigation() {
	  String actualTitle = driver.getTitle();
	  String actualLocale = driver.findElement(By.xpath("//div[@class='uU7dJb']")).getText();
	  sf.assertEquals(actualTitle, "Google");
	  sf.assertEquals(actualLocale, "India");
	  
	  driver.navigate().to("https://www.gmail.com");
	  WebDriverWait wait = new WebDriverWait(driver, 120);
	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Forgot email?']"))));
	  driver.findElement(By.xpath("//button[text()='Forgot email?']")).click();
	  
	 sf.assertAll();
  }
  
  @Test
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
