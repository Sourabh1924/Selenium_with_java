package string;

public class ASCII_value_converstion {

	static String Str ="SOo7ur8a123bh";
	char var;
	public static void main(String[] args) {
		{
			for(int i=0;i<=Str.length()-1;i++)
			{
				int ascii = (int)Str.charAt(i);
				System.out.println(ascii);
			}
		}
	}
}
