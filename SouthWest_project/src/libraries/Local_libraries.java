package libraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Local_libraries {

	static int num = 0;
	static String Attri ="";

		//----------------------------------------To get element for Enroll script------------------------------------------
		public static String GetElement_Enroll(String Keys,String OR_name) throws Throwable
		{
			FileInputStream pagobj =null;
			Properties obj = new Properties();
			try
			{ 		
				pagobj = new FileInputStream(System.getProperty("user.dir")+"\\src\\properties_file\\Enroll_properties.properties");
			}
			catch (Exception e) 
			{	
				System.out.println("File is not found");
			}
				obj.load(pagobj);
				return obj.getProperty(Keys);
		}
		
		//----------------------------------------To get element for Bus booking script------------------------------------------
		public static String GetElement_Bus(String Keys,String OR_name) throws Throwable
		{
			FileInputStream pagobj =null;
			Properties obj = new Properties();
			try
			{ 		
				pagobj = new FileInputStream(System.getProperty("user.dir")+"\\src\\properties_file\\Bus_properties.properties");
			}
			catch (Exception e) 
			{	
				System.out.println("File is not found");
			}
				obj.load(pagobj);
				return obj.getProperty(Keys);
		}
				
		//----------------------------------------To get element for Flight booking------------------------------------------
		public static String GetElement_Flight(String Keys,String OR_name) throws Throwable
		{
			FileInputStream pagobj =null;
			Properties obj = new Properties();
				try
				{ 		
					pagobj = new FileInputStream(System.getProperty("user.dir")+"\\src\\properties_file\\Flight_properties.properties");
				}
				catch (Exception e) 
				{	
					System.out.println("File is not found");
				}
			obj.load(pagobj);
			return obj.getProperty(Keys);
		}
				
		//----------------------------------------To get element for Hotel booking------------------------------------------
		public static String GetElement_Hotel(String Keys,String OR_name) throws Throwable
		{
			FileInputStream pagobj =null;
			Properties obj = new Properties();
				try
				{ 		
					pagobj = new FileInputStream(System.getProperty("user.dir")+"\\src\\properties_file\\Hotel_properties.properties");
				}
				catch (Exception e) 
				{	
					System.out.println("File is not found");
				}
			obj.load(pagobj);
			return obj.getProperty(Keys);
		}
		
		//-------------------------------------------Check for username exist ro not-----------------------------------------
		public static String name(WebDriver driver) throws Throwable, Throwable, Throwable
		 {
			 driver.findElement(By.cssSelector("#js-check-availability-link")).click();
			 Thread.sleep(3000);
			 String status = driver.findElement(By.cssSelector("#js-username-available")).getText();
			 if(status.equals("Sorry, already taken."))
				{
				 Local_libraries.username(driver);	
				}
			 else
			 {
				 return status;
			 }
			return null;

		 }
		
		//-------------------------------------------Take username from excel sheet---------------------------------------
		public static void username(WebDriver driver) throws Throwable, InvalidFormatException, IOException
		 {
			 FileInputStream fin=new FileInputStream("F:\\Sel\\SouthWest_project\\Project _Data\\Enroll_data.xls");
			 Workbook WB=WorkbookFactory.create(fin);
			 Sheet sh = WB.getSheet("Sheet2");
			 int Row_cnt = sh.getLastRowNum();	
				   for(int i=0;i<=Row_cnt;i++)  
				   {
					   if(num>Row_cnt) {
						   break;
					   }
					   Row rw_obj = sh.getRow(num);
					   Cell cell_obj = rw_obj.getCell(0);
					   Attri = cell_obj.toString();	
					   driver.findElement(By.cssSelector("#js-username")).clear();
					   Thread.sleep(3000);
					   driver.findElement(By.cssSelector("#js-username")).sendKeys(Attri);
					   driver.findElement(By.cssSelector("#js-check-availability-link")).click();
					   num++;
					   Local_libraries.name(driver);
				   }
				  
		 }

}
