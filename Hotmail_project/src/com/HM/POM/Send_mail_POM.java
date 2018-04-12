package com.HM.POM;

import org.openqa.selenium.By;

import com.HM.libraries.Utility_libraries;

public class Send_mail_POM {

	String File_name = "F:\\Sel\\Hotmail_project\\src\\com\\HM\\properties\\HM_Send_Mail.properties";
	
	public By Next_button() throws Throwable
	{
		By Source = By.xpath(Utility_libraries.GetElement("Xpath_new_button", "HM_Send_Mail",File_name));
		return Source;
	}
	public By To_recipient() throws Throwable
	{
		By Source = By.xpath(Utility_libraries.GetElement("Xpath_to", "HM_Send_Mail",File_name));
		return Source;
	}
	public By Cc_button() throws Throwable
	{
		By Source = By.xpath(Utility_libraries.GetElement("Xpath_cc_button", "HM_Send_Mail",File_name));
		return Source;
	}
	public By Cc_recipient() throws Throwable
	{
		By Source = By.xpath(Utility_libraries.GetElement("Xpath_cc", "HM_Send_Mail",File_name));
		return Source;
	}
	public By Subject_box() throws Throwable
	{
		By Source = By.xpath(Utility_libraries.GetElement("Xpath_subject", "HM_Send_Mail",File_name));
		return Source;
	}
	public By Body_box() throws Throwable
	{
		By Source = By.xpath(Utility_libraries.GetElement("Xpath_body", "HM_Send_Mail",File_name));
		return Source;
	}
	public By Send_button() throws Throwable
	{
		By Source = By.xpath(Utility_libraries.GetElement("Xpath_send_button", "HM_Send_Mail",File_name));
		return Source;
	}
	public By Delete_button() throws Throwable
	{
		By Source = By.xpath(Utility_libraries.GetElement("Xpath_delete_button", "HM_Send_Mail",File_name));
		return Source;
	}
}
