package com.HM.webelement;

import org.openqa.selenium.WebDriver;
import com.HM.POM.Logout_POM;
import com.HM.libraries.Utility_libraries;
import com.relevantcodes.extentreports.ExtentTest;

public class Logout_script {

	WebDriver driver;
	ExtentTest logger;
	
	public Logout_script(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
	}
	public void Logout() throws Throwable
	{
		Logout_POM Obj_logout = new Logout_POM();
		Utility_libraries Obj = new Utility_libraries();
		
		driver.findElement(Obj_logout.Account_button()).click();
			//--------------------------------------------------------------------------
			Obj.Report_pass("Click on button","Cick on Signout button",logger);
			//--------------------------------------------------------------------------
		driver.findElement(Obj_logout.Signout_button()).click();
		
		try
		{
			driver.findElement(Obj_logout.Element_display()).isDisplayed();
				//--------------------------------------------------------------------------
				Obj.Report_pass("Signout","User signout successfully",logger);
				//--------------------------------------------------------------------------
		}
		catch(Exception e)
		{
				//--------------------------------------------------------------------------
				Obj.Report_fail("Signout","User is not signout successfully",logger);
				//--------------------------------------------------------------------------
		}
	}
}
