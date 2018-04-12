package java_program;
public class Method_overloading {
	int i=5,j=6;
	double k=8;
	  double Calculate(int i)
	{
		System.out.println("Area of a square is = "+i*i);
		return i*i;
	}
	  double Calculate(int j,int k)
		{
			System.out.println("Area of a rectangle is = "+j*k);  
			return j*k;
		}  
	  double Calculate(double l)
		{
			System.out.println("Area of a circle is = "+3.14159*l*l);  	
			return 3.14159*l*l;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Method_overloading obj = new Method_overloading();
		obj.Calculate(obj.i=5);
		obj.Calculate(obj.i=5,obj.j=6);
		obj.Calculate(obj.k=5);
	}

}
