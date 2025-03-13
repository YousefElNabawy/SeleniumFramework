package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparelistPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToComparelistTest extends TestBase
{
	HomePage homeObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ComparelistPage compareObject;
	
	String firstProductName = "Apple MacBook Pro";
	String secondProductName = "Asus Laptop";
	
	
	@Test(priority = 1)
	public void UserCompareProducts()
	{
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		compareObject = new ComparelistPage(driver);
		
		searchObject.ProductSearch(firstProductName);
		//Assert.assertTrue(detailsObject.productNameCheck.getText().equalsIgnoreCase(firstProductName));
		detailsObject.AddToComparelist();
		
		searchObject.ProductSearch(secondProductName);
		//Assert.assertTrue(detailsObject.productNameCheck.getText().equalsIgnoreCase(secondProductName));
		detailsObject.AddToComparelist();
		
		
		detailsObject.GoToComparelist();
		Assert.assertTrue(compareObject.firstProductName.getText().equals(firstProductName));
		Assert.assertTrue(compareObject.secondProductName.getText().equals(secondProductName));
		
		compareObject.CompareProducts();
	}
	
	
	@Test(priority = 2)
	public void UserClearComparelist()
	{
		compareObject.ClearComparelist();
		//Assert.assertTrue(compareObject.clearMessage.getText().contains("You have no items to compare."));	
	}
}
