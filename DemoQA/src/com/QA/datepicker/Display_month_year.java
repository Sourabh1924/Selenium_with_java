package com.QA.datepicker;

import java.time.Month;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Display_month_year {

	WebDriver driver;
	String URL = "http://demoqa.com/datepicker/";
	boolean counter;
	String Date = "11-April-2018";
	String[] Date1 = Date.split("-");
	int Month_num = Month.valueOf(Date1[1].toUpperCase()).getValue();
	
	@Test
	public void run() throws Throwable
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.findElement(By.cssSelector("#ui-id-3")).click();
		driver.findElement(By.cssSelector("#datepicker3")).click();	
		Select Month = new Select(driver.findElement(By.cssSelector(".ui-datepicker-month")));
		Month.selectByIndex(Month_num-1); 		
		Select Year = new Select(driver.findElement(By.cssSelector(".ui-datepicker-year")));
		Year.selectByVisibleText(Date1[2]);
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
}
