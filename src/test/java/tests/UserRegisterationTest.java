package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	
	@Test(enabled = false)
	public void UserRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.OpenRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.Registeration("Yousef", "El-Nabawy", "yousefayman@gmail.com", "12345678");
		//Assert.assertTrue(registerObject.successMsg.getText().contains("Your registration completed"));
		
	}
	
	@Test(dependsOnMethods = ("UserCanLogin"))
	public void UserCanLogout()
	{
		registerObject = new UserRegisterationPage(driver);
		registerObject.UserLogout();
	}
	
	@Test(priority = 1)
	public void UserCanLogin()
	{
		homeObject = new HomePage(driver);
		homeObject.OpenLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin("yousefayman@gmail.com", "123456789");
		//Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));
	}
	
}
