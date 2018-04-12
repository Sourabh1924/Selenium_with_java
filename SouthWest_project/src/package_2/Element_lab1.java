package package_2;

import org.openqa.selenium.By;

import libraries.Local_libraries;

public class Element_lab1 {

	public By Hotel_link() throws Throwable
	{
		By Hotel = By.cssSelector(Local_libraries.GetElement_Hotel("css_hotel_link", "Hotel_properties"));
		return Hotel;
	}
	
	public By Switch_frame() throws Throwable
	{
		By frame = By.xpath(Local_libraries.GetElement_Hotel("Switch_frame", "Hotel_properties"));
		return frame;
	}
	
	public By Destination() throws Throwable
	{
		By Destination = By.cssSelector(Local_libraries.GetElement_Hotel("css_destination", "Hotel_properties"));
		return Destination;
	}
	
	public By Checkin() throws Throwable
	{
		By Checkin = By.cssSelector(Local_libraries.GetElement_Hotel("css_checkin", "Hotel_properties"));
		return Checkin;
	}
	
	public By Checkout() throws Throwable
	{
		By Checkout = By.cssSelector(Local_libraries.GetElement_Hotel("css_checkout", "Hotel_properties"));
		return Checkout;
	}
	
	public By Search() throws Throwable
	{
		By Search = By.cssSelector(Local_libraries.GetElement_Hotel("css_search", "Hotel_properties"));
		return Search;
	}
	
	public By Hotel_click() throws Throwable
	{
		By Hotel_click = By.cssSelector(Local_libraries.GetElement_Hotel("css_click", "Hotel_properties"));
		return Hotel_click;
	}
	
	public By Room_select() throws Throwable
	{
		By Room_select = By.xpath(Local_libraries.GetElement_Hotel("xpath_room_select", "Hotel_properties"));
		return Room_select;
	}
	
	public By Total_price() throws Throwable
	{
		By Total_price = By.cssSelector(Local_libraries.GetElement_Hotel("css_total_price", "Hotel_properties"));
		return Total_price;
	}
	
	public By Reserve() throws Throwable
	{
		By Reserve = By.cssSelector(Local_libraries.GetElement_Hotel("css_reserve", "Hotel_properties"));
		return Reserve;
	}

	public By Title() throws Throwable
	{
		By title = By.cssSelector(Local_libraries.GetElement_Hotel("css_title", "Hotel_properties"));
		return title;
	}
	
	public By Fname() throws Throwable
	{
		By fname = By.cssSelector(Local_libraries.GetElement_Hotel("css_fname", "Hotel_properties"));
		return fname;
	}
	
	public By Lname() throws Throwable
	{
		By lname = By.cssSelector(Local_libraries.GetElement_Hotel("css_lname", "Hotel_properties"));
		return lname;
	}
	
	public By Email() throws Throwable
	{
		By email = By.cssSelector(Local_libraries.GetElement_Hotel("css_email", "Hotel_properties"));
		return email;
	}
	
	public By Re_Email() throws Throwable
	{
		By re_email = By.cssSelector(Local_libraries.GetElement_Hotel("css_re_email", "Hotel_properties"));
		return re_email;
	}
	
	public By Submit() throws Throwable
	{
		By submit = By.cssSelector(Local_libraries.GetElement_Hotel("css_submit", "Hotel_properties"));
		return submit;
	}
	
	public By Price() throws Throwable
	{
		By price = By.cssSelector(Local_libraries.GetElement_Hotel("css_price", "Hotel_properties"));
		return price;
	}
	
	public By Cust_name() throws Throwable
	{
		By email = By.cssSelector(Local_libraries.GetElement_Hotel("css_customer_name", "Hotel_properties"));
		return email;
	}
	
	public By Cust_address() throws Throwable
	{
		By re_email = By.cssSelector(Local_libraries.GetElement_Hotel("css_customer_email", "Hotel_properties"));
		return re_email;
	}
	
	public By Hotel_price() throws Throwable
	{
		By submit = By.cssSelector(Local_libraries.GetElement_Hotel("css_hotel_price", "Hotel_properties"));
		return submit;
	}
	
	public By Phone() throws Throwable
	{
		By email = By.cssSelector(Local_libraries.GetElement_Hotel("css_phone", "Hotel_properties"));
		return email;
	}
	
	public By Card_type() throws Throwable
	{
		By re_email = By.cssSelector(Local_libraries.GetElement_Hotel("css_card_type", "Hotel_properties"));
		return re_email;
	}
	
	public By Card_num() throws Throwable
	{
		By submit = By.cssSelector(Local_libraries.GetElement_Hotel("css_card_num", "Hotel_properties"));
		return submit;
	}
	
	public By Exp_month() throws Throwable
	{
		By re_email = By.cssSelector(Local_libraries.GetElement_Hotel("css_month", "Hotel_properties"));
		return re_email;
	}
	
	public By Exp_year() throws Throwable
	{
		By submit = By.cssSelector(Local_libraries.GetElement_Hotel("css_year", "Hotel_properties"));
		return submit;
	}
}
