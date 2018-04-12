package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import gmail_by_class.Gmail_reusablemethod;
import gmail_by_class.Launch;

public class Gmail_by_class {
	
	WebDriver driver;
	WebDriverWait wait ;
	Gmail_reusablemethod Gmail_obj ;
	static int count=1;
	
	//Create the driver
	@Parameters({"strBrowserName"})
	@BeforeSuite
	public void Driver(@Optional("firefox") String strBrowserName)  {
		this.driver = Launch.getBrowser(strBrowserName);
		this.Gmail_obj = new  Gmail_reusablemethod(driver);
		System.out.println("Test is launched "+strBrowserName);
	}
	
	//Launch the website
	@Parameters({"strURL"})
    @BeforeTest
    public void Launch(@Optional("https://www.gmail.com") String strURL)
    {
		driver.get(strURL);
		System.out.println("Website is showing "+strURL);
    }
	
	//Login in Gmail
	@Parameters({"strusername","strpassword"})
	@Test(priority=1)
	public void Test1(String strusername,String strpassword) throws Throwable
	{
		Gmail_obj.Login(strusername, strpassword);
		System.out.println("Enter Username "+strusername+" Password "+strpassword);
	}
	
	//Compose the mail and send 
	@Test(dataProvider="data",priority=2)
	public void Snd_Msg(String To_field,String cc_field,String subject,String content) throws Throwable
	{
		Gmail_obj.TC_Compose();
		Gmail_obj.TC_Add_to(To_field);
		Gmail_obj.TC_Add_cc(cc_field);
		Gmail_obj.TC_Subject(subject);
		Gmail_obj.TC_Body(content);
		Gmail_obj.TC_Send();
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
		 Gmail_obj.Logout();
		System.out.println("Logout class");
    }
	
	//Close the browser
	@AfterTest
	public void CloseTest()  {
		  driver.quit();
		  System.out.println("Close test");
	}
}
