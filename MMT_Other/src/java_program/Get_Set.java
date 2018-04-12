package java_program;
public class Get_Set {
	private int Emp_id,Salary=4000;
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
		Salary = Salary+var;
	}
}
