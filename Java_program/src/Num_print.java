
public class Num_print {
	public static void main(String args[])
	  {
	    int i,a=0,j=2;
		  for (i=1;i<=7;i++)
		  {  
		     if(i<=4)
			 {
				 a=a+i;
				 System.out.print(a);
				 a=0;
			 }
	      	 else
			 {
				 a = i-j;
				 System.out.print(a);
				 j++;
				 j++;
			 }			 
		  }		 
	  }
}
