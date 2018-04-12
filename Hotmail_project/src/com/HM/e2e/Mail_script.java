package com.HM.e2e;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.HM.webelement.Login_script;
import com.HM.webelement.Logout_script;
import com.HM.webelement.Send_mail_script;
import com.HM.libraries.Excel_libraries;
import com.HM.libraries.Utility_libraries;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Mail_script {
	
	//---------------------------------Variables---------------------------------------------
	String testName 		= "Hotmail_send_mail";
	String File_path		= "F:\\Sel\\Hotmail_project\\Project_Data\\HM_Data_sheet.xls";
	long S_time				= 0;
	long E_time				= 0;
	//---------------------------------------------------------------------------------------
	
	WebDriver driver;
	ExtentTest logger;						
	ExtentReports Extndreport;  			
	
	
	@BeforeSuite
	public void Create() throws Throwable 
		{	
			S_time = System.nanoTime();
			//--------------------------------------------Calling report-----------------------------------------------
			Extndreport = Utility_libraries.Report();
			//------------------------------------------Create a Excel file--------------------------------------------
			Excel_libraries.Create_Excel_file(); 
			//--------------------------------------------Create a logger----------------------------------------------
			logger 		= Extndreport.startTest(testName); 
		}
	
	
	@BeforeTest
	public void Launch() throws Throwable 
		{
			//----------------------------------------------Start report test-------------------------------------------------
			testName	= new Object(){}.getClass().getEnclosingMethod().getName();
			logger 		= Extndreport.startTest(testName);
				
			//---------------------------------Variables--------------------------------------
			String[] Launch = {Excel_libraries.Read("URL",File_path,"Prerequisite"),Excel_libraries.Read("Browser",File_path,"Prerequisite")};
			Utility_libraries.Verify_value(Launch,logger,Extndreport);
			String URL 			= Launch[0];
			String Browser 		= Launch[1];
			//--------------------------------------------------------------------------------
			
			driver=Utility_libraries.getBrowser(Browser);		//Assign browser object in driver			 
			driver.navigate().to(URL);							//Launch URL
		}
	
	
	@Test(priority=1)
	public void Login_HM_page() throws Throwable
		{
			//----------------------------------------------Start report test-------------------------------------------------
			testName	= new Object(){}.getClass().getEnclosingMethod().getName();
			logger 		= Extndreport.startTest(testName);
		
			//---------------------------------Variables--------------------------------------
			String[] Login_HM_page = {Excel_libraries.Read("Username",File_path,"Login"),Excel_libraries.Read("Password",File_path,"Login")};
			Utility_libraries.Verify_value(Login_HM_page,logger,Extndreport);
			String Username = Login_HM_page[0];
			String Password = Login_HM_page[1];
			Password = Base64.getEncoder().encodeToString(Password.getBytes());
			
			Login_script Login_obj = new Login_script(driver,logger);
			Login_obj.Login(Username,Base64.getDecoder().decode(Password));
		}
	
	
	@Test(priority=2)
	public void Mail() throws Throwable
		{
			//----------------------------------------------Start report test-------------------------------------------------
			testName	= new Object(){}.getClass().getEnclosingMethod().getName();
			logger 		= Extndreport.startTest(testName);
		
			//---------------------------------Variables--------------------------------------
			String[] Mail = {Excel_libraries.Read("To_recipient",File_path,"Send_mail"),Excel_libraries.Read("Cc_recipient",File_path,"Send_mail"),Excel_libraries.Read("Subject",File_path,"Send_mail"),Excel_libraries.Read("Main_matter",File_path,"Send_mail")};
			Utility_libraries.Verify_value(Mail,logger,Extndreport);			
			String To_recipient 	= Mail[0];
			String Cc_recipient 	= Mail[1];
			String Subject 			= Mail[2];
			String Main_matter 		= Mail[3];
			
			Send_mail_script Send_obj = new Send_mail_script(driver, logger);
			Send_obj.SendMail(To_recipient,Cc_recipient,Subject,Main_matter);
		}

	
	@Test(priority=3)
	public void Send_mail_verify() throws Throwable
		{
			//----------------------------------------------Start report test-------------------------------------------------
			testName	= new Object(){}.getClass().getEnclosingMethod().getName();
			logger 		= Extndreport.startTest(testName);
			
			Thread.sleep(30000);
			Utility_libraries Obj = new Utility_libraries();
			List<WebElement> lst = driver.findElements(By.xpath("//div[@tabindex='-1']//child::span[@autoid='_lvv_c']"));
				for(WebElement we:lst)
				{
					if(we.getText().equalsIgnoreCase("Undeliverable: Sample mail"))
					{
						//--------------------------------------------------------------------------
						Obj.Report_fail("Send mail","Mail is not delivered",logger);
						//--------------------------------------------------------------------------
						break;
					}
					break;
				}	
		}

	
	@Test(priority=4)
	public void Logout_HM_page() throws Throwable
		{
			//----------------------------------------------Start report test-------------------------------------------------
			testName	= new Object(){}.getClass().getEnclosingMethod().getName();
			logger 		= Extndreport.startTest(testName);
		
			Logout_script Logout_obj = new Logout_script(driver, logger);
			Logout_obj.Logout();
		}
	
	
	@AfterMethod	
	public void Flush(ITestResult result) throws Throwable		
	    {
			if(result.getStatus()==ITestResult.FAILURE) 
			{ 			
				logger.log(LogStatus.FAIL,"Error :"+result.getThrowable());//+report.getClass()+" Test "+logger.getTest().statusMessage);//,ClassTest.takeScreenShot());			
			}		
			  if (result.getStatus() == ITestResult.FAILURE) {
		            logger.log(LogStatus.FAIL, "Test '"+ testName+ "' Failed : Cause>>"+result.getThrowable(),logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
		            Excel_libraries.Excel_Reporter( ""+result.getThrowable()+"" , "Condition must be fullfill", "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
		            Extndreport.endTest(logger);
		            Extndreport.flush();
		            System.exit(1);
			  	} else if (result.getStatus() == ITestResult.SKIP) {
		        	logger.log(LogStatus.SKIP, "Test '"+ testName+ "' skipped : Cause>>"+ result.getThrowable(),logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
		        } else {
		        	logger.log(LogStatus.PASS, "Test  '"+ testName+"'  passed");
		        }	  
			  Extndreport.endTest(logger);
			  Extndreport.flush();
	    }
	
	
	@AfterTest
	public void Close() throws Throwable
		{
			E_time = System.nanoTime();
			
			//============================Reporter============================
			//================================================================
			logger.log(LogStatus.PASS,"Total Time Taken in Execution :", ""+(E_time-S_time)/1000000000+" second to run.");
			Excel_libraries.Excel_Reporter("Script take "+(E_time-S_time)/1000000000+" second to run.", "Script run successfully", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
			//================================================================
			//================================================================
	
			driver.close();
		}

	
	@AfterSuite
	public void Cleanup() throws Throwable 
		{
			Utility_libraries.Delete_folder("F:\\Sel\\Hotmail_project\\src\\Test_Result","");		
		}
	
	
}
