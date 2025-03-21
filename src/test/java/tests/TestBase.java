package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests
{
	public static WebDriver driver;
	public static String downloadPath = System.getProperty("user.dir") + "/Downloads";
	
	
	public static FirefoxOptions FirefoxOption()
	{
		FirefoxOptions option = new FirefoxOptions();
		
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf,application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		return option;	
	}
	
	
	public static ChromeOptions ChromeOption()
	{
		ChromeOptions options = new ChromeOptions();
		
		HashMap<String, Object> chromPrefs = new HashMap<String, Object>();
		chromPrefs.put("profile.default.content_settings.popups", 0);
		chromPrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromPrefs);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		return options;
	}
	
	
	
	@SuppressWarnings("deprecation")
	@BeforeSuite @Parameters({"browser"})
	public void StartDriver(@Optional("chrome") String browserName)
	{
		if (browserName.equalsIgnoreCase("chrome")) 
		{
			// Setup ChromeDriver using WebDriverManager
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			//driver = new ChromeDriver(ChromeOption());
		}
		else if (browserName.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver(FirefoxOption());		
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com");
	}
	
	@AfterSuite
	public void StopDriver()
	{
		driver.quit();
	}
	
	//Take Screenshot when test case fails
	@AfterMethod
	public void ScreenshotOnFailure(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			System.out.println("Failed!");
			System.out.println("Taking screenshot.");
			Helper.CaptureScreenshot(driver, result.getName());
		}
	}
}
