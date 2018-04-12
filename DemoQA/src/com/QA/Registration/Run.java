package com.QA.Registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Run {

	String Country="India";
	String Password="123456789";
	String Username="vikas,iDeliver008";
	String[] Username1 = Username.split(",");
	String DOB1="11-11-2005";
	String[] DOB = DOB1.split("-");
	int counter = 0;
	
	public void User_valid(String username,WebDriver driver) throws Throwable
	{
		
		Select Dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown_7']")));
		Dropdown.selectByVisibleText(Country);
		Select Dropdown2 = new Select(driver.findElement(By.xpath("//select[@id='mm_date_8']")));
		Dropdown2.selectByVisibleText(DOB[0]);
		Select Dropdown1 = new Select(driver.findElement(By.xpath("//select[@id='dd_date_8']")));
		Dropdown1.selectByVisibleText(DOB[1]);
		Select Dropdown3 = new Select(driver.findElement(By.xpath("//select[@id='yy_date_8']")));
		Dropdown3.selectByVisibleText(DOB[2]);
		driver.findElement(By.cssSelector("#username")).clear();
		driver.findElement(By.cssSelector("#username")).sendKeys(username);
		driver.findElement(By.cssSelector("#password_2")).sendKeys(Password);
		driver.findElement(By.cssSelector("#confirm_password_password_2")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
			try {
				driver.findElement(By.cssSelector(".piereg_login_error")).isDisplayed();							
				Run obj = new Run();
				obj.User_valid(Username1[counter],driver);	
				counter++;
			}
			catch(Exception e) { }
	
			Exception e = new Exception();
			 
	        throw e;
	}
	
	
}
