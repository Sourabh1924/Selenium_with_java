package newtour_project;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import libraries.Utilities_Libraries;

public class Run_NewTour {
	
	static String username = "jhon",password = "mercury";
	static String passenger = "2",Destination = "London",Date = "21-August",Arriving = "Paris";
	static String Flight_num = "361";
	static WebDriver driver;
	static String Path = "F:\\Sel\\Selenium\\src\\screenshot\\Screenshot";
	static Utilities_Libraries util_obj = new Utilities_Libraries();
	
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		driver = new FirefoxDriver();
		driver.navigate().to("http://newtours.demoaut.com/");
		
		//--------------------------------Login page--------------------------------- 
		
		
		driver.findElement(By.xpath("//input[contains(@name,'userName')]")).sendKeys(username);
		driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys(password);
		driver.findElement(By.xpath("//input[contains(@name,'login')]")).click();
		util_obj.Screen(driver, Path);
	}

}
