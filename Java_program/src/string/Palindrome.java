package string;

import org.testng.annotations.Test;

public class Palindrome {

	@Test
	public void run()
	{
		
		String Str="sourabh";
		String var = "";
			for(int i =Str.length()-1;i>=0;i--)
			{
				var = var +Str.charAt(i);
			}
			if(var.equalsIgnoreCase(Str))
			{
				System.out.println("Yes");
			}
			else
			{
				System.out.println("No");
			}
	}
	
}
