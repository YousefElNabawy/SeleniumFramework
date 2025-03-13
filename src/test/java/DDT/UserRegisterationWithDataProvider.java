package DDT;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisterationWithDataProvider extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	@DataProvider(name = "TestData")
	public static Object[][] userData()
	{
		return new Object[][]
		{
			{"Yousef" , "El-Nabawy", "yousef@gmail.com", "123456789"},
			{"Ayman", "Fathi", "ayman@gmail.com", "12345678"}
		};
	}
	
	
	
	@Test(priority = 1, alwaysRun = true, dataProvider = "TestData")
	public void UserRegisterSuccessfully(String firstName, String lastName, String email, String password)
	{
		homeObject = new HomePage(driver);
		registerObject = new UserRegisterationPage(driver);
		loginObject = new LoginPage(driver);
		
		homeObject.OpenRegisterationPage();
		registerObject.Registeration(firstName, lastName, email, password);
		//Assert.assertTrue(registerObject.successMsg.getText().contains("Your registration completed"));
		registerObject.UserLogout();
		homeObject.OpenLoginPage();
		loginObject.UserLogin(email,password);
		//Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));	
		registerObject.UserLogout();
	}
	
	
}
