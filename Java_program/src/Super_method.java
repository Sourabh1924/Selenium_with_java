

public class Super_method extends B{
	void display()
	{
		super.display();
		System.out.println("Print grand child class");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Super_method obj = new Super_method();
		obj.display();
	}

}

class A {
	void display()
	{
		System.out.println("Print Parent class");
	}
}
class B extends A {
	void display()
	{
		super.display();
		System.out.println("Print child class");
	}
}