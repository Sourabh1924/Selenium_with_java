import java.util.Scanner;
public class Odd_Even {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int a;
		  Scanner in = new Scanner(System.in);
		  a = in.nextInt();
		  System.out.println(a);
		    if(a%2==0) 
		    {
			  System.out.println("Number is even = "+a);
		    }
			else
			{ 
			  System.out.println("Number is odd = "+a);
			}
		    in.close();
	}
}
