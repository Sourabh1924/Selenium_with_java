//Create a copy constructor pass there value to another constructor

public class copy_const {
	int x,y;
	 copy_const(int i) {
		// TODO Auto-generated constructor stub
		this.x = i;
	 }
	 copy_const(int i,int j)
	 {
		this.x=i;
		this.y=j;
	 }
	copy_const(copy_const ob)
	{
		x = ob.x;
		y = ob.y;
		System.out.println();
		System.out.println("Copy the value of x from 1 to 2 constructer = "+ob.x);
		System.out.println("Copy the value of y from 1 to 2 constructer = "+ob.y);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		copy_const obj = new copy_const(45);
		System.out.println("Value of x in the 1 constructer = "+obj.x);
		copy_const obj1 = new copy_const(56,55);
		System.out.println();
		System.out.println("Value of x in the 2 constructer = "+obj1.x);
		System.out.println("Value of y in the 2 constructer = "+obj1.y);
		copy_const obj2 = new copy_const(obj1);
		System.out.println();
		System.out.println("Value of x in the obj2 = "+obj2.x);
		System.out.println("Value of y in the obj2 = "+obj2.y);
	}
}
