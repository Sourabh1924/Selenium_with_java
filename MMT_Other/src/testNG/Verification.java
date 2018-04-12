package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Verification {
	
		
 @Test
 public void test1() throws Throwable {
	
	 WebDriver driver = new FirefoxDriver();
	 driver.get("https://www.gmail.com");
	 driver.findElement(By.id("Email")).sendKeys("memo.sourabh@gmail.com");
	 boolean Flage;
		  if (Flage = driver.findElement(By.id("next")).isEnabled())
		  {
			  System.out.println(Flage);
			Assert.assertFalse(Flage, "Next button is still showing");
			Assert.assertTrue(Flage, "Next button is showing");
			driver.findElement(By.id("next")).click();
		  }
	 Thread.sleep(3000);
	 driver.findElement(By.name("Passwd")).sendKeys("sourabh24");
	 driver.findElement(By.id("signIn")).click();
	 System.out.println("Test1");
	}
 @Test
 public void test2() throws Throwable {
	
	 WebDriver driver = new FirefoxDriver();
	 driver.get("https://www.gmail.com");
	 driver.findElement(By.id("Email")).sendKeys("memo.sourabh@gmail.com");
	 String Flage = driver.findElement(By.id("next")).getAttribute("value");
	 Assert.assertEquals("Next",Flage );
	 driver.findElement(By.id("next")).click();
		  
	 Thread.sleep(3000);
	 driver.findElement(By.name("Passwd")).sendKeys("sourabh24");
	 driver.findElement(By.id("signIn")).click();
	 System.out.println("Test2");
	}
 @Test
 public void test() throws Throwable {
	
	 WebDriver driver = new FirefoxDriver();
	 driver.get("https://www.gmail.com");
	 driver.findElement(By.id("Email")).sendKeys("memo.sourabh@gmail.com");
	 boolean Flage;
		  if (Flage = driver.findElement(By.id("next")).isEnabled())
		  {
			System.out.println(Flage);
			Assert.fail();
			Assert.assertTrue(Flage, "Next button is showing");
			driver.findElement(By.id("next")).click();
		  }
	 Thread.sleep(3000);
	 driver.findElement(By.name("Passwd")).sendKeys("sourabh24");
	 driver.findElement(By.id("signIn")).click();
	 System.out.println("Test3");
	}
}
