
public class Prime_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0;
		for(int i=1;i<=100;i++)
		{
			for(int j=1;j<=i;j++)
			{
				if(i%j==0)
				{
					count++;
				}
			}
			if (count==2)
			{
				System.out.println("Number is prime = "+i);
			}
			count=0;
		}
	}
}
