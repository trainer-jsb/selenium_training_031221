package handsonexercises;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.selenium.WebDriverManager;

public class SwitchWindow {

	WebDriverManager webDrvMgr;
	private WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("edge");
		driver.get("https://demoqa.com/browser-windows");
	}

	@Test
	public void frameTest() {
		driver.findElement(By.id("tabButton")).click();
		System.out.println(driver.getCurrentUrl()); // Base URL
		switchWindow();

		System.out.println(driver.getCurrentUrl()); // New URL
		driver.close();
		switchWindow();

		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.id("tabButton")).click();
	}

	private void switchWindow() {
		String currentWindowHandle = null;
		try {
			currentWindowHandle = driver.getWindowHandle(); 
		} catch (Exception ex) {
			System.out.println("Parent window is closed");
		}
		Set<String> windowHandles = driver.getWindowHandles();   
		for (String newWindow : windowHandles) {						
			if (!newWindow.equalsIgnoreCase(currentWindowHandle))
				driver.switchTo().window(newWindow); 
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
