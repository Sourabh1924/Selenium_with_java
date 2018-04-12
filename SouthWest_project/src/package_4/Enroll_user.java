package package_4;

import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import libraries.Excel_libraries;
import libraries.Local_libraries;
import libraries.Utility_libraries;

public class Enroll_user {

		//-----------------------------------------Data initialization----------------------------------------------
		static WebDriver driver;                          // Create driver instance
		static ExtentReports report1;                     // Create reporter instance 
		static ExtentTest logger;						  // Create logger instance
		static Element_lab3 Elem_obj ;			  		  // Create Class object
		public static String testName="Enroll_user";	  // Create testname 
		static long S_time;								  // Start time of test
		static long E_time;								  // End time of test
		
		@BeforeTest
		public void Create() throws Throwable {	 
			 
			//--------------------------------------Delete the previous folders---------------------------------------
			//Function_libraries.Delete_folder();
			//------------------------------------------Create class object------------------------------------------- 
			Elem_obj = new Element_lab3();	
			//--------------------------------------------Calling report-----------------------------------------------
			report1=Utility_libraries.Report();
			//------------------------------------------Create a Excel file--------------------------------------------
			Excel_libraries.Create_Excel_file();  	
		}
		
		@Test(priority=1)
		public void Launch() throws Throwable {
			
			//----------------------------------------------Start report test-------------------------------------------------
			testName=new Object(){}.getClass().getEnclosingMethod().getName();
			logger = report1.startTest(testName);
			    
			//-----------------------------------------Data initialization----------------------------------------------
			String Browser_name 	= Excel_libraries.Read("Browser_name","Enroll_data.xls");			// Browser name 
			String URL 				= Excel_libraries.Read("URL","Enroll_data.xls");					// Web site URL
			
			//---------------------------------------------- Start time------------------------------------------------
			S_time = System.nanoTime();
			//-------------------------------------------Launch Firefox driver-----------------------------------------
			driver=Utility_libraries.getBrowser(Browser_name);
			//-------------------------------------------------Enter URL----------------------------------------------
			driver.navigate().to(URL);
			//----------------------------------------Wait statement is initialize------------------------------------
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

		@Test(priority=2)
		public void User_enroll() throws Throwable
		{
			
			//----------------------------------------------Start report test-------------------------------------------------
			testName=new Object(){}.getClass().getEnclosingMethod().getName();
			logger = report1.startTest(testName);
					
	        //-----------------------------------------Data initialization----------------------------------------------
		    
			String First_name 		= Excel_libraries.Read("First_name","Enroll_data.xls");
		    String Middle_name 		= Excel_libraries.Read("Middle_name","Enroll_data.xls");		
		    String Last_name 		= Excel_libraries.Read("Last_name","Enroll_data.xls");
		    String DOB 				= Excel_libraries.Read("DOB","Enroll_data.xls");
		    String SSN 				= Excel_libraries.Read("SSN","Enroll_data.xls");
		    String Gender 			= Excel_libraries.Read("Gender","Enroll_data.xls");
		    String City 			= Excel_libraries.Read("City","Enroll_data.xls");
		    String Address 			= Excel_libraries.Read("Address","Enroll_data.xls");
		    String Zipcode 			= Excel_libraries.Read("Zipcode","Enroll_data.xls");
		    String State 			= Excel_libraries.Read("State","Enroll_data.xls");
		    String Ph_number 		= Excel_libraries.Read("Ph_number","Enroll_data.xls");
		    String Email 			= Excel_libraries.Read("Email","Enroll_data.xls");
		    String Username 		= Excel_libraries.Read("Username","Enroll_data.xls");
		    String Password 		= Excel_libraries.Read("Password","Enroll_data.xls");
		    String Answer 			= Excel_libraries.Read("Answer","Enroll_data.xls");
		    
		   
		    //Click on Enroll button
			driver.findElement(Elem_obj.Enroll_button()).click();
			Thread.sleep(5000);
			
			 
					//===========================Reporter=============================
					//================================================================
					logger.log(LogStatus.PASS,"Step-2","User enrollment page is open");
					logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
					//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
					Excel_libraries.Excel_Reporter("User enrollment page will open", "User enrollment page is open", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
					//================================================================
					//================================================================	
			
			
			//Type on First name
			driver.findElement(Elem_obj.First_name()).sendKeys(First_name);
			//Type on Middle name
			driver.findElement(Elem_obj.Middle_name()).sendKeys(Middle_name);
			//Type on Last name
			driver.findElement(Elem_obj.Last_name()).sendKeys(Last_name);
			//Select the DOB(Month)
			String[] arrSplit = DOB.split("-");
			WebElement Month = driver.findElement(Elem_obj.DOB_month());
			Select dropdown_month = new Select(Month);
			dropdown_month.selectByVisibleText(arrSplit[0]);
			//Select the DOB(Day)
			WebElement Day = driver.findElement(Elem_obj.DOB_day());
			Select dropdown_day = new Select(Day);
			dropdown_day.selectByVisibleText(arrSplit[1]);
			//Select the DOB(Year)
			WebElement Year = driver.findElement(Elem_obj.DOB_year());
			Select dropdown_year = new Select(Year);
			dropdown_year.selectByVisibleText(arrSplit[2]);
			Thread.sleep(3000);	
			//Select the Gender
			WebElement Gender1 = driver.findElement(Elem_obj.Gender());
			Select dropdown_gender = new Select(Gender1);
			dropdown_gender.selectByVisibleText(Gender);
			//Type SSN
			driver.findElement(Elem_obj.SSN()).sendKeys(SSN);
			//Type City
			driver.findElement(Elem_obj.City()).sendKeys(City);
			//Type Address
			driver.findElement(Elem_obj.Address()).sendKeys(Address);
			//Type Zip code
			driver.findElement(Elem_obj.Zipcode()).sendKeys(Zipcode);
			//Select State
			WebElement State1 = driver.findElement(Elem_obj.State());
			Select dropdown_state = new Select(State1);
			dropdown_state.selectByVisibleText(State);
			//Type Phone number
			String[] arrSplit1 = Ph_number.split("-");
			driver.findElement(Elem_obj.Area_code()).sendKeys(arrSplit1[0]);
			driver.findElement(Elem_obj.Prefix_num()).sendKeys(arrSplit1[1]);
			driver.findElement(Elem_obj.Line_num()).sendKeys(arrSplit1[2]);
			//Type Email
			driver.findElement(Elem_obj.Email()).sendKeys(Email);
			//Type Retype-Email
			driver.findElement(Elem_obj.Re_Email()).sendKeys(Email);
			//Enter Username
			driver.findElement(Elem_obj.Username()).sendKeys(Username);
			//calling function
			Local_libraries.name(driver);
			//Enter Password
			driver.findElement(Elem_obj.Password()).sendKeys(Password);		
			//Enter Re-Password
			driver.findElement(Elem_obj.Re_Password()).sendKeys(Password);
	        //Select security question-1	
			WebElement Question1 = driver.findElement(By.cssSelector("#js-security-question-1"));
			Select dropdown_question1 = new Select(Question1);
			dropdown_question1.selectByVisibleText("What is the name of your first pet?");
			//Enter Answer
			driver.findElement(Elem_obj.Answer()).sendKeys(Answer);
			//Select security question-2
			WebElement Question2 = driver.findElement(By.cssSelector("#js-security-question-2"));
			Select dropdown_question2 = new Select(Question2);
			dropdown_question2.selectByVisibleText("What was the color of your first car?");
			//Enter Answer
			driver.findElement(Elem_obj.Answer1()).sendKeys(Answer);
			
			
					//===========================Reporter=============================
					//================================================================
					logger.log(LogStatus.PASS,"Step-3","Enter all the necessery user details");
					logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
					//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
					Excel_libraries.Excel_Reporter("Enter all the necessery user details", "All details are enter", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
					//================================================================
					//================================================================	
			
			
			//Select the checkbox
			driver.findElement(Elem_obj.Accept()).click();
			driver.findElement(Elem_obj.Submit()).click();
			//Store the account number
			String Account_num = driver.findElement(Elem_obj.Account_number()).getText();
			if(driver.findElement(Elem_obj.Account_number()).isDisplayed())
			{
					//===========================Reporter=============================
					//================================================================
					logger.log(LogStatus.PASS,"Step-4","New user account is successfully create :- "+Account_num);
					//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
					Excel_libraries.Excel_Reporter("New user account has to be create", "New user account is created", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
					//================================================================
					//================================================================	
			}
			else
			{
				
					//===========================Reporter=============================
					//================================================================
					logger.log(LogStatus.PASS,"Step-4","New user account is not create");
					//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
					Excel_libraries.Excel_Reporter("New user account has to be create", "New user account is not create", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
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
			            Excel_libraries.Excel_Reporter(""+result.getThrowable() , "Condition must be fullfill", "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
				  	} else if (result.getStatus() == ITestResult.SKIP) {
			        	logger.log(LogStatus.SKIP, "Test '"+ testName+ "' skipped : Cause>>"+ result.getThrowable(),logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
			        } else {
			        	logger.log(LogStatus.PASS, "Test  '"+ testName+"'  passed");
			        }	  
				 report1.endTest(logger);
				 report1.flush();
				    
			}

		@AfterTest
		public void Close() throws Throwable
		{
			//---------------------------------------------------End time--------------------------------
			E_time = System.nanoTime();
					
					//============================Reporter============================
					//================================================================
					report1.addSystemInfo("Total Time Taken in Execution :", ""+(E_time-S_time)/1000000000+" second to run.");
					//Function_libraries.ATUReport_Pass("Step-9","No Data","Script take "+(E_time-S_time)/1000000000+" second to run.", "Script run successfully");
					Excel_libraries.Excel_Reporter("Script take "+(E_time-S_time)/1000000000+" second to run.", "Script run successfully", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
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
//			  //---------------------------------It will generate TestNG report into Excel file------------
//			  org.automationtesting.excelreport.Xl.generateReport(Excel_libraries.Folder_path,"Excel_report.xlsx");
//			  //---------------------------------------------Create a Zip Folder--------------------------- 
//			  Utility_libraries.Zip_folder("EnRoll_script");
		  }
}
