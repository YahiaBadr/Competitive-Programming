package UVA;
import java.io.PrintWriter;
import java.util.*;
public class Problem_357
{
	public static void main(String[] args) throws Throwable
	{
		Scanner sc= new Scanner(System.in);
		PrintWriter pw= new PrintWriter(System.out);
		int[] c={5,10,25,50};
		long[] d=new long[30001];
		Arrays.fill(d, 1);
		for(int i=0;i<c.length;i++)
			for(int j=c[i];j<d.length;j++)
				d[j]+=d[j-c[i]];
		while(sc.hasNextInt())
		{
			int n=sc.nextInt();
			//double m=(n/100)*20;
			if(d[n]!=1)
				pw.println("There are "+d[n]+ " ways to produce "+n+" cents change.");
			else
				pw.println("There is only "+d[n]+ " way to produce "+n+" cents change.");
		}
		pw.flush();
		pw.close();
		sc.close();
	}
}
