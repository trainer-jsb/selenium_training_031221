package handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.selenium.WebDriverManager;

public class ProgressBar {
	
	WebDriverManager webDrvMgr;
	WebDriverWait wait;
	private WebDriver driver;
	
@BeforeClass
public void setUp(){
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("edge");  
		wait = new WebDriverWait(driver, 120);
		driver.get("http://demo.seleniumeasy.com/jquery-download-progress-bar-demo.html");
	}

  @Test
  public void dynamicDataLoadTest() {
	  driver.findElement(By.id("downloadButton")).click();
	  By oByLocator = By.className("progress-label");
	  wait.until(ExpectedConditions.textToBePresentInElementLocated(oByLocator, "Complete!"));
	  driver.findElement(By.xpath("//button[text()='Close']")).click();
	 Assert.assertFalse(isDownloadWindowDisplayed());
  }
  
  private Boolean isDownloadWindowDisplayed(){
	  try{
		  driver.findElement(By.xpath("//button[text()='Close']")).isDisplayed();
		  return true;
	  }catch(Exception ex){
		  return false;
	  }
  }
  
  @AfterClass
  public void tearDown(){
	  driver.quit();
  }
  
  
  
}
