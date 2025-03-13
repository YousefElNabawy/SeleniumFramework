package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase
{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}	
	
	@FindBy(linkText = "Change password")
	WebElement changePassword;
	
	@FindBy(id = "OldPassword")
	private WebElement oldPasswordTxt;
	
	@FindBy(id = "NewPassword")
	private WebElement newPasswordTxt;
	
	@FindBy(id = "ConfirmNewPassword")
	private WebElement confirmPasswordTxt;
	
	@FindBy(css = "button.button-1.change-password-button")
	WebElement changePasswordBtn;
	
	@FindBy(css = "p.content")
	public WebElement resultMsg;
	
	
	public void OpenChangePassswordPage()
	{
		ClickButton(changePassword);
	}
	
	public void ChangePassword(String oldPassword, String newPassword)
	{
		SetText(oldPasswordTxt, oldPassword);
		SetText(newPasswordTxt, newPassword);
		SetText(confirmPasswordTxt, newPassword);
		ClickButton(changePasswordBtn);
	}
	
	
}
