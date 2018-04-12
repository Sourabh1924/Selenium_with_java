package car_secenerio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import libraries.Excel_libraries;
import libraries.Utility_libraries;

public class Car_search {

	WebDriver driver;
	ExtentTest logger;
	boolean counter=false;
	
	public Car_search(WebDriver driver,ExtentTest logger) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.logger = logger;
	}
	
	public void Search(String Drop_Time,String Pick_Time,String Rental_company,String Car_type,String Pick_UP_Location,String Pick_UP_Date,String Return_Location,String Return_Date) throws Throwable
	{
		//Click on car tab
		driver.findElement(By.cssSelector("#booking-form--car-tab")).click();	
		Thread.sleep(2000);
		//Select the Pickup location
		driver.findElement(By.cssSelector("#car-location-pick-up")).sendKeys(Pick_UP_Location);
		//Select return location
		driver.findElement(By.cssSelector("#car-location-drop-off")).clear();
		driver.findElement(By.cssSelector("#car-location-drop-off")).sendKeys(Return_Location);
		//Click pickup date
		driver.findElement(By.cssSelector("#car-date-pick-up")).clear();
		driver.findElement(By.cssSelector("#car-date-pick-up")).sendKeys(Pick_UP_Date);
		//Click drop date
		driver.findElement(By.cssSelector("#car-date-drop-off")).clear();
		driver.findElement(By.cssSelector("#car-date-drop-off")).sendKeys(Return_Date);
		//Select rental company
		driver.findElement(By.cssSelector("#booking-form--car-panel")).click();
		//Select pickup time
		driver.findElement(By.cssSelector("#car-time-pick-up")).click();
		Car_search Search_obj = new Car_search( driver, logger);
		Search_obj.Time(Pick_Time);
		Thread.sleep(1000);
		//Select drop time
		driver.findElement(By.cssSelector("#car-time-drop-off")).click();
		Search_obj.Time(Drop_Time);
		Thread.sleep(1000);
		//Click on vendor company 
		driver.findElement(By.cssSelector("#vendors")).click();
		driver.findElement(By.cssSelector("#vendors")).click();
		Thread.sleep(2000);
		//Loop for select the company		
		do 
		{
			List<WebElement> Alllist = driver.findElements(By.xpath("//li[@role='option']"));

			for(WebElement we:Alllist)
				{
				Thread.sleep(1000);
					if(Rental_company.equals(we.getText()))
							{
								we.click();
								break;
							}
				}
		}	
		while(counter==true);
		//Select the car size
		driver.findElement(By.cssSelector("#car-size")).click();
		Thread.sleep(1000);
		//Loop for select the car size
		do 
		{
			List<WebElement> Alllist = driver.findElements(By.xpath("//li[@role='option']"));

			for(WebElement we:Alllist)
				{
					Thread.sleep(1000);
					if(Car_type.equals(we.getText()))
							{
								we.click();
								break;
							}
				}
		}	
		while(counter==true);
		
				  //===========================Reporter=============================
				  //================================================================
			      logger.log(LogStatus.PASS,"Travelling details","Travelling details are entered");
			      logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
			      //Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
			      Excel_libraries.Excel_Reporter("Travelling details","Travelling details are entered", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				  //================================================================
				  //================================================================
	      
		//Click on search button
		driver.findElement(By.cssSelector(".js-button-search-car.swa-button.swa-button_primary")).click();
		Thread.sleep(6000);
	}
	
	public void Time(String Time)
	{
		int k=1;
		for(int i=0;i<=37;i++)
		{
		driver.findElement(By.cssSelector(".menu--arrow.js-menu-scroll-up")).click();
		}
		
		do 
		{
			List<WebElement> Alllist = driver.findElements(By.xpath("//li[@role='option']"));

			for(WebElement we:Alllist)
				{
					k++;
					if(we.getText().equals(Time))
					{
						we.click();
						break;
					}
					if(k==10)
					{
						for(int j=1;j<=k;j++)
						{
							driver.findElement(By.cssSelector(".menu--arrow.js-menu-scroll-down")).click();
						}
						k=1;
					}
						
				}
		}	
		while(counter==true);
		counter=false;
	}

}
