package flight_secenerio;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import libraries.Excel_libraries;
import libraries.Utility_libraries;

public class Reporter {

	WebDriver driver;
	ExtentTest logger;
	ExtentReports report1;
	
	public Reporter(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
	}
	
	public void Outbound_Report(String Class) throws Throwable
	{
		try
		{
			driver.findElement(By.xpath("//div[@id='upsellRowOutboundContent']/div")).isDisplayed();
			
				//===========================Reporter=============================
				//================================================================
				logger.log(LogStatus.PASS,"Seat select",Class+" outgoing flight for adult passenger seat is select");
				logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
				//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
				Excel_libraries.Excel_Reporter("Seat select",Class+" outgoing flight for adult passenger seat is select", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				//================================================================
				//================================================================
		
		}
		catch(Exception e)
		{
			
				//===========================Reporter=============================
				//================================================================
				logger.log(LogStatus.FAIL,"Seat select",Class+" outgoing flight for adult passenger seat is not select");
				logger.log(LogStatus.FAIL,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
				//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
				Excel_libraries.Excel_Reporter("Seat select",Class+" outgoing flight for adult passenger seat is not select", "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				Utility_libraries.Close(driver,report1,logger);
				//================================================================
				//================================================================
		
		}
	}
	
	public void Inbound_Report(String Class) throws Throwable
	{
		try
		{
			driver.findElement(By.xpath("//div[@id='upsellRowInboundContent']/div")).isDisplayed();
			
				//===========================Reporter=============================
				//================================================================
				logger.log(LogStatus.PASS,"Seat select",Class+" outgoing flight for adult passenger seat is select");
				logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
				//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
				Excel_libraries.Excel_Reporter("Seat select",Class+" outgoing flight for adult passenger seat is select", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				//================================================================
				//================================================================
		
		}
		catch(Exception e)
		{
			
				//===========================Reporter=============================
				//================================================================
				logger.log(LogStatus.FAIL,"Seat select",Class+" outgoing flight for adult passenger seat is not select");
				logger.log(LogStatus.FAIL,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
				//Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
				Excel_libraries.Excel_Reporter("Seat select",Class+" outgoing flight for adult passenger seat is not select", "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				Utility_libraries.Close(driver,report1,logger);
				//================================================================
				//================================================================
		
		}
	}

}
