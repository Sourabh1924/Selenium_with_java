package example;

import org.testng.Assert;

public class Verify_parameter_value {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] Launch ={"sourabh","vikas"};
		Verify_parameter_value.Verify_value(Launch);
	}
	    
	
	static void Verify_value(String[] Array)
	   {
		   for(int i=0;i<=Array.length-1;i++)
		   {
			   Assert.assertNotNull(Array[i].toString(), "Value is present");
		   }
	   }
}
