package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase
{

	public ProductDetailsPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(css = "strong.current-item")
	public WebElement productNameCheck;
	
	@FindBy(css = "button.button-2.email-a-friend-button")
	public WebElement emailFriendBtn;
	
	@FindBy(id = "price-value-4")
	public WebElement productPrice;
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addToWishlistBtn;
	
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement addToComparelistBtn;
	
	@FindBy(linkText = "product comparison")
	WebElement productComparelistLink;
	
	@FindBy(id = "add-to-cart-button-4")
	WebElement addToCartBtn;
	
	
	
	
	public void OpenEmailFriend()
	{
		ClickButton(emailFriendBtn);
	}
	
	public void AddProductToWishlist()
	{
		ClickButton(addToWishlistBtn);
	}
	
	public void AddToComparelist()
	{
		ClickButton(addToComparelistBtn);
	}
	
	public void GoToComparelist()
	{
		ClickButton(productComparelistLink);
	}
	
	public void AddToCart()
	{
		ClickButton(addToCartBtn);
	}
	
	
}
