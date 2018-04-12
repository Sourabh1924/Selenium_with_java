package com.QA.Draggable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Default_functionality {

	WebDriver driver;
	String URL = "http://demoqa.com/draggable/";
		
	@Test
	public void run()
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		WebElement source = driver.findElement(By.cssSelector("#draggable"));
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(source, 400, 150).build().perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
