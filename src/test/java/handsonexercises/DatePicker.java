package handsonexercises;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.selenium.WebDriverManager;

public class DatePicker {
	
	WebDriverManager webDrvMgr;
	private WebDriver driver;
	SoftAssert sf;
	
@BeforeClass
public void setUp(){
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("edge");  
		driver.get("http://demo.seleniumeasy.com/bootstrap-date-picker-demo.html");
	}

@BeforeMethod
public void testPreReq(){
	sf = new SoftAssert();
}

  @Test
  public void datePickerTest() {
	driver.findElement(By.xpath("//div[@id='sandbox-container1']/div[@class='input-group date']")).click();
	List<WebElement> oDaysOfWeek = driver.findElements(By.className("dow"));
	for(WebElement oElem: oDaysOfWeek){
		System.out.println(oElem.getText());
	}
  }
  
  @AfterClass
  public void tearDown(){
	  driver.quit();
  }
  
  
  
}
