package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase 
{

	public WishlistPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "updatecart")
	private WebElement removeBtn;
	
	@FindBy(css = "td.product")
	public WebElement productCell;
	
	@FindBy(css = "div.no-data")
	public WebElement cartLabel;
	
	@FindBy(css = "div.page-title")
	public WebElement pageTitle;
	
	
	public void RemoveProductFromWishlist()
	{
		ClickButton(removeBtn);
	}
	
}
