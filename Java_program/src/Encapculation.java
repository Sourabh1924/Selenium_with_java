
/*public class Encapculation {
	
	private int Emp_id,Salary;
	private String Emp_name;
	
	public int getID()
	{
		return Emp_id;
	}
	public String getName()
	{
		return Emp_name;
	}
	public int getSalary()
	{
		return Salary;
	}	
	public void setID(int var)
	{
		 Emp_id = var;
	}
	public void setName(String var)
	{
		Emp_name = var;
	}
	public void setSalary(int var)
	{
		Salary = var;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Encapculation obj = new Encapculation();	
		obj.setID(102);
		obj.setName("Sourabh");
		obj.setSalary(50000);
		System.out.println("Employ ID is = "+obj.getID());
		System.out.println("Employ name is = "+obj.getName());
		System.out.println("Employ salary is = "+obj.getSalary());
	}
}*/


//Encapculation using 2 different classes 
public class Encapculation {
	Get_Set obj1;
	public static void main(String[] args) {
		Encapculation obj = new Encapculation();
		obj.obj1 = new Get_Set();
		obj.obj1.setID(102);
		obj.obj1.setName("Sourabh");
		obj.obj1.setSalary(50000);
		System.out.println("Employ ID is = "+obj.obj1.getID());
		System.out.println("Employ name is = "+obj.obj1.getName());
		System.out.println("Employ salary is = "+obj.obj1.getSalary());
	}
}
	

