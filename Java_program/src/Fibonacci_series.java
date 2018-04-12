
public class Fibonacci_series {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,fir = 0,sec = 1,var;
		System.out.println(fir);
		System.out.println(sec);
			for (i=1;i<10;i++)
			{
				var = fir + sec;
				System.out.println(var);
				fir = sec;
				sec=var;				
			}
	}

}
