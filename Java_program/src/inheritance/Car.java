package inheritance;

public class Car extends Vehicle {
	 int CC;
	 int gears;
	   void attributescar() {
	      // The subclass refers to the members of the superclass
		  System.out.println("Attributes for car are :- ");
	      System.out.println("Company of Car : " + company);
	      System.out.println("Speed of Car : " + speed + " km/h");
	      System.out.println("Size of Car : " + size + " mm");
	      System.out.println("CC of Car : " + CC);
	      System.out.println("No of gears of Car : " + gears);
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Car obj = new Car();
		 obj.company = "Honda";
		 obj.speed = 120;
		 obj.size = 3655;
		 obj.CC = 1200;
		 obj.gears = 5;
		 obj.attributescar();
		 System.out.println("----------------------------------------------------");
		 obj.attributesvehicle();
	}

}

	   