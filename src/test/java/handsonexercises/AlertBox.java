package handsonexercises;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.selenium.WebDriverManager;
import util.selenium.WebDriverUtil;

public class AlertBox {
	
	WebDriverManager webDrvMgr;
	private WebDriver driver;
	SoftAssert sf;
	WebDriverUtil webDrvUtl;
	
@BeforeClass
public void setUp(){
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("edge");  
		webDrvUtl = new WebDriverUtil(driver);
		driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
	}

@BeforeMethod
public void testPreReq(){
	sf = new SoftAssert();
}

  @Test
  public void alertBoxTest() {
	  WebElement oElem = driver.findElement(By.tagName("a")); 
	  System.out.println(oElem.getAttribute("href"));
	  
	  System.out.println("====================== FOR LOOP BELOW =======================");
	  List<WebElement> oList = driver.findElements(By.tagName("a"));
	  for(int loop=0; loop< oList.size(); loop ++){
		  System.out.println(oList.get(loop).getAttribute("href"));
	  }
	  
	  System.out.println("====================== FOR EACH LOOP BELOW =======================");
	  for(WebElement oelem: oList){
		  System.out.println(oelem.getAttribute("href"));
	  }
	  
	  driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
	  driver.switchTo().alert().accept();
	  Assert.assertFalse(webDrvUtl.doesAlertExist());
  }
  
  @Test
  public void testAlertBoxWithMessage(){
	  String strInput = "testing", actual;
	  
	//Click on JS button, type a text, click cancel and verify that the typed text doesn't appears on the screen
	  driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg'][text()='Click for Prompt Box']")).click();
	  driver.switchTo().alert().sendKeys(strInput);
	  driver.switchTo().alert().dismiss();
	  actual = driver.findElement(By.id("prompt-demo")).getText().trim();
	  sf.assertTrue(actual.length() == 0);
	  
	  //Click on JS button, type a text, click OK and verify that the typed txt appears on the screen
	  driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg'][text()='Click for Prompt Box']")).click();
	  driver.switchTo().alert().sendKeys(strInput);
	  driver.switchTo().alert().accept();
	  actual = driver.findElement(By.id("prompt-demo")).getText();
	  sf.assertTrue(actual.contains(strInput), "FAIL | Expected was " +strInput+ ", Actual is " + actual);
	  
	  sf.assertAll();
  }
  
  
  @AfterClass
  public void tearDown(){
	  driver.quit();
  }
  
}
