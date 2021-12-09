package framework.functionlibrary;

import org.openqa.selenium.WebDriver;
import framework.pageobjects.HomePO;
import util.selenium.WebDriverUtil;

public class HomeLib {
	
	public HomeLib(WebDriver driver){
		this.driver = driver;
	}
	
	WebDriver driver;
	private String propfile="src/test/resources/base.prop";
	private int  timeout = Integer.parseInt(util.DataProvider.getTestData(propfile, "timeout"));
	
	public void searchProduct(String searchParam){
		HomePO hompo = new HomePO(driver);
		hompo.setValueInSearchBox(searchParam);
		hompo.clickSearchBtn();
		WebDriverUtil webdrvutil = new WebDriverUtil(driver);
		webdrvutil.waitForPageToLoad(timeout);
	}
}