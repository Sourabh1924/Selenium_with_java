package com.QA.datepicker;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Default_functionality {

	WebDriver driver;
	String URL = "http://demoqa.com/datepicker/";
	boolean counter;
	String Date = "11-April-2018";
	String[] Date1 = Date.split("-");
	
	@Test
	public void run() throws Throwable
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.findElement(By.cssSelector("#ui-id-1")).click();
		driver.findElement(By.cssSelector("#datepicker1")).click();		
			do
			{
				String Date = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
				String Year = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
					if(Date.equalsIgnoreCase(Date1[1]) && Year.equalsIgnoreCase(Date1[2]))
					{
						List<WebElement> lst = driver.findElements(By.className("ui-state-default"));
							for(WebElement we:lst)
							{
								if(we.getText().equalsIgnoreCase(Date1[0]))
								{
									we.click();
									break;
								}
							}
					}
					else
					{
						driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
					}
			}
			while(counter=true);
	}

}
