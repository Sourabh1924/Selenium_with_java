package atu_reporte;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })
public class NewTest {
	
	static ExtentReports report1;                     
	static ExtentTest logger;
	
  @Test(priority=1)
  public void Launch() {
	  
	  WebDriver driver = new FirefoxDriver();
	  ATUReports.setWebDriver(driver);
	  driver.navigate().to("https://www.google.co.in/");
	 
	  logger.log(LogStatus.PASS,"Payment method","Payment method is selected.");
	  ATUReport_Pass("Step 2","https://www.google.co.in/", "Url is enter", "URL have to enter");
  }
 
  
  @BeforeSuite
  public void Properties()
  {
	    //Set Property for ATU Reporter Configuration
	    {
	    	 report1 = Generate_report.Report();
	    	System.setProperty("atu.reporter.config", "C:\\Users\\Yogesh\\Desktop\\Selenium_project\\atu.properties");
	    }	   
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  
	  
	  ATUReport_Pass("Step 1","Nothing", "Before test run", "Before test have to be run");
  }
 
  @AfterTest
  public void afterTest() {
	  
	  report1.flush();
	  ATUReport_Pass("Step 3","Nothing", "After test run", "After test have to be run");
  }

  
  public void ATUReport_Pass(String Detail,String value,String AExpected,String Actual)
  {
	 
	  ATUReports.add("Step 1","Nothing", "Before test run", "Before test have to be run",LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
	  ATUReports.setAuthorInfo("Sourabh Chakroborty", new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()), "1.0");
  }
  
  
  public void ATUReport_Fail(String Detail,String value,String AExpected,String Actual)
  {
	 
	  ATUReports.add("Step 1","Nothing", "Before test run", "Before test have to be run",LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
	  ATUReports.setAuthorInfo("Sourabh Chakroborty", new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()), "1.0");
  }
  
}
