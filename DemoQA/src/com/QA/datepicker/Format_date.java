package com.QA.datepicker;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Format_date {

	WebDriver driver;
	String URL = "http://demoqa.com/datepicker/";
	
	@Test
	public void run() throws Throwable
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.findElement(By.cssSelector("#ui-id-4")).click();
		driver.findElement(By.cssSelector("#datepicker4")).click();	
		List<WebElement> lst = driver.findElements(By.className("ui-state-default"));
		for(WebElement we:lst)
		{
			if(we.getText().equalsIgnoreCase("11"))
			{
				we.click();
				break;
			}
		}
		
		Select Year = new Select(driver.findElement(By.cssSelector("#format")));
		List<WebElement> Data = Year.getOptions();
		   for(WebElement we:Data)
		   {
			   Year.selectByVisibleText(we.getText());
		   }
		
	}
	
}
