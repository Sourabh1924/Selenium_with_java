package jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Demo_jenkins {
	
	@Test
	public void Run() throws Throwable
	{
		System.out.println("sourabh");
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("https://www.gmail.com/");
		driver.findElement(By.cssSelector("#identifierId")).sendKeys("memo.sourabh@gmail.com");
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(60000);
		driver.close();
	}
}