package com.test.modules;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;

public class Email_details {

	Browser browser;
	public Email_details(Browser browser) {
		// TODO Auto-generated constructor stub
		this.browser = browser;
	}
	
	public void Mal_details(String Username,String Password) throws Throwable
	{
		
		//Enter Email
    	browser.describe(EditField.class, new EditFieldDescription.Builder()
    			.type("text").tagName("INPUT").name("GmailAddress").build()).setValue(Username);
    	Reporter.reportEvent("Step - 4", "Enter Email address",Status.Passed);
    	Utility_libraries.Excel_Reporter("Enter value", "Enter Email address", "PASS", ""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
    	
    	//Enter password
    	browser.describe(EditField.class, new EditFieldDescription.Builder()
    			.type("password").tagName("INPUT").name("Passwd").build()).setValue(Password);
    	Reporter.reportEvent("Step - 5", "Enter password",Status.Passed);
    	Utility_libraries.Excel_Reporter("Enter value", "Enter password", "PASS", ""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
    	
    	//Re-Enter password
    	browser.describe(EditField.class, new EditFieldDescription.Builder()
    			.type("password").tagName("INPUT").name("PasswdAgain").build()).setValue(Password);
    	Reporter.reportEvent("Step - 6", "Re-enter password",Status.Passed);
    	Utility_libraries.Excel_Reporter("Enter value", "Re-enter password", "PASS", ""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
    	
	}
	
}
