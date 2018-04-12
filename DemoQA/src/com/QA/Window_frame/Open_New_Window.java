package com.QA.Window_frame;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Open_New_Window {

	WebDriver driver;
	String URL = "http://demoqa.com/frames-and-windows/#";
	
	@Test
	public void run()
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.findElement(By.cssSelector("#ui-id-1")).click();
		driver.findElement(By.xpath("//div[@id='tabs-1']/div/p/a")).click();		
		Set<String> Window = driver.getWindowHandles();		
		Iterator<String> itr = Window.iterator();
		driver.switchTo().window(itr.next());
		driver.findElement(By.xpath("//div[@id='tabs-1']/div/p/a")).click();
	}
}
