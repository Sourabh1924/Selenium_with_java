package package_1;

import org.openqa.selenium.By;

import libraries.Local_libraries;

public class Element_Lab {

	public  By Cartab_element() throws Throwable
	{
	By Cartab  = By.cssSelector(Local_libraries.GetElement_Bus("Cartab", "Bus_properties"));
	return Cartab;
	}

	public  By Pick_UP_Location_element() throws Throwable
	{
	By Pick_UP_Location  = By.cssSelector(Local_libraries.GetElement_Bus("Pick_UP_Location", "Bus_properties"));
	return Pick_UP_Location;

	}

	public  By Carpickup_element() throws Throwable
	{
	By Carpickup  = By.cssSelector(Local_libraries.GetElement_Bus("Carpickup", "Bus_properties"));
	return Carpickup;

	}

	public  By Pick_UP_Date_element() throws Throwable
	{
	By Pick_UP_Date  = By.cssSelector(Local_libraries.GetElement_Bus("Pick_UP_Date", "Bus_properties"));
	return Pick_UP_Date;

	}
	public  By CartimePickup_element() throws Throwable
	{
	By CartimePickup  = By.cssSelector(Local_libraries.GetElement_Bus("CartimePickup", "Bus_properties"));
	return CartimePickup;

	}
	public  By CartimePickupmenu_element() throws Throwable
	{
	By CartimePickupmenu  = By.cssSelector(Local_libraries.GetElement_Bus("CartimePickupmenu", "Bus_properties"));
	return CartimePickupmenu;

	}
	public  By vendors_element() throws Throwable
	{
	By vendors  = By.cssSelector(Local_libraries.GetElement_Bus("vendors", "Bus_properties"));
	return vendors;

	}
	public  By vendormenu_element() throws Throwable
	{
	By vendormenu  = By.xpath(Local_libraries.GetElement_Bus("vendormenu", "Bus_properties"));
	return vendormenu;

	}
	public  By Return_Location_element() throws Throwable
	{
	By Return_Location  = By.cssSelector(Local_libraries.GetElement_Bus("Return_Location", "Bus_properties"));
	return Return_Location;

	}

	public  By Dropoffdate_element() throws Throwable
	{
	By Dropoffdate  = By.cssSelector(Local_libraries.GetElement_Bus("Dropoffdate", "Bus_properties"));
	return Dropoffdate;

	}

	public  By Return_Date_element() throws Throwable
	{
	By Return_Date  = By.cssSelector(Local_libraries.GetElement_Bus("Return_Date", "Bus_properties"));
	return Return_Date;

	}
	public  By Searchbutton_element() throws Throwable
	{
	By Searchbutton  = By.cssSelector(Local_libraries.GetElement_Bus("Searchbutton", "Bus_properties"));
	return Searchbutton;

	}
	
	public  By CarInfo_element() throws Throwable
	{
	By CarInfo  = By.cssSelector(Local_libraries.GetElement_Bus("CarInfo", "Bus_properties"));
	return CarInfo;

	}	

	public  By Continuebutton_element() throws Throwable
	{
	By Continuebutton  = By.cssSelector(Local_libraries.GetElement_Bus("Continuebutton", "Bus_properties"));
	return Continuebutton;

	}
	public  By SubmitButton_element() throws Throwable
	{
	By SubmitButton  = By.cssSelector(Local_libraries.GetElement_Bus("SubmitButton", "Bus_properties"));
	return SubmitButton;

	}
	public  By DriverFirstname_element() throws Throwable
	{
	By DriverFirstname  = By.cssSelector(Local_libraries.GetElement_Bus("DriverFirstname", "Bus_properties"));
	return DriverFirstname;

	}

	public  By DriverLastname_element() throws Throwable
	{
	By DriverLasttname  = By.cssSelector(Local_libraries.GetElement_Bus("DriverLastname", "Bus_properties"));
	return DriverLasttname;

	}
}

