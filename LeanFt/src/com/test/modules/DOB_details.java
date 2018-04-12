package com.test.modules;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;

public class DOB_details {

	Browser browser;
	public DOB_details(Browser browser) {
		// TODO Auto-generated constructor stub
		this.browser = browser;
	}
	
	public void DOB_detls(String DOB,String Phone,String Gender) throws GeneralLeanFtException, Throwable
	{
		
		//Enter day
    	browser.describe(EditField.class, new EditFieldDescription.Builder()
    			.type("text").tagName("INPUT").name("BirthDay").build()).setValue("24");
    	Reporter.reportEvent("Step - 7", "Enter DOB day",Status.Passed);
    	Utility_libraries.Excel_Reporter("Enter value", "Enter DOB day", "PASS", ""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
    	
    	//Click on month listbox
    	browser.describe(WebElement.class, new WebElementDescription.Builder()
    			.className("goog-inline-block goog-flat-menu-button-caption").tagName("DIV").innerText("Month").build()).click();
    	
    	//Select the month
    	browser.describe(WebElement.class, new WebElementDescription.Builder()
    			.className("goog-menuitem-content").tagName("DIV").innerText("May").build()).click();
    	Reporter.reportEvent("Step - 8", "Enter DOB month",Status.Passed);
    	Utility_libraries.Excel_Reporter("Enter value", "Enter DOB month", "PASS", ""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
    	
    	//Enter year
    	browser.describe(EditField.class, new EditFieldDescription.Builder()
    			.type("text").tagName("INPUT").name("BirthYear").build()).setValue("1990");
    	Reporter.reportEvent("Step - 10", "Enter DOB year",Status.Passed);
    	Utility_libraries.Excel_Reporter("Enter value", "Enter DOB year", "PASS", ""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
    	
    	//Click on gender listbox
    	browser.describe(WebElement.class, new WebElementDescription.Builder()
    			.className("goog-inline-block goog-flat-menu-button-caption").tagName("DIV").innerText("I am...").build()).click();
    	
    	//Select the gender
      	browser.describe(WebElement.class, new WebElementDescription.Builder()
      			.className("goog-menuitem-content").tagName("DIV").innerText("Female").build()).click();
      	Reporter.reportEvent("Step - 12", "Select Gender",Status.Passed);
      	Utility_libraries.Excel_Reporter("Enter value", "Select Gender", "PASS", ""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
    	
      	//Enter phone number
    	browser.describe(EditField.class, new EditFieldDescription.Builder()
    			.type("tel").tagName("INPUT").name("RecoveryPhoneNumber").build()).setValue("+911234567895");
    	Reporter.reportEvent("Step - 13", "Enter phone number",Status.Passed);
    	Utility_libraries.Excel_Reporter("Enter value", "Enter phone number", "PASS", ""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
	
	}
}
