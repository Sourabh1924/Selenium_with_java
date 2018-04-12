package com.QA.Droppable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Revert_draggable_Position {

	WebDriver driver;
	String URL = "http://demoqa.com/droppable/";

	@Test
	public void run() throws InterruptedException
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.findElement(By.cssSelector("#ui-id-4")).click();
		WebElement Drop = driver.findElement(By.xpath("//div[@id='droppablerevert']"));
		WebElement Drop_outer = driver.findElement(By.xpath("//div[@id='tabs-4']/div"));
		WebElement Drag = driver.findElement(By.xpath("//div[@id='tabs-4']/descendant::div[@id='draggablerevert']"));
		WebElement Drag1 = driver.findElement(By.xpath("//div[@id='tabs-4']/descendant::div[@id='draggablerevert2']"));
		Actions builder = new Actions(driver);
		builder.dragAndDrop(Drag, Drop).build().perform();
		builder.dragAndDrop(Drag, Drop_outer).build().perform();
		Thread.sleep(5000);
		builder.dragAndDrop(Drag1, Drop).build().perform();	
		builder.dragAndDrop(Drag1, Drop_outer).build().perform();	
	}	
}
