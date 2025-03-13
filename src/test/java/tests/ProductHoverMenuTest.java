package tests;

import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase
{
	HomePage homeObject;
	
	@Test
	public void UserSelectSubCategory()
	{
		homeObject = new HomePage(driver);
		
		homeObject.SelectNotebooksMenu();
		 
		//Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
		 
	}
}
