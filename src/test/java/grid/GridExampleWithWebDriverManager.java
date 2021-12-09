package grid;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.selenium.WebDriverManagerCombined;

public class GridExampleWithWebDriverManager {
	WebDriver driver;
	WebDriverManagerCombined webDrvMgr;

	@BeforeClass
	public void setup() throws MalformedURLException {
		webDrvMgr = new WebDriverManagerCombined();
		driver = webDrvMgr.launchBrowser("remote", "edge");
	}

	@Test
	public void navigate() throws InterruptedException {
		driver.navigate().to("http://google.co.in");
		Thread.sleep(5000);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
