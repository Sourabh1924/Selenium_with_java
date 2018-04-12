package car_secenerio;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import libraries.Excel_libraries;
import libraries.Utility_libraries;

public class Rate_Price_verify {

	WebDriver driver;
	ExtentTest logger;
	WebDriverWait wait;
	
	public Rate_Price_verify(WebDriver driver,ExtentTest logger) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.logger = logger;
	}
	
	public void Rate_verify() throws Throwable
	{
		Thread.sleep(5000);
		String Rate_by_day = driver.findElement(By.xpath("//span[contains(@class,'summary--rate-breakdown-item')]")).getText();
		
				//===========================Reporter=============================
				//================================================================
		  		logger.log(LogStatus.PASS,"Rate breakdown","Rate breakdown of number of days "+Rate_by_day);
		  		//================================================================
				//================================================================
		  		
		  		
		String Price = driver.findElement(By.xpath("//td[@class='summary--rate-breakdown-value']")).getText();
		Price = Price.replace("$", "");
		double Price1 = Double.parseDouble(Price);
		
		String Tax = driver.findElement(By.xpath("//div[@class='summary--taxes-and-fees-value']")).getText();
		Tax = Tax.replace("$", "");
		double Tax1 = Double.parseDouble(Tax);
		
		String Total = driver.findElement(By.xpath("//div[@class='summary--subtotal-value']")).getText();
		Total = Total.substring(1, 6);
		double Total1 = Double.parseDouble(Total);
		
		double Total_rate = Price1+Tax1;
		if(Double.compare(Math.round(Total_rate),Math.round(Total1))==0)
		{
				
				  //===========================Reporter=============================
				  //================================================================
			      logger.log(LogStatus.PASS,"Price verification details","Cab rate "+Math.round(Price1)+". Tax rate "+Tax1+". Total price "+Math.round(Total_rate));
			      logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
			      //Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
			      Excel_libraries.Excel_Reporter("Price verification details","Cab rate "+Math.round(Price1)+". Tax rate "+Tax1+". Total price "+Math.round(Total_rate), "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				  //================================================================
				  //================================================================
		      
		}
		else
		{
				
				  //===========================Reporter=============================
				  //================================================================
			      logger.log(LogStatus.FAIL,"Price verification details","Cab rate "+Math.round(Price1)+". Tax rate "+Tax1+". Total price "+Math.round(Total_rate));
			      logger.log(LogStatus.FAIL,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
			      //Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
			      Excel_libraries.Excel_Reporter("Price verification details","Cab rate "+Math.round(Price1)+". Tax rate "+Tax1+". Total price "+Math.round(Total_rate), "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				  //================================================================
				  //================================================================
		      
		}
		
		driver.findElement(By.cssSelector(".actionable.actionable_button.actionable_full-width.actionable_large-button.actionable_no-outline.actionable_primary.button.submit-button.checkout-price-continue-button")).click();
		
	}
	
	public void Passenger_details(String First_Name,String Last_Name,String Ph_number,String Email) throws Throwable
	{
		
		driver.findElement(By.cssSelector("#whoIsDrivingFirstName")).sendKeys(First_Name);
		driver.findElement(By.cssSelector("#whoIsDrivingLastName")).sendKeys(Last_Name);
		driver.findElement(By.cssSelector("#whoIsDrivingPhoneNumber")).sendKeys(Ph_number);
		driver.findElement(By.cssSelector("#sendYourReceiptEmail")).sendKeys(Email);
		
				  //===========================Reporter=============================
				  //================================================================
			      logger.log(LogStatus.PASS,"Passenger details","Passenger details are entered");
			      logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
			      //Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
			      Excel_libraries.Excel_Reporter("Passenger details","Passenger details are entered", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				  //================================================================
				  //================================================================
	      
	      
	}

}
