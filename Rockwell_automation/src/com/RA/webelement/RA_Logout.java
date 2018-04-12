package com.RA.webelement;

import org.openqa.selenium.WebDriver;

import com.RA.libraries.Local_libraries;
import com.RA.page_object_model.RA_Logout_POM;
import com.relevantcodes.extentreports.ExtentTest;

interface Myinterface_Logout
{
	public void Logout() throws Throwable;
}

public class RA_Logout implements Myinterface_Logout {

	WebDriver driver;
	ExtentTest logger;
	
	public RA_Logout(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;	
		this.logger = logger;
	}
	
	public void Logout() throws Throwable
	{		
		Myinterface_Reporter Reporter = new RA_Reporter( logger, driver);
		RA_Logout_POM POM = new RA_Logout_POM();			//Create a object of a class 			
		Local_libraries Lab = new Local_libraries(driver);	//Create a object of a class 		
		Lab.Wait_for_click(POM.Navigate(), 50);				//Access a method with argument	
		
			try
			{
				driver.findElement(POM.Signout()).isDisplayed();
				Reporter.RA_report_pass("Click on Signout link", "Signout link is clicked");
			}
			catch(Exception e)
			{
				Reporter.RA_report_fail("Click on Signout link", "Signout link is not clicked");
			}
		
		driver.findElement(POM.Signout()).click();			//Click on signout button		
		Lab.Wait_for_display(POM.Verify(), 20);				//Access a method with argument
		
			try
			{
				driver.findElement(POM.Verify()).isDisplayed();
				Reporter.RA_report_pass("User Logout", "User is sucessfully Logout");
			}
			catch(Exception e)
			{
				Reporter.RA_report_fail("User Logout", "User is not sucessfully Logout");
			}
		
	}
}
