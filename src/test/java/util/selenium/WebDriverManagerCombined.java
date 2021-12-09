package util.selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class WebDriverManagerCombined {

	WebDriver driver;
	DesiredCapabilities cap;

	public WebDriver launchBrowser(String execEnv, String browsername) throws MalformedURLException {
		// For grid execution
		if (execEnv.equalsIgnoreCase("remote")) {
			if (browsername.equalsIgnoreCase("ff") || browsername.equalsIgnoreCase("firefox"))
				cap = DesiredCapabilities.firefox();
			else if (browsername.equalsIgnoreCase("chrome"))
				cap = DesiredCapabilities.chrome();
			else if (browsername.equalsIgnoreCase("edge"))
				cap = DesiredCapabilities.edge();
			else
				Assert.fail("Invalid browser extension");

			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		}

		// For local machine execution
		else if (execEnv.equalsIgnoreCase("local")) {
			if (browsername.equalsIgnoreCase("ff") || browsername.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browsername.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browsername.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
				driver = new EdgeDriver();
			} else
				Assert.fail("Invalid browser extension");
		} else
			Assert.fail("Incorrect execution environment provided");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}
