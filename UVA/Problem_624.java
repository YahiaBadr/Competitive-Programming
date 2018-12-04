package UVA;
import java.util.*;
public class Problem_624
{
	static int x[];
	static String list;
	static int sum;
	static int max;
	public static void get(int i,int sum1, String s)
	{
		if(max<sum1 || i==x.length)
		{
			if(max>=sum1 && sum1>sum )
			{
				sum=sum1;
				list =s;
			}
			return;
		}
		
		{	
		get(i+1,sum1+x[i],s+""+x[i]+" ");
		get(i+1,sum1,s);	
		}
	}
	public static void main(String[] args)
	{
		Scanner sc= new Scanner (System.in);
		while(sc.hasNextInt())
		{
			max=sc.nextInt();
			int n=sc.nextInt();
			x=new int[n];
			for(int i=0;i<n;i++)
			{
				x[i]=sc.nextInt();
			}
			String s="";
			sum=0;
			get(0,0,s);
			System.out.println(list+"sum:"+sum);
		}
	sc.close();
	}
}
