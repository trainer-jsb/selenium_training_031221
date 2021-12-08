package handsonexercises;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.selenium.WebDriverManager;

public class Frames {
	
	WebDriverManager webDrvMgr;
	private WebDriver driver;
	
@BeforeClass
public void setUp(){
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("edge");  
		driver.get("https://demoqa.com/frames");
	}

  @Test
  public void frameTest() {
	  driver.switchTo().frame("frame1");
	  String text = driver.findElement(By.id("sampleHeading")).getText();
	  System.out.println(text);
  }
  
  @Test
  public void getFrameCountTest() {
	  List <WebElement> oFrames = driver.findElements(By.tagName("iframe"));
	  System.out.println(oFrames.size());
	  for(WebElement oElem: oFrames){
		  String strID = oElem.getAttribute("id");
		  System.out.println(strID);
	  }
  } 
  
  @AfterClass
  public void tearDown(){
	  driver.quit();
  }
}
