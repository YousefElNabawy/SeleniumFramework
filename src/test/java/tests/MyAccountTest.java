package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterationPage;

public class MyAccountTest extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	
	String oldPassword = "12345678";
	String newPassword = "123456789";
	String email = "yousefayman691@gmail.com";

	
	@Test(priority = 1)
	public void UserCanLogin()
	{
		homeObject = new HomePage(driver);
		homeObject.OpenLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, oldPassword);
		//Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));
	}
	
	@Test(priority = 2)
	public void UserCanChangePasssword()
	{
		myAccountObject = new MyAccountPage(driver);
		homeObject.OpenMyAccountPage();		
		myAccountObject.OpenChangePassswordPage();
		myAccountObject.ChangePassword(oldPassword, newPassword);
		//Assert.assertTrue(myAccountObject.resultMsg.getText().contains("Password was changed"));
	}
}
