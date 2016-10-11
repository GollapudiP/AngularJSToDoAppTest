package toDoListTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import toDoListPages.AllPages;
import toDoListPages.ToDoPage;

public class TodosTests {

	@BeforeMethod
	public void openApplicationToTest() {
		AllPages.initialise();
		//TODO: The URL value should be fetched from the config file 
		AllPages.jsPage
				.navigateToApplication("http://todomvc.com/examples/angularjs/#/");
	}

	@Test
	public void createToDoItemAndDeleteIt() {
		String task = "create a test case";
		AllPages.jsPage.addToDoItem(task);
		AllPages.jsPage.deletToDoItem(task);
		Assert.assertTrue(AllPages.jsPage.isTaskListEmpty());
	}

	@Test
	public void addItemsAndVerifyCount() {
		int count = 50;
		for (int i = 1; i <= count; i++) {
			String task = "Task " + i;
			AllPages.jsPage.addToDoItem(task);
		}
		int itemsLeft = AllPages.jsPage.getTotalItemsLeft();
		Assert.assertEquals(count, itemsLeft);
	}

	@Test
	public void verifyActiveItemsLeft() {
		String task1 = "Task 1";
		String task2 = "Task 2";
		AllPages.jsPage.addToDoItem(task1);
		AllPages.jsPage.addToDoItem(task2);
		AllPages.jsPage.completeToDoItem(task1);
		AllPages.jsPage.showListOfActiveItems();
		int itemsLeft = AllPages.jsPage.getTotalItemsLeft();
		Assert.assertEquals(1, itemsLeft);
	}

	@AfterMethod
	public void disposeEverything() {
		AllPages.dispose();
	}

}
