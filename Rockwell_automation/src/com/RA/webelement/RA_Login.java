package com.RA.webelement;

import org.openqa.selenium.WebDriver;
import com.RA.page_object_model.RA_Login_POM;
import com.relevantcodes.extentreports.ExtentTest;

public class RA_Login {

	WebDriver driver;
	ExtentTest logger;
	
	public RA_Login(ExtentTest logger,WebDriver driver)
	{
		this.driver = driver;
		this.logger = logger;
	}
	public void Login(String Username,String Password) throws Throwable
	{		
		Myinterface_Reporter Reporter = new RA_Reporter( logger, driver);
		RA_Login_POM POM = new RA_Login_POM();					//Create a object of a class 		
		driver.findElement(POM.Navigate()).click();				//Click on navigate link
		Thread.sleep(2000);		
		
			try
			{
				driver.findElement(POM.Signin()).isDisplayed();
				Reporter.RA_report_pass("Click on signIn link", "Sign in link is clicked");
			}
			catch(Exception e)
			{
				Reporter.RA_report_fail("Click on signIn link", "Sign in link is not clicked");
			}
			
		driver.findElement(POM.Signin()).click();				//Click on sign in link		
		driver.findElement(POM.Username()).sendKeys(Username);	//Enter User name		
		driver.findElement(POM.Password()).sendKeys(Password);	//Enter Password	
		driver.findElement(POM.Submit()).click();				//Click on submit
		
			try
			{
				driver.findElement(POM.Error_MSG()).isDisplayed();
				Reporter.RA_report_fail("User login", "User is not sucessfully login");
			}
			catch(Exception e)
			{
				Reporter.RA_report_pass("User login", "User sucessfully login");
			}
		
	}
}
