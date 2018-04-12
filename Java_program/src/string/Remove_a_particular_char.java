package string;

public class Remove_a_particular_char {

	public static String removeCharAt(String s,int pos)
	{
		
		return s.substring(0, pos)+s.substring(pos+1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String str="sourabh";
			System.out.println(removeCharAt(str,3));
	}
}
