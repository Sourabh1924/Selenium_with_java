package com.QA.Autocomplete;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Categories {

	WebDriver driver;
	String URL = "http://demoqa.com/autocomplete/";
	String Enter_value = "a";
	String Enter_value_product = "annhhx10";
	String Enter_value_people = "anders andersson";
	
	@Test
	public void run() throws Throwable
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.findElement(By.cssSelector("#ui-id-6")).click();		
		//Enter Product value
		driver.findElement(By.xpath("//input[@id='searcha']")).sendKeys(Enter_value);
		Thread.sleep(2000);
		List<WebElement> pro_lst = driver.findElements(By.xpath("//li[contains(@aria-label,'Products')]"));
		for(WebElement pro_we:pro_lst)
		{
			System.out.println(pro_we.getText());
				if(pro_we.getText().equalsIgnoreCase(Enter_value_product))
				{
					pro_we.click();
				}
		}
		//Enter People value
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='searcha']")).clear();
		driver.findElement(By.xpath("//input[@id='searcha']")).sendKeys(Enter_value);
		List<WebElement> per_lst = driver.findElements(By.xpath("//li[contains(@aria-label,'People ')]"));
		for(WebElement per_we:per_lst)
		{
			System.out.println(per_we.getText());
				if(per_we.getText().equalsIgnoreCase(Enter_value_people))
				{
					per_we.click();
				}
		}
	}	
}
