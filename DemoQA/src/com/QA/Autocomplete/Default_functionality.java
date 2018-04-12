package com.QA.Autocomplete;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Default_functionality {

	WebDriver driver;
	String URL = "http://demoqa.com/autocomplete/";
	
	@Test
	public void run() throws Throwable
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.findElement(By.cssSelector("#ui-id-4")).click();
		driver.findElement(By.xpath("//input[@id='tagss']")).sendKeys("p");
		Thread.sleep(2000);
		List<WebElement> lst = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
			for(WebElement we:lst)
			{
				if(we.getText().startsWith("Pyth"))
				{
					we.click();
				}
			}	
	}	
}