package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverLocator {
	
	public static WebDriver createDriver(){
		WebDriver driver = null;
		
		// TODO: Fetch the browser value from config file
		String browser = "Chrome";
		
		if(browser.equalsIgnoreCase("Firefox")){
			driver = new FirefoxDriver();
		}
		
		if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		if(browser.equalsIgnoreCase("IE")){
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		return driver;
	}

}
