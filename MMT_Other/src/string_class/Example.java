package string_class;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Sourabh";
		System.out.println("Charater at that place is "+str.charAt(5));
		System.out.println(str.equalsIgnoreCase("SOURABH"));
		System.out.println(str.length());
		System.out.println(str.trim().length());
		System.out.println(str.trim().concat(" memo"));
		System.out.println(str.substring(1));
		System.out.println(str.endsWith("abh"));
		System.out.println(str.startsWith("Sou"));
		System.out.println(str.compareTo("Aourajkjbh"));
		System.out.println(str.substring(2, 5));
		String[] c= str.split("r");
		System.out.println(c[0]);
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		System.out.println(str.toCharArray());
		System.out.println(str.compareToIgnoreCase("sourabh"));
		System.out.println(str.indexOf("r"));
	}


}
