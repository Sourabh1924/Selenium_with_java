package string_class;
public class String_unicode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "My name is sourabh";
		System.out.println("String formate :-"+str);
		System.out.println(str.codePointCount(0, str.length()));
		System.out.println(str.codePointAt(6000));
	}

}
