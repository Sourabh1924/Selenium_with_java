package java_program;
public class This_call {
	int a,x,y,z;
	This_call(int l, int b, int h)
	{
		this.a=l+b+h;
	}
	This_call()
	{
		this(4,5,6);		
		System.out.println("Value is copied");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Copy the value from default constructor to parameter constructor");
		This_call obj1 = new This_call();
		System.out.println("Sum of 3 number is = "+obj1.a);
	}
}
