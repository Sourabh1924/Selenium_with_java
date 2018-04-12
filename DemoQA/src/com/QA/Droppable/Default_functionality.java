package com.QA.Droppable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Default_functionality {

	WebDriver driver;
	String URL = "http://demoqa.com/droppable/";

	@Test
	public void run()
	{
	driver = new FirefoxDriver();
	driver.get(URL);
	driver.findElement(By.cssSelector("#ui-id-1"));
	WebElement Drag = driver.findElement(By.cssSelector("#draggableview"));
	WebElement Drop = driver.findElement(By.cssSelector("#droppableview"));
	Actions builder = new Actions(driver);
	builder.dragAndDrop(Drag, Drop).build().perform();
	}
}
