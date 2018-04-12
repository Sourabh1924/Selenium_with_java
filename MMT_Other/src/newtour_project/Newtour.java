package newtour_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Newtour {
	
	//Variables declared
	static String username = "jhon",password = "mercury";
	static String passenger = "2",Destination = "London",Date = "21-August",Arriving = "Paris";
	static String Flight_num = "361";
	
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		//Start timer
		long Start_time = System.nanoTime();
				
		//Launch browser
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://newtours.demoaut.com/");
		
		//--------------------------------Login page--------------------------------- 
		
		driver.findElement(By.xpath("//input[contains(@name,'userName')]")).sendKeys(username);
		driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys(password);
		driver.findElement(By.xpath("//input[contains(@name,'login')]")).click();
		
		//------------------------------Flight booking page------------------------------------
		
			//Click on tour type
			driver.findElement(By.xpath("//input[contains(@value,'oneway')]")).click();
		
			//Select number of passenger by using Select Class
			WebElement drop_passenger = driver.findElement(By.xpath("//select[@name='passCount']"));
			Select dropdown = new Select(drop_passenger);
			dropdown.selectByVisibleText(passenger);
		
			//Select the Departing  city
			WebElement drop_from_city = driver.findElement(By.xpath("//select[@name='fromPort']"));
			Select dropdown1 = new Select(drop_from_city);
			dropdown1.selectByVisibleText(Destination);
		
			//Select the date
			String[] Date1 = Date.split("-");
			WebElement drop_from_month = driver.findElement(By.xpath("//select[@name='fromMonth']"));
			Select dropdown2 = new Select(drop_from_month);
			//Select month
			dropdown2.selectByVisibleText(Date1[1]);
			WebElement drop_from_day = driver.findElement(By.xpath("//select[@name='fromDay']"));
			Select dropdown3 = new Select(drop_from_day);
			//Select day
			dropdown3.selectByVisibleText(Date1[0]);

			//Select the Arriving  city
			WebElement drop_to_city = driver.findElement(By.xpath("//select[@name='toPort']"));
			Select dropdown4 = new Select(drop_to_city);
			dropdown4.selectByVisibleText(Destination);
			
			//Select traveling class
			driver.findElement(By.xpath("//input[@value='Business']")).click();
			
			//Click on 'Continue' button
			driver.findElement(By.xpath("//input[@name='findFlights']")).click();
			
	   //----------------------Flight Select Page----------------------	
			
			//Click on '361' flight number
			driver.findElement(By.xpath("//input[contains(@value,'361')]")).click();
			
			//Store the Attribute_value in a variable 
			String Store_prize =   driver.findElement(By.xpath("//input[contains(@value,'361')]")).getAttribute("value");
			
			//Split the string
			String[] Prize = Store_prize.split("Airlines");
			
			//Store the prize from substring
			String Rate = Prize[1].substring(5, 8);
			
			//Click on 'Continue' button
			driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();
			
	   //--------------------------Payment page--------------------------
			
			//Verification of rate 
			WebElement value = driver.findElement(By.xpath("//b[contains(text(),Flight_num)]/ancestor::td/following-sibling::td/descendant::font[contains(text(),'271')]"));
			String Rate1 = value.getText();
			if (Rate1.contentEquals(Rate))
			{
				System.out.println("Both the rate are same = "+value.getText());
			}
			else
			{
				System.out.println("Both the rate are not same = "+value.getText());
				System.out.println("Error :- Rate are not equal");
			}
			
			//Gave the card details
			driver.findElement(By.name("passFirst0")).sendKeys("Sourabh");
			driver.findElement(By.name("passLast0")).sendKeys("Sourabh");
			driver.findElement(By.name("creditnumber")).sendKeys("45896254");
			driver.findElement(By.name("buyFlights")).click();
			
	   //---------------------------Confirmation page--------------------------------
			
			//Verify booking is confirmed
			WebElement Status = driver.findElement(By.xpath("//font[contains(text(),'booked')]"));
			String Status1 = Status.getText();
			if(Status1.contentEquals("Your itinerary has been booked!"))
			{
				System.out.println("Booking is confirmed = "+Status.getText());
			}
			else
			{
				System.out.println("Booking is not confirmed = "+Status.getText());
				System.out.println("Error :- Booking error");
			}
				
			//Close the browser
			driver.close();
			
			//Stop timer
			long Stop_time = System.nanoTime();
			
			//Calculate total time to execute the script
			System.out.println("Total excuation time of the script is :- "+(Stop_time - Start_time)/1000000000+" seconds");
	}
}
