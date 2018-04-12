package com.HM.POM;

import org.openqa.selenium.By;

import com.HM.libraries.Utility_libraries;

public class Login_POM {

	String File_name = "F:\\Sel\\Hotmail_project\\src\\com\\HM\\properties\\HM_Login.properties";
	
	public By Navigate() throws Throwable
	{
		By Source = By.className(Utility_libraries.GetElement("Class_signin_button", "HM_Login",File_name));
		return Source;
	}
	public By Username_Box() throws Throwable
	{
		By Source = By.id(Utility_libraries.GetElement("Id_username_field", "HM_Login",File_name));
		return Source;
	}
	public By Next_button() throws Throwable
	{
		By Source = By.id(Utility_libraries.GetElement("Id_next_button", "HM_Login",File_name));
		return Source;
	}
	public By Name_verify() throws Throwable
	{
		By Source = By.id(Utility_libraries.GetElement("Id_name_verify", "HM_Login",File_name));
		return Source;
	}
	public By Password_box() throws Throwable
	{
		By Source = By.id(Utility_libraries.GetElement("Id_password_field", "HM_Login",File_name));
		return Source;
	}
	public By Sign_button() throws Throwable
	{
		By Source = By.id(Utility_libraries.GetElement("Id_sign_in_buttom", "HM_Login",File_name));
		return Source;
	}
}
