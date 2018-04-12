package java_program;
public class reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 1234,temp=0;
		  while(num>0)
		  {
		     temp = num%10;
			 StringBuilder str = new StringBuilder(temp);
			 str.append(temp); 
			 num = num/10;
			 System.out.print(str);	  
		  }
	}

}
