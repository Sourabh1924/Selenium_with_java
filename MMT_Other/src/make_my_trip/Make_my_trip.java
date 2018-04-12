package make_my_trip;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Make_my_trip {

	static WebDriver driver;
	static ExtentReports report1;
	static ExtentTest logger;
	static Element_libraries Elem_obj = new Element_libraries();
	
	
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		 //-----------------------------------------Data initialization----------------------------------------------
		
		 String Gender 			= Excel_libraries.Read("Gender");				// Gender of passenger
		 String Browser_name 	= Excel_libraries.Read("Browser_name");			// Browser name
		 String URL 			= Excel_libraries.Read("URL");					// Enter URL
		 String Source 			= Excel_libraries.Read("Source");				// Enter Source city
		 String Destination  	= Excel_libraries.Read("Destination");			// Enter Destination city
		 String Email 			= Excel_libraries.Read("Email");				// Enter customer Email address
		 String Fname 			= Excel_libraries.Read("Fname");				// Enter customer fist name
		 String Lname 			= Excel_libraries.Read("Lname");				// Enter customer last name
		 String Ph_num 			= Excel_libraries.Read("Ph_num"); 				// Enter phone number
		 String Bank_name 		= Excel_libraries.Read("Bank_name");			// Select the bank for payment
		 String Card_num 		= Excel_libraries.Read("Card_num");				// Enter card number
		 String Hold_name 		= Excel_libraries.Read("Hold_name");			// Enter customer name
		 String Date 			= Excel_libraries.Read("Date");					// Enter expiry date
		 String[] arrSplit 		= Date.split("-");
		 String card_month 		= arrSplit[0];
		 String card_year 		= arrSplit[1];		
			 
		 
//==========================================================================================================================================================================================================================================================================================		 
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------Flight search ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//==========================================================================================================================================================================================================================================================================================	 
		 
		//--------------------------------------------Calling report-----------------------------------------------
		report1=Function_libraries.Report();
		//------------------------------------------Create a Excel file--------------------------------------------
		Excel_libraries.Create_Excel_file();
		//----------------------------------------------Start test-------------------------------------------------
		logger = report1.startTest("Start test");
		//---------------------------------------------- Start time------------------------------------------------
		long S_time = System.nanoTime();
		//-------------------------------------------Launch Firefox driver-----------------------------------------
		driver=Function_libraries.getBrowser(Browser_name);
		//-------------------------------------------------Enter URL----------------------------------------------
		driver.navigate().to(URL);	
			
				//===========================Reporter=============================
				//================================================================
				logger.log(LogStatus.PASS,"Step-1","URL enter after browser open");
				logger.log(LogStatus.PASS, Function_libraries.Screen_Report(driver),logger.addScreenCapture(Function_libraries.Screen_Report(driver)));
				Excel_libraries.Excel_Reporter("Step-1", "URL enter after browser open", "Browser hase to open", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				//================================================================
				//================================================================
			
		//-----------------------------------------------Enter Source--------------------------------------------
		driver.findElement(Elem_obj.Src_element()).click();
		driver.findElement(Elem_obj.Src_element()).sendKeys(Source);
		Thread.sleep(2000);	
		//---------------------------------------------Enter Destination-----------------------------------------
		driver.findElement(Elem_obj.Des_element()).click();
		driver.findElement(Elem_obj.Des_element()).sendKeys(Destination);
		//------------------------------------------------Enter Date--------------------------------------------
		Thread.sleep(2000);
		driver.findElement(Elem_obj.Date_Butn_element()).click();
		Thread.sleep(2000);		
		driver.findElement(Elem_obj.Date_element()).click();
		//----------------------------------------------Enter Passenger-----------------------------------------
		driver.findElement(Elem_obj.Pass_Butn_element()).click();
		driver.findElement(Elem_obj.Select_pass_element()).click();
		driver.findElement(Elem_obj.Click_butn_element()).click();
		//--------------------------------------------   Select Class-------------------------------------------
		driver.findElement(Elem_obj.Click_class_element()).click();
		driver.findElement(Elem_obj.Select_class_element()).click();
		
					//===========================Reporter=============================
					//================================================================
					logger.log(LogStatus.PASS,"Step-2:- Enter all the flight details");
					logger.log(LogStatus.PASS, Function_libraries.Screen_Report(driver),logger.addScreenCapture(Function_libraries.Screen_Report(driver)));
					Excel_libraries.Excel_Reporter("Step-2", "Enter all the flight details", "Flight details is entered", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
					//================================================================
					//================================================================
				
		//---------------------------------------------Enter Search button------------------------------------
		driver.findElement(Elem_obj.Click_search_element()).click();
	
		
//==========================================================================================================================================================================================================================================================================================		
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------Flight select------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//==========================================================================================================================================================================================================================================================================================	
		
		
		//-----------------------------------------Wait until page is loaded-----------------------------------
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(Elem_obj.Click_filter_element()));		
		//----------------------------------Click on filter button to select aurindia flights------------------
		driver.findElement(Elem_obj.Click_filter_element()).click();
		//----------------------------------------Capture single person ticket price---------------------------
		String Price = driver.findElement(Elem_obj.Price_element()).getText();
		String Price1 = Price.replaceAll(",", "");
		int price = Integer.parseInt(Price1);
		System.out.println("Ticket price for 1 person "+Price1);
		
					//===========================Reporter=============================
					//================================================================
					logger.log(LogStatus.PASS,"Step-3","Select the flight");
					logger.log(LogStatus.PASS, Function_libraries.Screen_Report(driver),logger.addScreenCapture(Function_libraries.Screen_Report(driver)));
					Excel_libraries.Excel_Reporter("Step-3", "Select the flight", "Travelling flight is selected", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
					//================================================================
					//================================================================
		
		//---------------------------------------------Click on Book button------------------------------------
		driver.findElement(Elem_obj.Book_element()).click();
	
		
//==========================================================================================================================================================================================================================================================================================		
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------Fare check & Continue------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//==========================================================================================================================================================================================================================================================================================
		
		
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
		int Total_Fare = Integer.parseInt(Total1);
			//------------------------------------Verify both the price are equal----------------------------
			if(Total_Fare == (price*1))
			{
				System.out.println("Total fare is correct");
				
				//============================Reporter============================
				//================================================================
				logger.log(LogStatus.PASS,"Step-4","Total fare is :- "+(Fare+Inc_Tax));
				logger.log(LogStatus.PASS, Function_libraries.Screen_Report(driver),logger.addScreenCapture(Function_libraries.Screen_Report(driver)));
				Excel_libraries.Excel_Reporter("Step-4", "Total fare is = "+Total_Fare, "Actual fare is :- "+(Fare+Inc_Tax), "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				//================================================================
				//================================================================
			
			}
		//----------------------------------------------Enter email address--------------------------------
		driver.findElement(Elem_obj.Email_element()).sendKeys(Email);
		
				//============================Reporter============================
				//================================================================
				logger.log(LogStatus.PASS,"Step-5","Enter Email & click on Continue");
				logger.log(LogStatus.PASS, Function_libraries.Screen_Report(driver),logger.addScreenCapture(Function_libraries.Screen_Report(driver)));
				Excel_libraries.Excel_Reporter("Step-4", "Enter Email & click on Continue", "Click on contine button", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				//================================================================
				//================================================================
		
		//--------------------------------------------Click on Continue button----------------------------
		if(driver.findElement(Elem_obj.Continu_element()).isEnabled())
		{
			driver.findElement(Elem_obj.Continu_element()).click();
		}
	
	
//==========================================================================================================================================================================================================================================================================================		
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------Passenger details--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//==========================================================================================================================================================================================================================================================================================		
		
		
		//--------------------------------------------Wait until page is loaded---------------------------
		wait.until(ExpectedConditions.presenceOfElementLocated(Elem_obj.Fname_element()));
		//---------------------------------------------Enter first & last name---------------------------
		driver.findElement(Elem_obj.Fname_element()).click();
		driver.findElement(Elem_obj.Fname_element()).sendKeys(Fname);
		Thread.sleep(2000);
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
				logger.log(LogStatus.PASS, Function_libraries.Screen_Report(driver),logger.addScreenCapture(Function_libraries.Screen_Report(driver)));
				Excel_libraries.Excel_Reporter("Step-6", "Enter all the passenger details", "Passenger details is entered", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				//================================================================
				//================================================================
				
		//----------------------------------------------Click on Payment button-------------------------
		driver.findElement(Elem_obj.Payment_element()).click();
		
		
//==========================================================================================================================================================================================================================================================================================		
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------Payment details------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//==========================================================================================================================================================================================================================================================================================
		
		
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
		Thread.sleep(2000);
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
				Excel_libraries.Excel_Reporter("Step-7", "Fare price is verified", "Fare price has to be same", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				//================================================================
				//================================================================
			}
		
				//============================Reporter============================
				//================================================================
				logger.log(LogStatus.PASS,"Step-8","Enter all the payment details");	
				logger.log(LogStatus.PASS, Function_libraries.Screen_Report(driver),logger.addScreenCapture(Function_libraries.Screen_Report(driver)));
				Excel_libraries.Excel_Reporter("Step-8", "Enter all the payment details", "Payment details is entered", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				//================================================================
				//================================================================
		
		//------------------------------------------------End reporter--------------------------------
		report1.endTest(logger);
		//----------------------------------------------Flush the report------------------------------
		report1.flush();
		//----------------------------------------------Close the browser-----------------------------
		driver.close();
		//---------------------------------------------------End time--------------------------------
		long E_time = System.nanoTime();
		
				//============================Reporter============================
				//================================================================
				logger.log(LogStatus.PASS,"Step-9","Script take "+(E_time-S_time)/1000000000+" second to run.");	
				Excel_libraries.Excel_Reporter("Step-9", "Script take "+(E_time-S_time)/1000000000+" second to run.", "Script run successfully", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				//================================================================
				//================================================================
		
		//--------------------------------------------------Quit driver--------------------------------
		driver.quit();
	}
}
