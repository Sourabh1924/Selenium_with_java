package com.QA.Draggable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Events {

	WebDriver driver;
	String URL = "http://demoqa.com/draggable/";
	String Start;
	String Drag;
	String Stop;
	int x_axis = 20 ;
	int y_axis = 30 ;
			
	@Test
	public void Run()
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.findElement(By.cssSelector("#ui-id-4")).click();		
		WebElement source = driver.findElement(By.cssSelector("#dragevent"));
		Actions builder = new Actions(driver);		
			for(int i=0;i<=3;i++)
			{
				builder.dragAndDropBy(source, x_axis, y_axis).build().perform();
				x_axis=x_axis+20;
				y_axis=y_axis+30;
				Start = driver.findElement(By.xpath("//li[@id='event-start']/descendant::span[@class='count']")).getText();
				Drag = driver.findElement(By.xpath("//li[@id='event-drag']/descendant::span[@class='count']")).getText();
				Stop = driver.findElement(By.xpath("//li[@id='event-stop']/descendant::span[@class='count']")).getText();
			}		
		System.out.println("Number of start event = "+ Start+" .Number of axis move = "+Drag+" .Number of stop event = "+Stop+" .");
	}
}
