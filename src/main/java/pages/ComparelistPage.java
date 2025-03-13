package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparelistPage extends PageBase 
{

	public ComparelistPage(WebDriver driver) {
		super(driver);
		}
		
	@FindBy(css = "a.clear-list")
	private WebElement clearListBtn;
	
	@FindBy(css = "div.no-data")
	public WebElement clearMessage;
	
	@FindBy(tagName = "tr")
	public List<WebElement> allRows;
	
	@FindBy(tagName = "td")
	public List<WebElement> allCol;
	
	@FindBy(linkText = "Asus Laptop")
	public WebElement secondProductName;
	
	@FindBy(linkText = "Apple MacBook Pro")
	public WebElement firstProductName;
	
	
	public void ClearComparelist()
	{
		ClickButton(clearListBtn);
	}
	
	public void CompareProducts()
	{
		//Get all rows
		System.out.println(allRows.size());
		
		//Get data from each row
		for(WebElement row : allRows)
		{
			System.out.println(row.getText() + "\t");
			
			for(WebElement col : allCol)
			{
				System.out.println(col.getText() + "\t");
			}
		}
	}
	
}
