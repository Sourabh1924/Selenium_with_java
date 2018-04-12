package com.HM.webelement;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.HM.POM.Send_mail_POM;
import com.HM.libraries.Utility_libraries;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Send_mail_script {

	WebDriver driver;
	ExtentTest logger;
	
	public Send_mail_script(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
	}
	
	public  void SendMail(String To_recipient,String Cc_recipient,String Subject,String Main_matter) throws Throwable 
	{
		Thread.sleep(5000);
		Send_mail_POM Obj_sendmail = new Send_mail_POM();
		Utility_libraries Obj = new Utility_libraries();
		
		try
		{
			driver.findElement(Obj_sendmail.Next_button()).isDisplayed();
				//--------------------------------------------------------------------------
				logger.log(LogStatus.PASS,"Login","User login successfully");
				//--------------------------------------------------------------------------
		}
		catch(Exception e)
		{
				//--------------------------------------------------------------------------
				logger.log(LogStatus.FAIL,"Login","User is not login successfully");
				//--------------------------------------------------------------------------
		}
		//Click on New button
		driver.findElement(Obj_sendmail.Next_button()).click();
		//Enter the mail id for To 
		driver.findElement(Obj_sendmail.To_recipient()).sendKeys(To_recipient);
			if(Cc_recipient.isEmpty())  {}			
			else  {
				//Enter the mail id for Cc 
				driver.findElement(Obj_sendmail.Cc_button()).click();
				driver.findElement(Obj_sendmail.Cc_recipient()).sendKeys(Cc_recipient);
			}
		//Enter Subject of the mail
		driver.findElement(Obj_sendmail.Subject_box()).click();
		driver.findElement(Obj_sendmail.Subject_box()).sendKeys(Subject);
		//Enter Mail matter
		driver.findElement(Obj_sendmail.Body_box()).click();
		driver.findElement(Obj_sendmail.Body_box()).sendKeys(Main_matter);
			//--------------------------------------------------------------------------
			Obj.Report_pass("Enter all the fields","Enter mail details",logger);
			//--------------------------------------------------------------------------
		//Click on Send button
		List<WebElement> lst = driver.findElements(Obj_sendmail.Send_button());
			for(WebElement we:lst)
			{
				we.click();
				break;
			}
	}
}
