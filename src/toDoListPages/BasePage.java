package toDoListPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	public BasePage(WebDriver webDriver){
		driver = webDriver;
	}
		
	public void navigateToApplication(String url){
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void waitForElement(WebElement element){
		WebDriverWait wdWait = new WebDriverWait(driver, 5);		
		wdWait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
