package com.QA.Droppable;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Accept {

	WebDriver driver;
	String URL = "http://demoqa.com/droppable/";

	@Test
	public void run()
	{

		driver = new FirefoxDriver();
		driver.get(URL);
		driver.findElement(By.cssSelector("#ui-id-2")).click();
		Actions builder = new Actions(driver);
		WebElement Drop = driver.findElement(By.cssSelector("#droppableaccept"));
		List<WebElement> Drag = driver.findElements(By.xpath("//div[@id='tabs-2']/descendant::div[@style='position: relative;']"));
			for(WebElement we: Drag)
			{
			builder.dragAndDrop(we, Drop).build().perform();
			System.out.println(Drop.getText());	
			}	
		}
}
