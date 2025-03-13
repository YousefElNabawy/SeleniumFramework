package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppinCartPage;

public class AddProductToCartTest extends TestBase 
{
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppinCartPage cartObject;
	HomePage homeObject;
	
	String productName = "Apple MacBook Pro";
	
	@Test(priority = 1)
	public void UserSearchForProduct()
	{
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.ProductSearch(productName);
		searchObject.OpenProductDetailPage();
		//Assert.assertTrue(detailsObject.productNameCheck.getText().equalsIgnoreCase(productName));
	}
	
	@Test
	public void UserAddProductToShoppingCart()
	{
		detailsObject = new ProductDetailsPage(driver);
		
		detailsObject.AddToCart();
		homeObject.GoToShoppingCart();
		Assert.assertTrue(cartObject.productName.getText().equals(productName));
	}
	
	@Test
	public void UserRemoveProductFromCart()
	{
		cartObject = new ShoppinCartPage(driver);
		
		cartObject.RemoveProductFromCart();
	}
}
