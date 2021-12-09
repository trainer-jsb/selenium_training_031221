package framework.pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPO {

	WebDriver driver;

	public SearchResultsPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//div[contains(@data-cel-widget,'search_result_')]//h2")
	private List<WebElement> prodNames;

	public List<WebElement> returnListOfSearchResult() {
		return prodNames;
	}
}