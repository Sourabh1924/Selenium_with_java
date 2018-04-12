package java_program;import java.util.Scanner;

//Call method with using object.

/*public class Method {
	int i;
	String name;
		void insert(int r,String n)
		{
		   i = r;
		   name = n;
		}
		void display()
		{
			System.out.print(i+" "+name);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Method obj = new Method();
		Method obj1 = new Method();
		obj.insert(25,"sourabh");
		obj1.insert(26,"venki");
		obj.display();
		obj1.display();
	}

}*/

//Call method without using object.
public class Method {
	
	public static void sum(int var,int var1)
	{
		int sum = var+var1;
		display(sum);
	}
	public static void sub(int var, int var1)
	{
		int sub = var-var1;
		display(sub);
	}
	public static void mul(int var, int var1)
	{
		int mul = var*var1;
		display(mul);
	}
	public static void display(int a)
	{
		System.out.println("Result = "+ a);
	}
	public static void main(String[] args) {
		int var,var1;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter any number = ");
		var = in.nextInt();
		System.out.print("Enter any number = ");
		var1 = in.nextInt();
		
		Method.sum(var, var1);
		mul(var, var1);
		sub(var, var1);
		in.close();
	}
}

