package DDT;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisterationTestWithExcelFile extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	@DataProvider(name = "ExcelData")
	public Object[][] UserRegsiterData() throws IOException
	{
		// Get data from ExcelReader class
		
		ExcelReader ER = new ExcelReader();
		
		return ER.getExcelData();	
	}
	
	
	@Test(priority = 1, alwaysRun = true, dataProvider = "ExcelData")
	public void UserRegisterSuccessfully(String firstname, String lastname, String email, String password)
	{
		homeObject = new HomePage(driver);
		registerObject = new UserRegisterationPage(driver);
		loginObject = new LoginPage(driver);
		
		homeObject.OpenRegisterationPage();
		registerObject.Registeration(firstname, lastname, email, password);
		//Assert.assertTrue(registerObject.successMsg.getText().contains("Your registration completed"));
		
		registerObject.UserLogout();
		
		homeObject.OpenLoginPage();
		loginObject.UserLogin(email, password);
		//Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));	
		
		registerObject.UserLogout();

	}
}
