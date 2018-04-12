
/*public class Object_class {
	int x=10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object_class obj = new Object_class();
		System.out.println(obj);
	}
}*/

//Use of toString() method
/*public class Object_class {
	int x=10;
	public String toString()
	{
		return "print the object" ;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object_class obj = new Object_class();
		System.out.println(obj);
		System.out.println(obj.toString());
	}
}*/
//Use equal() method
/*public class Object_class {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object_class obj = new Object_class();
		String s1 = "sourabh",s2 = "sourabh",s3 = "memo";
		if (s1.equals(s2))
		{
			System.out.println("String 1 "+s1+" is equal to String 2 "+s2);
		}
		if (s1.equals(s3))
		{
			System.out.println("String 1 "+s1+" is equal to String 2 "+s3);
		}
		else 
		{
			System.out.println("String 1 "+s1+" is not equal to String 3 "+s3);
		}	
	}
}*/

public class Object_class {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object_class obj = new Object_class();
		Integer i = new  Integer(5);
		System.out.println(i);
		System.out.println(i.hashCode());
		System.out.println("Get class of integer i = "+i.getClass());
		System.out.println("Get class name of object = "+obj.getClass());	
	}
}

