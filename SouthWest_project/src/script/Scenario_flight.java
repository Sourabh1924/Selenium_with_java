package script;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import flight_secenerio.Flight_search;
import flight_secenerio.Passenger;
import flight_secenerio.Payment;
import flight_secenerio.Price_verify;
import flight_secenerio.Travel_by_availiblity;
import libraries.Excel_libraries;
import libraries.Utility_libraries;
import package_3.Element_lab2;

public class Scenario_flight {

	//-----------------------------------------Data initialization----------------------------------------------
	double Total_price1;
	double Adu_ticket_price;
	double Sen_ticket_price;
	String Total_price;
	
	String Total_credit;
	double Total_fare;
	String Total_Cus_fare;
	static long S_time;								  
	static long E_time;
	public static String testName="Flight_booking";	  
	
	//-----------------------------------------Object initialization----------------------------------------------
	WebDriver driver;
	static ExtentReports report1;                     
	static ExtentTest logger;						 
	static Element_lab2 Elem_obj ;
	
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
	
	@Test(priority=1)
	public void Launch() throws Throwable
	{
		//----------------------------------------------Start report test-------------------------------------------------
		testName	= new Object(){}.getClass().getEnclosingMethod().getName();
		logger 		= report1.startTest(testName);
		    
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
	public void Flight_Search() throws Throwable
	{
		
		//-----------------------------------------Data initialization----------------------------------------------
		String Tour_type = Excel_libraries.Read("Tour_type","Flight_booking_data.xls");
		String Adult_pass = Excel_libraries.Read("Adult_pass","Flight_booking_data.xls");
		String Senior_pass = Excel_libraries.Read("Senior_pass","Flight_booking_data.xls");
		
		//----------------------------------------------Start report test-------------------------------------------------
		testName=new Object(){}.getClass().getEnclosingMethod().getName();
		logger = report1.startTest(testName);
				
		//Flight search
		Flight_search search = new Flight_search(driver, logger);
		search.Search(Tour_type,Adult_pass,Senior_pass);
		
	}
	
	@Test(priority=3)
	public void Flight_Select() throws Throwable
	{
		
		//-----------------------------------------Data initialization----------------------------------------------
		String Tour_type 			= Excel_libraries.Read("Tour_type","Flight_booking_data.xls");
		String Flight_type 			= Excel_libraries.Read("Flight_type","Flight_booking_data.xls");
		String Travel_class_out 	= Excel_libraries.Read("Travel_class_out","Flight_booking_data.xls");
		String Travel_class_in 		= Excel_libraries.Read("Travel_class_in","Flight_booking_data.xls");
		String Travel_class_sen_out = Excel_libraries.Read("Travel_class_sen_out","Flight_booking_data.xls");
		String Travel_class_sen_in 	= Excel_libraries.Read("Travel_class_sen_in","Flight_booking_data.xls");
		
		//----------------------------------------------Start report test-------------------------------------------------
		testName = new Object(){}.getClass().getEnclosingMethod().getName();
		logger 	 = report1.startTest(testName);
				
		//Select Non Stop or Direct
		try {
				if(Flight_type.toLowerCase().equals("non stop"))
				{
					driver.findElement(Elem_obj.Non_stop()).click();
					
						//===========================Reporter=============================
		  				//================================================================
		  				logger.log(LogStatus.PASS,"Checkbox select","Non stop checkbox is selected");
		  				Excel_libraries.Excel_Reporter("Checkbox select","Non stop checkbox is selected", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
		  				//================================================================
		  				//================================================================
				
				}
				else
				{
					driver.findElement(Elem_obj.Direct()).click();
					
						//===========================Reporter=============================
		  				//================================================================
		  				logger.log(LogStatus.PASS,"Checkbox select","Direct checkbox is selected");
		  				Excel_libraries.Excel_Reporter("Checkbox select","Direct checkbox is selected", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
		  				//================================================================
		  				//================================================================
		  			
				}
			}
			catch(Exception e) {
				
				//===========================Reporter=============================
	  			//================================================================
	  			logger.log(LogStatus.PASS,"Checkbox select","Direct/Non stop checkbox is not available");
	  			Excel_libraries.Excel_Reporter("Checkbox select","Direct/Non stop checkbox is not available", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
	  			//================================================================
	      		//================================================================
	  			
			}
		
		//Select the adult travelling class and tour type
		if(Tour_type.toLowerCase().equals("oneway"))
		{
			Travel_by_availiblity Flight = new Travel_by_availiblity(driver,logger,report1);
			Flight.Select_Outgoing_Flight(Travel_class_out);
		}
		else
		{
			Travel_by_availiblity Flight = new Travel_by_availiblity(driver,logger,report1);
			Flight.Select_Outgoing_Flight(Travel_class_out);
			Flight.Select_Return_Flight(Travel_class_in);
		}
		
		  		//===========================Reporter=============================
		  		//================================================================
	      		logger.log(LogStatus.PASS,"Adult seat","Adult passenger seat is booked");
	      		logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
	      		Excel_libraries.Excel_Reporter("Adult seat","Adult passenger seat is booked", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
	      		//================================================================
	      		//================================================================
	      
		driver.findElement(Elem_obj.Submit_button()).click();
		
		//Select the senior travelling class and tour type
		try
		{
			driver.findElement(By.xpath("//strong[contains(text(),'Senior Passenger')]")).isDisplayed();
			if(Tour_type.toLowerCase().equals("oneway"))
			{
				Travel_by_availiblity Flight = new Travel_by_availiblity(driver,logger,report1);
				Flight.Select_Senior_Out(Travel_class_sen_out);
			}
			else
			{
				Travel_by_availiblity Flight = new Travel_by_availiblity(driver,logger,report1);
				Flight.Select_Senior_Out(Travel_class_sen_out);
				Flight.Select_Senior_Return(Travel_class_sen_in);
			}	
			
					//===========================Reporter=============================
  					//================================================================
  					logger.log(LogStatus.PASS,"Senior citizen seat","Citizen passenger seat is booked");
  					logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
  					Excel_libraries.Excel_Reporter("Senior citizen seat","Citizen passenger seat is booked", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
  					//================================================================
  					//================================================================
  	
  			driver.findElement(Elem_obj.Submit_button()).click();
		}
		catch(Exception e){}
	}
	
	@Test(priority=4)
	public void Price_verification() throws Throwable
	{
		
		//-----------------------------------------Data initialization----------------------------------------------
		String Adult_pass 	= Excel_libraries.Read("Adult_pass","Flight_booking_data.xls");
		String Senior_pass 	= Excel_libraries.Read("Senior_pass","Flight_booking_data.xls");
		double Total_Cus_fare1;
		double Total_credit1;
		double Total_payment;
		
		//----------------------------------------------Start report test-------------------------------------------------
		testName=new Object(){}.getClass().getEnclosingMethod().getName();
		logger = report1.startTest(testName);
				
		if(Integer.parseInt(Adult_pass)>=1)
		{
			Price_verify verfication = new Price_verify(driver);
			Adu_ticket_price=verfication.Adult_price_verify(Integer.parseInt(Adult_pass));
			
			  //===========================Reporter=============================
			  //================================================================
		      logger.log(LogStatus.PASS,"Price_verify","Adult ticket price is "+Adu_ticket_price+"$");
		      Excel_libraries.Excel_Reporter("Price_verify","Adult ticket price is "+Adu_ticket_price+"$", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
			  //================================================================
			  //================================================================	
		      
		}
		else
		{
			  //===========================Reporter=============================
			  //================================================================
		      logger.log(LogStatus.FAIL,"Price_verify","Adult ticket price not verified");
		      Excel_libraries.Excel_Reporter("Price_verify","Adult ticket price not verified", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
		      //================================================================
			  //================================================================	
		}
		
		if(Integer.parseInt(Senior_pass)>=1)
		{
			Price_verify verfication = new Price_verify(driver);
			Sen_ticket_price = verfication.Senior_price_verify(Integer.parseInt(Senior_pass));
			
			  //===========================Reporter=============================
			  //================================================================
		      logger.log(LogStatus.PASS,"Price_verify","Senior ticket price is "+Sen_ticket_price+"$");
		      Excel_libraries.Excel_Reporter("Price_verify","Senior ticket price is "+Sen_ticket_price+"$", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
			  //================================================================
			  //================================================================	
		}
		else
		{
			  //===========================Reporter=============================
			  //================================================================
		      logger.log(LogStatus.PASS,"Price_verify","Senior ticket price is not verified");
		      Excel_libraries.Excel_Reporter("Price_verify","Senior ticket price is not verified", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
			  //================================================================
			  //================================================================	
		}
		
		Total_Cus_fare = driver.findElement(Elem_obj.Total_Cus_fare()).getText().replace("$", "").replace(",", "");
		Total_Cus_fare1 = Double.parseDouble(Total_Cus_fare);
		Total_fare= Adu_ticket_price + Sen_ticket_price;
		if(Double.compare(Math.round(Total_fare),Math.round(Total_Cus_fare1)) == 0)
		{
			System.out.println("Both price are same");
		}
		
		Total_credit = driver.findElement(Elem_obj.Total_credit()).getText().replace("-$", "");
		Total_credit1 = Double.parseDouble(Total_credit);
		Total_payment = Total_fare-Total_credit1;
				
				//===========================Reporter=============================
				//================================================================
				logger.log(LogStatus.PASS,"Credit amount","Total payment= "+Total_payment+" Total credit amount= "+Total_credit1);
				//================================================================
	  			//================================================================		
				
		driver.findElement(Elem_obj.Book_button()).click();
	}
	
	@Test(priority=5)
	public void Passenger_select() throws Throwable
	{
		
		//-----------------------------------------Data initialization----------------------------------------------
		String Passenger = Excel_libraries.Read("Passenger","Flight_booking_data.xls");
		
		//----------------------------------------------Start report test-------------------------------------------------
		testName=new Object(){}.getClass().getEnclosingMethod().getName();
		logger = report1.startTest(testName);
		
		Passenger obj = new Passenger();
		obj.Passenger_details(Passenger, driver);
	
			//===========================Reporter=============================
  			//================================================================
  			logger.log(LogStatus.PASS,"Passenger details","All passengers details are enter.");
  			logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
  			Excel_libraries.Excel_Reporter("Passenger details","All passengers details are enter.", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
  			//================================================================
  			//================================================================
	
	}

	@Test(priority=6)
	public void Pay() throws Throwable
	{
		
		//-----------------------------------------Data initialization----------------------------------------------
		String Payment_method = Excel_libraries.Read("Payment_method","Flight_booking_data.xls");
		String Confirmation_receipt = Excel_libraries.Read("Confirmation_receipt","Flight_booking_data.xls"); 
		
		//----------------------------------------------Start report test-------------------------------------------------
		testName=new Object(){}.getClass().getEnclosingMethod().getName();
		logger = report1.startTest(testName);
				
		//Price verfication
		Total_price = driver.findElement(Elem_obj.Total_cart_price()).getText().replace("$", "");
		Total_price1 = Double.parseDouble(Total_price);
		if(Double.compare(Math.round(Total_price1),Math.round(Total_fare))==0)
		{
			
			
				//===========================Reporter=============================
	  			//================================================================
      			logger.log(LogStatus.PASS,"Travelling price","Air Total= "+Math.round(Total_price1)+" Trip Total= "+Math.round(Total_fare));
      			logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
      			Excel_libraries.Excel_Reporter("Travelling price","Air Total= "+Math.round(Total_price1)+" Trip Total= "+Math.round(Total_fare), "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
      			//================================================================
      			//================================================================
		
		
		}
		else
		{
			
				//===========================Reporter=============================
	  			//================================================================
				logger.log(LogStatus.FAIL,"Travelling price","Air Total= "+Math.round(Total_price1)+" Trip Total= "+Math.round(Total_fare));
      			logger.log(LogStatus.FAIL,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
      			Excel_libraries.Excel_Reporter("Travelling price","Air Total= "+Math.round(Total_price1)+" Trip Total= "+Math.round(Total_fare), "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
      			//================================================================
      			//================================================================
		
		}
		
		Payment Payment = new Payment(driver);
		Payment.Payment_method(Payment_method, Confirmation_receipt);
		
		
				//===========================Reporter=============================
  				//================================================================
  				logger.log(LogStatus.PASS,"Payment method","Payment method is selected.");
  				logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
  				Excel_libraries.Excel_Reporter("Payment method","Payment method is selected.", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
  				//================================================================
  				//================================================================
	
	
	}
	
	@AfterMethod	
	public void Flush(ITestResult result) 
		
	  {
			if(result.getStatus()==ITestResult.FAILURE) 
			{ 
				
				logger.log(LogStatus.FAIL,"Error :"+result.getThrowable());//+report.getClass()+" Test "+logger.getTest().statusMessage);//,ClassTest.takeScreenShot());
				
			}		
			  if (result.getStatus() == ITestResult.FAILURE) {
		            try {
						logger.log(LogStatus.FAIL, "Test '"+ testName+ "' Failed : Cause>>"+result.getThrowable(),logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
					} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            try {
						Excel_libraries.Excel_Reporter( ""+result.getThrowable()+"" , "Condition must be fullfill", "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
					} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            report1.endTest(logger);
					report1.flush();
		            System.exit(1);
			  	} else if (result.getStatus() == ITestResult.SKIP) {
		        	try {
						logger.log(LogStatus.SKIP, "Test '"+ testName+ "' skipped : Cause>>"+ result.getThrowable(),logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
					} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        } else {
		        	logger.log(LogStatus.PASS, "Test  '"+ testName+"'  passed");
		        }	  
			 report1.endTest(logger);
			 report1.flush();
			    
		}

	@AfterClass
	public void Close() 
	{
		E_time = System.nanoTime();
		
				//============================Reporter============================
				//================================================================
				logger.log(LogStatus.PASS,"Total Time Taken in Execution :", ""+(E_time-S_time)/1000000000+" second to run.");
					try {
						Excel_libraries.Excel_Reporter("Script take "+(E_time-S_time)/1000000000+" second to run.", "Script run successfully", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
					} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				//================================================================
				//================================================================
		
		driver.close();
	}

}
