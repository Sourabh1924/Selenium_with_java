package com.testing;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import com.hp.lft.sdk.*;
import com.hp.lft.sdk.sap.ui5.ListBox;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.Image;
import com.hp.lft.sdk.web.ImageDescription;
import com.hp.lft.sdk.web.ListBoxDescription;
import com.hp.lft.sdk.web.RadioGroup;
import com.hp.lft.sdk.web.RadioGroupDescription;
import unittesting.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LeanFtTest extends UnitTestClassBase {

	static Browser browser;
		
    public LeanFtTest() {
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
    	browser.close();
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
    	
    	browser = BrowserFactory.launch(BrowserType.INTERNET_EXPLORER);   	
    }

    @After
    public void tearDown() throws Exception {
    	//browser.close();
    }

    @Test
    public void Login() throws GeneralLeanFtException {
    	
    	//Launch
    	browser.navigate("http://newtours.demoaut.com/");
    	//Login
    	browser.describe(EditField.class, new EditFieldDescription.Builder().xpath("//input[@name='userName']").build()).setValue("agent");    	
    	browser.describe(EditField.class, new EditFieldDescription.Builder().xpath("//input[@name='password']").build()).setValue("mercury");    	
    	browser.describe(Image.class, new ImageDescription.Builder().xpath("//input[@alt='Sign-In']").build()).click();
    	//Enter flight details
    	browser.describe(RadioGroup.class, new RadioGroupDescription.Builder().tagName("INPUT").name("tripType").build()).select(1);
    	//browser.describe(ListBox.class, new ListBoxDescription.Builder().tagName("SELECT").name("passCount").build()).set("2");
    	browser.describe(ListBox.class, new ListBoxDescription.Builder().tagName("SELECT").name("passCount").build()).click();
    	

    	browser.describe(ListBox.class, new ListBoxDescription.Builder().xpath("//select[@name='fromPort']").build()).singleSelect("Paris");
    	browser.describe(ListBox.class, new ListBoxDescription.Builder().xpath("//select[@name='toPort']").build()).singleSelect("London");    	
    	browser.describe(ListBox.class, new ListBoxDescription.Builder().xpath("//select[@name='fromMonth']").build()).singleSelect("January");
    	browser.describe(ListBox.class, new ListBoxDescription.Builder().xpath("//select[@name='toMonth']").build()).singleSelect("January");   	
    	browser.describe(ListBox.class, new ListBoxDescription.Builder().xpath("//select[@name='fromDay']").build()).singleSelect("12");
    	browser.describe(ListBox.class, new ListBoxDescription.Builder().xpath("//select[@name='toDay']").build()).singleSelect("18");    	
    	browser.describe(RadioGroup.class,  new RadioGroupDescription.Builder().xpath("//input[@value='First']").build()).click();
    	browser.describe(Image.class, new ImageDescription.Builder().xpath("//input[@name='findFlights']").build()).click();
    	//Select flight
    	browser.describe(Image.class, new ImageDescription.Builder().xpath("//input[@name='reserveFlights']").build()).click();
    	//Enter passenger/Payment details
    	browser.describe(EditField.class, new EditFieldDescription.Builder().xpath("//input[@name='passFirst0']").build()).setValue("John");
    	browser.describe(EditField.class, new EditFieldDescription.Builder().xpath("//input[@name='passLast0']").build()).setValue("West");
    	browser.describe(EditField.class, new EditFieldDescription.Builder().xpath("//input[@name='creditnumber']").build()).setValue("123456789");   	
    	browser.describe(ListBox.class, new ListBoxDescription.Builder().xpath("//select[@name='pass.0.meal']").build()).singleSelect("12");
    	browser.describe(Image.class, new ImageDescription.Builder().xpath("//input[@name='buyFlights']").build()).click();
    	//Logout
    	browser.describe(Image.class, new ImageDescription.Builder().xpath("//img[contains(@src,'Logout')]").build()).click();
   
    }
 

}