package com.test.modules;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;

public class Personal_details {

	Browser browser;
	public Personal_details(Browser browser) {
		// TODO Auto-generated constructor stub
		this.browser = browser;
	}
	
	public void Per_details(String Fname,String Lname) throws Throwable
	{
		
		//Enter First name
    	browser.describe(EditField.class, new EditFieldDescription.Builder()
    			.type("text").tagName("INPUT").name("FirstName").build()).setValue(Fname);
    	Reporter.reportEvent("Step - 2", "Enter First name",Status.Passed);
    	Utility_libraries.Excel_Reporter("Enter value", "Enter First name", "PASS", ""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
    	
    	//Enter Last name
    	browser.describe(EditField.class, new EditFieldDescription.Builder()
    			.type("text").tagName("INPUT").name("LastName").build()).setValue(Lname);
    	Reporter.reportEvent("Step - 3", "Enter Last name",Status.Passed);
    	Utility_libraries.Excel_Reporter("Enter value", "Enter  Last name", "PASS", ""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
    	
	}
}
