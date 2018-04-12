package java_program;
/*public class Constructor {
	int x,y;
	
	Constructor(int a,int b)
	{
		x = a; 
		y = b;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Constructor obj = new Constructor(5,6);
		System.out.println(obj.x+" "+obj.y);
	}

}*/

//Constructor using set and get method and using constructor overloading using 2 different class

public class Constructor {
	Cont obj1;
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Constructor obj = new Constructor();
		obj.obj1 = new Cont();
		System.out.println(obj.obj1.setx());
		System.out.println(obj.obj1.sety());
		obj.obj1 = new Cont(100,75);
		System.out.println(obj.obj1.setx());
		System.out.println(obj.obj1.sety());
	}
}

class Cont {
private int x,y;
	
	 Cont(int a,int b)
	{
		this.x = a; 
		this.y = b;	
	}
	Cont()
	{
		this.x=45;
		this.y=55;
	}
	public int setx()
	{
		return x;
	}
	public int sety()
	{
		return y;
	}
}

