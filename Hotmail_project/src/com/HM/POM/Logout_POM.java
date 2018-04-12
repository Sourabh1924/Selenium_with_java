package com.HM.POM;

import org.openqa.selenium.By;

import com.HM.libraries.Utility_libraries;

public class Logout_POM {

	String File_name = "F:\\Sel\\Hotmail_project\\src\\com\\HM\\properties\\HM_Logout.properties";
	
	public By Account_button() throws Throwable
	{
		By Source = By.id(Utility_libraries.GetElement("Id_account_button", "HM_Logout",File_name));
		return Source;
	}
	public By Signout_button() throws Throwable
	{
		By Source = By.xpath(Utility_libraries.GetElement("Xpath_sign_out_button", "HM_Logout",File_name));
		return Source;
	}
	public By Element_display() throws Throwable
	{
		By Source = By.id(Utility_libraries.GetElement("Id_element_display", "HM_Logout",File_name));
		return Source;
	}
}
