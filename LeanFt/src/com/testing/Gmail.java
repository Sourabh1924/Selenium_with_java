package com.testing;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.Button;
import com.hp.lft.sdk.web.ButtonDescription;
import com.test.modules.DOB_details;
import com.test.modules.Email_details;
import com.test.modules.Launch;
import com.test.modules.Personal_details;
import com.test.modules.Utility_libraries;

import unittesting.UnitTestClassBase;


public class Gmail extends UnitTestClassBase {

	static Browser browser;
	String Pro_file_name = "E:\\Sourabh_Selenium\\Sel\\LeanFt\\bin\\Test_data\\Data.properties";
	
    public Gmail() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new LeanFtTest();
        globalSetup(LeanFtTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception 
    {
        globalTearDown();
    }

    @Before
    public void setUp() throws Throwable {
    	
    	//------------------------Variable Initialize----------------------------
    	String Browser = Utility_libraries.GetElement("Browser", Pro_file_name);
    	
    	Reporter.init(Utility_libraries.Result());
    	browser = Launch.LBrowser(Browser); 
    	Reporter.reportEvent("Step A", "Browser instance is created for : "+Browser,Status.Passed);
    	Utility_libraries.Excel_Reporter("Browser instance", "Browser instance is created for : "+Browser, "PASS", ""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
    }

    @Test
    public void Login() throws GeneralLeanFtException, Throwable {
    	
    	//------------------------Variable Initialize----------------------------	
    	String	URL		     	= Utility_libraries.GetElement("URL", Pro_file_name);		
    	String	Fname			= Utility_libraries.GetElement("Fname", Pro_file_name);
    	String	Lname			= Utility_libraries.GetElement("Lname", Pro_file_name);
    	String	Username		= Utility_libraries.GetElement("Username", Pro_file_name);
    	String	Password		= Utility_libraries.GetElement("Password", Pro_file_name);
    	String	DOB				= Utility_libraries.GetElement("DOB", Pro_file_name);
    	String	Phone_number	= Utility_libraries.GetElement("Phone_number", Pro_file_name);
    	String	Gender			= Utility_libraries.GetElement("Gender", Pro_file_name);
    	
    	//Launch
    	browser.navigate(URL);
    	Reporter.reportEvent("Step - 1", "Enter URL",Status.Passed);
    	//Reporter.getSnapshotCaptureLevel();
    	
    	//Enter the full name of user
    	Personal_details obj_per = new Personal_details(browser);
    	obj_per.Per_details(Fname,Lname);
    	
    	//Enter username and password
    	Email_details mail_obj = new Email_details(browser);
    	mail_obj.Mal_details(Username,Password);
    	
    	//Enter user details
    	DOB_details DOB_obj = new DOB_details(browser);
    	DOB_obj.DOB_detls(DOB,Phone_number,Gender);
    	    	
    	//Click on next button
    	browser.describe(Button.class, new ButtonDescription.Builder()
    			.buttonType("submit").tagName("INPUT").name("Next step").build()).click();
    	Reporter.reportEvent("Step - 14", "Click on next button",Status.Passed);
    }
    
    @After
    public void tearDown() throws Throwable {
    	
    	Utility_libraries.Excel_Reporter("Browser instance close","Browser is close", "PASS", ""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
    	Reporter.reportEvent("Step - 15", "Browser is close",Status.Passed);
    	//Report generate
    	Reporter.generateReport();
    	//Close the browser
    	browser.close(); 
    	Utility_libraries.Excel_Reporter("","","","");
    }
}