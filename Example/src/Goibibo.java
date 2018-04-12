import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Goibibo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "E:\\Sourabh_Selenium\\Sel\\Selenium_python\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.goibibo.com/");
		driver.navigate().refresh();
		
		WebElement frame = driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));
		driver.switchTo().frame(frame);
		driver.findElement(By.className("close")).click();
		driver.findElement(By.id("phone")).sendKeys("4512578");
		
	}

}
