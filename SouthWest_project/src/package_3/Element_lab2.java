package package_3;

import org.openqa.selenium.By;

import libraries.Local_libraries;

public class Element_lab2 {

	public By One_way() throws Throwable
	{
		By one_way = By.cssSelector(Local_libraries.GetElement_Flight("css_type", "Flight_properties"));
		return one_way;
	}
	
	public By Departure() throws Throwable
	{
		By departure = By.cssSelector(Local_libraries.GetElement_Flight("css_departure", "Flight_properties"));
		return departure;
	}
	
	public By Arrival() throws Throwable
	{
		By arrival = By.cssSelector(Local_libraries.GetElement_Flight("css_arrival", "Flight_properties"));
		return arrival;
	}
	
	public By Departure_date() throws Throwable
	{
		By departure_date = By.cssSelector(Local_libraries.GetElement_Flight("css_departure_date", "Flight_properties"));
		return departure_date;
	}
	
	public By Search() throws Throwable
	{
		By search = By.xpath(Local_libraries.GetElement_Flight("css_submit", "Flight_properties"));
		return search;
	}
	
	public By Flight_select() throws Throwable
	{
		By select = By.cssSelector(Local_libraries.GetElement_Flight("css_flight_select", "Flight_properties"));
		return select;
	}
	
	public By Submit_button() throws Throwable
	{
		By submit = By.cssSelector(Local_libraries.GetElement_Flight("css_submit", "Flight_properties"));
		return submit;
	}
	
	public By Flight_price() throws Throwable
	{
		By price = By.cssSelector(Local_libraries.GetElement_Flight("css_price", "Flight_properties"));
		return price;
	}
	
	public By Book_button() throws Throwable
	{
		By book = By.cssSelector(Local_libraries.GetElement_Flight("css_book", "Flight_properties"));
		return book;
	}
	
	public By Fname() throws Throwable
	{
		By fname = By.cssSelector(Local_libraries.GetElement_Flight("css_fname", "Flight_properties"));
		return fname;
	}
	
	public By Lname() throws Throwable
	{
		By lname = By.cssSelector(Local_libraries.GetElement_Flight("css_lname", "Flight_properties"));
		return lname;
	}
	
	public By DOB_month() throws Throwable
	{
		By month = By.cssSelector(Local_libraries.GetElement_Flight("css_dob_month", "Flight_properties"));
		return month;
	}
	
	public By DOB_day() throws Throwable
	{
		By day = By.cssSelector(Local_libraries.GetElement_Flight("css_dob_day", "Flight_properties"));
		return day;
	}
	
	public By DOB_year() throws Throwable
	{
		By year = By.cssSelector(Local_libraries.GetElement_Flight("css_dob_year", "Flight_properties"));
		return year;
	}

	public By Gender() throws Throwable
	{
		By gender = By.cssSelector(Local_libraries.GetElement_Flight("css_gender", "Flight_properties"));
		return gender;
	}

	public By Email() throws Throwable
	{
		By email = By.cssSelector(Local_libraries.GetElement_Flight("css_email", "Flight_properties"));
		return email;
	}

	public By Card_type() throws Throwable
	{
		By card_type = By.cssSelector(Local_libraries.GetElement_Flight("css_card_type", "Flight_properties"));
		return card_type;
	}

	public By Card_number() throws Throwable
	{
		By card_number = By.cssSelector(Local_libraries.GetElement_Flight("css_card_number", "Flight_properties"));
		return card_number;
	}

	public By Expiry_year() throws Throwable
	{
		By expiry_year = By.cssSelector(Local_libraries.GetElement_Flight("css_exp_year", "Flight_properties"));
		return expiry_year;
	}

	public By Expiry_month() throws Throwable
	{
		By expiry_month = By.cssSelector(Local_libraries.GetElement_Flight("css_exp_month", "Flight_properties"));
		return expiry_month;
	}
	
	public By Total_price() throws Throwable
	{
		By total_price = By.cssSelector(Local_libraries.GetElement_Flight("css_total_cost", "Flight_properties"));
		return total_price;
	}
	
	public By Non_stop() throws Throwable
	{
		By one_way = By.cssSelector(Local_libraries.GetElement_Flight("css_non_stop", "Flight_properties"));
		return one_way;
	}
	
	public By Direct() throws Throwable
	{
		By departure = By.cssSelector(Local_libraries.GetElement_Flight("css_direct", "Flight_properties"));
		return departure;
	}
	
	public By Total_Cus_fare() throws Throwable
	{
		By departure = By.cssSelector(Local_libraries.GetElement_Flight("css_total_Cus_fare", "Flight_properties"));
		return departure;
	}
	
	public By Total_credit() throws Throwable
	{
		By departure = By.cssSelector(Local_libraries.GetElement_Flight("css_Total_credit", "Flight_properties"));
		return departure;
	}

	public By Total_cart_price() throws Throwable
	{
		By departure = By.cssSelector(Local_libraries.GetElement_Flight("css_total_price", "Flight_properties"));
		return departure;
	}
}
