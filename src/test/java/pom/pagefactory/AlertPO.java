package pom.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPO {
	
	WebDriver driver;
	
	public AlertPO(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//button[@class='btn btn-default']")
	private WebElement alertBtn;
	
	public void clickAlertButton(){
		alertBtn.click();
	}
	
	public void acceptAlert(){
		driver.switchTo().alert().accept();
		}

}
