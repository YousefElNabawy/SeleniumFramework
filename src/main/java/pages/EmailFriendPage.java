package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase
{

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FriendEmail")
	private WebElement friendEmailTxt;
	
	@FindBy(id = "PersonalMessage")
	private WebElement personalMessageTxt;
	
	@FindBy(name = "send-email")
	private WebElement sendEmailBtn;
	
	@FindBy(css = "div.result")
	public WebElement confirmationMessage;
	
	public void SendEmailToFriend(String friendEmail, String personalMessage)
	{
		SetText(friendEmailTxt, friendEmail);
		SetText(personalMessageTxt, personalMessage);
		ClickButton(sendEmailBtn);
	}
}
