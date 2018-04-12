
public class Fact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int var = 5,fat=1;
			/*for(int i=1;i<=var;i++)
			{
				fat = fat * i;				
			}
			System.out.println(fat);*/
		while(var>=1)
		{
			fat = fat * var;
			var--;
		}
		System.out.println(fat);
	}

}
