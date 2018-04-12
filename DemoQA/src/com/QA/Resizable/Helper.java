package com.QA.Resizable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Helper {

	WebDriver driver;
	String URL = "http://demoqa.com/resizable/";
	
	@Test
	public void run() throws Throwable
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.findElement(By.cssSelector("#ui-id-4")).click();
		WebElement Resize = driver.findElement(By.xpath("//div[@id='resizable_helper']/div[3]"));
		Actions builder = new Actions(driver);
		builder.clickAndHold(Resize).moveByOffset(60, 70).build().perform();
		builder.release().build().perform();
	}
}
