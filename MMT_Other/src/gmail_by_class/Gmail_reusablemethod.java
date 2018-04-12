package gmail_by_class;

import java.io.File;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gmail_reusablemethod {

	 WebDriver driver;
	 public Gmail_reusablemethod (WebDriver driver)
	{
		 
		this.driver=driver;
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
		}	
	}
	public void TC_Compose() throws Throwable
	{
		//Wait until 'COMPOSE' button is appear
		Gmail_reusablemethod.Screen(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
		//Click on COMPOSE button
		Gmail_reusablemethod.Screen(driver);
		driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
	}
	public  void Login(String strUserName,String StrPasword) throws Throwable
	{
		//Enter Username
		driver.findElement(By.id("identifierId")).sendKeys(strUserName);					
		//Click on Next button
		Gmail_reusablemethod.Screen(driver);
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(2000);
		//Enter Password
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(StrPasword);
		//Click on Sign In button
		Gmail_reusablemethod.Screen(driver);
		driver.findElement(By.id("passwordNext")).click();
	}
	public void Logout() throws Throwable
	{
		if (driver.findElement(By.xpath("//span[contains(@class,'gb_9a gbii')]")).isDisplayed())
		{
			//Click on 'Account' button
			Gmail_reusablemethod.Screen(driver);
			driver.findElement(By.xpath("//span[contains(@class,'gb_9a gbii')]")).click();	
		}
		if(driver.findElement(By.xpath("//a[contains(text(),'Sign')]")).isDisplayed())
		{
			//Click on 'Signout' button
			Gmail_reusablemethod.Screen(driver);
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
			//Take a screenshort
			Gmail_reusablemethod.Screen(driver);
		}
	}	
	static long screen_number;
	//Take ScreenShot method
	public static void Screen(WebDriver driver) throws Throwable
	{
		TakesScreenshot shot =(TakesScreenshot)driver;
		File source_image = shot.getScreenshotAs(OutputType.FILE);
		Gmail_reusablemethod.Time_stamp();
		FileUtils.copyFile(source_image,new File( "F:\\Sel\\Selenium\\src\\screenshot\\Screenshot\\Screen_short"+screen_number+".png"));
	}
	//TimeStamp method
	public static void Time_stamp()
	{
		Date Time_stamp = new Date();
		screen_number = Time_stamp.getTime();
	}
}

