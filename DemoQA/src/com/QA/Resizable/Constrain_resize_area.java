package com.QA.Resizable;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Constrain_resize_area {

	WebDriver driver;
	String URL = "http://demoqa.com/resizable/";
	
	@Test
	public void run() throws Throwable
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.findElement(By.cssSelector("#ui-id-3")).click();
		Point Location = driver.findElement(By.xpath("//div[@id='container1']")).getLocation();		
		WebElement Resize = driver.findElement(By.xpath("//div[@id='resizableconstrain']/div[3]"));		
		Actions builder = new Actions(driver);
		builder.clickAndHold(Resize).moveByOffset(Location.getX(),Location.getY()).build().perform();
		builder.release().build().perform();
	}
	
}
