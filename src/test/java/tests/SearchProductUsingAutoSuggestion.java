package tests;

import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggestion extends TestBase
{
	String productName = "Apple MacBook Pro";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	
	@Test
	public void UserSearchWithAutoSuggest()
	{
		try {
			detailsObject = new ProductDetailsPage(driver);
			searchObject = new SearchPage(driver);
			searchObject.ProductSearchUsingAutoSuggestion("Mac");
			
			//Assert.assertEquals(detailsObject.productNameCheck.getText(), productName);
			
		} catch (Exception e) {
			System.out.println("Error occured: " + e.getMessage());
		}
	}
	
}
