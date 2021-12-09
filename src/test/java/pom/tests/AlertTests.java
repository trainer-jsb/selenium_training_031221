package pom.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pom.pagefactory.AlertPO;
import util.selenium.WebDriverManager;
import util.selenium.WebDriverUtil;

public class AlertTests {
	WebDriverManager webDrvMgr;
	private WebDriver driver;
	SoftAssert sf;
	WebDriverUtil webDrvUtl;
	AlertPO alertpo;
	String strInput = "testing", actual;
	
@BeforeClass
public void setUp(){
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("edge");  
		webDrvUtl = new WebDriverUtil(driver);
		alertpo = new AlertPO(driver);
		driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
	}

@BeforeMethod
public void testPreReq(){
	sf = new SoftAssert();
}

  @Test
  public void alertBoxTest() {	  
	  alertpo.clickAlertButton();
	  alertpo.acceptAlert();
	  Assert.assertFalse(webDrvUtl.doesAlertExist());
  }
  
  /*
  public void testAlertBoxWithMessage(){	  
	//Click on JS button, type a text, click cancel and verify that the typed text doesn't appears on the screen
	  alertpo.clickButtonToOpenPromptBox();
	  driver.switchTo().alert().sendKeys(strInput);
	  alertpo.dismissAlert();
	  sf.assertTrue(alertpo.returnTextAddedInPromptBox().length() == 0);
	  
	  //Click on JS button, type a text, click OK and verify that the typed txt appears on the screen
	  alertpo.clickButtonToOpenPromptBox();
	  driver.switchTo().alert().sendKeys(strInput);
	  alertpo.acceptAlert();
	  actual = driver.findElement(By.id("prompt-demo")).getText();
	  sf.assertTrue(actual.contains(strInput), "FAIL | Expected was " +strInput+ ", Actual is " + actual);
	  
	  sf.assertAll();
  }
  */
  
  @AfterClass
  public void tearDown(){
	  driver.quit();
  }
  
}
