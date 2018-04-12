package gmail_by_class;

import org.openqa.selenium.WebDriver;

public class RunTestCase {
	
	static String  strBrowserName="chrome";
	static String strURL = "http://www.gmail.com/";
	static String strUserName = "memo.sourabh@gmail.com";
	static String StrPasword = "sourabh24";
	static String To_field = "memo.sourabh@gmail.com;",cc_field="ideliver007@gmail.com;";
	static String subject = "My name is Sourabh";
	static String content = "Automation complete";
	static WebDriver driver;
	
	public static void main(String[] args) throws Throwable {
		
		//Start timer
		long Start_time = System.nanoTime();
		
		//Step 1:-Initialize the  the browser
		driver=Launch.getBrowser(strBrowserName);	
			
		//Step 2:-navigate to gmail		
		driver.get(strURL);
		driver.manage().window().maximize();
		
		//Step 3:-Create Login 
		Gmail_reusablemethod run = new Gmail_reusablemethod(driver);
		run.Login(strUserName,StrPasword);
					
		//Step 4:-Click on compose button
		run.TC_Compose();
		
		//Step 5:-Enter in "to" field
		run.TC_Add_to(To_field);
		
		//Step 6:-Enter in "cc" field
		run.TC_Add_cc(cc_field);
		
		//Step 7:-Enter subject
		run.TC_Subject(subject);
		
		//Step 8:-Enter content of the mail
		run.TC_Body(content);
		
		//Step 9:-Enter send button
		run.TC_Send();
		Thread.sleep(2000);
		
		//Step 10:-Logout
		run.Logout();
		
		//Step 11:-Close the browser
		driver.close();
				
		//End timer
		long End_time = System.nanoTime();
		
		//Calculate Total time to excuate
		long TT_time = End_time - Start_time;
		System.out.println("Total excuation time = "+TT_time/1000000000+" seconds");
		}
	}