package java_program;
public class Const_overload {
	int x,y,z;
	Const_overload(int a,int b)
	{
		x = a; 
		y = b;	
	}
	Const_overload(int a,int b,int c)
	{
		x = a; 
		y = b;	
		z = c;
	}
	Const_overload()
	{	
		x=444;
		y=452;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Const_overload obj = new Const_overload(5,6);
		System.out.println(obj.x+" "+obj.y);

		Const_overload obj1 = new Const_overload(5,4,8);
		System.out.println(obj1.x+" "+obj1.y+" "+obj1.z);
		
		Const_overload obj2 = new Const_overload();
		System.out.println(obj2.x+" "+obj2.y);
	}

}
