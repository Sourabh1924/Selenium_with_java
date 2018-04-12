package com.QA.Tooltips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Custom_animation_demo {

	WebDriver driver;
	String URL = "http://demoqa.com/tooltip/";
	
	@Test
	public void run() throws Throwable
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.findElement(By.cssSelector("#ui-id-2")).click();
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.cssSelector("#show-option"))).build().perform();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector(".ui-tooltip-content")).getText());
		builder.moveToElement(driver.findElement(By.cssSelector("#open-event"))).build().perform();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector(".ui-tooltip-content")).getText());
	}
	
}
