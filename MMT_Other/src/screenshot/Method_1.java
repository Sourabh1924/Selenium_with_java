package screenshot;


import java.io.File;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Method_1 {
	static WebDriver driver;
	static String strUsername="memo.sourabh@gmail.com";
	static String strPassword = "sourabh24";
	static long screen_number;	
	public static void Screen() throws Throwable
	{
		TakesScreenshot shot =(TakesScreenshot)driver;
		File source_image;
		source_image = shot.getScreenshotAs(OutputType.FILE);
		Method_1.Time_stamp();
		FileUtils.copyFile(source_image,new File( "F:\\Sel\\Selenium\\src\\screenshot\\Screenshot\\Screen_short"+screen_number+".png"));
	}
	
	public static void Time_stamp()
	{
		Date Time_stamp = new Date();
		screen_number = Time_stamp.getTime();
	}
	public static void main(String[] args) throws Throwable
	{
		JavascriptExecutor Js = (JavascriptExecutor)driver;
		driver = new FirefoxDriver();	
		//Navigate to Gmail
		driver.navigate().to("http://www.gmail.com/");
		
		//Enter Username
		WebElement username= driver.findElement(By.id("Email"));
		Js.executeScript("arguments[0].style.border='3px solid red'", username);
		Thread.sleep(3000);
		driver.findElement(By.id("Email")).sendKeys(strUsername);
		Method_1.Screen();
		
		//Click on Next button
		driver.findElement(By.id("next")).click();
		Thread.sleep(2000);
		
		//Enter Password
		driver.findElement(By.name("Passwd")).sendKeys(strPassword);
		Method_1.Screen();
		
		//Click on Sign In button
		driver.findElement(By.id("signIn")).click();
	}
}
