package java_program;
public class Unery_operate {
	public static void main (String args[]){
	
		int s=1,r=2,l,k;
		k= r++ + ++s - --r + --s;
		System.out.println("k="+k);
		l= s++ + --s - ++s - r++ + ++r + --r ;
		System.out.println("l="+l);	


		int a,b,c,d,e,f = 1;
		a = ++f + f++ + ++f+ ++f + f++;
		System.out.println("a=" +a);
		e = a++ + ++a + ++f + a++ + ++a + f++;
		System.out.println("e=" +e);
		d = ++f + a++ + e++ + ++e + f++ + a++;
		System.out.println("d=" +d);
		c = f+ ++d + e++ + ++a;
		System.out.println("c=" +c);
		b = ++c + d++ + ++e + a++ + ++f;
		System.out.println("b=" +b);
		    
		    
		int z,x,y,w,g= 1;
		z = ++g + g + g++  + ++g + ++g;
		System.out.println("z=" +z);
		z++;
		System.out.println("z=" +z);
		x = g + z + ++z + z++;
		System.out.println("x=" +x);
		y = g+x+a;
		System.out.println("y=" +y);
		a++;
		System.out.println("a=" +a);
		x++;
		System.out.println("x=" +b);
		++y;
		System.out.println("y=" +y);
		w = z+x+y+g;
		System.out.println("w=" +w);
	}
}
