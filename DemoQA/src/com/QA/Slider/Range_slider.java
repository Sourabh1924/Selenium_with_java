package com.QA.Slider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Range_slider {

	WebDriver driver;
	String URL = "http://demoqa.com/slider/";
	String Left;
	
	@Test
	public void run() throws Throwable
	{
		driver = new FirefoxDriver();
		driver.get(URL);
		WebElement slider = driver.findElement(By.xpath("//div[@id='slider-range-max']/span"));
		Actions builder = new Actions(driver);
		builder.click(slider).sendKeys(slider, Keys.ARROW_LEFT).build().perform();
	}
}
