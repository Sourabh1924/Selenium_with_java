package com.QA.Registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Registration {

	WebDriver driver;
	String URL="http://demoqa.com/registration/";
	String user_Fname="sourabh";
	String user_Lname="chakroborty";
	String Email="memo@gmail.com";
	String Phone = "1234598751";
	String username="sourabh";
	String marital_Status = "single";
	String Hooby = "Dance,Reading,Cricket";
	String[] Hoody = Hooby.split(",");
	int counter=0;
	
	@Test
	public void Run() throws Throwable {
		// TODO Auto-generated method stub
		
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.findElement(By.cssSelector("#name_3_firstname")).sendKeys(user_Fname);
		driver.findElement(By.cssSelector("#name_3_lastname")).sendKeys(user_Lname);
			if(marital_Status.equalsIgnoreCase("single")) {
				driver.findElement(By.xpath("//input[@value='single']")).click();
			}
			else if(marital_Status.equalsIgnoreCase("married")) {
				driver.findElement(By.xpath("//input[@value='married']")).click();
			}
			else {
				driver.findElement(By.xpath("//input[@value='divorced']")).click();
			}
				
			for(int i=0;i<=Hoody.length-1;i++)  {
				
				if(Hoody[i].equalsIgnoreCase("dance")) {
					driver.findElement(By.xpath("//input[@value='dance']")).click();
					
				}
				else if(Hoody[i].equalsIgnoreCase("reading")) {
					driver.findElement(By.xpath("//input[@value='reading']")).click();
					//input[@value='dance']
				}
				else if(Hoody[i].equalsIgnoreCase("cricket")) {
					driver.findElement(By.xpath("//input[@value='cricket ']")).click();
					//input[@value='dance']
				}
				
			}	
		driver.findElement(By.cssSelector("#phone_9")).sendKeys(Phone);
		driver.findElement(By.cssSelector("#email_1")).sendKeys(Email);
			
		Run obj = new Run();
		obj.User_valid(username,driver);		
	}
}
