package com.QA.Resizable;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Max_Min_size {

	WebDriver driver;
	String URL = "http://demoqa.com/resizable/";
	int x = 10;
	int y = 10;
	Point Location;

	@Test
	public void run() throws Throwable
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.findElement(By.cssSelector("#ui-id-5")).click();
		Actions builder = new Actions(driver);
		WebElement Resize = driver.findElement(By.xpath("//div[@id='resizable_max_min']/div[3]"));	
		Location = driver.findElement(By.xpath("//div[@id='resizable_max_min']")).getLocation();
			do
			{								
				builder.clickAndHold(Resize).moveByOffset(x,y).build().perform();
				builder.release(Resize).build().perform();					
				x=x+5;
				y=y+5;
			}
			while(x<=100);
		
	}
}
