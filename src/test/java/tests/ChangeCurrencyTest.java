package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase
{
	HomePage homeObject;
	ProductDetailsPage detailsObject;
	SearchPage searchObject;
	
	String productName = "Apple MacBook Pro";
	String currency = "Euro";
	
	@Test(priority = 1)
	public void UserChangeCurrency()
	{
		homeObject = new HomePage(driver);
		detailsObject = new ProductDetailsPage(driver);
		
		homeObject.ChangeCurrency(currency);
	}
	
	@Test(priority = 2)
	public void UserSearchWithAutoSuggest()
	{
		try {
			searchObject = new SearchPage(driver);
			detailsObject = new ProductDetailsPage(driver);
			
			searchObject.ProductSearchUsingAutoSuggestion("Mac");
			
			//Assert.assertEquals(detailsObject.productNameCheck.getText(), productName);
			Assert.assertTrue(detailsObject.productPrice.getText().contains("€"));
			
			System.out.println("Product price: " + detailsObject.productPrice.getText());
			
		} catch (Exception e) {
			System.out.println("Error occured: " + e.getMessage());
		}
	}
}
