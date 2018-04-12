
class Vehicle
{
	String company,color,type;
	int size;
	void display()
	{
		System.out.println("Company name = "+company);
		System.out.println("Colore of the vehicle = "+color);
		System.out.println("Type of the vehicle = "+type);
		System.out.println("Size of the vehicle = "+size);
	}
}
class Car extends Vehicle
{
	String name;
	int eng_num,weight,CC;
	void display1()
	{
		System.out.println("Car name = "+name);
		System.out.println("Eng_num of "+name+" is = "+eng_num);
		System.out.println("Weight of the car is = "+weight);
		System.out.println("CC of the car is = "+CC);
	}
}
