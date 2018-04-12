package sams_club;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Run_Test {

	static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		driver = new FirefoxDriver();
		driver.navigate().to("https://www.samsclubchecks.com/");
  		
		//Check frame is display or not
		if(driver.findElement(By.cssSelector("#bx-close-inside-439505")).isDisplayed())
		{
			driver.findElement(By.cssSelector("a[id='bx-close-inside-439505']")).click();
		}
		//Click on Personal checks
		driver.findElement(By.cssSelector("a[href*='add=n14']")).click();
		//Click on Basic checks
		driver.findElement(By.cssSelector("a[href^='/c/personal'][href$='add=n21']")).click();
		//Pick the price of that elite checks
		String Price = driver.findElement(By.cssSelector(".errorsmall")).getText();
		System.out.println(Price);
		//Click on Elite checks
		driver.findElement(By.cssSelector("img[id*='ctl06']")).click();
		//Click on Single checks
		driver.findElement(By.cssSelector("li[id='secondTab']>a>span[id='sglTip']")).click();
		Thread.sleep(2000);
		//Select the checkbox
		driver.findElement(By.cssSelector("input[name*='2024_291']")).click();
		//Click on the Personalize button
		driver.findElement(By.cssSelector("#lnkBtnPersonalize")).click();
		
		
		driver.findElement(By.cssSelector("input[id='routenum']")).sendKeys("123123123");
		driver.findElement(By.cssSelector("input[id='acctnum']")).sendKeys("123456789");
		driver.findElement(By.cssSelector("input[id='checknum']")).sendKeys("1001");
		driver.findElement(By.cssSelector("input[id='micrline']")).sendKeys("123123123123456789");
		driver.findElement(By.cssSelector("input[id='txtEmail']")).sendKeys("houston@texas.com");
		driver.findElement(By.cssSelector("input[id='txtContactPhone']")).sendKeys("713-555-1212");
		driver.findElement(By.cssSelector("a[id='NextButtonTab1']")).click();
		
		
		driver.findElement(By.cssSelector("input[id='pline1']")).sendKeys("John Doe");
		driver.findElement(By.cssSelector("input[id='pline3']")).sendKeys("10391 Laureate Drive");
		driver.findElement(By.cssSelector("input[id='city']")).sendKeys("San Antonio");	
		WebElement State =driver.findElement(By.cssSelector("select[id='states']"));
		Select dropdown = new Select(State);
		dropdown.selectByVisibleText("TX");
		driver.findElement(By.cssSelector("input[id='zip']")).sendKeys("78249");
		driver.findElement(By.cssSelector("input[id='bankinfo1']")).sendKeys("Key Bank");	
		driver.findElement(By.cssSelector("a[id='NextButtonTab2']")).click();
	  
		Thread.sleep(5000);
		WebElement Address = driver.findElement(By.cssSelector("#rdoSureItsCorrect"));	
		Address.click();
		String Address1 = driver.findElement(By.cssSelector("#lblCurrentNotFound")).getText();
		System.out.println(Address1);
		driver.findElement(By.cssSelector("#lnkNotFoundContinue")).click();	
		driver.findElement(By.cssSelector("previewbutton1a")).click();	
		driver.findElement(By.cssSelector("#ckAgree")).click();
		driver.findElement(By.cssSelector("a[id='lbApproveButton2a']")).click();
		driver.findElement(By.cssSelector("ViewCartAndCheckout")).click();
	}
}
