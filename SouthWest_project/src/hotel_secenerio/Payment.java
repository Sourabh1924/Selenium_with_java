package hotel_secenerio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Payment {

	WebDriver driver;
	String Total_price;
	
	public Payment(WebDriver driver) 
	{
		this.driver = driver;
	}

	public String Payment_details(String Price)
	{
		
		Total_price = driver.findElement(By.cssSelector(".jq-tooltip.bp_pricedetails_total_value")).getText();
		Total_price = Total_price.replace("US$", "").replace(" *", "").replace(",", "");
		// Enter ph number
		driver.findElement(By.cssSelector("#phone")).sendKeys("4578963254");
		try
		{
			// Select card type
			WebElement Card_type = driver.findElement(By.cssSelector("#cc_type"));
			Select dropdown_Card_type = new Select(Card_type);
			dropdown_Card_type.selectByVisibleText("Visa");
			// Enter card number
			driver.findElement(By.cssSelector("#cc_number")).sendKeys("46321785");
			// Select expiry month
			WebElement month = driver.findElement(By.cssSelector("#cc_month"));
			Select dropdown_month = new Select(month);
			dropdown_month.selectByVisibleText("05 - May");
			// Select expiry year
			WebElement year = driver.findElement(By.cssSelector("#ccYear"));
			Select dropdown_year = new Select(year);
			dropdown_year.selectByVisibleText("2019");
		}
		catch(Exception e)
		{
			
		}
		driver.findElement(By.cssSelector("#bonusmilesnr")).sendKeys("4587956");
		return Total_price;
	
	}
}
