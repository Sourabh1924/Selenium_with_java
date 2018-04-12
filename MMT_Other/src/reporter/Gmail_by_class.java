package reporter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
import gmail_by_class.Launch;

@Test
public class Gmail_by_class {
	
	WebDriver driver;
	WebDriverWait wait ;
	Reporter Util_obj;
	ExtentTest logger;
	static int count=1;
	
	//Create the driver
	@Parameters({"strBrowserName"})
	@BeforeSuite
	public void Driver(@Optional("firefox") String strBrowserName)  {
		this.driver = Launch.getBrowser(strBrowserName);
		this.Util_obj = new  Reporter(driver,logger);
		System.out.println("Test is launched "+strBrowserName);
	}
	
	//Launch the website
	@Parameters({"strURL"})
    @BeforeTest
    public  ExtentTest Launch(@Optional("https://www.gmail.com") String strURL)
    {
		driver.get(strURL);
		System.out.println("Website is showing "+strURL);
		logger = Reporter.Report().startTest("");
		return logger;
    }
	
	//Login in Gmail
	@Parameters({"strusername","strpassword"})
	@BeforeClass
	public void Test1(@Optional("memo.sourabh@gmail.com")String Username,@Optional("sourabh24")String Password) throws Throwable
	{
		Util_obj.Login(Username, Password);
		System.out.println("Enter Username "+Username+" Password "+Password);
	}
	
	//Compose the mail and send 
	@Test(dataProvider="data")
	public void Snd_Msg(String To_field,String cc_field,String subject,String content) throws Throwable
	{
		Util_obj.TC_Compose();
		Util_obj.TC_Add_to(To_field);
		Util_obj.TC_Add_cc(cc_field);
		Util_obj.TC_Subject(subject);
		Util_obj.TC_Body(content);
				//--------------------------------Reporter--------------------------------------
				Reporter.Screen_Report(driver,"Enter all the details");
				//--------------------------------------------------------------------------------
		Util_obj.TC_Send();
		System.out.println("Run for iteration"+count++);
	}
	
	//By using 'Dataprovider' send two mail by iterating the test
	@DataProvider(name="data") 
	public Object[][] data_provider()
	{
		Object[][] get = new Object[2][4];
		get[0][0]="memo.sourabh@gmail.com;";	
		get[0][1]="ideliver007@gmail.com;";	
		get[0][2]="My name is Sourabh";	
		get[0][3]="Automation complete";	
		
		get[1][0]="memo.sourabh@gmail.com;";	
		get[1][1]="ideliver007@gmail.com;";	
		get[1][2]="My name is Sourabh";	
		get[1][3]="Automation complete";
		return get;	
	}
	
	//Logout
	@AfterClass
	public void LogoutTest() throws Throwable  {
		Util_obj.Logout();
		 		//--------------------------------Reporter--------------------------------------
				Reporter.Screen_Report(driver,"Logout sucessfully");
				//--------------------------------------------------------------------------------
		System.out.println("Logout class");
    }
	
	//Close the browser
	@AfterTest
	public void CloseTest() throws Throwable  {
		  System.out.println("Close test");
		  Reporter.Report().endTest(logger);
		  Reporter.Report().flush();
		  		//--------------------------------Reporter--------------------------------------
				Reporter.Screen_Report(driver,"Close browser and flush the report successfully");
				//--------------------------------------------------------------------------------
		  driver.quit();
	}
}
