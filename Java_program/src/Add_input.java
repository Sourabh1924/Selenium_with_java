import java.util.Scanner;
public class Add_input {
	public static void main(String args[]) 
	  {
	    int a,b,c;
	    Scanner in = new Scanner(System.in);
	    System.out.println("Enter first number");
	    a = in.nextInt();
	    System.out.println("Enter first number");
	    b = in.nextInt();
	    c= a+b;
	    System.out.println(c);
	    in.close();
	  }
}
