package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppinCartPage extends PageBase
{

	public ShoppinCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(name = "updatecart")
	WebElement removerBtn;
	
	@FindBy(id = "itemquantity6")
	WebElement quantityTxt;
	
	@FindBy(css = "td.subtotal")
	WebElement totalPrice;
	
	@FindBy(css = "a.product-name")
	public WebElement productName;
	
	@FindBy(id = "termsofservice")
	WebElement termsOfServiceBtn;
	
	@FindBy(id = "checkout")
	WebElement checkoutBtn;
	
	public void RemoveProductFromCart()
	{
		ClickButton(removerBtn);
	}
	
	public void UpdateProductQuantity(String quantity)
	{
		ClearText(quantityTxt);
		SetText(quantityTxt, quantity);
	}
	
	public void ClickAgreeOnTerms() 
	{
		ClickButton(termsOfServiceBtn);
	}
	
	public void GoToCheckout()
	{
		ClickButton(checkoutBtn);
	}
}
