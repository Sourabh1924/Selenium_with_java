package selenium_grid;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Grid_testng {
 
  @Test
  public void f() throws MalformedURLException {
	 
	  	DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setPlatform(Platform.WINDOWS);
		URL url = new URL("http://localhost:4444/wd/hub");
		WebDriver driver = new RemoteWebDriver(url, cap);
//		System.setProperty("webdriver.chrome.driver", "F:\\Software\\Selenium_setup\\Drivers\\chromedriver.exe");
//		driver=new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver", "F:\\Sel\\Selenium\\Drivers\\geckodriver.exe");
//  	cap.setCapability("marionette", true);
//		driver=new FirefoxDriver(cap);
		driver.get("https://www.makemytrip.com/");
		System.out.println(driver.getTitle());
		driver.close();
  
  }
}
