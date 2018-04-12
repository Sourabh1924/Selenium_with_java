package com.test.modules;

import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;

public class Launch {

	static Browser browser;

	public static Browser LBrowser(String Browser) throws Throwable
	{	
		switch(Browser.toLowerCase())
		{
		case "firefox":
			browser = BrowserFactory.launch(BrowserType.FIREFOX);
			break;
		case "chrome":
			browser = BrowserFactory.launch(BrowserType.CHROME);
			break;
		case "internetexplore":
			browser = BrowserFactory.launch(BrowserType.INTERNET_EXPLORER);
			break;
		}
		return browser;
	}
}
