package tests;

import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase
{
	HomePage home;
	ContactUsPage contactPage;
	
	String fullName = "Yousef El-Nabawy";
	String email = "Test@gmail.com";
	String enquiry = "Hello test";
	String successMessage = "Your enquiry has been successfully sent to the store owner.";
	
	
	@Test
	public void UserContactUs()
	{
		home = new HomePage(driver);
		contactPage = new ContactUsPage(driver);
		
		home.OpenContactUsPage();
		contactPage.ContactUs(fullName, email, enquiry);
		//Assert.assertTrue(contactPage.successMessage.getText().contains(successMessage));
	}
}
