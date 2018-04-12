package java_program;
public class Amstrong {

	public static void main(String args[])
	   {
	     int a=0,b=0,num1=0;
		 for (int i=100;i<=999;i++)
		 {
			 num1=i;
			 while(num1>0)
			   {
			     a=num1%10;
			     num1=num1/10;
				 b = b +(a*a*a);
			   }	
			   if (b == i)
			   {
				    System.out.println("Number is armstrong "+b);
			   }
			   b=0;
		 }
		      
	   }
}
