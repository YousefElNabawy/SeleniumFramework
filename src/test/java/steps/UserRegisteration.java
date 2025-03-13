package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisteration extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	
	
	
	@Given("the user in the home page")
	public void the_user_in_the_home_page() 
	{
	   homeObject = new HomePage(driver);
	   homeObject.OpenRegisterationPage();
	}
	@When("I click on register link")
	public void i_click_on_register_link() 
	{
	   Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	/*
	 * @When("I entered the user data") public void i_entered_the_user_data() {
	 * registerObject = new UserRegisterationPage(driver);
	 * registerObject.Registeration("Yousef", "El-Nabawy", "yousef@gmail.com",
	 * "123456789"); }
	 */
	@When("I enter {string}, {string}, {string}, {string}")
	public void i_enter(String firstname, String lastname, String email, String password) 
	{
		registerObject = new UserRegisterationPage(driver);
		registerObject.Registeration(firstname, lastname, email, password);
	}
	
	
	@Then("The registeration page will be dispalyed successfuly")
	public void the_registeration_page_will_be_dispalyed_successfuly() 
	{
	    registerObject.UserLogout(); 
	}
}
