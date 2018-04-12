package java_program;/*import java.util.*;
public class Armstrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num,temp,sum=0,temp1=1,num1;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter 1 number");
		num = in.nextInt();		
		num1=num;
		int length = String.valueOf(num).length();// Convert int into string
				for(int i=1;i<=length;i++)
					{
						temp = num%10;
							for (int j = 0;j<length;j++)
							{
								temp1 = temp*temp1;
							}
						num = num/10;
						sum = temp1+sum;
						temp1=1;
					}
				if (sum==num1)
				{
					System.out.println("Number you enter ="+num1+". Number you get "+sum);
					System.out.print("Both the numbers are same so it is a armstrong number.");
				}
				else
				{
					System.out.println("Number you enter ="+num1+". Number you get "+sum);
					System.out.print("Both the numbers are not same so it is not a armstrong number.");
				}								
	}
}*/

public class Armstrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num,temp,temp1,sum=0;		
		for (int j=100;j<=999;j++)
		{
			num=j;
			int length = String.valueOf(num).length();// Convert int into string
			for(int i=1;i<=length;i++)
			{
				temp = num%10;	
				temp1 = (int)(Math.pow(temp, length));	
				num = num/10;
				sum = temp1+sum;
			}
			if(j==sum)
			{
				System.out.println(j+"=="+sum);
			}
			sum=0;
		}
		
	}
}



