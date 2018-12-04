package UVA;
import java.util.*;
public class Problem_11565
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		while(n-->0)
		{
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			int z;
			boolean f=false;
			for(int x=-101;x<101 && f==false;x++)
			{
				for(int y=-101;y<101 && f==false;y++)
				{
					z=(x+y-a)*(-1);
					if(y*x*z==b && ((x*x)+(y*y)+(z*z))==c && (y!=x && y!=z && x!=z))
						{
							System.out.println(""+x+" "+y+" "+z);
							f=true;
						}
				}
			}
			if(f==false)
				System.out.println("No solution.");
		}
		sc.close();
	}
}
