package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase
{

	public SearchPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(id = "small-searchterms")
	WebElement searchTextBox;
	
	@FindBy(css = "button.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(id = "ui-id-1")
	List<WebElement> suggestionList;
	
	@FindBy(linkText = "Apple MacBook Pro")
	WebElement productTitle;
	
	public void ProductSearch(String productName)
	{
		SetText(searchTextBox, productName);
		ClickButton(searchBtn);
	}
	
	public void OpenProductDetailPage()
	{
		ClickButton(productTitle);
	}
	
	public void ProductSearchUsingAutoSuggestion(String searchTxt)
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		SetText(searchTextBox, searchTxt);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		suggestionList.get(0).click();
	}

}
