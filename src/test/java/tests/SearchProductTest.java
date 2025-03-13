package tests;

import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase
{
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	
	String productName = "Apple MacBook Pro";
	
	@Test
	public void UserSearchForProduct()
	{
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.ProductSearch(productName);
		searchObject.OpenProductDetailPage();
		//Assert.assertTrue(detailsObject.productNameCheck.getText().equalsIgnoreCase(productName));
	}
}
