package libraries;

import java.io.File;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.relevantcodes.extentreports.ExtentReports;
import reporter.Gmail_by_class;

public class Utilities_Libraries {
	  long screen_number;
	
	//Take ScreenShot method
	public void Screen(Object driver,String Path) throws Throwable
	{
		TakesScreenshot shot =(TakesScreenshot)driver;
		File source_image = shot.getScreenshotAs(OutputType.FILE);
		Date Time_stamp = new Date();
		screen_number = Time_stamp.getTime();
		File Desti_image = new File( Path+screen_number+".png");
		FileUtils.copyFile(source_image,Desti_image);
	}
	 public ExtentReports Report()
	   {	
		 	Date Time_stamp = new Date();
			screen_number = Time_stamp.getTime();
		 	ExtentReports report1 = new ExtentReports("F:\\"+Gmail_by_class.class.getName()+" . "+screen_number+".html");
			report1.addSystemInfo("Browser","Internet Explore");
			report1.addSystemInfo("Java version", "JDK 8");
			report1.addSystemInfo("Machine", "iDeliver8");
			report1.config().documentTitle("Sourabh");
			report1.config().reportHeadline("Selenium");
			report1.config().reportName("Automation");
			return report1;
	   }
	 public void Screen_Reporter(Object logger,Object driver,String Path,String Details) throws Throwable
	 {
		TakesScreenshot shot =(TakesScreenshot)driver;
		File source_image = shot.getScreenshotAs(OutputType.FILE);
		File Desti_image = new File( Path+screen_number+".png");
		FileUtils.copyFile(source_image,Desti_image);
		//logger.log(LogStatus.PASS,Details,logger.addScreenCapture(Path));
	 }
}
	
