package UVA;
import java.util.*;
public class Problem_11450
{
	static int x[][];
	static int max;
	static int sump;
	public static void check(int i, int j,int sum)
	{
		if((i==x.length && j==x[x.length-1].length) || sum>max)
		{
			if(sum<=max && sum>sump)
				sump=sum;
		}
		else
		{
			for(int z=0;z<x[0].length;z++)
			{
				
			}
			
		}
	}
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		while(n-->0)
		{
			max=sc.nextInt();
			int r=sc.nextInt();
			x= new int[r][];
			for(int i=0;i<r;i++)
			{
				int c= sc.nextInt();
				x[i]=new int[c]; 
				for(int j=0;j<c;j++)
					x[i][j]=sc.nextInt();
			}
			Arrays.sort(x);
				
		}
	sc.close();
	}
}
