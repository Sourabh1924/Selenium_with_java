package package_2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import libraries.Excel_libraries;
import libraries.Utility_libraries;

public class Hotel_booking {

	//-----------------------------------------Data initialization----------------------------------------------
	static WebDriver driver;                          // Create Driver instance
	static ExtentReports report1;                     // Create Reporter instance 
	static ExtentTest logger;						  // Create Logger instance
	static Element_lab1 Elem_obj ;			  		  // Create Class object
	static WebDriverWait wait;						  // Create wait object	
	public static String testName="Hotel_booking";	  // Create testname 
	static long S_time;								  // Start time of test
	static String Parent__window = "";				  // Create a Parent object
	static String Child_window = "";				  // Create a Child object
	static String Rum_price = "";					  // Store rum price
	static long E_time;								  // End time of test
	static String  Customer_name = "";				  // Store Customer price
	static String Email = "";						  // Store Email address
	static String Price = "";						  // Store Price
		
	@BeforeTest
	public void Create() throws Throwable {	 
		 
		//--------------------------------------Delete the previous folders---------------------------------------
		//Function_libraries.Delete_folder();
		//------------------------------------------Create class object------------------------------------------- 
		Elem_obj = new Element_lab1();		 
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
	public void Search_hotel() throws Throwable  {
			
		//----------------------------------------------Start report test-------------------------------------------------
		testName=new Object(){}.getClass().getEnclosingMethod().getName();
		logger = report1.startTest(testName);
		
		//-----------------------------------------Data initialization----------------------------------------------
		String Destination 		= Excel_libraries.Read("Destination","Hotel_booking_data.xls");
		String CheckIn_date 	= Excel_libraries.Read("CheckIn","Hotel_booking_data.xls");
		String CheckOut_date 	= Excel_libraries.Read("CheckOut","Hotel_booking_data.xls");
		
		//Click on Hotel link
		driver.findElement(Elem_obj.Hotel_link()).click();
		//Create Parent__window object
		Parent__window =  driver.getWindowHandle();	
		//Switching to frame
		WebElement frame = driver.findElement(Elem_obj.Switch_frame());
		driver.switchTo().frame(frame);
		//Enter Destination city
		driver.findElement(Elem_obj.Destination()).sendKeys(Destination);
		//Clear the date field
		driver.findElement(Elem_obj.Checkin()).clear();
		//Enter date field
		driver.findElement(Elem_obj.Checkin()).sendKeys(CheckIn_date);
		//Clear the date field
		driver.findElement(Elem_obj.Checkout()).clear();
		//Enter date field
		driver.findElement(Elem_obj.Checkout()).sendKeys(CheckOut_date);
		
				//===========================Reporter=============================
				//================================================================
	      		logger.log(LogStatus.PASS,"Step-2","Enter travelling details");
	      		logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
	      		//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
	      		Excel_libraries.Excel_Reporter("Enter travelling details", "Travelling details is enter", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
	      		//================================================================
	      		//================================================================	
		
	    //Enter search button
		driver.findElement(Elem_obj.Search()).click();
		Thread.sleep(5000);
	
	}

	@Test(priority=2)
	public void Select_hotel() throws Throwable  {
		
		//----------------------------------------------Start report test-------------------------------------------------
		testName=new Object(){}.getClass().getEnclosingMethod().getName();
		logger = report1.startTest(testName);
		
				//===========================Reporter=============================
				//================================================================
  				logger.log(LogStatus.PASS,"Step-3","Hotels details page will open.");
  				logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
  				//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
  				Excel_libraries.Excel_Reporter("Hotels details page will open.", "Hotels details page is open.", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
  				//================================================================
  				//================================================================	
  		
		//Switch to Parent__window
		driver.switchTo().defaultContent();
		//Create child window object
		Set<String> str = driver.getWindowHandles(); 
		//Store all the window instance for iterator 
		Iterator<String> itr = str.iterator();
		itr.next();
		Child_window = itr.next();
		//Switch to child window
		driver.switchTo().window(Child_window);
		//Click on any hotel in that page
		List<WebElement> lst = driver.findElements(Elem_obj.Hotel_click());
		lst.get(5).click();
	
	}
	
	@Test(priority=3)
	public void Select_Room() throws Throwable {
		
		//----------------------------------------------Start report test-------------------------------------------------
		testName=new Object(){}.getClass().getEnclosingMethod().getName();
		logger = report1.startTest(testName);
				
		//Create grand child window object
		Set<String> str1 = driver.getWindowHandles(); 
		//Store all the window instance for iterator 
		Iterator<String> itr1 = str1.iterator();
		itr1.next();
		itr1.next();
		String Grand_child_window = itr1.next();
		//Switch to grand child window
		driver.switchTo().window(Grand_child_window);
		Thread.sleep(10000);
		//Select the number of room 
//		WebElement Room = driver.findElement(Elem_obj.Room_select());
//		Select dropdown_room = new Select(Room);
//		dropdown_room.selectByIndex(1);
		Rum_price = driver.findElement(Elem_obj.Total_price()).getText();
		System.out.println(Rum_price);
		Thread.sleep(10000);
		
				//===========================Reporter=============================
				//================================================================
				logger.log(LogStatus.PASS,"Step-4","Select the room.");
				logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
				//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
				Excel_libraries.Excel_Reporter("Select the room.", "Room is selected.", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				//================================================================
				//================================================================	
			
		//Click on reserve button
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(Elem_obj.Reserve())).click().perform();
	}

	@Test(priority=4)
	public void Cust_details() throws Throwable {
		
		//----------------------------------------------Start report test-------------------------------------------------
		testName=new Object(){}.getClass().getEnclosingMethod().getName();
		logger = report1.startTest(testName);
				
		//-----------------------------------------Data initialization----------------------------------------------
		String Fname 	= Excel_libraries.Read("First_name","Hotel_booking_data.xls");
		String Lname 	= Excel_libraries.Read("Last_name","Hotel_booking_data.xls");
		String Title 	= Excel_libraries.Read("Title","Hotel_booking_data.xls");
		String Email 	= Excel_libraries.Read("Emails","Hotel_booking_data.xls");
		
		//Select title
		WebElement Surname = driver.findElement(Elem_obj.Title());
		Select dropdown_Surname = new Select(Surname);
		dropdown_Surname.selectByVisibleText(Title);
		//Enter first name
		driver.findElement(Elem_obj.Fname()).sendKeys(Fname);
		//Enter last name
		driver.findElement(Elem_obj.Lname()).sendKeys(Lname);
		Thread.sleep(10000);
		//Enter email address
		driver.findElement(Elem_obj.Email()).click();
		driver.findElement(Elem_obj.Email()).sendKeys(Email);
		//Enter re-email address
		driver.findElement(Elem_obj.Re_Email()).click();
		driver.findElement(Elem_obj.Re_Email()).sendKeys(Email);
		
				//===========================Reporter=============================
				//================================================================
				logger.log(LogStatus.PASS,"Step-5","Customer details will enter.");
				logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
				//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
				Excel_libraries.Excel_Reporter("Customer details will enter.", "Customer details is enter.", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				//================================================================
				//================================================================	
		
		//Click on booking button
		driver.findElement(Elem_obj.Submit()).click();
	}
	
	@Test(priority=5)
	public void Payment_details() throws Throwable {
			
		//----------------------------------------------Start report test-------------------------------------------------
		testName=new Object(){}.getClass().getEnclosingMethod().getName();
		logger = report1.startTest(testName);
				
		//-----------------------------------------Data initialization----------------------------------------------
		String Ph_number 		= Excel_libraries.Read("Ph_number","Hotel_booking_data.xls");
		String Card_number 		= Excel_libraries.Read("Card_number","Hotel_booking_data.xls");
		String Card_name 		= Excel_libraries.Read("Card_name","Hotel_booking_data.xls");
		String Card_exp_month 	= Excel_libraries.Read("Card_exp_month","Hotel_booking_data.xls");
		String Card_exp_year 	= Excel_libraries.Read("Card_exp_year","Hotel_booking_data.xls");
		
		
		//Save customer name
		Customer_name = driver.findElement(Elem_obj.Cust_name()).getText();
		//Save customer email address
		Email = driver.findElement(Elem_obj.Cust_address()).getText();
		//Save hotel price
		Price = driver.findElement(Elem_obj.Hotel_price()).getText();
		Price = Price.replace("US$", "").replace(" *", "");
		Rum_price = Rum_price.replace("US$", "");
		if(Price.equals(Rum_price))
		{
				//===========================Reporter=============================
				//================================================================
				logger.log(LogStatus.PASS,"Step-6","Room price is verified.");
				//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
				Excel_libraries.Excel_Reporter("Room price has to be same.", "Room price is same.", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				//================================================================
				//================================================================	
		}
		else
		{
				//===========================Reporter=============================
				//================================================================
				logger.log(LogStatus.FAIL,"Step-6","Room price is verified.");
				//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
				Excel_libraries.Excel_Reporter("Room price has to be same.", "Room price is not same.", "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				//================================================================
				//================================================================	
		}
		//Enter ph number
		driver.findElement(Elem_obj.Phone()).sendKeys(Ph_number);
		//Select card type
		WebElement Card_type = driver.findElement(Elem_obj.Card_type());
		Select dropdown_Card_type = new Select(Card_type);
		dropdown_Card_type.selectByVisibleText(Card_name);
		//Enter card number
		driver.findElement(Elem_obj.Card_num()).sendKeys(Card_number);
		//Select expiry month
		WebElement month = driver.findElement(Elem_obj.Exp_month());
		Select dropdown_month = new Select(month);
		dropdown_month.selectByVisibleText(Card_exp_month);
		//Select expiry year
		WebElement year = driver.findElement(Elem_obj.Exp_year());
		Select dropdown_year = new Select(year);
		dropdown_year.selectByVisibleText(Card_exp_year);
		
				//===========================Reporter=============================
				//================================================================
				logger.log(LogStatus.PASS,"Step-7","Customer details will enter.");
				logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
				//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
				Excel_libraries.Excel_Reporter("Customer details will enter.", "Customer details is enter.", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
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
		driver.switchTo().window(Child_window);
		driver.close();
		driver.switchTo().window(Parent__window);
		driver.close();
}

	@AfterSuite
	public void Zip_folder() throws Exception
	  {
//		  //---------------------------------It will generate TestNG report into Excel file------------
//		  org.automationtesting.excelreport.Xl.generateReport(Excel_libraries.Folder_path,"Excel_report.xlsx");
//		  //---------------------------------------------Create a Zip Folder--------------------------- 
//		  Utility_libraries.Zip_folder("Hotel_Booking");
	  }

}
