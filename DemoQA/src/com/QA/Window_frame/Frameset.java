package com.QA.Window_frame;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Frameset {

	WebDriver driver;
	String URL = "http://demoqa.com/frames-and-windows/#";
	
	@Test
	public void run()
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.findElement(By.cssSelector("#ui-id-3")).click();
		driver.findElement(By.xpath("//div[@id='tabs-3']/div/p/a")).click();		
		Set<String> Window = driver.getWindowHandles();		
		Iterator<String> itr = Window.iterator();
		itr.next();
		driver.switchTo().window(itr.next());
		driver.switchTo().frame(1);
		System.out.println(driver.findElement(By.cssSelector("html>body>h2")).getText());		
	}	
}
