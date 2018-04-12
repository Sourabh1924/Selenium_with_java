package script;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import car_secenerio.Car_book;
import car_secenerio.Car_search;
import car_secenerio.Rate_Price_verify;
import libraries.Excel_libraries;
import libraries.Utility_libraries;


public class Scenario_car {

	WebDriver driver;
	static ExtentReports report1;                     
	static ExtentTest logger;
	
	//-----------------------------------------Data initialization----------------------------------------------
	long S_time;
	long E_time;
	boolean counter = false;
	public static String testName="Flight_booking";
	
	@BeforeTest
	public void Create() throws Throwable {	 
		 
		//--------------------------------------Delete the previous folders---------------------------------------
		//Function_libraries.Delete_folder();
		//------------------------------------------Create class object------------------------------------------- 
		//Elem_obj = new Element_lab2();		 
		//--------------------------------------------Calling report-----------------------------------------------
		report1=Utility_libraries.Report();
		//------------------------------------------Create a Excel file--------------------------------------------
		Excel_libraries.Create_Excel_file();  	
		
		System.setProperty("atu.reporter.config", "C:\\Users\\Yogesh\\Desktop\\Selenium_project\\atu.properties");
	}
	
	@Test(priority=1)
	public void Launch() throws Throwable
	{
		//----------------------------------------------Start report test-------------------------------------------------
		testName	= new Object(){}.getClass().getEnclosingMethod().getName();
		logger 		= report1.startTest(testName);  
		//-----------------------------------------Data initialization----------------------------------------------------
		String Browser_name 	= Excel_libraries.Read("Browser_name","Flight_booking_data.xls");			// Browser name 
		String URL 				= Excel_libraries.Read("URL","Flight_booking_data.xls");					// Web site URL
		
		//---------------------------------------------- Start time------------------------------------------------
		S_time = System.nanoTime();
		//-------------------------------------------Launch Firefox driver-----------------------------------------
		driver=Utility_libraries.getBrowser(Browser_name);
		//-------------------------------------------------Enter URL----------------------------------------------
		driver.navigate().to(URL);
		//----------------------------------------Wait statement is initialize------------------------------------
		if(driver.getCurrentUrl().equals("https://www.southwest.com/#") )
		{
			
			  //===========================Reporter=============================
			  //================================================================
		      logger.log(LogStatus.PASS,"URL enter","URL enter after browser open");
		      logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
		      Excel_libraries.Excel_Reporter("URL enter after browser open", "Browser has to open", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
			  //================================================================
			  //================================================================	
		
		}
		else
		{
			
			  //===========================Reporter=============================
			  //================================================================
		      logger.log(LogStatus.FAIL,"URL enter","URL is not enter after browser open");
		      logger.log(LogStatus.FAIL,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
		      Excel_libraries.Excel_Reporter("URL is not enter after browser open", "Browser open but URL is not enter", "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
			  driver.quit();
		      //================================================================
			  //================================================================	
	    
		}
	}
	
	@Test(priority=2)
	public void Search() throws Throwable
	{
		
		//----------------------------------------------Start report test-------------------------------------------------
		testName	= new Object(){}.getClass().getEnclosingMethod().getName();
		logger 		= report1.startTest(testName);
		
		//-----------------------------------------Data initialization----------------------------------------------
		String Rental_company 		= Excel_libraries.Read("Rental_company","Bus_booking_data.xls");	
		String Car_type 			= Excel_libraries.Read("Car_type","Bus_booking_data.xls");
		String Pick_UP_Location		= Excel_libraries.Read("Pick_UP_Location","Bus_booking_data.xls");
		String Pick_UP_Date			= Excel_libraries.Read("Pick_UP_Date","Bus_booking_data.xls");
		String Return_Location		= Excel_libraries.Read("Return_Location","Bus_booking_data.xls");
		String Return_Date			= Excel_libraries.Read("Return_Date","Bus_booking_data.xls");
		String Drop_Time			= Excel_libraries.Read("Drop_Time","Bus_booking_data.xls");
		String Pick_Time			= Excel_libraries.Read("Pick_Time","Bus_booking_data.xls");
		
		Car_search Search_obj = new Car_search(driver,logger);
		Search_obj.Search(Drop_Time,Pick_Time,Rental_company, Car_type,Pick_UP_Location,Pick_UP_Date,Return_Location,Return_Date);
	}
	
	@Test(priority=3)
	public void Book() throws Throwable
	{
		
		//----------------------------------------------Start report test-------------------------------------------------
		testName	= new Object(){}.getClass().getEnclosingMethod().getName();
		logger 		= report1.startTest(testName);
			
		//-----------------------------------------Data initialization---------------------------------------------------
		String Car_type = Excel_libraries.Read("Car_type","Bus_booking_data.xls");
		
		Car_book Book_obj = new Car_book(driver,logger);
		Book_obj.Book(Car_type);
	}
	
	@Test(priority=4)
	public void Verify() throws Throwable
	{
		
		//----------------------------------------------Start report test-------------------------------------------------
		testName	= new Object(){}.getClass().getEnclosingMethod().getName();
		logger 		= report1.startTest(testName);
		
		//-----------------------------------------Data initialization---------------------------------------------------
		String First_Name	= Excel_libraries.Read("First_Name","Bus_booking_data.xls");
		String Last_Name	= Excel_libraries.Read("Last_Name","Bus_booking_data.xls");
		String Ph_number	= Excel_libraries.Read("Ph_number","Bus_booking_data.xls");
		String Email		= Excel_libraries.Read("Email","Bus_booking_data.xls");
		
		Rate_Price_verify Verify_obj = new Rate_Price_verify(driver, logger);
		Verify_obj.Rate_verify();
		Thread.sleep(3000);
		Verify_obj.Passenger_details(First_Name,Last_Name,Ph_number,Email);
	
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
		            report1.endTest(logger);
					report1.flush();
		            System.exit(1);
			  	} else if (result.getStatus() == ITestResult.SKIP) {
		        	logger.log(LogStatus.SKIP, "Test '"+ testName+ "' skipped : Cause>>"+ result.getThrowable(),logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
		        } else {
		        	logger.log(LogStatus.PASS, "Test  '"+ testName+"'  passed");
		        }	  
			 report1.endTest(logger);
			 report1.flush();
			    
		}

	@AfterClass
	public void Close() throws Throwable
	{
		E_time = System.nanoTime();
		
				//============================Reporter============================
				//================================================================
				logger.log(LogStatus.PASS,"Total Time Taken in Execution :", ""+(E_time-S_time)/1000000000+" second to run.");
				Utility_libraries.ATUReport_Pass("Step-9","No Data","Script take "+(E_time-S_time)/1000000000+" second to run.", "Script run successfully");
				Excel_libraries.Excel_Reporter("Script take "+(E_time-S_time)/1000000000+" second to run.", "Script run successfully", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
				//================================================================
				//================================================================
		
		driver.close();
	}
	
	public String Class_name()
	{
		
		return  driver.getClass().toString();	
	
	}
}


