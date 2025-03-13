package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase
{
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	
	
	
	@FindBy(linkText = "Register")
	WebElement registerLink;
	
	@FindBy(linkText = "Log in")
	WebElement loginLink;
	
	@FindBy(linkText = "My account")
	WebElement MyaccountLink;
	
	@FindBy(linkText = "Contact us")
	WebElement ContactUs;
	
	@FindBy(id = "customerCurrency")
	WebElement currencyDropList;
	
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
	WebElement computerMenu;
	
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
	WebElement notebooksMenu;
	
	@FindBy(linkText = "Wishlist")
	WebElement wishlistLink;
	
	@FindBy(css = "span.cart-label")
	WebElement ShoppingCartBtn;
	
	
	public void OpenRegisterationPage()
	{
		ClickButton(registerLink);
	}
	
	public void OpenLoginPage()
	{
		ClickButton(loginLink);
	}
	
	public void OpenMyAccountPage()
	{
		ClickButton(MyaccountLink);
	}
	
	public void OpenContactUsPage()
	{
		ScrollToBottom();
		ClickButton(ContactUs);
	}
	
	public void ChangeCurrency(String currency)
	{
		select = new Select(currencyDropList);
		select.selectByVisibleText(currency);
	}
	
	public void SelectNotebooksMenu()
	{
		action.moveToElement(computerMenu).moveToElement(notebooksMenu).click().build().perform();
	}
	
	public void GoToWishlist()
	{
		ClickButton(wishlistLink);
	}
	
	public void GoToShoppingCart()
	{
		ClickButton(ShoppingCartBtn);
	}
}
