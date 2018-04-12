package upcasting;

public class Run { 
	public static void main (String [] args) { 
		
//		Dog d = new Dog(); 
//		Animal a = (Animal)d; 
//		d.callme(); 
//		a.callme(); 
//		((Dog) a).callme2(); 
		Animal a = new Animal(); 
		//Dog d = (Dog)a;
		a.callme();
	
	} 
}

class Animal { 
	public void callme() { 
		
		System.out.println("In callme of Animal"); 
		} 
	} 

class Dog extends Animal { 
	
	public void callme() {
		
		System.out.println("In callme of Dog"); 
		} 
	
	public void callme2() { 
		
		System.out.println("In callme2 of Dog"); 
		} 
} 
