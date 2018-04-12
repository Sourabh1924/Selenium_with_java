package make_my_trip;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class MMT_TestNGaa {

  //-----------------------------------------Data initialization----------------------------------------------
  static WebDriver driver;                          // Create driver instance
  static ExtentReports report1;                     // Create reporter instance 
  static ExtentTest logger;							// Create logger instance
  static Element_libraries Elem_obj ;				// Create Class object
  static WebDriverWait wait;						// Create wait object	
  public static String testName="MMT_TestNGaa";		// Create testname 
  private static int Total_Fare;					// Store total travelling fare
  static long S_time;								// Start time of test
  static long E_time;								// End time of test
  static int price;									// Store price of ticket
 

 @BeforeSuite
  public void Create() throws Throwable {	 
	 
	//--------------------------------------Delete the previous folders---------------------------------------
	//Function_libraries.Delete_folder();
	//------------------------------------------Create class object------------------------------------------- 
	Elem_obj = new Element_libraries();		 
	//--------------------------------------------Calling report-----------------------------------------------
	report1=Function_libraries.Report();
	//------------------------------------------Create a Excel file--------------------------------------------
	Excel_libraries.Create_Excel_file();  	
  }
  
//==========================================================================================================================================================================================================================================================================================		 
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------Launch the website--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//==========================================================================================================================================================================================================================================================================================
  //@Parameters("Browser") 
  @Test(priority=0)
  public void Launch(/*@Optional("firefox") String Browser*/) throws Throwable {
	
	//----------------------------------------------Start report test-------------------------------------------------
	  	testName=new Object(){}.getClass().getEnclosingMethod().getName();
	    logger = report1.startTest(testName);
	    
	//-----------------------------------------Data initialization----------------------------------------------
	String Browser_name 	= Excel_libraries.Read("Browser_name");			// Browser name
	//String Browser_name 	= Browser;										// Browser name use for parallel excuation 
	String URL 				= Excel_libraries.Read("URL");					// Web site URL
	
	//---------------------------------------------- Start time------------------------------------------------
	S_time = System.nanoTime();
	//-------------------------------------------Launch Firefox driver-----------------------------------------
	driver=Function_libraries.getBrowser(Browser_name);
	//-------------------------------------------------Enter URL----------------------------------------------
	driver.navigate().to(URL);
	//----------------------------------------Wait statement is initialize------------------------------------
	wait = new WebDriverWait(driver,30);
	if(driver.getCurrentUrl().equals(URL) )
	{
		
		  //===========================Reporter=============================
		  //================================================================
	      logger.log(LogStatus.PASS,"Step-1","URL enter after browser open");
	      logger.log(LogStatus.PASS,logger.addScreenCapture(Function_libraries.Screen_Report(driver)));
	      //Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
	      Excel_libraries.Excel_Reporter("Step-1", "URL enter after browser open", "Browser has to open", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
		  //================================================================
		  //================================================================	
	
	}
	else
	{
		
		  //===========================Reporter=============================
		  //================================================================
	      logger.log(LogStatus.FAIL,"Step-1","URL is not enter after browser open");
	      logger.log(LogStatus.FAIL,logger.addScreenCapture(Function_libraries.Screen_Report(driver)));
	      //Function_libraries.ATUReport_Fail("Step-1",URL,"URL is not enter after browser open", "Browser open but URL is not enter");
	      Excel_libraries.Excel_Reporter("Step-1", "URL is not enter after browser open", "Browser open but URL is not enter", "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
		  //================================================================
		  //================================================================	
    
	}
  }  

    
//==========================================================================================================================================================================================================================================================================================		 
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------Flight search ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//==========================================================================================================================================================================================================================================================================================	 	  
  @Test(priority=1)
  public void Flight_Search() throws Throwable {
	  
	  //----------------------------------------------Start report test-------------------------------------------------
	  testName=new Object(){}.getClass().getEnclosingMethod().getName();
	  logger = report1.startTest(testName);
	  
	  //-----------------------------------------Data initialization----------------------------------------------
	  String Source 			= Excel_libraries.Read("Source");				// Enter Source city
	  String Destination  	    = Excel_libraries.Read("Destination");			// Enter Destination city
	   
	  //-----------------------------------------------Enter Source--------------------------------------------
	  driver.findElement(Elem_obj.Src_element()).click();
	  Thread.sleep(2000);
	  driver.findElement(Elem_obj.Src_element()).sendKeys(Source);
	  Thread.sleep(4000);
	  //---------------------------------------------Enter Destination-----------------------------------------
	  driver.findElement(Elem_obj.Des_element()).click();
	  Thread.sleep(3000);
	  driver.findElement(Elem_obj.Des_element()).sendKeys(Destination);
	  Thread.sleep(5000);
	  //------------------------------------------------Enter Date--------------------------------------------  
	  driver.findElement(Elem_obj.Date_Butn_element()).click();
	  driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);			
	  driver.findElement(Elem_obj.Date_element()).click();
	  //----------------------------------------------Enter Passenger-----------------------------------------
	  driver.findElement(Elem_obj.Pass_Butn_element()).click();
	  driver.findElement(Elem_obj.Select_pass_element()).click();
	  driver.findElement(Elem_obj.Click_butn_element()).click();
	  //--------------------------------------------   Select Class-------------------------------------------
	  driver.findElement(Elem_obj.Click_class_element()).click();
	  driver.findElement(Elem_obj.Select_class_element()).click();
	  Thread.sleep(2000);
	  
				//===========================Reporter=============================
				//================================================================
				logger.log(LogStatus.PASS,"Step-2:- Enter all the flight details");
				logger.log(LogStatus.PASS,logger.addScreenCapture(Function_libraries.Screen_Report(driver)));
				//Function_libraries.ATUReport_Pass("Step-2",Source+" ,"+Destination,"Enter all the flight details", "Flight details is entered");
				Excel_libraries.Excel_Reporter("Step-2", "Enter all the flight details", "Flight details is entered", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				//================================================================
				//================================================================
					
	  //---------------------------------------------Enter Search button------------------------------------	  
	  driver.findElement(Elem_obj.Click_search_element()).click();
  }
  
 
//==========================================================================================================================================================================================================================================================================================		
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------Flight book--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//==========================================================================================================================================================================================================================================================================================				
  @Test(priority=2)
  public void Flight_Book() throws Throwable
  {
	  
	  //----------------------------------------------Start report test-------------------------------------------------
	  testName=new Object(){}.getClass().getEnclosingMethod().getName();
	  logger = report1.startTest(testName);
	  
	  //-----------------------------------------Wait until page is loaded-----------------------------------
	  wait.until(ExpectedConditions.presenceOfElementLocated(Elem_obj.Click_filter_element()));		
	  //----------------------------------Click on filter button to select aurindia flights------------------
	  driver.findElement(Elem_obj.Click_filter_element()).click();
	  //----------------------------------------Capture single person ticket price---------------------------
	  String Price = driver.findElement(Elem_obj.Price_element()).getText();
	  String Price1 = Price.replaceAll(",", "");
	  price = Integer.parseInt(Price1);
			
				//===========================Reporter=============================
				//================================================================
				logger.log(LogStatus.PASS,"Step-3","Select the flight");
				logger.log(LogStatus.PASS,logger.addScreenCapture(Function_libraries.Screen_Report(driver)));
				//Function_libraries.ATUReport_Pass("Step-3","Flight number - AI-803","Select the flight", "Travelling flight is selected");
				Excel_libraries.Excel_Reporter("Step-3", "Select the flight", "Travelling flight is selected", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				//================================================================
				//================================================================
			
 	  //---------------------------------------------Click on Book button------------------------------------
	  driver.findElement(Elem_obj.Book_element()).click();

  }

  
//==========================================================================================================================================================================================================================================================================================		
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------Fare check & Continue--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//==========================================================================================================================================================================================================================================================================================
  @Test(priority=3)
  public void Fare_check() throws Throwable
  {
	  
	//----------------------------------------------Start report test-------------------------------------------------
	testName=new Object(){}.getClass().getEnclosingMethod().getName();
	logger = report1.startTest(testName);
	  
	//-----------------------------------------Data initialization----------------------------------------------
	String Email 			= Excel_libraries.Read("Email");				// Enter customer Email address				
	
	//--------------------------------------------Wait until page is loaded--------------------------------
	wait.until(ExpectedConditions.presenceOfElementLocated(Elem_obj.Continu_element()));
	//-----------------------------------------------Capture Base_fare-------------------------------------
	String Base_fare = driver.findElement(Elem_obj.Base_fare_element()).getText();
	String Base_fare1 = Base_fare.replaceAll(",", "").replaceAll("Rs. ", "");
	int Fare = Integer.parseInt(Base_fare1);
	//--------------------------------------------------Capture Tax---------------------------------------
	String Tax = driver.findElement(Elem_obj.Tax_element()).getText();
	String Tax1 = Tax.replaceAll(",", "").replaceAll("Rs. ", "");
	int Inc_Tax = Integer.parseInt(Tax1);
	//----------------------------------------------Capture total price----------------------------------
	String Total = driver.findElement(Elem_obj.Total_price_element()).getText();
	String Total1 = Total.replaceAll(",", "").replaceAll("Rs. ", "");
	Total_Fare = Integer.parseInt(Total1);
	//------------------------------------Verify both the price are equal----------------------------
		if(Total_Fare == (price*1))
		{
			System.out.println("Total fare is correct");
				
				//============================Reporter============================
				//================================================================
				logger.log(LogStatus.PASS,"Step-4","Total fare is :- "+(Fare+Inc_Tax));
				logger.log(LogStatus.PASS,logger.addScreenCapture(Function_libraries.Screen_Report(driver)));
				//Function_libraries.ATUReport_Pass("Step-4","No data","Total fare is = "+Total_Fare, "Actual fare is :- "+(Fare+Inc_Tax));
				Excel_libraries.Excel_Reporter("Step-4", "Total fare is = "+Total_Fare, "Actual fare is :- "+(Fare+Inc_Tax), "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				//================================================================
				//================================================================
				
		}
		else
		{
			
				//============================Reporter============================
				//================================================================
				logger.log(LogStatus.FAIL,"Step-4","Total fare is :- "+(Fare+Inc_Tax));
				logger.log(LogStatus.FAIL,logger.addScreenCapture(Function_libraries.Screen_Report(driver)));
				//Function_libraries.ATUReport_Fail("Step-4","Total fare is = "+Total_Fare,"Total fare is = "+Total_Fare, "Actual fare is :- "+(Fare+Inc_Tax));
				Excel_libraries.Excel_Reporter("Step-4", "Total fare is = "+Total_Fare, "Actual fare is :- "+(Fare+Inc_Tax), "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				//================================================================
				//================================================================
		
		}
	//----------------------------------------------Enter email address--------------------------------
	driver.findElement(Elem_obj.Email_element()).sendKeys(Email);
			
				//============================Reporter============================
				//================================================================
				logger.log(LogStatus.PASS,"Step-5","Enter Email & click on Continue");
				logger.log(LogStatus.PASS,logger.addScreenCapture(Function_libraries.Screen_Report(driver)));
				//Function_libraries.ATUReport_Pass("Step-5",Email,"Enter Email & click on Continue", "Click on contine button");
				Excel_libraries.Excel_Reporter("Step-5", "Enter Email & click on Continue", "Click on contine button", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
	 			//================================================================
				//================================================================
			
	//--------------------------------------------Click on Continue button----------------------------
	if(driver.findElement(Elem_obj.Continu_element()).isEnabled())
	{
		driver.findElement(Elem_obj.Continu_element()).click();
	}
	
  }
    

//==========================================================================================================================================================================================================================================================================================		
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------Passenger details----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//==========================================================================================================================================================================================================================================================================================		
  @Test(priority=4)
  public void Passenger_details() throws Throwable
  {
	  
	//----------------------------------------------Start report test-------------------------------------------------
	testName=new Object(){}.getClass().getEnclosingMethod().getName();
	logger = report1.startTest(testName);
	  
	//-----------------------------------------Data initialization----------------------------------------------
	String Fname 			= Excel_libraries.Read("Fname");				// Enter customer fist name
	String Lname 			= Excel_libraries.Read("Lname");				// Enter customer last name  
	String Gender 			= Excel_libraries.Read("Gender");				// Gender of passenger
	String Ph_num 			= Excel_libraries.Read("Ph_num"); 				// Enter phone number
	  
	//--------------------------------------------Wait until page is loaded---------------------------
	wait.until(ExpectedConditions.presenceOfElementLocated(Elem_obj.Fname_element()));
	//---------------------------------------------Enter first & last name---------------------------
	driver.findElement(Elem_obj.Fname_element()).click();
	driver.findElement(Elem_obj.Fname_element()).sendKeys(Fname);
	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	driver.findElement(Elem_obj.Lname_element()).click();
	driver.findElement(Elem_obj.Lname_element()).sendKeys(Lname);
	//----------------------------------------------Select Gender--------------------------------
		if(Gender.toLowerCase() == "female") {
				driver.findElement(Elem_obj.Fgender_element()).click();			
		}
		else {
				driver.findElement(Elem_obj.Mgender_element()).click();			
		}
	//------------------------------------------------Enter mobile number----------------------------
	driver.findElement(Elem_obj.Ph_element()).sendKeys(Ph_num);
			
		    //============================Reporter============================
			//================================================================
			logger.log(LogStatus.PASS,"Step-6","Enter all the passenger details");
			logger.log(LogStatus.PASS,logger.addScreenCapture(Function_libraries.Screen_Report(driver)));
			//Function_libraries.ATUReport_Pass("Step-6",Fname+" ,"+Lname+" ,"+Gender+" ,"+Ph_num,"Enter all the passenger details", "Passenger details is entered");
			Excel_libraries.Excel_Reporter("Step-6", "Enter all the passenger details", "Passenger details is entered", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
			//================================================================
			//================================================================
					
	//----------------------------------------------Click on Payment button-------------------------
	driver.findElement(Elem_obj.Payment_element()).click();
  }
  
  
//==========================================================================================================================================================================================================================================================================================		
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------Payment details----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//==========================================================================================================================================================================================================================================================================================
  @Test(priority=5)
  public void Payment_details() throws Throwable
  {
	  
	//----------------------------------------------Start report test-------------------------------------------------
	testName=new Object(){}.getClass().getEnclosingMethod().getName();
	logger = report1.startTest(testName);
		
	//-----------------------------------------Data initialization----------------------------------------------
	String Bank_name 		= Excel_libraries.Read("Bank_name");					// Select the bank for payment
	String Card_num 		= Excel_libraries.Read("Card_num");						// Enter card number
	String Hold_name 		= Excel_libraries.Read("Hold_name");					// Enter customer name
	String Date 			= Excel_libraries.Read("Date");							// Enter expiry date
	String[] arrSplit       = Date.split("-");										// Store date in array
  	String card_month 	    = arrSplit[0];											// Store month in string											
  	String card_year 		= arrSplit[1];											// Store year 

	//---------------------------------------------Wait until page is loaded------------------------
	wait.until(ExpectedConditions.presenceOfElementLocated(Elem_obj.Payment_type_element()));	
	//------------------------------------------Click on ATM/Debit card option---------------------- 
	driver.findElement(Elem_obj.Payment_type_element()).click();
	//-----------------------------------------------Select payment Bank----------------------------
	WebElement drop_bank = driver.findElement(Elem_obj.Select_bank_element());
	Select dropdown = new Select(drop_bank);
	dropdown.selectByVisibleText(Bank_name);
	//-------------------------------------------------Enter card number---------------------------
	driver.findElement(Elem_obj.Card_num_element()).sendKeys(Card_num);
	//----------------------------------------------------Holder name-----------------------------
	driver.findElement(Elem_obj.Holder_name_element()).sendKeys(Hold_name);
	//-------------------------------------------------Enter expiry month-------------------------
	WebElement drop_month = driver.findElement(Elem_obj.Expry_month_element());
	Select dropdown2 = new Select(drop_month);
	dropdown2.selectByVisibleText(card_month);
	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	//--------------------------------------------------Enter expiry year-------------------------		
	WebElement drop_year = driver.findElement(Elem_obj.Expry_year_element());
	Select dropdown1 = new Select(drop_year);
	dropdown1.selectByVisibleText(card_year);
	//---------------------------------------------------Check the price--------------------------
	String Check_price = driver.findElement(Elem_obj.Price_check_element()).getText();
	String Check_price1 = Check_price.replaceAll(",", "");
	int check_price1 = Integer.parseInt(Check_price1);
		if(Total_Fare==check_price1)
		{
			
			//============================Reporter============================
			//================================================================
			logger.log(LogStatus.PASS,"Step-7","Fare price is verified");	
			//Function_libraries.ATUReport_Pass("Step-7","No Data","Fare price is verified", "Fare price has to be same");
			Excel_libraries.Excel_Reporter("Step-7", "Fare price is verified", "Fare price has to be same", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
			//================================================================
			//================================================================
		
		}
			
			//============================Reporter============================
			//================================================================
			logger.log(LogStatus.PASS,"Step-8","Enter all the payment details");	
			logger.log(LogStatus.PASS,logger.addScreenCapture(Function_libraries.Screen_Report(driver)));
			//Function_libraries.ATUReport_Fail("Step-8",Bank_name+" ,"+Card_num+" ,"+Hold_name+" ,"+Date,"Enter all the payment details", "Payment details is entered");
			Excel_libraries.Excel_Reporter("Step-8", "Enter all the payment details", "Payment details is entered", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
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
	            logger.log(LogStatus.FAIL, "Test '"+ testName+ "' Failed : Cause>>"+result.getThrowable(),logger.addScreenCapture(Function_libraries.Screen_Report(driver)));
	            Excel_libraries.Excel_Reporter("Step-Fail", ""+result.getThrowable() , "Condition must be fullfill", "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
		  	} else if (result.getStatus() == ITestResult.SKIP) {
	        	logger.log(LogStatus.SKIP, "Test '"+ testName+ "' skipped : Cause>>"+ result.getThrowable(),logger.addScreenCapture(Function_libraries.Screen_Report(driver)));
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
			Excel_libraries.Excel_Reporter("Step-9", "Script take "+(E_time-S_time)/1000000000+" second to run.", "Script run successfully", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
			//================================================================
			//================================================================
					
	//----------------------------------------------Close the browser-----------------------------
	driver.close();		
	//--------------------------------------------------Quit driver--------------------------------
	driver.quit();
  }
  
  
  @AfterSuite
  public void Zip_folder() throws Exception
  {
	  //---------------------------------It will generate TestNG report into Excel file------------
	  org.automationtesting.excelreport.Xl.generateReport(Excel_libraries.Folder_path,"Excel_report.xlsx");
	  //---------------------------------------------Create a Zip Folder--------------------------- 
	  Function_libraries.Zip_folder();
  }
}
