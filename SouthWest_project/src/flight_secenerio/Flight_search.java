package flight_secenerio;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import libraries.Excel_libraries;
import libraries.Utility_libraries;

public class Flight_search {
	
	WebDriver driver;
	ExtentTest logger;
	int Adu_passenger;
	int Sen_passenger;
	
	public Flight_search(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
	}
	public void Search(String Travel_type,String Adu_pass,String Sen_pass) throws Throwable  {
		// TODO Auto-generated method stub
		
		String Departure = Excel_libraries.Read("Departure","Flight_booking_data.xls");
		String Arrival = Excel_libraries.Read("Arrival","Flight_booking_data.xls");
		String Date = Excel_libraries.Read("Date","Flight_booking_data.xls");
		String Return_Date = Excel_libraries.Read("Return_Date","Flight_booking_data.xls");
		
			if(Travel_type.toLowerCase().equals("roundtrip"))
			{
				driver.findElement(By.cssSelector("#trip-type-round-trip")).click();
			}
			else
			{
				driver.findElement(By.cssSelector("#trip-type-one-way")).click();
			}
		
		//Enter departure city
		driver.findElement(By.cssSelector("#air-city-departure")).sendKeys(Departure);
		//Enter arrival city
		driver.findElement(By.cssSelector("#air-city-arrival")).sendKeys(Arrival);
			//Enter travelling date
			if(Travel_type.equals("roundtrip"))
			{
				driver.findElement(By.cssSelector("#air-date-departure")).clear();
				driver.findElement(By.cssSelector("#air-date-departure")).sendKeys(Date);
			
				driver.findElement(By.cssSelector("#air-date-return")).clear();
				driver.findElement(By.cssSelector("#air-date-return")).sendKeys(Return_Date);
			}
			else
			{
				driver.findElement(By.cssSelector("#air-date-departure")).clear();
				driver.findElement(By.cssSelector("#air-date-departure")).sendKeys(Date);
			}
			
		Adu_passenger = Integer.parseInt(Adu_pass);
		Sen_passenger = Integer.parseInt(Sen_pass);
		if((Adu_passenger + Sen_passenger)>8)
		{
			  
			  //===========================Reporter=============================
			  //================================================================
		      logger.log(LogStatus.FAIL,"Passenger number","Passenger number is greater then 8");
		      logger.log(LogStatus.FAIL,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
		      //Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
		      Excel_libraries.Excel_Reporter("Passenger number","Passenger number is greater then 8", "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
		      System.exit(1);
		      //================================================================
			  //================================================================	
		
		}
		//Select the number of adult passenger
		driver.findElement(By.cssSelector("#air-pax-count-adults")).click();
		for(int Adult=1;Adult<Integer.parseInt(Adu_pass);Adult++)
		{
			driver.findElement(By.cssSelector("#jb-number-selector-more")).click();
		}
		//Select the number of senior passenger
		driver.findElement(By.cssSelector("#air-pax-count-seniors")).click();
		for(int Senior=1;Senior<=Integer.parseInt(Sen_pass);Senior++)
		{
			driver.findElement(By.cssSelector("#jb-number-selector-more")).click();
		}
		
		
		  //===========================Reporter=============================
		  //================================================================
	      logger.log(LogStatus.PASS,"Flight details","Flight details are enter.");
	      logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
	      //Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
	      Excel_libraries.Excel_Reporter("Flight details","Flight details are enter.", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
		  //================================================================
		  //================================================================	
	      
	      
		//Click on submit button
		driver.findElement(By.xpath("//button[@id='jb-booking-form-submit-button']")).click();	
	}
}
