package flight_secenerio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import libraries.Excel_libraries;

public class Payment {

	WebDriver driver;
	
	public Payment(WebDriver driver)
	{
		this.driver = driver;
	}
	public void Payment_method(String Payment_method,String Confirmation_receipt) throws Throwable
	{
		String Email = Excel_libraries.Read("Email","Flight_booking_data.xls");
		String Card_type = Excel_libraries.Read("Card_type","Flight_booking_data.xls");
		String Card_number = Excel_libraries.Read("Card_number","Flight_booking_data.xls");
		String Exp_month = Excel_libraries.Read("Exp_month","Flight_booking_data.xls");
		String Exp_year = Excel_libraries.Read("Exp_year","Flight_booking_data.xls");
		String Ph_number = Excel_libraries.Read("Ph_number","Flight_booking_data.xls");
		
		if(Payment_method.toLowerCase().equals("paypal"))
		{
			driver.findElement(By.cssSelector("#payPalRadioButton")).click();
			
			if(Confirmation_receipt.equals("Email"))
			{
				driver.findElement(By.cssSelector("#emailConfirmationAddress")).sendKeys(Email);
			}
			else
			{
				driver.findElement(By.cssSelector("#faxConfirmationMethod")).click();
				String[] Ph_number1 = Ph_number.split("-");
				driver.findElement(By.cssSelector("#faxConfirmationAreaCode")).sendKeys(Ph_number1[0]);
				driver.findElement(By.cssSelector("#faxConfirmationPrefix")).sendKeys(Ph_number1[1]);
				driver.findElement(By.cssSelector("#faxConfirmationLine")).sendKeys(Ph_number1[2]);
			}
		}
		else
		{
			//Select card type
			WebElement Cardtype = driver.findElement(By.cssSelector("#creditCardType"));
			Select dropdown_Card_type = new Select(Cardtype);
			dropdown_Card_type.selectByVisibleText(Card_type);
			//Enter card number
			driver.findElement(By.cssSelector("#creditCardNumber1")).sendKeys(Card_number);
			//Select card expiry month
			WebElement Emonth = driver.findElement(By.cssSelector("#expirationMonth"));
			Select dropdown_Card_month = new Select(Emonth);
			dropdown_Card_month.selectByVisibleText(Exp_month);
			//Select card expiry year
			WebElement Eyear = driver.findElement(By.cssSelector("#expirationYear"));
			Select dropdown_Card_year = new Select(Eyear);
			dropdown_Card_year.selectByVisibleText(Exp_year);
			
		}
	}

}
