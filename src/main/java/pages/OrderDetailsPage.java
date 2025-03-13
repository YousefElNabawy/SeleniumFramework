package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase
{

	public OrderDetailsPage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	@FindBy(css = "button-2.print-order-button")
	WebElement printOrder;
	
	@FindBy(css = "button-2.pdf-invoice-button")
	WebElement pdfInvoice;
	
	public void PrintOrderDetails()
	{
		ClickButton(printOrder);
	}
	
	public void DownloadPDFInvoice()
	{
		ClickButton(pdfInvoice);
	}
}
