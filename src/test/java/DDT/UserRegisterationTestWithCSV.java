package DDT;

import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisterationTestWithCSV extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	CSVReader reader;
	
	@Test
	public void UserRegisterSuccessfully() throws IOException, CsvValidationException
	{
		// Get CSV file path
		String CSV_file = System.getProperty("user.dir") + "\\src\\test\\java\\data\\Boook2.csv";
		reader = new CSVReader(new FileReader(CSV_file));
		
		String[] csvCell;
		
		// while loop will be executed till the last value in the CSV file
		while((csvCell = reader.readNext())!= null)
		{
			String firstname = csvCell[0];
			String lastname = csvCell[1];
			String email = csvCell[2];
			String password = csvCell[3];
			
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
	
}
