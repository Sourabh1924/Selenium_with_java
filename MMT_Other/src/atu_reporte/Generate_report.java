package atu_reporte;



import com.relevantcodes.extentreports.ExtentReports;



public class Generate_report {

	public static ExtentReports Report()
	{	
	 	ExtentReports report1 = new ExtentReports("C:\\Users\\Yogesh\\Desktop\\Selenium_project");
		report1.addSystemInfo("Browser","Internet Explore");
		report1.addSystemInfo("Java version", "JDK 8");
		report1.addSystemInfo("Machine", "iDeliver8");
		report1.config().documentTitle("Sourabh");
		report1.config().reportHeadline("Selenium");
		report1.config().reportName("Automation");
		return report1;
	}
}
