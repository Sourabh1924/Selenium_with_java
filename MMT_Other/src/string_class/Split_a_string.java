package string_class;
public class Split_a_string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "My name is sourabh";
		String[] ch = str.split(" ");
		for(int i=0;i<=ch.length;i++)
		{
			System.out.println(ch[i]);
		}
	}

}
