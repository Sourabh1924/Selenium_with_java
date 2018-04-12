package string_class;
public class Match_region {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="sourabh is my name";
		String str1="my name is sourabh";
		System.out.println(str.regionMatches(0, str1, 11, 7));	
	}
}
