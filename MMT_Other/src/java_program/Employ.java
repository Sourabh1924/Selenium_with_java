package java_program;// Here we use 3 different classes.
// Calling value from 2 class in one class without using inheritance.

public class Employ {
	int Emp_id;
	String Emp_name;
	Address add;
	Salary sal;
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Employ obj = new Employ();
		obj.add = new Address();
		obj.sal = new Salary();
		System.out.print("Employ ID = ");
		System.out.println(obj.Emp_id=12563);
		
		System.out.print("Employ name = ");
		System.out.println(obj.Emp_name = "Sourabh");
		
		System.out.print("Employ address = ");
		System.out.println(obj.add.Addr = "Tarbhar");
		
		System.out.print("Employ country = ");
		System.out.println(obj.add.Country = "India");
		
		System.out.print("Employ state = ");
		System.out.println(obj.add.State = "C.G");
		
		System.out.print("Employ salary amount = ");
		System.out.println(obj.sal.sal_amount = 50000);
		
		System.out.print("Employ account id = ");
		System.out.println(obj.sal.account_id = 145632578);
		
		System.out.println(obj);
	}
}
 
 


