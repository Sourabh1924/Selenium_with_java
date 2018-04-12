package com.QA.Droppable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Prevent_propagation {

	WebDriver driver;
	String URL = "http://demoqa.com/droppable/";
	
	@Test
	public void run() throws Throwable
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.findElement(By.cssSelector("#ui-id-3")).click();
		WebElement Drag = driver.findElement(By.cssSelector("#draggableprop"));
		WebElement Dropinner = driver.findElement(By.cssSelector("#droppable-inner"));
		Actions builder = new Actions(driver);
		builder.dragAndDrop(Drag, Dropinner).build().perform();

		Thread.sleep(4000);
		
		WebElement Dropinner1 = driver.findElement(By.cssSelector("#droppable2-inner"));
		builder.clickAndHold(Drag).moveByOffset(150, 5).build().perform();
		builder.release(Drag).build().perform();
		builder.dragAndDrop(Drag, Dropinner1).build().perform();	
	}
	
}
