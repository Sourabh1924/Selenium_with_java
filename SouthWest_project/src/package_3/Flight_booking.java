package package_3;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


public class Flight_booking {


		//-----------------------------------------Data initialization----------------------------------------------
		static WebDriver driver;                          // Create Driver instance
		static ExtentReports report1;                     // Create Reporter instance 
		static ExtentTest logger;						  // Create Logger instance
		static Element_lab2 Elem_obj ;			  		  // Create Class object
		static WebDriverWait wait;						  // Create wait object	
		public static String testName="Flight_booking";	  // Create testname 
		static long S_time;								  // Start time of test
		static String Parent__window = "";				  // Create a Parent object
		static String Child_window = "";				  // Create a Child object
		static String Rum_price = "";					  // Store rum price
		static long E_time;								  // End time of test
		static String Price="";
		
		@BeforeTest
		public void Create() throws Throwable {	 
			 
			//--------------------------------------Delete the previous folders---------------------------------------
			//Function_libraries.Delete_folder();
			//------------------------------------------Create class object------------------------------------------- 
			Elem_obj = new Element_lab2();		 
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
			String Browser_name 	= Excel_libraries.Read("Browser_name","Flight_booking_data.xls");			// Browser name 
			String URL 				= Excel_libraries.Read("URL","Flight_booking_data.xls");					// Web site URL
			
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
		public void Search_flight() throws Throwable
		{
			
			//----------------------------------------------Start report test-------------------------------------------------
			testName=new Object(){}.getClass().getEnclosingMethod().getName();
			logger = report1.startTest(testName);
			
			String Departure 	= Excel_libraries.Read("Departure","Flight_booking_data.xls");
			String Arrival 		= Excel_libraries.Read("Arrival","Flight_booking_data.xls");
			String Date 		= Excel_libraries.Read("Date","Flight_booking_data.xls");
					
			//Click on one way
			driver.findElement(Elem_obj.One_way()).click();
			//Enter departure city
			driver.findElement(Elem_obj.Departure()).sendKeys(Departure);
			//Enter arrival city
			driver.findElement(Elem_obj.Arrival()).sendKeys(Arrival);
			//Enter travelling date
			driver.findElement(Elem_obj.Departure_date()).clear();
			driver.findElement(Elem_obj.Departure_date()).sendKeys(Date);
			
			 	//===========================Reporter=============================
			  	//================================================================
		      	logger.log(LogStatus.PASS,"Step-2","Travelling details are enters");
		      	logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
		      	//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
		      	Excel_libraries.Excel_Reporter("Travelling details will enters", "Travelling details is enters", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
		      	//================================================================
		      	//================================================================	
		      
			//Click on search
			driver.findElement(By.xpath("//button[@id='jb-booking-form-submit-button']")).click();
		
		}
		
		@Test(priority=2)
		public void Select_flight() throws Throwable
		{
			
			//----------------------------------------------Start report test-------------------------------------------------
			testName=new Object(){}.getClass().getEnclosingMethod().getName();
			logger = report1.startTest(testName);
			
			  
			try
			{
				driver.findElement(By.xpath("//tr[@id='outbound_flightRow_1']/descendant::td[@class='price_column']/descendant::span[contains(@class,'anytimeToBusinessSelect')]/following-sibling::div[contains(@class,'radioButton')]")).isDisplayed();
				driver.findElement(By.xpath("//tr[@id='outbound_flightRow_1']/descendant::td[@class='price_column']/descendant::span[contains(@class,'anytimeToBusinessSelect')]/following-sibling::div[contains(@class,'radioButton')]")).click();
			}
			catch(Exception e)
			{
				try
				{
					driver.findElement(By.xpath("//tr[@id='outbound_flightRow_2']/descendant::td[@class='price_column']/descendant::span[contains(@class,'anytimeToBusinessSelect')]/following-sibling::div[contains(@class,'radioButton')]")).isDisplayed();
					driver.findElement(By.xpath("//tr[@id='outbound_flightRow_2']/descendant::td[@class='price_column']/descendant::span[contains(@class,'anytimeToBusinessSelect')]/following-sibling::div[contains(@class,'radioButton')]")).click();
				}
				catch(Exception f)
				{
					try
					{
						driver.findElement(By.xpath("//tr[@id='outbound_flightRow_3']/descendant::td[@class='price_column']/descendant::span[contains(@class,'anytimeToBusinessSelect')]/following-sibling::div[contains(@class,'radioButton')]")).isDisplayed();
						driver.findElement(By.xpath("//tr[@id='outbound_flightRow_3']/descendant::td[@class='price_column']/descendant::span[contains(@class,'anytimeToBusinessSelect')]/following-sibling::div[contains(@class,'radioButton')]")).click();
					}
					catch(Exception g)
					{
						
					}
				}
			}
			Thread.sleep(5000);
			//Select first flight
			driver.findElement(Elem_obj.Flight_select()).click();
			
			
					//===========================Reporter=============================
		  			//================================================================
	      			logger.log(LogStatus.PASS,"Step-3","First flight is selected");
	      			logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
	      			//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
	      			Excel_libraries.Excel_Reporter("First flight will select", "First flight is selected", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
	      			//================================================================
	      			//================================================================	
	      	
	      	
			//Click on submit
			driver.findElement(Elem_obj.Submit_button()).click();
			//Store flight price
			Price = driver.findElement(Elem_obj.Flight_price()).getText();		
			Price = Price.replace("$", "");
			//Click on submit
			driver.findElement(Elem_obj.Book_button()).click();
		}
		
		@Test(priority=3)
		public void Customer_details() throws Throwable
		{
			
			//----------------------------------------------Start report test-------------------------------------------------
			testName=new Object(){}.getClass().getEnclosingMethod().getName();
			logger = report1.startTest(testName);
			
			//-----------------------------------------Data initialization----------------------------------------------
			String Fname 		= Excel_libraries.Read("Fname","Flight_booking_data.xls");
			String Lname 		= Excel_libraries.Read("Lname","Flight_booking_data.xls");
			String DOB_month 	= Excel_libraries.Read("DOB_month","Flight_booking_data.xls");
			String DOB_day 		= Excel_libraries.Read("DOB_day","Flight_booking_data.xls");
			String DOB_year 	= Excel_libraries.Read("DOB_year","Flight_booking_data.xls");
			String Gender 		= Excel_libraries.Read("Gender","Flight_booking_data.xls");
			String Email 		= Excel_libraries.Read("Email","Flight_booking_data.xls");
			
			
			Thread.sleep(6000);
			//Enter fname
			driver.findElement(Elem_obj.Fname()).sendKeys(Fname);
			//Enter lname
			driver.findElement(Elem_obj.Lname()).sendKeys(Lname);
			//Select customer DOB month
			WebElement month = driver.findElement(Elem_obj.DOB_month());
			Select dropdown_Card_type1 = new Select(month);
			dropdown_Card_type1.selectByVisibleText(DOB_month);
			//Select customer DOB day
			WebElement day = driver.findElement(Elem_obj.DOB_day());
			Select dropdown_Card_type2 = new Select(day);
			dropdown_Card_type2.selectByVisibleText(DOB_day);
			//Select customer DOB year
			WebElement year = driver.findElement(Elem_obj.DOB_year());
			Select dropdown_Card_type3 = new Select(year);
			dropdown_Card_type3.selectByVisibleText(DOB_year);
			//Select gender
			WebElement Gend = driver.findElement(Elem_obj.Gender());
			Select dropdown_Card_type4 = new Select(Gend);
			dropdown_Card_type4.selectByVisibleText(Gender);
			//Select email
			driver.findElement(Elem_obj.Email()).sendKeys(Email);
			
			
					//===========================Reporter=============================
		  			//================================================================
	      			logger.log(LogStatus.PASS,"Step-4","Travelling details are enters");
	      			logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
	      			//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
	      			Excel_libraries.Excel_Reporter("Travelling details will enters", "Travelling details is enters", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
	      			//================================================================
	      			//================================================================	
		
	      			
		}
		
		@Test(priority=4)
		public void Payment_details() throws Throwable
		{
			
			//----------------------------------------------Start report test-------------------------------------------------
			testName=new Object(){}.getClass().getEnclosingMethod().getName();
			logger = report1.startTest(testName);
			
			//-----------------------------------------Data initialization----------------------------------------------
			String Card_type 		= Excel_libraries.Read("Card_type","Flight_booking_data.xls");
			String Card_number 		= Excel_libraries.Read("Card_number","Flight_booking_data.xls");
			String Exp_month 		= Excel_libraries.Read("Exp_month","Flight_booking_data.xls");
			String Exp_year 		= Excel_libraries.Read("Exp_year","Flight_booking_data.xls");
			
			
			//Select card type
			WebElement Cardtype = driver.findElement(Elem_obj.Card_type());
			Select dropdown_Card_type5 = new Select(Cardtype);
			dropdown_Card_type5.selectByVisibleText(Card_type);
			//Enter card number
			driver.findElement(Elem_obj.Card_number()).sendKeys(Card_number);
			//Select card expiry month
			WebElement Emonth = driver.findElement(Elem_obj.Expiry_month());
			Select dropdown_Card_type6 = new Select(Emonth);
			dropdown_Card_type6.selectByVisibleText(Exp_month);
			//Select card expiry year
			WebElement Eyear = driver.findElement(Elem_obj.Expiry_year());
			Select dropdown_Card_type7 = new Select(Eyear);
			dropdown_Card_type7.selectByVisibleText(Exp_year);
			
			
					//===========================Reporter=============================
  					//================================================================
  					logger.log(LogStatus.PASS,"Step-5","Payment details is enters");
  					logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
  					//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
  					Excel_libraries.Excel_Reporter("Payment details will enters", "Payment details is enters", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
  					//================================================================
  					//================================================================	
  			
  			
			//Store flight ticket price
			String total_price = driver.findElement(Elem_obj.Total_price()).getText();
			total_price = total_price.replace("$", "");
				if(total_price.equals(Price))
				{
				
						//===========================Reporter=============================
						//================================================================
						logger.log(LogStatus.PASS,"Step-6","Price is verified");
						//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
						Excel_libraries.Excel_Reporter("Price will be same", "Price have to be same", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
						//================================================================
						//================================================================	
				}
				else
				{
						//===========================Reporter=============================
						//================================================================
						logger.log(LogStatus.FAIL,"Step-6","Price is not verified");
						//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
						Excel_libraries.Excel_Reporter("Price will be same", "Price is not same", "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
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
		public void Zip_folder()
		  {
//			  //---------------------------------It will generate TestNG report into Excel file------------
//			  org.automationtesting.excelreport.Xl.generateReport(Excel_libraries.Folder_path,"Excel_report.xlsx");
//			  //---------------------------------------------Create a Zip Folder--------------------------- 
//			  Utility_libraries.Zip_folder("Hotel_Booking");
		  }

}	
		
		

