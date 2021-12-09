package pom.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPO {
	
	WebDriver driver;
	
	public AlertPO(WebDriver driver){
		this.driver = driver;
	}
	
	public void clickAlertButton(){
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
	}
	
	public void acceptAlert(){
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(){
		driver.switchTo().alert().dismiss();
	}
	
	public void clickButtonToOpenPromptBox(){
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg'][text()='Click for Prompt Box']")).click();
	}
	
	public String returnTextAddedInPromptBox(){
		return driver.findElement(By.id("prompt-demo")).getText().trim();
	}

}
