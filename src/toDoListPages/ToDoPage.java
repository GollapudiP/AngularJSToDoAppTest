package toDoListPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToDoPage extends BasePage{
	
	By toDoInputBox = By.id("new-todo");
	By items = By.xpath("//span[@id='todo-count']/strong");
	By itemsListed = By.xpath("//ul[@id='todo-list']/li");
	By labelCompleted = By.xpath("//footer[@id='footer']//ul/li[3]");
	By labelActive = By.xpath("//footer[@id='footer']//ul/li[2]");
	
	public ToDoPage(WebDriver driver){
		super(driver);
	}
	
	public void addToDoItem(String item){
		driver.findElement(toDoInputBox).sendKeys(item + Keys.ENTER);			
	}
	
	public void deletToDoItem(String item){
		List<WebElement> items = driver.findElements(itemsListed);
		for(WebElement e:items){
			String text = e.findElement(By.xpath("./div/label")).getText();
			if(text.equals(item)){
				e.findElement(By.xpath("./div/input")).click();
				e.findElement(By.xpath("./div/button")).click();
				break;
			}				
		}		
	}
	
	public boolean isTaskListEmpty(){
		boolean flag = true;
		try {
			List<WebElement> items = driver.findElements(itemsListed);
			flag = !(items.size()>0);
		} catch (Exception e) {
			
		}
		return flag;
	}	
	
	public int getTotalItemsLeft(){
		return Integer.parseInt(driver.findElement(items).getText());
	}
	
	public void completeToDoItem(String item){
		List<WebElement> items = driver.findElements(itemsListed);
		for(WebElement e:items){
			String text = e.findElement(By.xpath("./div/label")).getText();
			if(text.equals(item)){
				e.findElement(By.xpath("./div/input")).click();
				break;
			}				
		}
	}	
	
	public void showListOfActiveItems(){
		driver.findElement(labelActive).click();
	}

}
