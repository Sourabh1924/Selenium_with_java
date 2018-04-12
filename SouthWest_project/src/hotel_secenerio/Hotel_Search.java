package hotel_secenerio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import libraries.Excel_libraries;
import libraries.Local_libraries;
import libraries.Utility_libraries;

public class Hotel_Search {

	WebDriver driver;
	ExtentTest logger;	
	
	public Hotel_Search(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
	}
	
	public String[] Search() throws Throwable {
		
		String Destination = Excel_libraries.Read("Destination","Hotel_booking_data.xls");
		String CheckIn = Excel_libraries.Read("CheckIn","Hotel_booking_data.xls");
		String CheckOut = Excel_libraries.Read("CheckOut","Hotel_booking_data.xls");
		String Adult_number = Excel_libraries.Read("Adult_number","Hotel_booking_data.xls");
		String Child_number = Excel_libraries.Read("Child_number","Hotel_booking_data.xls");
		String Child_age = Excel_libraries.Read("Child_age","Hotel_booking_data.xls");
		
		//Click on Hotel link
		driver.findElement(By.cssSelector("#booking-form--hotel-tab")).click();
		//Create Parent__window object
		String Parent__window = driver.getWindowHandle();	
		//Switching to frame
		WebElement frame = driver.findElement(By.xpath("//iframe[contains(@src,'https://www.booking.com/')]"));
		driver.switchTo().frame(frame);
		//Enter Destination city
		driver.findElement(By.cssSelector("input[class*='b-aff-destination']")).sendKeys(Destination);
		//Clear the date field
		driver.findElement(By.cssSelector("#checkInDate")).clear();
		//Enter date field
		driver.findElement(By.cssSelector("#checkInDate")).sendKeys(CheckIn);
		//Clear the date field
		driver.findElement(By.cssSelector("#checkOutDate")).clear();
		//Enter date field
		driver.findElement(By.cssSelector("#checkOutDate")).sendKeys(CheckOut);
		//Select number of Adult
		WebElement Adult = driver.findElement(By.xpath("//select[@name='group_adults']"));
		Select dropdown_Adult = new Select(Adult);
		dropdown_Adult.selectByVisibleText(Adult_number);
		//Select number of Children
		WebElement Child = driver.findElement(By.xpath("//select[@name='group_children']"));
		Select dropdown_Child = new Select(Child);
		dropdown_Child.selectByVisibleText(Child_number);
		String Child_Age[] = {"xpath_child1","xpath_child2","xpath_child3","xpath_child4","xpath_child5","xpath_child6","xpath_child7","xpath_child8"};
		String Age[] = Child_age.split(",");
			for(int i=0;i<=Age.length-1;i++)
			{
				//Select number of Children
				WebElement Child1 = driver.findElement(By.xpath(Local_libraries.GetElement_Hotel(Child_Age[i],"Hotel_properties")));
				Select dropdown_Child_age = new Select(Child1);
				dropdown_Child_age.selectByVisibleText(Age[i]);
			}
		
					  //===========================Reporter=============================
					  //================================================================
				      logger.log(LogStatus.PASS,"Travelling details","City & travelling details are enter.");
				      logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
				      //Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
				      Excel_libraries.Excel_Reporter("Travelling details","City & travelling details are enter.", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
					  //================================================================
					  //================================================================
	      
		//Enter search button
		driver.findElement(By.cssSelector(".input_wrappper>button")).click();
		
		//Switch to Parent__window
		driver.switchTo().defaultContent();
		// Create child window object
		Set<String> str = driver.getWindowHandles();
		// Store all the window instance for iterator
		Iterator<String> itr = str.iterator();
		itr.next();
		String Child_window = itr.next();
		// Switch to child window
		driver.switchTo().window(Child_window);
		
		String[] window = new String[2];
		window[0] = Parent__window;
		window[1] = Child_window;
		return window;
		//return new MyResult(Parent__window, Child_window);
	}

}
