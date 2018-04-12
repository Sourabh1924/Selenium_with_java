
public class Pattern_program {
	
	public static void main(String[] args) {
		int var=1;
		for(int i=1;i<=6;i++)
		{
			if(i<=3)
			{
				for(int j=1;j<=i;j++)
				{
					System.out.print(var);
					var++;
				}
				System.out.println();
			}
			else
			{
				for(int k=2;k>=i-3;k--)
				{
					var--;
					System.out.print(var-3);
					
				}
				System.out.println();
			}		
		}
	}
}

