package framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePO {

	WebDriver driver;

	public HomePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;

	@FindBy(id = "nav-search-submit-button")
	private WebElement searchBtn;

	public void setValueInSearchBox(String searchParam) {
		searchBox.clear();
		searchBox.sendKeys(searchParam);
	}

	public void clickSearchBtn() {
		searchBtn.click();
	}
}
