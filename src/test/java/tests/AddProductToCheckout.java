package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppinCartPage;
import pages.UserRegisterationPage;

public class AddProductToCheckout extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppinCartPage cartObject;
	CheckoutPage checkoutObject;
	OrderDetailsPage orderObject;
	
	String productName = "Apple MacBook Pro";
	String city = "Cairo";
	String address = "Street1";
	String zipCode = "11111";
	String number = "011115555111";
	String countryName = "Egypt";
	String stateName = "Cairo";
	
	@Test(priority = 1)
	public void UserLogin()
	{
		homeObject = new HomePage(driver);
		loginObject = new LoginPage(driver);
		
		homeObject.OpenLoginPage();
		loginObject.UserLogin("yousefayman691@gmail.com", "123456789");
		//Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));
	}
	
	@Test(priority = 2)
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
	
	@Test(priority = 3)
	public void UserAddProductToShoppingCart()
	{
		detailsObject = new ProductDetailsPage(driver);
		cartObject = new ShoppinCartPage(driver);
		
		detailsObject.AddToCart();
		homeObject.GoToShoppingCart();
		Assert.assertTrue(cartObject.productName.getText().equals(productName));
	}
	
	@Test(priority = 4)
	public void UserCheckoutProduct()
	{
		checkoutObject = new CheckoutPage(driver);
		orderObject = new OrderDetailsPage(driver);
		
		cartObject.GoToCheckout();
		checkoutObject.CheckoutProduct(city, address, zipCode, number, countryName, stateName);
		
		checkoutObject.ConfirmOrder();
		
		checkoutObject.GoToOrderDetails();
		
		orderObject.DownloadPDFInvoice();
		orderObject.PrintOrderDetails();
	}
	
	@Test(priority = 5)
	public void UserLogout()
	{
		registerObject.UserLogout();
	}
	
	
	
	
}
