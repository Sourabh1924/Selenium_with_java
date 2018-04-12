package flight_secenerio;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Travel_by_availiblity {

	WebDriver driver;
	ExtentTest logger;
	ExtentReports report1;
	boolean counter = false;
	List<WebElement> List1;
	
	public Travel_by_availiblity(WebDriver driver,ExtentTest logger,ExtentReports report1) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.logger = logger;
		this.report1 = report1;
	}

	public void Select_Outgoing_Flight(String Class) throws Throwable
	{
		
		switch (Class.toLowerCase()) {
		
		case "business":
			List<WebElement> Business = driver.findElements(By.xpath("//tr[contains(@id,'outbound_flightRow')]/td[6]/descendant::div[@class='radioButtonRelativeContainer_outer']"));
			List1 = Business;
			break;
		case "anytime":
			List<WebElement> Anytime = driver.findElements(By.xpath("//tr[contains(@id,'outbound_flightRow')]/td[7]/descendant::div[@class='radioButtonRelativeContainer_outer']"));
			List1 = Anytime;
			break;
		case "wanna get away":
			List<WebElement> Wanna_get_away = driver.findElements(By.xpath("//tr[contains(@id,'outbound_flightRow')]/td[8]/descendant::div[@class='radioButtonRelativeContainer_outer']"));
			List1 = Wanna_get_away;
			break;
		}
				do 
					{
						for(WebElement we:List1)
							{
								we.click();
									try 
									{
										driver.findElement(By.xpath("//div[@id='upsellRowOutboundContent']/div")).isDisplayed();
										break;
									}
									catch(Exception e)
									{
										
									}
							}
					}	
					while(counter==true);
						Reporter Reporter_obj = new Reporter(driver, logger);
						Reporter_obj.Outbound_Report(Class);
				
	}		
		
	public void Select_Return_Flight(String Class) throws Throwable
	{
		switch (Class.toLowerCase()) {
		
		case "business":
			List<WebElement> Business = driver.findElements(By.xpath("//tr[contains(@id,'inbound_flightRow')]/td[6]/descendant::div[@class='radioButtonRelativeContainer_outer']"));
			List1 = Business;
			break;
		case "anytime":
			List<WebElement> Anytime = driver.findElements(By.xpath("//tr[contains(@id,'inbound_flightRow')]/td[7]/descendant::div[@class='radioButtonRelativeContainer_outer']"));
			List1 = Anytime;
			break;
		case "wanna get away":
			List<WebElement> Wanna_get_away = driver.findElements(By.xpath("//tr[contains(@id,'inbound_flightRow')]/td[8]/descendant::div[@class='radioButtonRelativeContainer_outer']"));
			List1 = Wanna_get_away;
			break;
		}
				do 
				{
					for(WebElement we:List1)
						{
							we.click();
								try 
								{
									driver.findElement(By.xpath("//div[@id='upsellRowInboundContent']/div")).isDisplayed();
									break;
								}
								catch(Exception e)
								{
									
								}			
						}
				}	
				while(counter==true);
					Reporter Reporter_obj = new Reporter(driver, logger);
					Reporter_obj.Outbound_Report(Class);
	}		

	public void Select_Senior_Out(String Class) throws Throwable
	{
		switch (Class.toLowerCase()) 
		{
		
		case "business":
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#Out1A")).click();
			break;
		case "anytime":
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#Out1B")).click();
			break;
		case "wanna get away":
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#Out1C")).click();
			break;
		case "senior":
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#Out1S")).click();
			break;
		}
		
		Reporter Reporter_obj = new Reporter(driver, logger);
		Reporter_obj.Outbound_Report(Class);
	}

	public void Select_Senior_Return(String Class) throws Throwable
	{
		switch (Class.toLowerCase()) 
		{
		
		case "business":
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#In1A")).click();
			break;
		case "anytime":
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#In1B")).click();
			break;
		case "wanna get away":
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#In1C")).click();
			break;
		case "senior":
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#In1S")).click();
			break;
		}
		
		Reporter Reporter_obj = new Reporter(driver, logger);
		Reporter_obj.Inbound_Report(Class);
	}

}
