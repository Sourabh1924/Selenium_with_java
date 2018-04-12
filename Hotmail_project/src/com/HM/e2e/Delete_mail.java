package com.HM.e2e;

import java.util.List;
import com.HM.POM.Login_POM;
import org.openqa.selenium.By;
import com.HM.libraries.Utility_libraries;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Delete_mail {

		WebDriver driver;
		ExtentTest logger;
		ExtentReports Extndreport;
		String testName 		= "Delete the selected mails";
		
		@Test
		public void run() throws Throwable {
			// TODO Auto-generated method stub
					
			//---------------------------------Object created--------------------------------------
			WebDriver driver 		= new FirefoxDriver();
			Login_POM Obj_login 	= new Login_POM();
			Extndreport 			= Utility_libraries.Report();
			logger 					= Extndreport.startTest(testName);
			
			
			//----------------------------------------------Start report test-------------------------------------------------
			testName	= new Object(){}.getClass().getEnclosingMethod().getName();
			logger 		= Extndreport.startTest(testName);
			
			//---------------------------------Variables--------------------------------------
			String Username = "memo.sourabh@hotmail.com";
			String Password = "sourabh1990";
			int counter 	= 0;
			
			//Launch URL
			driver.navigate().to("https://outlook.live.com/owa/");
			//Click on Navigate link
			driver.findElement(Obj_login.Navigate()).click();
			//Enter Username
			driver.findElement(Obj_login.Username_Box()).sendKeys(Username);
			//Click on next button
			driver.findElement(Obj_login.Next_button()).click();
			Thread.sleep(4000);
			//Enter Password
			driver.findElement(Obj_login.Password_box()).sendKeys(Password);
			//Click on Signin button
			driver.findElement(Obj_login.Sign_button()).click();	
			Thread.sleep(4000);
			//Store all the mail subject 
			List<WebElement> Subject_lst = driver.findElements(By.xpath("//span[@autoid='_lvv_c']"));
			//Store all the checkbox button
			List<WebElement> Checkbox_lst = driver.findElements(By.xpath("//button[@class='_lvv_f1 noMargin o365button']"));
				for(WebElement Subject:Subject_lst)
				{
					counter = counter + 1;
					    //Match the subject matter with the given argument
						if(Subject.getText().equalsIgnoreCase("undeliverable: sample mail"))
						{								
							Checkbox_lst.get(counter-1).click();
						}  
				}	
			//Click on delete button
			driver.findElement(By.xpath("//button[@title='Delete (Del)']")).click();	
			Thread.sleep(5000);
			driver.close();
		}
	}

