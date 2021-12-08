package handsonexercises;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.selenium.WebDriverManager;

public class TableDataSearch {
	
	WebDriverManager webDrvMgr;
	WebDriverWait wait;
	SoftAssert sf;
	private WebDriver driver;
	
@BeforeClass
public void setUp(){
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("edge");  
		wait = new WebDriverWait(driver, 120);
		driver.get("http://demo.seleniumeasy.com/table-search-filter-demo.html");
	}

@BeforeMethod
public void testPreReq(){
	sf = new SoftAssert();
}

  @Test
  public void tableDataSearchTest() {
	  String searchParam = "ro";
	  Reporter.log("Enter search parameter");
	  driver.findElement(By.id("task-table-filter")).clear();
	  driver.findElement(By.id("task-table-filter")).sendKeys(searchParam);
	  
	  Reporter.log("Check for search results");
	  List<WebElement> oResult = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
	  
	  /*
	   * The search results that dont display have a style attrib = display: none;
	   * Below logic is to assert the search result, that DO NOT have the style attrib = display: none;
	   */
	  for(WebElement oElem: oResult){
		  String strStyleAttrib = oElem.getAttribute("style").trim();
		  if(!strStyleAttrib.equals("display: none;")){
			  String actualResult = oElem.getText().toLowerCase();
			  sf.assertTrue(actualResult.contains(searchParam.toLowerCase()), "FAIL | Expected was "+searchParam+", Actual is " +actualResult);
		  }
	  }
	  sf.assertAll();
  }
  
  @AfterClass
  public void tearDown(){
	  driver.quit();
  }
  
  
  
}
