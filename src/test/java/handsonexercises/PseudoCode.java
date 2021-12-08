package handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PseudoCode {
	
	WebDriver driver;
	
  @Test
  public void testPseudoCode() {
	  WebElement oElem = driver.findElement(By.id("pseudo"));
	  Select dropdown = new Select(oElem);
	  dropdown.selectByVisibleText("India");
	  
  }
}
