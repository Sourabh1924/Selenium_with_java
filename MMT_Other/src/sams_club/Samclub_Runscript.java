package sams_club;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import make_my_trip.Element_libraries;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Samclub_Runscript {
  
  static WebDriver driver;                          // Create driver instance
  static ExtentReports report1;                     // Create reporter instance 
  static ExtentTest logger;							// Create logger instance
  static Element_libraries Elem_obj ;				// Create Class object
  public static String testName="MMT_TestNGaa";		// Create testname 
  
  
  @BeforeSuite
  public void beforeSuite() throws Throwable {
	    
//	//--------------------------------------Delete the previous folders---------------------------------------
//	Function_libraries.Delete_folder();
//	//------------------------------------------Create class object------------------------------------------- 
//	Elem_obj = new Element_libraries();		 
//	//--------------------------------------------Calling report-----------------------------------------------
//	report1=Function_libraries.Report();
//	//------------------------------------------Create a Excel file--------------------------------------------
//	Excel_libraries.Create_Excel_file();  	
  
  }
  
  @BeforeTest
  public void beforeTest() {
	  
	  WebDriver driver = new FirefoxDriver();
	  driver.navigate().to("https://www.samsclubchecks.com/index.aspx");
  }
  
  @Test(priority=1)
  public void Select_check() {
	
	//Check frame is display or not
	if(driver.findElement(By.cssSelector("a[id='bx-close-inside-439505']")).isDisplayed())
	{
		driver.findElement(By.cssSelector("a[id='bx-close-inside-439505']")).click();
	}
	//Click on Personal checks
	driver.findElement(By.cssSelector("a[href*='add=n14']")).click();
	//Click on Basic checks
	driver.findElement(By.cssSelector("a[href^='/c/personal'][href$='add=n21']")).click();
	//Pick the price of that elite checks
	//String Price = driver.findElement(By.cssSelector(".errorsmall")).getText();
	//Click on Elite checks
	driver.findElement(By.cssSelector("img[id*='ctl06']")).click();
	//Click on Single checks
	driver.findElement(By.cssSelector("li[id='secondTab']>a>span[id='sglTip']")).click();
	//Select the checkbox
	driver.findElement(By.cssSelector("input[name*='2024_291']")).click();
	//Click on the Personalize button
	driver.findElement(By.cssSelector("#lnkBtnPersonalize")).click();
	
  }
  
  @Test(priority=2)
  public void Customer_details() {
	  
	//Enter bank account routing number
	driver.findElement(By.cssSelector("input[id='routenum']")).sendKeys("123123123");
	//Enter bank account number
	driver.findElement(By.cssSelector("input[id='acctnum']")).sendKeys("123456789");
	//Enter check number
	driver.findElement(By.cssSelector("input[id='checknum']")).sendKeys("1001");
	//Enter both routing and bank account number
	driver.findElement(By.cssSelector("input[id='micrline']")).sendKeys("123123123123456789");
	//Enter Email
	driver.findElement(By.cssSelector("input[id='txtEmail']")).sendKeys("houston@texas.com");
	//Enter phone number
	driver.findElement(By.cssSelector("input[id='txtContactPhone']")).sendKeys("713-555-1212");
	//Click on Next button
	driver.findElement(By.cssSelector("a[id='NextButtonTab1']")).click();
  
  }
  
  @Test(priority=3)
  public void Customer_address()  {
	  
	//Enter customer account number  
    driver.findElement(By.id("pline1")).sendKeys("John Doe");
	//Enter customer address
    driver.findElement(By.id("pline3")).sendKeys("10391 Laureate Drive");
	//Enter city
    driver.findElement(By.id("city")).sendKeys("San Antonio");	
    //Enter state
    driver.findElement(By.id("states")).click();
	WebElement State =driver.findElement(By.id("states"));
	Select dropdown = new Select(State);
	dropdown.selectByVisibleText("TX");
	//Enter zipcode
	driver.findElement(By.id("zip")).sendKeys("78249");
	//Enter name of bank
	driver.findElement(By.id("bankinfo1")).sendKeys("Key Bank");	
	//Enter next button
	driver.findElement(By.id("NextButtonTab2")).click();
  
  }
 
  @Test(priority=4)
  public void Details() {
	  
	driver.findElement(By.cssSelector("input[id='rdoSureItsCorrect']")).click();	
	//String Address = driver.findElement(By.cssSelector("#lblCurrentNotFound")).getText();
	driver.findElement(By.cssSelector("#lnkNotFoundContinue")).click();	
	driver.findElement(By.cssSelector("previewbutton1a")).click();	
	driver.findElement(By.cssSelector("#ckAgree")).click();
	driver.findElement(By.cssSelector("a[id='lbApproveButton2a']")).click();
	driver.findElement(By.cssSelector("ViewCartAndCheckout")).click();
  
  }
  
  @Test(priority=5)
  public void price_verificaton() {
	  
	//String Select_ = driver.findElement(By.xpath("//option[@selected='selected']")).getText();		
	driver.findElement(By.id("ctlCart_CartItems_ctl00_multipleshipmethods_0")).click();
	//String Extra= driver.findElement(By.id("ctlCart_CartItems_ctl00_multipleshipmethods_0")).getText();	
	//String Collect = driver.findElement(By.id("ctlCart_CartItems_ctl00_dblPrice")).getText();
	//String Processing = driver.findElement(By.id("ctlCart_Handling")).getText();
	//String Sub_total = driver.findElement(By.id("ctlCart_Subtotal")).getText();
	driver.findElement(By.id("ctlCart_lbtnCheckout")).click();
	//String Sub_total1 = driver.findElement(By.id("Subtotal")).getText();
	//String Tax = driver.findElement(By.id("TaxAmount")).getText();
 
  }
  
  @Test(priority=6)
  public void Payment() {
	  
	driver.findElement(By.id("ccNumber")).sendKeys("4111111111111111");
	driver.findElement(By.id("CVV2")).sendKeys("751");
	driver.findElement(By.id("ccType")).click();	
	WebElement Card_type = driver.findElement(By.id("ccType"));
	Select dropdown1 = new Select(Card_type);
	dropdown1.selectByVisibleText("Visa");
	driver.findElement(By.id("expMonth")).click();
	WebElement Exp_mon = driver.findElement(By.id("expMonth"));
	Select dropdown2 = new Select(Exp_mon);
	dropdown2.selectByVisibleText("12");
	driver.findElement(By.id("expYear")).click();
	WebElement Exp_yer = driver.findElement(By.id("expYear"));
	Select dropdown3 = new Select(Exp_yer);
	dropdown3.selectByVisibleText("2019");
	driver.findElement(By.xpath(".//input[@value='Submit']")).click();
  
  }
  
//  @AfterMethod
//  public void Flush(ITestResult result) throws Throwable  {
//	
//	  if (result.getStatus() == ITestResult.FAILURE) {
//            logger.log(LogStatus.FAIL, "Test '"+ testName+ "' Failed : Cause>>"+result.getThrowable(),logger.addScreenCapture(Function_libraries.Screen_Report(driver)));		 
//            Excel_libraries.Excel_Reporter("Step-Fail", ""+result.getThrowable() , "Condition must be fullfill", "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
//   	  } 
//	  else if (result.getStatus() == ITestResult.SKIP) {
//		    logger.log(LogStatus.SKIP, "Test '"+ testName+ "' skipped : Cause>>"+ result.getThrowable(),logger.addScreenCapture(Function_libraries.Screen_Report(driver)));
//	  } 
//	  else {
//		   	logger.log(LogStatus.PASS, "Test  '"+ testName+"'  passed");
//	  }	  
//	  report1.endTest(logger);
//	  report1.flush();
//  }

  @AfterTest
  public void Close() {
	  
	  driver.close();
  
  }
  @AfterSuite
  public void afterSuite() {
	  
	  
	  
  }

}
