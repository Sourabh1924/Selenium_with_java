package make_my_trip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;


public class Function_libraries {

	public static WebDriver driver;
	static String Folder_path = System.getProperty("user.dir")+"\\src\\Test_Result\\ReportFolder"+Function_libraries.Time_stamp();
	static String Excel_path = Folder_path+"\\Excelreport"+Function_libraries.Time_stamp()+".xls";
	
	
	//----------------------------------------To get element------------------------------------------
	public static String GetElement(String Keys,String OR_name) throws Throwable
	{
		FileInputStream pagobj =null;
		Properties obj = new Properties();
		try
		{ 
			pagobj = new FileInputStream (System.getProperty("user.dir")+"/src\\make_my_trip"+"\\"+OR_name+".properties");	
		}
		catch (Exception e) 
		{	
			System.out.println("File is not found");
		}
			obj.load(pagobj);
			return obj.getProperty(Keys);
	}
	
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
	 	ExtentReports report1 = new ExtentReports(Folder_path+"\\Test"+Function_libraries.Time_stamp()+".html");
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
	
	//----------------------------------------To get page element-------------------------------------
    public static void page_Element(String Xpath_name,String Properties_name) throws Throwable
    {
    	//Wait until page is loaded
    	WebDriverWait wait = new WebDriverWait(driver,120);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Function_libraries.GetElement("xpath_filter", "Properties"))));	
    }
    
    //----------------------------------------Screen Report-------------------------------------------
    public static String Screen_Report(WebDriver driver) throws Throwable
	{
		TakesScreenshot shot =(TakesScreenshot)driver;
		File source_image = shot.getScreenshotAs(OutputType.FILE);
		String Image_path = Folder_path+"\\Screeshot"+Function_libraries.Time_stamp()+".png";
		File Desti_image = new File(Image_path);
		FileUtils.copyFile(source_image,Desti_image);
		return ""+Desti_image;
	}
    
    //----------------------------------------Zip folder----------------------------------------------
    public static void Zip_folder()
    {
    	try
		  {
		    File inFolder=new File(Folder_path);
		    File outFolder=new File(Folder_path+"\\MMT.zip");
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
    public static void Delete_folder() throws IOException {

		File file = new File(System.getProperty("user.dir")+"\\src\\Test_Result");
		File[] files = file.listFiles();
	    for(File eachfile: files)   
	    {
	    	  File Subfile = new File(eachfile.getAbsolutePath());
	   	   			if ( eachfile.lastModified() > 3 * 86400000) 
	   	   			{
	   	   				FileUtils.deleteDirectory(new File(Subfile.getAbsolutePath()));
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



}
