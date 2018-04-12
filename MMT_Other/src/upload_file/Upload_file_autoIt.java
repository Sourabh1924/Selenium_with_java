package upload_file;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Upload_file_autoIt {
	
	static String File_path = "F:\\AutoIt_script\\Uploadfile.exe";
	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		WebDriver driver= new  FirefoxDriver();
		driver.navigate().to("https://www.123passportphoto.com/");
		driver.findElement(By.name("Submit1")).click();
		driver.findElement(By.id("file")).click();
		
		//AutoIT script excuate
		try {
			Runtime.getRuntime().exec(File_path);
			} 
		catch (Exception e) 
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		//Create a wait
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit1")));
		
		//Check "NEXT" button is showing or not 
		if(driver.findElement(By.name("Submit1")).isDisplayed())
		{
				System.out.println("NEXT button is showing");
				driver.close();
		}
	}
}

