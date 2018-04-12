package com.QA.Menu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Simple_Menu {
	
	WebDriver driver;
	String URL = "http://demoqa.com/menu/#";
	
	@Test
	public void run() throws Throwable
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.findElement(By.cssSelector("#ui-id-1")).click();
		List<WebElement> lst = driver.findElements(By.xpath("//div[@id='tabs-1']/descendant-or-self::a[@href='#']"));
			for(WebElement we:lst)
			{
				we.click();
				Thread.sleep(3000);
			}
	}
	
}
