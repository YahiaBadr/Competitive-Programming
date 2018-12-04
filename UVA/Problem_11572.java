package UVA;
import java.io.*;
import java.util.*;
public class Problem_11572
{
	public static void main(String[] args)
	{
		PrintWriter pw= new PrintWriter(System.out);
		//BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc= new Scanner (System.in);
		int n= sc.nextInt();int z;int max=0;
		while(n>0)
		{
			int x= sc.nextInt();
			ArrayList<Integer> a= new ArrayList<Integer>();
			if(x==0)
			{	
				pw.println(0);
				n--;
				continue;
			}
			a.add(sc.nextInt());
			int c=1;max =1;
			while(x>1)
			{
				z=sc.nextInt();
				if(!a.contains(z))
				{
					if(c>max)
						max=c;
					c=1;
				}	
				else
					c++;
				a.add(z);
				x--;
				if(x==0)
				{
					if(c>max)
						max=c;
				}
			}
			n--;
			pw.println(max);
		}
		pw.flush();
		pw.close();
		sc.close();
		
		
	}

}
