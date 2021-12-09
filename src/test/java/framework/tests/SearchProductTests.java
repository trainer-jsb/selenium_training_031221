package framework.tests;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import framework.functionlibrary.HomeLib;
import framework.functionlibrary.SearchResultsLib;
import util.selenium.WebDriverManager;

public class SearchProductTests {
	
	private WebDriverManager webDrvMgr;
	private WebDriver driver;
	private SoftAssert sf;
	
	//Test Input (Arrange)
	private String propfile = "src/test/resources/base.prop";
	private String url = util.DataProvider.getTestData(propfile, "url");
	private String searchParam = util.DataProvider.getTestData(propfile, "searchParam");
	
	@BeforeClass
	public void setup(){
		webDrvMgr = new WebDriverManager();
		Reporter.log("1. Open Browser and Navigate to " + url);
		driver = webDrvMgr.launchBrowser("edge");
		driver.get(url);
	}
	
	@BeforeMethod
	public void preReq(){
		sf = new SoftAssert();
	}
	
  @Test
  public void searchProductTest() {
	  Reporter.log("2. Search for product: " + searchParam);
	  HomeLib homlib = new HomeLib(driver);
	  homlib.searchProduct(searchParam);
	  
	  Reporter.log("3. Check if all search result contain search parameter : " + searchParam);
	  SearchResultsLib seareslib = new SearchResultsLib(driver);
	  List<String> listProdNames = seareslib.returnListOfProductName();
	  for(String prodName: listProdNames){
		  sf.assertTrue(prodName.toLowerCase().contains(searchParam.toLowerCase()), "FAIL | Actual is " +prodName+ ", whereas Expected was containing " +searchParam);
	  }
	  sf.assertAll();
  }
  
  @AfterClass
  public void tearDown(){
	  driver.quit();
  }
}
