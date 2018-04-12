package flight_secenerio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Price_verify {
	
	WebDriver driver;
	String Base_fare;
	String Excise_Taxes;
	String Segment_Fee;
	String Passenger_Facility_Charge;
	String Security_Fee;
	String Per_pass_fee;
	double Sen_total_fee;
	double Adu_total_fee;
	
	public Price_verify(WebDriver driver)
	{
		this.driver=driver;
	}

	public double Adult_price_verify(int Adult_number)
	{
		driver.findElement(By.cssSelector(".totalPriceDetailsText_ADT")).click();
		Base_fare = driver.findElement(By.cssSelector(".price_itinerary_popup_right_column.baseFare")).getText();
		Base_fare = Base_fare.replace("$", "");
		double Base_fare1 = Double.parseDouble(Base_fare);
		
		Excise_Taxes = driver.findElement(By.cssSelector(".price_itinerary_popup_right_column.exciseTaxes")).getText();
		Excise_Taxes = Excise_Taxes.replace("$", "");
		double Excise_Taxes1 = Double.parseDouble(Excise_Taxes);
		
		Segment_Fee = driver.findElement(By.cssSelector(".price_itinerary_popup_right_column.segmentFee")).getText();
		Segment_Fee = Segment_Fee.replace("$", "");
		double Segment_Fee1 = Double.parseDouble(Segment_Fee);
		
		Passenger_Facility_Charge = driver.findElement(By.cssSelector(".price_itinerary_popup_right_column.passengerFacilityFee")).getText();
		Passenger_Facility_Charge = Passenger_Facility_Charge.replace("$", "");
		double Passenger_Facility_Charge1 = Double.parseDouble(Passenger_Facility_Charge);
		
		Security_Fee = driver.findElement(By.cssSelector(".price_itinerary_popup_right_column.securityFee")).getText();
		Security_Fee = Security_Fee.replace("$", "");
		double Security_Fee1 = Double.parseDouble(Security_Fee);
		
		Per_pass_fee = driver.findElement(By.cssSelector(".price_itinerary_popup_right_column.totalPerPassenger")).getText();
		Per_pass_fee = Per_pass_fee.replace("$", "");
		double Per_pass_fee1 = Double.parseDouble(Per_pass_fee);
		
		double Total = Base_fare1 + Excise_Taxes1 + Segment_Fee1 + Passenger_Facility_Charge1 + Security_Fee1;
		Total = Total*Adult_number;
		Adu_total_fee = Per_pass_fee1*Adult_number;
		if(Double.compare(Math.round(Total),Math.round(Adu_total_fee))==0)
		{
			System.out.println("same price");
		}
		return Adu_total_fee;
	}
	
	public double Senior_price_verify(int Senoir_number)
	{
		driver.findElement(By.cssSelector(".totalPriceDetailsText_SRC")).click();
		Base_fare= driver.findElement(By.xpath(".//*[@id='page_bottom_popup_outer_container']/div[3]/div/div[2]/table/tbody/tr[1]/td[2]")).getText();
		Base_fare = Base_fare.replace("$", "");
		double Base_fare1 = Double.parseDouble(Base_fare);
		
		Excise_Taxes = driver.findElement(By.xpath(".//*[@id='page_bottom_popup_outer_container']/div[3]/div/div[2]/table/tbody/tr[2]/td[2]")).getText();
		Excise_Taxes = Excise_Taxes.replace("$", "");
		double Excise_Taxes1 = Double.parseDouble(Excise_Taxes);
		
		Segment_Fee = driver.findElement(By.xpath(".//*[@id='page_bottom_popup_outer_container']/div[3]/div/div[2]/table/tbody/tr[4]/td[2]")).getText();
		Segment_Fee = Segment_Fee.replace("$", "");
		double Segment_Fee1 = Double.parseDouble(Segment_Fee);
		
		Passenger_Facility_Charge = driver.findElement(By.xpath(".//*[@id='page_bottom_popup_outer_container']/div[3]/div/div[2]/table/tbody/tr[5]/td[2]")).getText();
		Passenger_Facility_Charge = Passenger_Facility_Charge.replace("$", "");
		double Passenger_Facility_Charge1 = Double.parseDouble(Passenger_Facility_Charge);
		
		Security_Fee = driver.findElement(By.xpath(".//*[@id='page_bottom_popup_outer_container']/div[3]/div/div[2]/table/tbody/tr[6]/td[2]")).getText();
		Security_Fee = Security_Fee.replace("$", "");
		double Security_Fee1 = Double.parseDouble(Security_Fee);
		
		Per_pass_fee = driver.findElement(By.xpath(".//*[@id='page_bottom_popup_outer_container']/div[3]/div/div[2]/table/tbody/tr[7]/td[2]")).getText();
		Per_pass_fee = Per_pass_fee.replace("$", "");
		double Per_pass_fee1 = Double.parseDouble(Per_pass_fee);
		
		double Total = Base_fare1 + Excise_Taxes1 + Segment_Fee1 + Passenger_Facility_Charge1 + Security_Fee1;
		Total = Total*Senoir_number;
		Sen_total_fee = Per_pass_fee1*Senoir_number;
		if(Double.compare(Math.round(Total),Math.round(Sen_total_fee))==0)
		{
			System.out.println("same price");
		}
		return Sen_total_fee;			
	}
}
