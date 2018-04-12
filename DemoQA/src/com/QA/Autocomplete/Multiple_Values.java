package com.QA.Autocomplete;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Multiple_Values {

	WebDriver driver;
	String URL = "http://demoqa.com/autocomplete/";
	String[] Enter_value1 = "a,pe".split(",");
	String[] Main_value1 = "asp,perl".split(",");
	
	@Test
	public void run() throws Throwable
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.findElement(By.cssSelector("#ui-id-5")).click();
			for(int i=0;i<=Enter_value1.length-1;i++)
			{
				driver.findElement(By.xpath(".//div[@class='ui-widget']/input[@id='tagsss']")).sendKeys(Enter_value1[i]);
				Thread.sleep(2000);
				List<WebElement> lst = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
					for(WebElement we:lst)
					{
						System.out.println(we.getText());
						if(we.getText().equalsIgnoreCase(Main_value1[i]))
						{
							we.click();
							break;
						}
					}
			}		
	}
	
}
