package handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.selenium.WebDriverManager;

public class DragAndDrop {

	WebDriverManager webDrvMgr;
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("edge");
		driver.get("https://demoqa.com/droppable");
	}

	@Test
	public void dragAndDropTest() {
		Actions action = new Actions(driver);
		WebElement oSrc = driver.findElement(By.id("draggable"));
		WebElement oTarget = driver.findElement(By.id("droppable"));

		action.dragAndDrop(oSrc, oTarget).build().perform();
		String actual = driver.findElement(By.id("droppable")).getText();
		Assert.assertEquals(actual, "Dropped!");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
