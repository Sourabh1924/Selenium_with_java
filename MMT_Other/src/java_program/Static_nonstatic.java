package java_program;//''''''''''''''''''''''''''''''''''Non-Static method'''''''''''''''''''''''''''''''''''''
/*public class Static_nonstatic {
	
	void Test1()
	{
		Test2();
		System.out.println("Test 1");
	}
	void Test2()
	{
		Test3();
		System.out.println("Test 2");
	}
	void Test3()
	{		
		System.out.println("Test 3");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Static_nonstatic obj = new Static_nonstatic();
		obj.Test1();
	}
}*/

//''''''''''''''''''''''''''''''''''Static method'''''''''''''''''''''''''''''''''''''
/*public class Static_nonstatic {
	
	static void Test1()
	{
		Test2();
		System.out.println("Test 1");
	}
	static void Test2()
	{
		Test3();
		System.out.println("Test 2");
	}
	static void Test3()
	{		
		System.out.println("Test 3");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1();
	}
}*/

//''''''''''''''''''''''''''''''''''Call Non-Static to Static method'''''''''''''''''''''''''''''''''''''
/*public class Static_nonstatic {
	
	void Test1()
	{
		Test2();
		System.out.println("Test 1");
	}
	static void Test2()
	{
		System.out.println("Test 2");
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Static_nonstatic obj = new Static_nonstatic();
		obj.Test1();
	}
}*/

//''''''''''''''''''''''''''''''''''Call Static to Non-Static method'''''''''''''''''''''''''''''''''''''
/*public class Static_nonstatic {
	static Static_nonstatic obj = new Static_nonstatic();
	void Test1()
	{
		System.out.println("Test 1");
	}
	public static void Test2()
	{   
		Static_nonstatic obj = new Static_nonstatic();		
		obj.Test1();
		System.out.println("Test 2");
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Static_nonstatic.Test2();		
	}
}*/

//''''''''''''''''''''''''''''''''''Call Static variable to Non-Static method'''''''''''''''''''''''''''''''''''''
/*public class Static_nonstatic {
	static int a=5;
	void Test()
	{
		a=10;	
		System.out.println("a ="+a);
	}
	 	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		System.out.println("a ="+a);	
		Static_nonstatic obj = new Static_nonstatic();
		obj.Test();
	}
}*/

//''''''''''''''''''''''''''''''''''Call Static variable to Static method'''''''''''''''''''''''''''''''''''''
/*public class Static_nonstatic {
	static int a=5;
	static void Test()
	{
		a=10;	
		System.out.println("a = "+a);
	}
	 	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		System.out.println("a = "+a);	
		Static_nonstatic obj = new Static_nonstatic();
		Test();
	}
}*/

//''''''''''''''''''''''''''''''''''Call Non-Static variable to Non-Static method'''''''''''''''''''''''''''''''''''''
/*public class Static_nonstatic {
	 int a=5;
	 void Test()
	{
		a=10;	
		System.out.println("a = "+a);
	}	 	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Static_nonstatic obj = new Static_nonstatic();
		System.out.println("a = "+obj.a);
		obj.Test();
	}
}*/


public class Static_nonstatic {
	 int a=5;
	 static int b=5; 
	 void Test()
	{
		a=10;	
		System.out.println("a = "+a);
		System.out.println("b = "+b);
	}	 	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Static_nonstatic obj = new Static_nonstatic();
		System.out.println("a = "+obj.a);
		System.out.println("b = "+Static_nonstatic.b);
		obj.Test();
	}
}







