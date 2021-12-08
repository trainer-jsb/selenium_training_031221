package handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.selenium.WebDriverManager;

public class DynamicDataLoad {
	
	WebDriverManager webDrvMgr;
	WebDriverWait wait;
	private WebDriver driver;
	
@BeforeClass
public void setUp(){
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("edge");  
		wait = new WebDriverWait(driver, 120);
		driver.get("http://demo.seleniumeasy.com/dynamic-data-loading-demo.html");
	}

  @Test
  public void dynamicDataLoadTest() {
	  driver.findElement(By.id("save")).click();
	  By oLoad = By.id("loading");
	  wait.until(ExpectedConditions.invisibilityOfElementWithText(oLoad, "loading..."));
	  String strName = driver.findElement(By.id("loading")).getText();
	  System.out.println(strName);
	  String strImgSrc = driver.findElement(By.xpath("//div[@id='loading']/img")).getAttribute("src");
	  System.out.println(strImgSrc);
  }
  
  @AfterClass
  public void tearDown(){
	  driver.quit();
  }
  
  
  
}
