package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase
{

	public CheckoutPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(id = "BillingNewAddress_City")
	WebElement cityTxt;
	
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement address1;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement postalCode;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneNumberTxt;
	
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countryIdList;
	
	@FindBy(id = "BillingNewAddress_StateProvinceId")
	WebElement stateIdList;
	
	@FindBy(css = "button.button-1.new-address-next-step-button")
	WebElement continueBtn1;
	
	@FindBy(css = "button.button-1.shipping-method-next-step-button")
	WebElement continueBtn2;
	
	@FindBy(css = "button.button-1.payment-method-next-step-button")
	WebElement continueBtn3;
	
	@FindBy(css = "button.button-1.payment-info-next-step-button")
	WebElement continueBtn4;
	
	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;
	
	@FindBy(css = "div.details-link")
	WebElement orderDetails;
	
	
	public void CheckoutProduct(String city, String Address, String zipCode, String phoneNumber, String countryName, String stateName)
	{
		select = new Select(countryIdList);
		select.selectByVisibleText(countryName);
		select.selectByVisibleText(stateName);
		SetText(cityTxt, city);
		SetText(address1, Address);
		SetText(postalCode, zipCode);
		SetText(phoneNumberTxt, phoneNumber);
		ClickButton(continueBtn1);
		ClickButton(continueBtn2);
		ClickButton(continueBtn3);
		ClickButton(continueBtn4);
	}
	
	public void ConfirmOrder() 
	{
		ClickButton(confirmBtn);
	}
	
	public void GoToOrderDetails()
	{
		ClickButton(orderDetails);
		
	}
}
