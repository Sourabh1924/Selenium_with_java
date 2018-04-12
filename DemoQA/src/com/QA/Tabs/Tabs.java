package com.QA.Tabs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Tabs {

	WebDriver driver;
	String URL = "http://demoqa.com/tabs/";
	int counter=1;
	int counter1=1;
	@Test
	public void run() throws Throwable
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		List<WebElement> tab_list = driver.findElements(By.xpath("//li[@role='tab']"));
		List<WebElement> tab_content = driver.findElements(By.xpath("//div[@role='tabpanel']"));
			for(WebElement we:tab_list)
			{
				we.click();
				counter++;
					for(WebElement we1:tab_content)
					{
						System.out.println(we1.getText());						
					}
			}
	}
	
}
