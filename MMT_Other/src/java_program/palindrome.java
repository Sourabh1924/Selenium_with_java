package java_program;
import java.util.Scanner;
public class palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num,temp=0,num1,sum=0;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter any number");
		num = in.nextInt();
		num1 = num;
		int length = String.valueOf(num).length();// Convert int into string
		for(int i=1;i<=length;i++)
		{
			temp = num%10;
			sum = (sum*10)+temp;
			num = num/10;
		}
        if(sum==num1)
        {
			System.out.println(sum+" number is a palindrome");
		}			
		else
		{
			System.out.println(sum+" number is not a palindrome");
		}
        in.close();
	}

}
