package flight_secenerio;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import libraries.Local_libraries;

public class Passenger {

	static Workbook WB;
	String Word = "";

	public void Passenger_details(String Adult_pass,WebDriver driver) throws Throwable{
		
		 String Fname[] 	= {"css_fname1","css_fname2","css_fname3","css_fname4","css_fname5","css_fname6","css_fname7","css_fname8"};
		 String Lname[] 	= {"css_lname1","css_lname2","css_lname3","css_lname4","css_lname5","css_lname6","css_lname7","css_lname8"};
		 String DOB_month[] = {"css_dob_month1","css_dob_month2","css_dob_month3","css_dob_month4","css_dob_month5","css_dob_month6","css_dob_month7","css_dob_month8"};
		 String DOB_day[] 	= {"css_dob_day1","css_dob_day2","css_dob_day3","css_dob_day4","css_dob_day5","css_dob_day6","css_dob_day7","css_dob_day8"};
		 String DOB_year[] 	= {"css_dob_year1","css_dob_year2","css_dob_year3","css_dob_year4","css_dob_year5","css_dob_year6","css_dob_year7","css_dob_year8"};
		 String Gender[] 	= {"css_gender1","css_gender2","css_gender3","css_gender4","css_gender5","css_gender6","css_gender7","css_gender8"};		 
		 String[] Name		= null;
		 String[] words		= Adult_pass.split(",");
		 int a 				= 0;
		 String Word 		= "";
		 FileInputStream fin=new FileInputStream(System.getProperty("user.dir")+"\\Project _Data\\Flight_booking_data.xls");    
			WB=WorkbookFactory.create(fin);
			Sheet sh = WB.getSheet("Sheet2");
			int Row_cnt = sh.getLastRowNum();
			
				for(int i=0;i<=Row_cnt;i++)
				{
					Row rw_obj = sh.getRow(i);
					int col_num = rw_obj.getLastCellNum();
					   Cell cell_obj = rw_obj.getCell(0);
					   String Attri = cell_obj.toString();
					      if(Attri.equals(words[a])) 
					      {
					    	   for(int j=1;j<=col_num-1;j++)
					    	   {
					    		   Cell Attri_valu= rw_obj.getCell(j);
								   String Attri_valu1 = Attri_valu.toString();
								   Word = Word +""+Attri_valu1+","; 
					    	   }
					    	   Name = Word.split(",");
					    	   for(int k=a;k<=a;k++)  {
					   				
					    		   	driver.findElement(By.cssSelector(Local_libraries.GetElement_Flight(Fname[k], "Flight_properties"))).sendKeys(Name[0]);
					   				driver.findElement(By.cssSelector(Local_libraries.GetElement_Flight(Lname[k], "Flight_properties"))).sendKeys(Name[1]);
					   				//Select customer DOB month
					   				WebElement month = driver.findElement(By.cssSelector(Local_libraries.GetElement_Flight(DOB_month[k], "Flight_properties")));
					   				Select dropdown_DOB = new Select(month);
					   				dropdown_DOB.selectByVisibleText(Name[2]);
					   				//Select customer DOB day
					   				WebElement day = driver.findElement(By.cssSelector(Local_libraries.GetElement_Flight(DOB_day[k], "Flight_properties")));
					   				Select dropdown_DOB1 = new Select(day);
					   				dropdown_DOB1.selectByVisibleText(Name[3]);
					   				//Select customer DOB year
					   				WebElement year = driver.findElement(By.cssSelector(Local_libraries.GetElement_Flight(DOB_year[k], "Flight_properties")));
					   				Select dropdown_DOB2 = new Select(year);
					   				dropdown_DOB2.selectByVisibleText(Name[4]);
					   				//Select gender
					   				WebElement Gend = driver.findElement(By.cssSelector(Local_libraries.GetElement_Flight(Gender[k], "Flight_properties")));
					   				Select dropdown_DOB3 = new Select(Gend);
					   				dropdown_DOB3.selectByVisibleText(Name[5]);	   				
					    	   }
					    	   a++;
					    	   if(words.length==a)
					    	   {
					    		   break;
					    	   }
					    	   
					    	  i=0;
					    	  Word="";
					      }
				}
	}

	
}