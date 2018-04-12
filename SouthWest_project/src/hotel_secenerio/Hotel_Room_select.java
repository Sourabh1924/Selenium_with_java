package hotel_secenerio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import libraries.Excel_libraries;
import libraries.Utility_libraries;

public class Hotel_Room_select {

	WebDriver driver;
	ExtentTest logger;	
	
	public Hotel_Room_select(WebDriver driver,ExtentTest logger) 
	{
		this.driver = driver;
		this.logger = logger;
	}
	
	public String Hotel_select(String Senerio,String Hotel_name) throws Throwable
	{
		
		do 
		{
			List<WebElement> Alllist = driver.findElements(By.xpath("//span[@class='sr-hotel__name']"));
			

			for(WebElement we:Alllist)
				{
					if(Hotel_name.equals(we.getText()))
					{	
						
									  //===========================Reporter=============================
									  //================================================================
								      logger.log(LogStatus.PASS,"Hotel select","Hotel is selected.");
								      logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
								      //Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
								      Excel_libraries.Excel_Reporter("Hotel select","Hotel is selected.", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
									  //================================================================
									  //================================================================
					      
						we.click();
						//Create grand child window object
						Set<String> str1 = driver.getWindowHandles(); 
						System.out.println(str1.size());
						//Store all the window instance for iterator 
						Iterator<String> itr1 = str1.iterator();
						
						itr1.next();
						itr1.next();
						String Grand_child_window = itr1.next();
						//Switch to grand child window
						driver.switchTo().window(Grand_child_window);
						Thread.sleep(5000);
								if(Senerio.equals("Room Select"))
								{
									Hotel_Room_select Room_Select = new Hotel_Room_select(driver,logger);
									Room_Select.Roomselect();
									return Grand_child_window;
								}
								else
								{
									  
											  //===========================Reporter=============================
											  //================================================================
										      logger.log(LogStatus.PASS,"Hotel room select","Hotel room is selected.");
										      logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
										      //Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
										      Excel_libraries.Excel_Reporter("Hotel room select","Hotel room is selected.", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
											  //================================================================
											  //================================================================
										      
									driver.findElement(By.xpath(".//*[@id='group_recommendation']/table/tbody/tr/td[2]/table/tbody/tr[2]/td/a")).click();
									return Grand_child_window;
								}
					}
				}		
				driver.findElement(By.xpath("//a[contains(text(),'Next page')]")).click();
				Thread.sleep(10000);
			
		}
		while(driver.findElement(By.xpath("//a[contains(text(),'Next page')]")).isEnabled()==true);
		return null;
	}
	
	public void Roomselect() throws Throwable
	{
		WebElement Room = driver.findElement(By.xpath("//tr[@id='price_highlight_space']/td[5]/div[@class='roomDefaultUse ']/select"));
		Select dropdown_room = new Select(Room);
		dropdown_room.selectByIndex(2);
		
				  //===========================Reporter=============================
				  //================================================================
			      logger.log(LogStatus.PASS,"Hotel room select","Hotel room is selected.");
			      logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_libraries.Screen_Report(driver)));
			      //Function_libraries.ATUReport_Pass("Step-1",URL,"URL enter after browser open","Browser has to open");
			      Excel_libraries.Excel_Reporter("Hotel room select","Hotel room is selected.", "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
				  //================================================================
				  //================================================================
			      
		driver.findElement(By.cssSelector("#b_tt_holder_1")).click();
		
	}
	
}
