import java.util.*;
public class swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int var,var1,swap;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter 1 number");
		var = in.nextInt();
		System.out.println("Enter 2 number");
		var1 = in.nextInt();
		System.out.println("Number before swap = "+var);
		System.out.println("Number before swap = "+var1);
		swap = var;
		var = var1;
		var1 = swap;
		System.out.println("Number after swap = "+var);
		System.out.println("Number after swap = "+var1);
		in.close();
	}
}
