package java_program;import java.util.*;
public class reverce_string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String original,rev="";
		int len,i;
	    Scanner in = new Scanner(System.in);
	    System.out.println("Enter the string");
	    original = in.nextLine();   
	    len = original.length();
		System.out.println(len);
	      for (i=len-1;i>=0;i--) 
	      {
			  rev = rev + original.charAt(i);
		  }		  
		System.out.println(rev);  
	in.close();
	}
}
