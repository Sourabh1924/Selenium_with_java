package script;

import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import hotel_secenerio.Customer_details;
import hotel_secenerio.Hotel_Room_select;
import hotel_secenerio.Hotel_Search;
import hotel_secenerio.Payment;
import libraries.Excel_libraries;
import libraries.Utility_libraries;
import package_2.Element_lab1;

public class Scenario_hotel {

	WebDriver driver;
	ExtentReports report1;                      
	ExtentTest logger;						 
	Element_lab1 Elem_obj ;			  		  
	WebDriverWait wait;	
	
	//-----------------------------------------Data initialization----------------------------------------------
	String Price;
	String[] object;
	String Grand_child;
	String Total_price;				   
	long S_time;
	long E_time;
	public static String testName="Hotel_booking";	
	
	@BeforeTest
	public void Create() throws Throwable {	 
		 
		//--------------------------------------Delete the previous folders---------------------------------------
		//Function_libraries.Delete_folder();
		//------------------------------------------Create class object------------------------------------------- 
		//Elem_obj = new Element_lab1();		 
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
		String Browser_name 	= Excel_libraries.Read("Browser_name","Hotel_booking_data.xls");			// Browser name 
		String URL 				= Excel_libraries.Read("URL","Hotel_booking_data.xls");					// Web site URL
		
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
		      logger.log(LogStatus.PASS,"URL enter","URL enter after browser open");
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
		      logger.log(LogStatus.FAIL,"URL enter","URL is not enter after browser open");
		      logger.log(LogStatus.FAIL,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
		      //Function_libraries.ATUReport_Fail("Step-1",URL,"URL is not enter after browser open", "Browser open but URL is not enter");
		      Excel_libraries.Excel_Reporter("URL is not enter after browser open", "Browser open but URL is not enter", "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
			  //================================================================
			  //================================================================	
	    
		}
	  
	}
		
	@Test(priority=1)
	public void Hotel_search() throws Throwable 
	{
	
		//----------------------------------------------Start report test-------------------------------------------------
		testName=new Object(){}.getClass().getEnclosingMethod().getName();
		logger = report1.startTest(testName);
				
		Hotel_Search Search_obj = new Hotel_Search(driver,logger);
		try {
			object = Search_obj.Search();
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try
		{
			driver.findElement(By.xpath("//div[@id='disambBlock_region']/div[2]/div[2]")).click();
				
					  //===========================Reporter=============================
					  //================================================================
				      logger.log(LogStatus.PASS,"Hotel page","Hotel select page is open.");
				      logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
				      //Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
				      Excel_libraries.Excel_Reporter("Hotel page","Hotel select page is open.", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
					  //================================================================
					  //================================================================
		
		}
		catch(Exception e)
		{
			
					  //===========================Reporter=============================
					  //================================================================
				      logger.log(LogStatus.PASS,"Hotel page","Hotel select page is open.");
				      logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
				      //Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
				      Excel_libraries.Excel_Reporter("Hotel page","Hotel select page is open.", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
					  //================================================================
					  //================================================================
		
		}	
	}

	@Test(priority=2)
	public void Hotel_room_select() throws Throwable 
	{
		
		//----------------------------------------------Start report test-------------------------------------------------
		testName=new Object(){}.getClass().getEnclosingMethod().getName();
		logger = report1.startTest(testName);
		
		//-----------------------------------------Data initialization---------------------------------------------------
		String Hotel_name=Excel_libraries.Read("Hotel_name","Hotel_booking_data.xls");
		String Senerio=Excel_libraries.Read("Senerio","Hotel_booking_data.xls");;
		
		Hotel_Room_select Room = new Hotel_Room_select(driver,logger);
		try {
			Grand_child = Room.Hotel_select(Senerio,Hotel_name);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority=3)
	public void Customer_details()
	{
		
		//----------------------------------------------Start report test-------------------------------------------------
		testName=new Object(){}.getClass().getEnclosingMethod().getName();
		logger = report1.startTest(testName);
		
		Customer_details Details = new Customer_details(driver,logger);
		try {
			Price = Details.Passenger_details();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=4)
	public void Payment_details() throws Throwable
	{
		
		//----------------------------------------------Start report test-------------------------------------------------
		testName=new Object(){}.getClass().getEnclosingMethod().getName();
		logger = report1.startTest(testName);
		
		Payment Payment_obj = new Payment(driver);
		Total_price =Payment_obj.Payment_details(Price);
		
		if(Price.equals(Total_price))
		{
			
					  //===========================Reporter=============================
					  //================================================================
				      logger.log(LogStatus.PASS,"Price verfication","Price of hotel booking is $"+Price+" Total price of room booking is $"+Total_price);
				      logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
				      //Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
				      Excel_libraries.Excel_Reporter("Price verfication","Price of hotel booking is $ "+Price+" Total price of room booking is $ "+Total_price, "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				      //================================================================
					  //================================================================
		
		}
		else
		{
			
					  //===========================Reporter=============================
					  //================================================================
				      logger.log(LogStatus.FAIL,"Price verfication","Price of hotel booking is $"+Price+" Total price of room booking is $"+Total_price);
				      logger.log(LogStatus.FAIL,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
				      //Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
				      Excel_libraries.Excel_Reporter("Price verfication","Price of hotel booking is $"+Price+" Total price of room booking is $"+Total_price, "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
					  //================================================================
					  //================================================================
		
		}
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
	            System.exit(1);
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
				
		driver.switchTo().window(Grand_child);
		driver.close();
		driver.switchTo().window(object[1]);
		driver.close();
		driver.switchTo().window(object[0]);
		driver.close();
		driver.quit();
		
	}

}
