package toDoListPages;

import org.openqa.selenium.WebDriver;

import base.WebDriverLocator;

public class AllPages {
	
	public static ToDoPage jsPage;
	private static WebDriver driver = null;
	
	public static void initialise(){		
		driver = WebDriverLocator.createDriver();
		jsPage = new ToDoPage(driver);		
	}	
	
	public static void dispose(){
		jsPage = null;
		driver.quit();		
	}

}
