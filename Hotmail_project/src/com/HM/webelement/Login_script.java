package com.HM.webelement;

import org.openqa.selenium.WebDriver;
import com.HM.POM.Login_POM;
import com.HM.libraries.Utility_libraries;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Login_script {

	WebDriver driver;
	ExtentTest logger;
	
	public Login_script(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
	}	
	public void Login(String Username,byte[] decryptedPasswordBytes) throws Throwable
	{		
		Login_POM Obj_login = new Login_POM();
		Utility_libraries Obj = new Utility_libraries();
		
		driver.findElement(Obj_login.Navigate()).click();
		driver.findElement(Obj_login.Username_Box()).sendKeys(Username);
			//--------------------------------------------------------------------------
			Obj.Report_pass("Enter value", "Enter username in the editbox ",logger);
			//--------------------------------------------------------------------------
		driver.findElement(Obj_login.Next_button()).click();
		Thread.sleep(4000);
			try
			{
				driver.findElement(Obj_login.Name_verify()).isDisplayed();
				    //--------------------------------------------------------------------------
					logger.log(LogStatus.PASS,"Username display", "Username enter successfully");
					//--------------------------------------------------------------------------
			}
			catch(Exception e)
			{
					//----------------------------------------------------------------------------------
					logger.log(LogStatus.FAIL,"Username display", "Username enter is not successfully");
					//----------------------------------------------------------------------------------
			}
		driver.findElement(Obj_login.Password_box()).sendKeys(new String(decryptedPasswordBytes));
			//--------------------------------------------------------------------------
			Obj.Report_pass("Enter value", "Enter password in the editbox ",logger);
			//--------------------------------------------------------------------------
		driver.findElement(Obj_login.Sign_button()).click();
		
		
	
	}
}
