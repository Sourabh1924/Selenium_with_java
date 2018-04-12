package properties;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gmail {

	public static String GetElement(String Keys,String OR_name) throws Throwable
	{
		FileInputStream pagobj =null;
		Properties obj = new Properties();
		try
		{ 
			pagobj = new FileInputStream (System.getProperty("user.dir")+"/src\\properties"+"\\"+OR_name+".properties");	
		}
		catch (Exception e) 
		{	
			System.out.println("File is not found");
		}
			obj.load(pagobj);
			return obj.getProperty(Keys);
	}
	
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();	
		
		//Navigate to Gmail
		driver.navigate().to("http://www.gmail.com/");
		
		//-------------------------------------------Login-----------------------------------------------------//
		//-----------------------------------------------------------------------------------------------------//
		
		//Enter Username
		driver.findElement(By.id(Gmail.GetElement("id_email","Login"))).sendKeys("memo.sourabh@gmail.com");
		
		//Click on Next button
		driver.findElement(By.id(Gmail.GetElement("id_next","Login"))).click();
		Thread.sleep(2000);
		
		//Enter Password
		driver.findElement(By.name(Gmail.GetElement("name_password","Login"))).sendKeys("sourabh24");
		
		//Click on Sign In button
		driver.findElement(By.id(Gmail.GetElement("id_signin","Login"))).click();	
			
		//----------------------------------------------Compose------------------------------------------------------//
		//-----------------------------------------------------------------------------------------------------------//
		
		//Wait until 'COMPOSE' button is appear
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Gmail.GetElement("xp_compose","Compose"))));
				
		//Click on COMPOSE button
		driver.findElement(By.xpath(Gmail.GetElement("xp_compose","Compose"))).click();
				
		//Type the mail id in 'To' 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(Gmail.GetElement("name_to","Compose"))));
		driver.findElement(By.name(Gmail.GetElement("name_to","Compose"))).sendKeys("memo.sourabh@gmail.com");
				
		//Click on 'Cc' link 
		driver.findElement(By.xpath(Gmail.GetElement("xp_add_cc","Compose"))).click();
		Thread.sleep(2000);
				
		//Type the mail id in 'Cc'
		driver.findElement(By.xpath(Gmail.GetElement("xp_cc","Compose"))).sendKeys("ideliver007@gmail.com");
						
		//Enter subject of the mail
		//driver.findElement(By.xpath(Gmail.GetElement("xp_subject","Compose"))).sendKeys("My name is Sourabh");
		driver.findElement(By.xpath(Gmail.GetElement("xp_subject","Compose"))).sendKeys(Gmail.GetElement("subject_con", "Compose"));
		
		//Enter content in the mail
		driver.findElement(By.xpath(Gmail.GetElement("xp_body","Compose"))).sendKeys("Automation completed");
				
		//Click on 'Send' button
		driver.findElement(By.xpath(Gmail.GetElement("xp_send","Compose"))).click();
		Thread.sleep(2000);
		//Verify mail is send succesfully or n';ot
		boolean str = driver.findElement(By.xpath("//div[contains(text(),'Your message has been sent.')]")).isDisplayed();
		  if(str==true)
			{
				System.out.println("Mail is send succesfully");
			}
				
		//-------------------------------------------Signout-----------------------------------------------------//
		//-------------------------------------------------------------------------------------------------------//
		
		//Click on 'Account' button
		driver.findElement(By.xpath(Gmail.GetElement("xp_account","Login"))).click();
				
		//Click on 'Signout' button
		driver.findElement(By.xpath(Gmail.GetElement("xp_signout","Login"))).click();
								
		//Close the browser
		driver.close();
	}
}
