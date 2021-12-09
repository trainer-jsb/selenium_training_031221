package util.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtil {
	
	private WebDriver driver;
	
	public WebDriverUtil(WebDriver driver){
		this.driver = driver;
	}
	
	public void waitForPageToLoad(int timeOut){
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver){
				JavascriptExecutor js = (JavascriptExecutor) driver;
				return(js.executeScript(("return document.readyState")).equals("complete"));
			}
		};
		WebDriverWait wait = new WebDriverWait(this.driver, timeOut);
		try{
			wait.until(expectation);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void waitForAjaxToLoad(){
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		if(!(Boolean) js.executeScript("return window.jQuery != undefined"))
		{
			while(!(Boolean)js.executeScript("return jQuery.active == 0"))
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void takeScreenshot(String filename) throws IOException{
		File srcFile = ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"/test-output/"+filename+".png"));
	}

	public boolean doesAlertExist(){
		  try{
			  driver.switchTo().alert();
			  return true;
			  }
			  catch(Exception ex){
				  return false;
			  }
	  }

	 public void scrollInView(WebElement oelem)
	  {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].scrollIntoView(true);", oelem);

	  }
	
}
