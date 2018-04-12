
public class This {
	int i = 10;
	double j=8.5;
	void display()
	{
		this.i = 100;		
		System.out.println("Value of i in the method "+i);
	}
	void display(int i)
	{		
		System.out.println("Value of i through parameter in 2 method "+i);	
	}
	static void display(double j)
	{			
		System.out.println("Value of i through parameter in 3 method "+j);
		This obj1 = new  This();
		System.out.println("Value of i through create object in 3 method "+obj1.j);
		// We cannot use "this" keyword in the static method "this.i = 100;"
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 5;
		This obj = new  This();
		System.out.println("Value of i in the main method "+i);
		System.out.println("Value of i through create object "+obj.i);
		obj.display();
		obj.display(5);
		This.display(7.5);
	}
}
