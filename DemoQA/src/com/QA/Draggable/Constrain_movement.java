package com.QA.Draggable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Constrain_movement {

	WebDriver driver;
	String URL = "http://demoqa.com/draggable/";
	
	@Test
	public void Run()
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		
		/*I can be dragged only vertically*/
		driver.findElement(By.cssSelector("#ui-id-2")).click();
		WebElement source = driver.findElement(By.cssSelector("#draggabl"));
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(source, 100, 40).build().perform();
		
		/*I can be dragged only horizontally*/
		driver.findElement(By.cssSelector("#ui-id-2")).click();
		WebElement source1 = driver.findElement(By.cssSelector("#draggabl2"));
		Actions builder1 = new Actions(driver);
		builder1.dragAndDropBy(source1, 290, 100).build().perform();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
