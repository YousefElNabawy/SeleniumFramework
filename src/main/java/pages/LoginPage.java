package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase
{

	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(id = "Email")
	WebElement EmailTxt;
	
	@FindBy(id = "Password")
	WebElement PasswordTxt;
	
	@FindBy(css = "button.button-1.login-button")
	WebElement LoginBtn;
	
	
	public void UserLogin(String email, String password)
	{
		SetText(EmailTxt, email);
		SetText(PasswordTxt, password);
		ClickButton(LoginBtn);
	}

}
