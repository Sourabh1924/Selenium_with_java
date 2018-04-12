package run;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Download_through_IE11_and_MS_Edge_to_verify_certificate_signing {

	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub		
		
		String strBrowserName = "chrome";
		
		switch(strBrowserName.toLowerCase())
		{	
		//launch in ChromeDriver
		case "chrome":
			System.setProperty("webdriver.ie.driver", "E:\\Sourabh_Selenium\\Sel\\Selenium_python\\Driver\\IEDriverServer.exe");
			driver=new ChromeDriver();
		break;
		//launch in InternetExplorerDriver
		case "internetexplore":
			System.setProperty("webdriver.ie.driver", "E:\\Sourabh_Selenium\\Sel\\Selenium_python\\Driver\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		break;
		//------------------------------------------------
		//launch in EdgeDriver
		case "edge":
			System.setProperty("webdriver.edge.driver", "E:\\Sourabh_Selenium\\Sel\\Selenium_python\\Driver\\MicrosoftWebDriver.exe");
			driver=new EdgeDriver();
		break;
		}
			
		driver.navigate().to("https://www.tableau.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='products/desktop']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Try it')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='edit-profile-about-you-mail']")).sendKeys("sourabhc@ideliver-inc.com");
		driver.findElement(By.xpath("//button[contains(text(),'Download')]")).click();
		
			if(strBrowserName.toLowerCase()=="internetexplore")
				Runtime.getRuntime().exec("E:\\Sourabh_Selenium\\Sel\\Tablaeu_AutoIT\\AutoIT\\Save_the_Tabulea_exe_IE.exe");
			else if(strBrowserName.toLowerCase()=="edge")
				Runtime.getRuntime().exec("E:\\Sourabh_Selenium\\Sel\\Tablaeu_AutoIT\\AutoIT\\");
		Thread.sleep(3600000);
		driver.close();
		driver.quit();
		
	}

}
