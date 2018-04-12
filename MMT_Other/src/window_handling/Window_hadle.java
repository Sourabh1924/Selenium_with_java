package window_handling;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Window_hadle {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();	
		
		//Launch the browser
		driver.navigate().to("https://www.irctc.co.in/eticketing/loginHome.jsf");
		
		//Create Parent__window object
		String Parent__window =  driver.getWindowHandle();
		
		//Click on  Flight Tickets
		driver.findElement(By.xpath("//a[contains(text(),'Flight Tickets')]")).click();
		Thread.sleep(5000);
		
		//Store all the window instance
		Set<String> str = driver.getWindowHandles(); 
		
		//Store all the window instance for iterator 
		Iterator<String> itr = str.iterator();
		
		while(itr.hasNext())
		{
			itr.next();
			String Child_window = itr.next();
			//To check Child_Window is not equal to Parent__window
			if(Child_window.equals(Parent__window)==false)
			{
				//Switch to Child__window
				driver.switchTo().window(Child_window);
				
				WebDriverWait wait = new WebDriverWait(driver,5);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("domastic")));
				driver.findElement(By.id("origin")).sendKeys("Raipur,RPR");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[contains(text(),'Raipur,RPR')]")).click();
				driver.findElement(By.id("destination")).sendKeys("Nagpur,NAG");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[contains(text(),'Nagpur,NAG')]")).click();
				driver.findElement(By.id("departDate")).sendKeys("08/05/2017");
				WebElement Select_pass = driver.findElement(By.id("noOfAdult"));
				Select dropdown = new Select(Select_pass);
				dropdown.selectByVisibleText("2");
				driver.findElement(By.xpath("//input[@name='submitVal']/following-sibling::div[@class='srchbtn']")).click();
				Thread.sleep(20000);
				driver.close();
			}
		}
		//Switch to Parent__window
		driver.switchTo().window(Parent__window);
		driver.close();
	}
}
