package DDT;

import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisterationTestWithPropertiesFiles extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	String firstname = LoadProperties.userData.getProperty("firstname");
	String lastname = LoadProperties.userData.getProperty("lastname");
	String email = LoadProperties.userData.getProperty("email");
	String password = LoadProperties.userData.getProperty("password");
	
	@Test(priority = 1)
	public void UserRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.OpenRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.Registeration(firstname, lastname, email, password);
		//Assert.assertTrue(registerObject.successMsg.getText().contains("Your registration completed"));
		
	}
	
	@Test(priority = 2)
	public void UserCanLogout()
	{
		registerObject = new UserRegisterationPage(driver);
		registerObject.UserLogout();
	}
	
	@Test(priority = 3)
	public void UserCanLogin()
	{
		homeObject = new HomePage(driver);
		loginObject = new LoginPage(driver);
		
		homeObject.OpenLoginPage();
		loginObject.UserLogin(email, password);
		//Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));
	}
	
}
