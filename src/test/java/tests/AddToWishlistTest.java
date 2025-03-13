package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;

public class AddToWishlistTest extends TestBase
{
	HomePage homeObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishlistPage wishlistObject;
	
	String productName = "Apple MacBook Pro";
	
	
	@Test(priority = 1)
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
	
	@Test(priority = 2)
	public void AddToWishlist()
	{
		homeObject = new HomePage(driver);
		detailsObject = new ProductDetailsPage(driver);
		wishlistObject = new WishlistPage(driver);
		
		detailsObject.AddProductToWishlist();
		homeObject.GoToWishlist();
		
		Assert.assertTrue(wishlistObject.pageTitle.isDisplayed());
		Assert.assertTrue(wishlistObject.productCell.getText().contains(productName));
	}
	
	@Test(priority = 3)
	public void RemoveProductFromWishlist()
	{
		wishlistObject.RemoveProductFromWishlist();
		Assert.assertTrue(wishlistObject.cartLabel.getText().contains("The Wishlis is empty!"));
	}
}
