package com.RA.page_object_model;

import org.openqa.selenium.By;

import com.RA.libraries.Utility_libraries;

public class RA_Logout_POM {

	public By Navigate() throws Throwable
	{
		By Source = By.cssSelector(Utility_libraries.GetElement("css_navigate", "Logout"));
		return Source;
	}
	
	public By Signout() throws Throwable
	{
		By Source = By.xpath(Utility_libraries.GetElement("xpath_signout_link", "Logout"));
		return Source;
	}
	
	public By Verify() throws Throwable
	{
		By Source = By.cssSelector(Utility_libraries.GetElement("css_verify", "Logout"));
		return Source;
	}
}
