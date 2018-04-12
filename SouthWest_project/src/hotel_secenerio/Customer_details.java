package hotel_secenerio;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import libraries.Excel_libraries;
import libraries.Utility_libraries;

public class Customer_details {

	WebDriver driver;
	String Total_price;
	String INR_price;
	ExtentTest logger;
	
	public Customer_details(WebDriver driver,ExtentTest logger) {

		this.driver = driver;
		this.logger = logger;
	}

	public String Passenger_details() throws Throwable
	{
		Total_price = driver.findElement(By.cssSelector(".jq-tooltip.bp_pricedetails_total_value")).getText();
		Total_price = Total_price.replace("US$", "").replace(" *", "").replace(",", "");
		System.out.println(Total_price);
		INR_price = driver.findElement(By.cssSelector(".bp_pricedetails_total_hotel_currency")).getText();
		INR_price = INR_price.replace("Rs. ", "").replace(",", "");
		System.out.println(INR_price);
		driver.findElement(By.cssSelector(".bp_pricedetails_total_hotel_currency")).getText();
		// Select title
		WebElement Surname = driver.findElement(By.cssSelector("#booker_title"));
		Select dropdown_Surname = new Select(Surname);
		dropdown_Surname.selectByVisibleText("Mr.");
		// Enter first name
		driver.findElement(By.cssSelector("#firstname")).sendKeys("sourabh");
		// Enter last name
		driver.findElement(By.cssSelector("#lastname")).sendKeys("memo");
		Thread.sleep(10000);
		// Enter email address
		driver.findElement(By.cssSelector("#email")).click();
		driver.findElement(By.cssSelector("#email")).sendKeys("memo.sourabh@gmail.com");
		// Enter re-email address
		driver.findElement(By.cssSelector("#email_confirm")).click();
		driver.findElement(By.cssSelector("#email_confirm")).sendKeys("memo.sourabh@gmail.com");
		
				  //===========================Reporter=============================
				  //================================================================
			      logger.log(LogStatus.PASS,"Customer details","Customer details are enterd.");
			      logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
			      //Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
			      Excel_libraries.Excel_Reporter("Customer details","Customer details are enterd.", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
			      Excel_libraries.Excel_Reporter("Price in Rs.","Doller price "+Total_price+" converted into Indian Rs "+INR_price, "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
			      //================================================================
				  //================================================================
	      
		driver.findElement(By.cssSelector(".submit_holder_button")).click();
		
		return Total_price;
	}
}
