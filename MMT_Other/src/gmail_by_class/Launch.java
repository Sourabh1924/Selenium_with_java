package gmail_by_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Launch {

	public static WebDriver driver;
	
	public static WebDriver  getBrowser(String strBrowserName)
	{
		switch(strBrowserName.toLowerCase())
		{	
		//launch in firefox
		case "firefox":
		driver=new FirefoxDriver();
		break;
		//------------------------------------------------
		//launch in chrome
		case "chrome":
		System.setProperty("webdriver.chrome.driver", "F:\\Software\\Selenium_setup\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		break;
		//------------------------------------------------		
		//launch in internetexplore
		case "internetexplore":
		System.setProperty("webdriver.ie.driver","F:\\Software\\Selenium_setup\\Drivers\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		
		case "ie":
			System.setProperty("webdriver.ie.driver","F:\\Software\\Selenium_setup\\Drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		//------------------------------------------------
		default:
			System.out.println("Driver is not found "+strBrowserName);
		}
		return driver;
	}
}

