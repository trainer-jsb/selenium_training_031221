package util.selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class WebDriverManagerGrid {
	
	WebDriver driver;
	DesiredCapabilities cap;
	
	public WebDriver launchBrowser( String browsername) throws MalformedURLException
	{
		if(browsername.equalsIgnoreCase("ff") || browsername.equalsIgnoreCase("firefox"))
			cap = DesiredCapabilities.firefox();
		else if (browsername.equalsIgnoreCase("chrome"))
			cap = DesiredCapabilities.chrome();
		else if (browsername.equalsIgnoreCase("edge"))
			cap = DesiredCapabilities.edge();
		else 
			Assert.fail("Invalid browser extension");
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}
