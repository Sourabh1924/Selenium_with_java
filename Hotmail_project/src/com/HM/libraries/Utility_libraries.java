package com.HM.libraries;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import com.HM.libraries.Excel_libraries;
import com.HM.libraries.Utility_libraries;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

interface Myinterface_Reporter
{
	public void RA_report_pass(String Step_details,String Actual);
	public void RA_report_fail(String Step_details,String Actual);
}

public class Utility_libraries {

	public static WebDriver driver;	
	static String Folder_path = System.getProperty("user.dir")+"\\src\\Test_Result\\RA_Login_Logout"+Utility_libraries.Time_stamp();
	static String Excel_path = Folder_path+"\\Excelreport"+Utility_libraries.Time_stamp()+".xls";	
	
	//----------------------------------------Launch browser------------------------------------------
	public static WebDriver getBrowser(String strBrowserName)
	{
		switch(strBrowserName.toLowerCase())
		{	
		//launch in firefox
		case "firefox":
		driver=new FirefoxDriver();
		break;
		//------------------------------------------------
		//launch in chrome
		case "chrome":
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		break;
		//------------------------------------------------		
		//launch in internetexplore
		case "internetexplore":
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		
		case "ie":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		//------------------------------------------------
		default:
			System.out.println("Driver is not found "+strBrowserName);
		}
		return driver;
	}
	
	//----------------------------------------Extend Report-------------------------------------------
	public static ExtentReports Report()
	{	
	 	ExtentReports report1 = new ExtentReports(Folder_path+"\\Test"+Utility_libraries.Time_stamp()+".html");
		report1.addSystemInfo("Browser","Internet Explore");
		report1.addSystemInfo("Java version", "JDK 8");
		report1.addSystemInfo("Machine", "iDeliver8");
		report1.config().documentTitle("Sourabh");
		report1.config().reportHeadline("Selenium");
		report1.config().reportName("Automation");
		return report1;
	}
	
	//----------------------------------------Time Stamp----------------------------------------------
	public static String Time_stamp()
	{
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
		String time = dateFormat.format(now);
		return time;
	}
	    
    //----------------------------------------Screen Report-------------------------------------------
    public static String Screen_Report(WebDriver driver) throws Throwable
	{
    	File source_image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String Image_path = Folder_path+"\\Screeshot"+Utility_libraries.Time_stamp()+".png";
		File Desti_image = new File(Image_path);
		FileUtils.copyFile(source_image,Desti_image);
		return ""+Desti_image;
	}
    
    //----------------------------------------Zip folder----------------------------------------------
    public static void Zip_folder(String Zip_folder)
    {
    	try
		  {
		    File inFolder=new File(Folder_path);
		    File outFolder=new File(Folder_path+"\\"+Zip_folder+".zip");
		    ZipOutputStream out = new ZipOutputStream(new  BufferedOutputStream(new FileOutputStream(outFolder)));
		    BufferedInputStream in = null;
		    byte[] data  = new byte[1000];
		    String files[] = inFolder.list();
		    	for (int i=0; i<files.length; i++)
		    	{
		    		in = new BufferedInputStream(new FileInputStream(inFolder.getPath() + "/" + files[i]), 1000);
		    		out.putNextEntry(new ZipEntry(files[i])); 
		    		int count;
		              while((count = in.read(data,0,1000)) != -1)
		               {
		                    out.write(data, 0, count);
		               }
		            out.closeEntry();
		    	}
		    out.flush();
		    out.close();
		  }
		 catch(Exception e)
		 {
		  e.printStackTrace();
		 }
    }
    //--------------------------------------Delete the subfolder--------------------------------------
    public static void Delete_folder(String Folder_path,String Condition) throws IOException, ParseException {

    	File file = new File(Folder_path); 
    	File[] files = file.listFiles(); 	
	    	if(Condition.isEmpty())
	    	{
	    		for(File eachfile: files)   
			    {
			    	File Subfile = new File(eachfile.getAbsolutePath());
			    	DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			    	//Find the file last modified date 
			    	Date lastModified_date = sdf.parse( sdf.format(eachfile.lastModified()));
			    	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			    	//File the current date
			    	Date Current_date = dateFormat.parse(dateFormat.format(new Date()));	    	
				   	   	if (Current_date.compareTo(lastModified_date) > 0) 
				   	   	{
				   	   		FileUtils.deleteDirectory(new File(Subfile.getAbsolutePath()));
				   	   	}
			    }
	    	}
	    	else
	    	{ 		
	    		for (File file1 : files)
	    		{
	    			file1.delete();
	    		}
	    	}		
	}
   //-----------------------------------ATU reporter for pass condition-------------------------------
   public static void ATUReport_Pass(String Detail,String value,String Expected,String Actual)  {
  	  
	  ATUReports.add(Detail,value,Expected,Actual,LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
  	  ATUReports.setAuthorInfo("Sourabh Chakroborty", new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()), "1.0");
    }
    
   //-----------------------------------ATU reporter for fail condition-------------------------------
   public static void ATUReport_Fail(String Detail,String value,String Expected,String Actual)  {
  	  
	  ATUReports.add(Detail,value,Expected,Actual,LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
  	  ATUReports.setAuthorInfo("Sourabh Chakroborty", new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()), "1.0");
    
    }
   //------------------------------------------Close all the window------------------------------------
   public static void Close(WebDriver driver,ExtentReports report1,ExtentTest logger)
   {
	   
	   	report1.endTest(logger);
		report1.flush();
		driver.close();			
   }
   //---------------------------------------Use to find POM through propertie file--------------------
   public static String GetElement(String Keys,String OR_name,String File_name) throws Throwable
	{
		FileInputStream pagobj =null;
		Properties obj = new Properties();
		try
		{ 
			pagobj = new FileInputStream (File_name);	
		}
		catch (Exception e) 
		{	
			System.out.println("File is not found");
		}
			obj.load(pagobj);
			return obj.getProperty(Keys);
	}
   //-----------------------------------------Verify the value is empty or not------------------------
   public static String[] Verify_value(String[] Array,ExtentTest logger,ExtentReports Extndreport)
   {
	   for(int i=0;i<=Array.length-1;i++)
	   {
		   if(Array[i].toString().isEmpty())
		   {
			   Assert.assertNull(Array[i].toString(), "Value is not present");
			   logger.log(LogStatus.FAIL,Array[i].toString(), "Value is not present");			   
			   Extndreport.flush();
			   return Array;
		   }
		   else
		   {
			   Assert.assertNotNull(Array[i].toString(), "Value is present");
			   logger.log(LogStatus.PASS,Array[i].toString(), "Value is present");
		   }		   
	   }
	   return Array;
   }
   public void Report_pass(String Step_details,String Actual,ExtentTest logger) throws Throwable
	{
		  //===========================Reporter======================================================================================
		  //=========================================================================================================================
	      logger.log(LogStatus.PASS,Step_details,Actual);
	      logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
		  Excel_libraries.Excel_Reporter(Step_details,Actual, "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
		  //=========================================================================================================================
		  //=========================================================================================================================
	}
	
	public void Report_fail(String Step_details,String Actual,ExtentTest logger) throws Throwable
	{
		  //===========================Reporter=====================================================================================
		  //========================================================================================================================
	      logger.log(LogStatus.FAIL,Step_details,Actual);
	      logger.log(LogStatus.FAIL,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
	      Excel_libraries.Excel_Reporter(Step_details,Actual, "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
		  //========================================================================================================================
		  //========================================================================================================================
	}
   
}
