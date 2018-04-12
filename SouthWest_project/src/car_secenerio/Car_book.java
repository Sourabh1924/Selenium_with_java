package car_secenerio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import libraries.Excel_libraries;
import libraries.Utility_libraries;

public class Car_book {

	int cnt=0;
	WebDriver driver;
	ExtentTest logger;
	boolean counter=false;
	
	public Car_book(WebDriver driver,ExtentTest logger) 
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.logger = logger;
	}

	public void Book(String Car_type) throws Throwable
	{					
		do 
		{
				List<WebElement> Allist = driver.findElements(By.cssSelector(".actionable.actionable_button.grid-title--content"));

					for(WebElement Add:Allist)
					{
							if(Car_type.equalsIgnoreCase(Add.getText()))
								{
									
									 //===========================Reporter=============================
									 //================================================================
								     logger.log(LogStatus.PASS,"Cab select","Cab is selected");
								     logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
								     //Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
								     Excel_libraries.Excel_Reporter("Cab select","Cab is selected", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
									 //================================================================
									 //================================================================
								
								   Add.click();
								   break;
								}
							if(Add.getText().equals("LUXURY"))
								{
									for(int i=1;i<=6;i++)
									{
										driver.findElement(By.cssSelector(".actionable.actionable_button.select-grid--pointer.select-grid--pointer_right")).click();
									}
								}
							}
						}	
		while(counter==true);
			
		try
		{
			driver.findElement(By.cssSelector(".actionable.actionable_button.actionable_no-outline.actionable_primary.button.submit-button.drawer--actions-continue")).click();
		}
		catch(Exception e)
		{
			  
			  //===========================Reporter=============================
			  //================================================================
		      logger.log(LogStatus.FAIL,"Cab select","Cab is not selected");
		      logger.log(LogStatus.FAIL,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
		      //Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
		      Excel_libraries.Excel_Reporter("Cab select","Cab is not selected", "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
			  //================================================================
			  //================================================================
		
		}

	}
}

     
//
