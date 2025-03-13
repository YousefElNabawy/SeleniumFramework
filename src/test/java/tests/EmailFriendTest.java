package tests;

import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class EmailFriendTest extends TestBase
{
	// 1-User Login
	HomePage homeObject;
	LoginPage loginObject;
	UserRegisterationPage registerObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailFriendPage emailObject;
	
	String email = "yousefayman@gmail.com";
	String password = "123456789";
	String friendEmail = "aaaa@gmail.com";
	String personalMsg = "Hello friend";
	String confirmationMsg = "Your message has been sent.";
	
	@Test(priority = 1)
	public void UserCanLogin()
	{
		homeObject = new HomePage(driver);
		loginObject = new LoginPage(driver);
		homeObject.OpenLoginPage();
		loginObject.UserLogin(email, password);
		//Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));
	}
	
	// 2- Search for product
	
	@Test(priority = 2)
	public void UserSearchWithAutoSuggest()
	{
		try {
			searchObject = new SearchPage(driver);
			detailsObject = new ProductDetailsPage(driver);
			searchObject.ProductSearchUsingAutoSuggestion("Mac");
			
			//Assert.assertEquals(detailsObject.productNameCheck.getText(), productName);
			
		} catch (Exception e) {
			System.out.println("Error occured: " + e.getMessage());
		}
	}
	
	// 3- Email friend
	
	@Test(priority = 3)
	public void EmailFriend()
	{
		emailObject = new EmailFriendPage(driver);
		detailsObject.OpenEmailFriend();
		emailObject.SendEmailToFriend(friendEmail, personalMsg);
		//Assert.assertTrue(emailObject.confirmationMessage.getText().contains(confirmationMsg));
	}
	
	// 4- User Logout
	
	@Test(priority = 4)
	public void UserCanLogout()
	{
		registerObject = new UserRegisterationPage(driver);
		registerObject.UserLogout();
	}
}
