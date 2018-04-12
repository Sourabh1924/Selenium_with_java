package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class LoginGmailTest1 {
	
	WebDriver driver;
	WebDriverWait wait ;

  @Parameters({"URL"})	
  @BeforeTest
  public void Launch(@Optional("https://www.google.com") String URL) {
	driver = new FirefoxDriver();	
	wait = new WebDriverWait(driver,20);
	//Navigate to Gmail
	driver.navigate	().to(URL);
	System.out.println("Launch test");
	}
  
  @Parameters({"strUsername","strPassword"})
  @BeforeClass
  public void Login(@Optional("sou") String strUsername,@Optional("sam") String strPassword) throws Throwable {
	//Enter Username
	driver.findElement(By.id("Email")).sendKeys(strUsername);
			
	//Click on Next button
	driver.findElement(By.id("next")).click();
	Thread.sleep(2000);
					
	//Enter Password
	driver.findElement(By.name("Passwd")).sendKeys(strPassword);
			
	//Click on Sign In button
	driver.findElement(By.id("signIn")).click();
	System.out.println("Login class");   
	}
  
  @Test(priority=1)
  public void Composebutton() {
	
	//Wait until 'COMPOSE' button is appear
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
			
	//Click on COMPOSE button
	driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
	System.out.println("Test 1");
  }
  
  @Test(priority=2)
  public void To()
  {
	//Type the mail id in 'To' 
	wait.until(ExpectedConditions.presenceOfElementLocated(By.name("to")));
	driver.findElement(By.name("to")).sendKeys("memo.sourabh@gmail.com");
	System.out.println("Test 2");
  }
  
  @Test(priority=3)
  public void Cc() throws Throwable
  {
	//Click on 'Cc' link 
	driver.findElement(By.xpath("//span[contains(@aria-label,'Add Cc')]")).click();
	Thread.sleep(2000);
			
	//Type the mail id in 'Cc'
	driver.findElement(By.xpath("//textarea[@aria-label='Cc']")).sendKeys("ideliver007@gmail.com");
	System.out.println("Test 3");
  }
  
  @Test(priority=4)
  public void Subject() throws Throwable
  {
	//Enter subject of the mail
	driver.findElement(By.xpath("//input[contains(@name,'subjectbox')]")).sendKeys("My name is Sourabh"); 
	System.out.println("Test 4");
  }
  
  @Test(priority=5)
  public void Content() throws Throwable
  {
	//Enter content in the mail
	driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf']")).sendKeys("Automation completed");		
	System.out.println("Test 5");
  }
  
  @Test(priority=6)
  public void Send() throws Throwable
  {
	//Click on 'Send' button
	driver.findElement(By.xpath("//div[contains(text(),'Send') and @role='button']")).click();
	System.out.println("Test 6");
  }
  
  @AfterClass
  public void LogoutTest() {
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Send')]")));
	//Click on 'Account' button
	driver.findElement(By.xpath("//span[contains(@class,'gb_9a gbii')]")).click();
			
	//Click on 'Signout' button
	driver.findElement(By.xpath("//a[contains(text(),'Sign')]")).click();
	System.out.println("Logout class");
  }
  
  @AfterTest
  public void CloseTest()  {
	  driver.quit();
	  System.out.println("Close test");
  }
}
