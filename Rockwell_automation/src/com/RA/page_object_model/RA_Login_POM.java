package com.RA.page_object_model;

import org.openqa.selenium.By;

import com.RA.libraries.Utility_libraries;

public class RA_Login_POM {

	public By Navigate() throws Throwable
	{
		By Source = By.cssSelector(Utility_libraries.GetElement("css_navigate", "Login"));
		return Source;
	}
	
	public By Signin() throws Throwable
	{
		By Source = By.xpath(Utility_libraries.GetElement("xpath_signin_link", "Login"));
		return Source;
	}
	
	public By Username() throws Throwable
	{
		By Source = By.name(Utility_libraries.GetElement("name_username", "Login"));
		return Source;
	}
	
	public By Password() throws Throwable
	{
		By Source = By.name(Utility_libraries.GetElement("name_password", "Login"));
		return Source;
	}
	
	public By Submit() throws Throwable
	{
		By Source = By.xpath(Utility_libraries.GetElement("xpath_submit_button", "Login"));
		return Source;
	}
	
	public By Error_MSG() throws Throwable
	{
		By Source = By.xpath(Utility_libraries.GetElement("xpath_error_msg", "Login"));
		return Source;
	}
	
}
