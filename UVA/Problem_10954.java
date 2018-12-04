package UVA;
import java.util.*;
import java.io.*;
public class Problem_10954
{
	public static void main(String[] args) throws Throwable
	{
		PrintWriter pw=new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			int n=sc.nextInt();
			if(n==0)
				break;
			PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
			int sum=0;
			for(int i=0;i<n;i++)
				pq.add(sc.nextInt());
			int x,y;
			while(pq.size()>1)
			{
				x=pq.remove();
				y=pq.remove();
				pq.add(x+y);
				sum+=x+y;
				
			}
			pw.println(sum);
		}
		pw.flush();
		pw.close();sc.close();
	}

}
