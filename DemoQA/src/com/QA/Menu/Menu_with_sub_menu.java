package com.QA.Menu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Menu_with_sub_menu {
	
	WebDriver driver;
	String URL = "http://demoqa.com/menu/#";
	Actions builder = new Actions(driver);
	
	@Test
	public void run() throws Throwable
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.findElement(By.cssSelector("#ui-id-2")).click();
		List<WebElement> lst = driver.findElements(By.xpath("//div[@id='tabs-1']/descendant-or-self::a[@href='#']"));
			for(WebElement we:lst)
			{
				if(we.getText().equalsIgnoreCase("home"))
				{
					builder.moveToElement(we).build().perform();
//						if()
//						{
//							By Baay = org.openqa.selenium.By.xpath("//a[contains(text(),'Home')]/following-sibling::ul[@class='sub-level']/descendant::li[@class='ui-corner-left']");
//							Baay.
//						}
					
				}
				
					
				
			}
	}
	
}
