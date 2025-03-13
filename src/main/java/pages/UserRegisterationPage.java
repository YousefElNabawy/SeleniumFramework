package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase
{

	public UserRegisterationPage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	@FindBy(id = "gender-male")
	WebElement gender;
	
	@FindBy(id = "FirstName")
	WebElement firstNameTxt;
	
	@FindBy(id = "LastName")
	WebElement lastNamTxt;
	
	@FindBy(id = "Email")
	WebElement emailTxt;
	
	@FindBy(id = "Password")
	WebElement passwordTxt;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTxt;
	
	@FindBy(id = "register-button")
	WebElement registerBtn;
	
	@FindBy(css = "div.result")
	public WebElement successMsg;
	
	@FindBy(css = "a.ico-logout")
	public WebElement LogoutLink;
	
	
	
	public void Registeration(String firstName, String lastName, String email, String password)
	{
		ClickButton(gender);
		SetText(firstNameTxt, firstName);
		SetText(lastNamTxt, lastName);
		SetText(emailTxt, email);
		SetText(passwordTxt, password);
		SetText(confirmPasswordTxt, password);
		ClickButton(registerBtn);
	}
	
	public void UserLogout()
	{
		ClickButton(LogoutLink);
	}
}
