package DDT;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisterationTestWithJSON extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	
	@Test
	public void UserRegisterSuccessfully() throws FileNotFoundException, IOException, ParseException
	{
		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.JsonReader();
		
		
		homeObject = new HomePage(driver);
		registerObject = new UserRegisterationPage(driver);
		loginObject = new LoginPage(driver);

		homeObject.OpenRegisterationPage();
		registerObject.Registeration(jsonReader.firstname, jsonReader.lastname, jsonReader.email, jsonReader.password);
		//Assert.assertTrue(registerObject.successMsg.getText().contains("Your registration completed"));
		
		registerObject = new UserRegisterationPage(driver);
		registerObject.UserLogout();
		
		homeObject.OpenLoginPage();
		loginObject.UserLogin(jsonReader.email, jsonReader.password);
		//Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));
		
		registerObject.UserLogout();
		
	}
	
}
