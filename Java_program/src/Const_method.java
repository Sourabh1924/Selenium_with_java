
public class Const_method {
	int x,y,z;
	Const_method(int a,int b)
	{
		x = a; 
		y = b;			
	}
	public void display()
	{
	    System.out.println(x+" "+y);
	    
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Const_method obj = new Const_method(5,6);
		obj.display();
	}

}
