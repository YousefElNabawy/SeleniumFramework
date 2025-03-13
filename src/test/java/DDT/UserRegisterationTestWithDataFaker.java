package DDT;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisterationTestWithDataFaker extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	Faker fakeData = new Faker();
	
	
	String firstname = fakeData.name().firstName();
	String lastname = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(8).toString();
	
	@Test(priority = 1)
	public void UserRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		registerObject = new UserRegisterationPage(driver);
		
		homeObject.OpenRegisterationPage();
		registerObject.Registeration(firstname, lastname, email, password);
		System.out.println("User data is: " + firstname + "" + lastname + "" + email + "" + password);
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
