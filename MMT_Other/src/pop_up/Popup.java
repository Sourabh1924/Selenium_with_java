package pop_up;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Popup {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();	
		
		//Launch the browser
		driver.navigate().to("http://demo.guru99.com/V4/index.php");
		//Enter username
		driver.findElement(By.name("uid")).sendKeys("mngr73101");
		//Enter password
		driver.findElement(By.name("password")).sendKeys("ApugejU");
		driver.findElement(By.name("btnLogin")).click();
		Thread.sleep(1000);	
		//Click on delete customer
		driver.findElement(By.xpath("//a[contains(text(),'Delete Customer')]")).click();
		//Enter customer customer ID
		driver.findElement(By.name("cusid")).sendKeys("456");
		driver.findElement(By.name("AccSubmit")).click();
		//Using alert
		Alert alt = driver.switchTo().alert();
		Thread.sleep(3000);
		alt.accept();
		Thread.sleep(3000);
		alt.accept();
		//Click on Logout
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		Thread.sleep(3000);
		alt.accept();
		driver.close();
		driver.quit();		
	}
}
