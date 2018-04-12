import java.util.*;
public class Product_table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int var=0,sum=0;
		System.out.print("Enter the number ");
		Scanner in = new Scanner(System.in);
		var = in.nextInt();
		for(int i=1;i<=10;i++)
		{
			sum = var*i;
			System.out.println(sum+" * "+i+" = "+sum);		
		    sum=0;
		}
		in.close();
	}
}
