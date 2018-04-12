package package_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import libraries.Excel_libraries;
import libraries.Utility_libraries;

public class Car_booking {

	//-----------------------------------------Data initialization----------------------------------------------
	static WebDriver driver;                          // Create Driver instance
	static ExtentReports report1;                     // Create Reporter instance 
	static ExtentTest logger;						  // Create Logger instance
	static Element_Lab Elem_obj ;			  		  // Create Class object
	static WebDriverWait wait;						  // Create wait object	
	public static String testName="Bus_booking";	  // Create testname 
	static long S_time;								  // Start time of test
	static long E_time;								  // End time of test
	String Class_name= Car_booking.class.getName().toString();
	
	
	public static void Class_name ()
	{
		Car_booking.class.toString();
		System.out.println(Car_booking.class.toString());
	}
	
	@BeforeTest
	public void Create() throws Throwable {	 
		
		//--------------------------------------Delete the previous folders---------------------------------------
		//Function_libraries.Delete_folder();
		//------------------------------------------Create class object------------------------------------------- 
		Elem_obj = new Element_Lab();		 
		//--------------------------------------------Calling report-----------------------------------------------
		report1=Utility_libraries.Report();
		//------------------------------------------Create a Excel file--------------------------------------------
		Excel_libraries.Create_Excel_file();  	
		}
	
	@Test(priority=0)
	public void Launch() throws Throwable {
		
		//----------------------------------------------Start report test-------------------------------------------------
		testName=new Object(){}.getClass().getEnclosingMethod().getName();
		logger = report1.startTest(testName);
		    
		//-----------------------------------------Data initialization----------------------------------------------
		String Browser_name 	= Excel_libraries.Read("Browser_name","Bus_booking_data.xls");			// Browser name 
		String URL 				= Excel_libraries.Read("URL","Bus_booking_data.xls");					// Web site URL
		
		//---------------------------------------------- Start time------------------------------------------------
		S_time = System.nanoTime();
		//-------------------------------------------Launch Firefox driver-----------------------------------------
		driver=Utility_libraries.getBrowser(Browser_name);
		//-------------------------------------------------Enter URL----------------------------------------------
		driver.navigate().to(URL);
		//----------------------------------------Wait statement is initialize------------------------------------
		wait = new WebDriverWait(driver,30);
		
		if(driver.getCurrentUrl().equals(URL) )
		{
			
			  //===========================Reporter=============================
			  //================================================================
		      logger.log(LogStatus.PASS,"Step-1","URL enter after browser open");
		      logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
		      //Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
		      Excel_libraries.Excel_Reporter("URL enter after browser open", "Browser has to open", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
			  //================================================================
			  //================================================================	
		
		}
		else
		{
			
			  //===========================Reporter=============================
			  //================================================================
		      logger.log(LogStatus.FAIL,"Step-1","URL is not enter after browser open");
		      logger.log(LogStatus.FAIL,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
		      //Function_libraries.ATUReport_Fail("Step-1",URL,"URL is not enter after browser open", "Browser open but URL is not enter");
		      Excel_libraries.Excel_Reporter("URL is not enter after browser open", "Browser open but URL is not enter", "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
			  //================================================================
			  //================================================================	
	    
		}
	  
	}
	
	@Test(priority=1)
	public void Car_search() throws Throwable
	{
			
			//----------------------------------------------Start report test-------------------------------------------------
			testName=new Object(){}.getClass().getEnclosingMethod().getName();
			logger = report1.startTest(testName);
		
			//-----------------------------------------Data initialization----------------------------------------------
			String Pick_UP_Location 	= Excel_libraries.Read("Pick_UP_Location","Bus_booking_data.xls");
			String Pick_UP_Date 		= Excel_libraries.Read("Pick_UP_Date","Bus_booking_data.xls");
			String Return_Location 		= Excel_libraries.Read("Return_Location","Bus_booking_data.xls");
			String Return_Date 			= Excel_libraries.Read("Return_Date","Bus_booking_data.xls");
			
			
			driver.findElement(Elem_obj.Cartab_element()).click();	
			Thread.sleep(2000);
			driver.findElement(Elem_obj.Pick_UP_Location_element()).sendKeys(Pick_UP_Location);
			driver.findElement(Elem_obj.Carpickup_element()).clear();
			driver.findElement(Elem_obj.Pick_UP_Date_element()).sendKeys(Pick_UP_Date);
			driver.findElement(Elem_obj.CartimePickup_element()).click();
			driver.findElement(Elem_obj.CartimePickupmenu_element()).click();
			driver.findElement(Elem_obj.vendors_element()).click();
			driver.findElement(Elem_obj.vendormenu_element()).click();
			Thread.sleep(2000);
			driver.findElement(Elem_obj.Return_Location_element()).sendKeys(Return_Location);
			driver.findElement(Elem_obj.Dropoffdate_element()).clear();
			driver.findElement(Elem_obj.Return_Date_element()).sendKeys(Return_Date);
			Thread.sleep(2000);
			
			
					//===========================Reporter=============================
			  		//================================================================
		      		logger.log(LogStatus.PASS,"Step-2","Search details are enter");
		      		logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
		      		//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
		      		Excel_libraries.Excel_Reporter("Search details will enter", "Search details is enter", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
		      		//================================================================
		      		//================================================================	
		      		
		      		
			driver.findElement(Elem_obj.Searchbutton_element()).click();
				
	}
		
	@Test(priority=2)
	public void Car_book() throws Throwable
		{
			
			//----------------------------------------------Start report test-------------------------------------------------
			testName=new Object(){}.getClass().getEnclosingMethod().getName();
			logger = report1.startTest(testName);
		
			wait.until(ExpectedConditions.presenceOfElementLocated(Elem_obj.Continuebutton_element()));			 
			driver.findElement(Elem_obj.CarInfo_element()).click();
			driver.findElement(Elem_obj.Continuebutton_element()).click();
			driver.findElement(Elem_obj.SubmitButton_element()).click();
			
	}
		
	@Test(priority=3)
	public void Customer_details() throws Throwable
	{
			
			//----------------------------------------------Start report test-------------------------------------------------
			testName=new Object(){}.getClass().getEnclosingMethod().getName();
			logger = report1.startTest(testName);
		
			//-----------------------------------------Data initialization----------------------------------------------
			String Driver_First_Name 	= Excel_libraries.Read("Driver_First_Name","Bus_booking_data.xls");
			String Driver_Last_Name 	= Excel_libraries.Read("Driver_Last_Name","Bus_booking_data.xls");
			
			driver.findElement(Elem_obj.DriverFirstname_element()).sendKeys(Driver_First_Name);
			driver.findElement(Elem_obj.DriverLastname_element()).sendKeys(Driver_Last_Name);
			
			
					//===========================Reporter=============================
	  				//================================================================
      				logger.log(LogStatus.PASS,"Step-3","Customer details is enter");
      				logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
      				//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
      				Excel_libraries.Excel_Reporter("Customer details will enter", "Customer details is enter", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
      				//================================================================
      				//================================================================	
		
		
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
			            Excel_libraries.Excel_Reporter(""+result.getThrowable() , "Condition must be fullfill", "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				  	} else if (result.getStatus() == ITestResult.SKIP) {
			        	logger.log(LogStatus.SKIP, "Test '"+ testName+ "' skipped : Cause>>"+ result.getThrowable(),logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
			        } else {
			        	logger.log(LogStatus.PASS, "Test  '"+ testName+"'  passed");
			        }	  
				 report1.endTest(logger);
				 report1.flush();
				    
	}
		
	@AfterTest
	public void Close() throws Throwable {
			
			//---------------------------------------------------End time--------------------------------
			E_time = System.nanoTime();
					
					//============================Reporter============================
					//================================================================
					report1.addSystemInfo("Total Time Taken in Execution :", ""+(E_time-S_time)/1000000000+" second to run.");
					//Function_libraries.ATUReport_Pass("Step-9","No Data","Script take "+(E_time-S_time)/1000000000+" second to run.", "Script run successfully");
					Excel_libraries.Excel_Reporter("Script take "+(E_time-S_time)/1000000000+" second to run.", "Script run successfully", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
					//================================================================
					//================================================================
					
			driver.close();
			
	}

}
