package framework.functionlibrary;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.pageobjects.SearchResultsPO;

public class SearchResultsLib {
	
	WebDriver driver;
	
	public SearchResultsLib(WebDriver driver){
		this.driver = driver;
	}
	
	/***
	 * 
	 * @return		Returns the names of all products
	 */
	public List<String> returnListOfProductName(){
		List<String> prodName = new ArrayList<String>();
		SearchResultsPO searespo = new SearchResultsPO(driver);
		List<WebElement> oSearchResults = searespo.returnListOfSearchResult();
		
		for(WebElement oelem: oSearchResults ){
			String strProdName = oelem.getText().trim();
			prodName.add(strProdName);
		}
		return prodName;
	}
}
