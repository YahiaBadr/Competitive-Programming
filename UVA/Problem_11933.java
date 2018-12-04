package UVA;
import java.util.*;
public class Problem_11933
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		while(true)
		{	
		int x=sc.nextInt();
		if(x==0)
			break;
		int c=0;
		ArrayList<Integer> l= new ArrayList<>();
		l.add(-1);
		while(x>0)
		{
			if(x%2!=0)
				l.add(c);
			c++;
			x=x>>1;
		}
		int a=0,b=0;
		for(int i=1,j=2;j<l.size() || i<l.size();i+=2,j+=2)
		{
			int tmp;
			if(i<l.size())
			{
				tmp=1<<l.get(i);
				a+=tmp;
			}
			if(j<l.size())
			{	
				tmp=1<<l.get(j);
				b+=tmp;
			}	
		}
		System.out.println(a+" "+b);
		}
		sc.close();
	}
}
