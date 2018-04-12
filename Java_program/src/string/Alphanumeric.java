package string;

import org.testng.annotations.Test;

public class Alphanumeric {
	
	@Test
	public void run()
	{
		String str ="SOo7ur8a123bh";
		int num = 1;
		String var="";
		String var1="";
			for(int i=0;i<=str.length()-1;i++)
			{		
				if(Character.toString(str.charAt(i)).matches("[0-9]"))
				{
					num = num * Character.getNumericValue(str.charAt(i));
				}
				else if(Character.toString(str.charAt(i)).matches("[A-Z]"))
				{
					var = var + Character.toString(str.charAt(i));
				}
				else
				{
					var1 = var1 + Character.toString(str.charAt(i));
				}
			}
		System.out.println(num);
		System.out.println(var);
		System.out.println(var1);
	}
}