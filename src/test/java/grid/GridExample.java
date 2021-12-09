package grid;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridExample {

	WebDriver driver;

	@Test
	public void navigate() throws MalformedURLException, InterruptedException {		
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
		driver.manage().window().maximize();
		driver.navigate().to("http://google.co.in");
		Thread.sleep(5000);
		driver.quit();

	}
}
