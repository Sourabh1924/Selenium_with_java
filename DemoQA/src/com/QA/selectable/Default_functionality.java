package com.QA.selectable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Default_functionality {

	WebDriver driver;
	String URL = "http://demoqa.com/selectable/";
	
	@Test
	public void run() throws Throwable
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.findElement(By.cssSelector("#ui-id-1")).click();
		List<WebElement> lst = driver.findElements(By.xpath("//ol[@id='selectable']/descendant::li[contains(@class,'ui-selectee')]"));
		for(WebElement we:lst)
		{
			we.click();
		}
	}
	
}
