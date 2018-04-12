package com.RA.e2e;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.RA.libraries.Excel_libraries;
import com.RA.libraries.Utility_libraries;
import com.RA.webelement.RA_Login;
import com.RA.webelement.RA_Logout;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RA_script {

	long S_time;
	long E_time;
	WebDriver driver;						//Create driver instance
	ExtentTest logger;						//Create logger instance
	ExtentReports Extndreport;  			//Create reporter instance
	String testName = "Rockwell_automation_login_logout";
	
	@BeforeTest
	public void Create() throws Throwable {	 
		 	 
		//--------------------------------------------Calling report-----------------------------------------------
		Extndreport = Utility_libraries.Report();
		//------------------------------------------Create a Excel file--------------------------------------------
		Excel_libraries.Create_Excel_file(); 
		
		logger 		= Extndreport.startTest(testName); 
	}
	
	@Test(priority=1)
	public void Launch() throws Throwable
		{
		    //----------------------------------------------Start report test-------------------------------------------------
			testName	= new Object(){}.getClass().getEnclosingMethod().getName();
			logger 		= Extndreport.startTest(testName);
				
			//---------------------------------Variables--------------------------------------
			String[] Launch = {Excel_libraries.Read("URL","RA_DATA_SHEET.xls","Login"),Excel_libraries.Read("Browser","RA_DATA_SHEET.xls","Login")};
			Utility_libraries.Verify_value(Launch,logger);
			String URL 			= Launch[0];
			String Browser 		= Launch[1];
			//--------------------------------------------------------------------------------
			
			driver=Utility_libraries.getBrowser(Browser);		//Assign browser object in driver			 
			driver.navigate().to(URL);							//Launch URL
		
		}		
				
	@Test(priority=2)
	public void Login_RA_page() throws Throwable
		{
		 	//----------------------------------------------Start report test-------------------------------------------------
			testName	= new Object(){}.getClass().getEnclosingMethod().getName();
			logger 		= Extndreport.startTest(testName);
		
			//---------------------------------Variables--------------------------------------
			String[] Login_RA_page = {Excel_libraries.Read("Username","RA_DATA_SHEET.xls","Login"),Excel_libraries.Read("Password","RA_DATA_SHEET.xls","Login")};
			Utility_libraries.Verify_value(Login_RA_page,logger);
			String Username 	= Login_RA_page[0];
			String Password 	= Login_RA_page[1];
			//--------------------------------------------------------------------------------
			
			RA_Login login_obj =  new RA_Login(logger, driver);			//Create a object of a class 			
			login_obj.Login(Username,Password);							//Login in a RA page
		}
		
	@Test(priority=3)
	public void Logout_RA_page() throws Throwable
	{
			 //----------------------------------------------Start report test-------------------------------------------------
			testName	= new Object(){}.getClass().getEnclosingMethod().getName();
			logger 		= Extndreport.startTest(testName);
		
			RA_Logout logout_obj = new RA_Logout(driver, logger);		//Create a object of a class
			logout_obj.Logout();										//Logout from a RA page
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

	@AfterClass
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
		
}	

