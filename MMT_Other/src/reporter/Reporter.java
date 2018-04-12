package reporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class Reporter {
	
	WebDriver driver;
	//ExtentTest logger;
	
	public Reporter (WebDriver driver,ExtentTest logger)
	{
		this.driver=driver;
		//this.logger = logger;
	}
	public  void  TC_Add_to(String To_field) throws Throwable
	{
		//Type the mail id in 'To'
		Thread.sleep(4000);
		driver.findElement(By.name("to")).sendKeys(To_field);
	}
	public void TC_Add_cc(String cc_field) throws Throwable
	{
		if (driver.findElement(By.xpath("//span[contains(@aria-label,'Add Cc')]")).isDisplayed())
		{
			//Click on 'Cc' link 
			driver.findElement(By.xpath("//span[contains(@aria-label,'Add Cc')]")).click();
			Thread.sleep(2000);
			//Type the mail id in 'Cc'
			driver.findElement(By.xpath("//textarea[@aria-label='Cc']")).sendKeys(cc_field);
		}
	}
	public void TC_Send() throws Throwable
	{
		if (driver.findElement(By.xpath("//div[contains(text(),'Send') and @role='button']")).isDisplayed())
		{
			//Click on 'Send' button
			driver.findElement(By.xpath("//div[contains(text(),'Send') and @role='button']")).click();
			Thread.sleep(3000);
		}	
	}
	public void TC_Compose() throws Throwable
	{
		//Wait until 'COMPOSE' button is appear
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
		//Click on COMPOSE button
		
		driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
	}
	public  void Login(String strUserName,String StrPasword) throws Throwable
	{
		//Enter Username
		driver.findElement(By.id("Email")).sendKeys(strUserName);					
				
				//--------------------------------Reporter--------------------------------------
				Reporter.Screen_Report(driver,"Enter Username"+strUserName);
				//--------------------------------------------------------------------------------
		
		//Click on Next button
		driver.findElement(By.id("next")).click();
		Thread.sleep(2000);
		//Enter Password
		driver.findElement(By.name("Passwd")).sendKeys(StrPasword);
				
				//--------------------------------Reporter--------------------------------------
				Reporter.Screen_Report(driver,"Enter Password"+StrPasword);
				//--------------------------------------------------------------------------------
		
		//Click on Sign In button
		driver.findElement(By.id("signIn")).click();
	}
	public void Logout() throws Throwable
	{
		if (driver.findElement(By.xpath("//span[contains(@class,'gb_9a gbii')]")).isDisplayed())
		{
			//Click on 'Account' button
			
			driver.findElement(By.xpath("//span[contains(@class,'gb_9a gbii')]")).click();	
		}
		if(driver.findElement(By.xpath("//a[contains(text(),'Sign')]")).isDisplayed())
		{
			//Click on 'Signout' button
			
			driver.findElement(By.xpath("//a[contains(text(),'Sign')]")).click();
		}
	}
	public void TC_Subject(String subject)
	{
		if(driver.findElement(By.xpath("//input[contains(@name,'subjectbox')]")).isDisplayed())
		{
			//Enter subject of the mail
			driver.findElement(By.xpath("//input[contains(@name,'subjectbox')]")).sendKeys(subject);			
		}
	}
	public void TC_Body(String content) throws Throwable
	{
		if(driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf']")).isDisplayed())
		{
			//Enter content in the mail
			driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf']")).sendKeys(content);
		}
	}		
	public static ExtentReports Report()
	{	
		Reporter.Time_stamp();
	 	ExtentReports report1 = new ExtentReports("F:\\Sel\\Selenium\\src\\TestResult\\"+Reporter.Folder_create()+"\\"+Reporter.Time_stamp()+".html");
		report1.addSystemInfo("Browser","Internet Explore");
		report1.addSystemInfo("Java version", "JDK 8");
		report1.addSystemInfo("Machine", "iDeliver8");
		report1.config().documentTitle("Sourabh");
		report1.config().reportHeadline("Selenium");
		report1.config().reportName("Automation");
		return report1;
	}
	public static String Time_stamp()
	{
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh mm ss");
		String time = dateFormat.format(now);
		return time;
	}
	public static void Screen_Report(Object driver,String Details) throws Throwable
	{
		//Gmail_by_class obj = new Gmail_by_class();
		TakesScreenshot shot =(TakesScreenshot)driver;
		File source_image = shot.getScreenshotAs(OutputType.FILE);
		Reporter.Time_stamp();
		File Desti_image = new File("F:\\Sel\\Selenium\\src\\TestResult\\"+Reporter.Folder_create()+"\\"+Reporter.Time_stamp()+".png");
		FileUtils.copyFile(source_image,Desti_image);
		//obj.logger.log(LogStatus.PASS,Details,obj.logger.addScreenCapture(Desti_image.toString()));
	}
	public static  String Folder_create()
	{
		File file = new File("F:\\Sel\\Selenium\\src\\TestResult\\"+Reporter.Time_stamp());
		file.mkdirs();
		return file.toString();
	}
}
