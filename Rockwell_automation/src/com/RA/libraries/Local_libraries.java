package com.RA.libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Local_libraries {

	WebDriver driver;
	By Locaters;
	
	public Local_libraries(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void Wait_for_click(By Locaters,int Wait)
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		WebElement Element_click = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fa.fa-user")));
		Element_click.click();
	}
	
	public void Wait_for_display(By Locaters,int Wait)
	{
		WebDriverWait wait1 = new WebDriverWait(driver,50);
		WebElement Display_Ele = wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#content>h3")));
		Display_Ele.click();
	}
}
