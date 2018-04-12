package com.RA.webelement;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.RA.libraries.Excel_libraries;
import com.RA.libraries.Utility_libraries;


interface Myinterface_Reporter
{
	public void RA_report_pass(String Step_details,String Actual);
	public void RA_report_fail(String Step_details,String Actual);
}

public class RA_Reporter implements Myinterface_Reporter {

	ExtentTest logger;		//Create logger instance
	WebDriver driver;
	public RA_Reporter(ExtentTest logger,WebDriver driver)
	{
		this.logger = logger;
		this.driver = driver;
	}
	public void RA_report_pass(String Step_details,String Actual)
	{
		  //===========================Reporter=============================
		  //================================================================
	      logger.log(LogStatus.PASS,Step_details,Actual);
	      try {
			logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      try {
			Excel_libraries.Excel_Reporter(Step_details,Actual, "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  //================================================================
		  //================================================================
	}
	
	public void RA_report_fail(String Step_details,String Actual)
	{
		  //===========================Reporter=============================
		  //================================================================
	      logger.log(LogStatus.FAIL,Step_details,Actual);
	      try {
			logger.log(LogStatus.FAIL,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			Excel_libraries.Excel_Reporter(Step_details,Actual, "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  //================================================================
		  //================================================================
	}
	
}
