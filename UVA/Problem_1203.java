package UVA;
import java.util.*;
import java.io.*;
public class Problem_1203
{
	static class pair implements Comparable<pair>
	{
		int q,k,ans;
		public pair(int qu,int k,int ans)
		{
			q=qu;this.k=k;this.ans=ans;
		}
		@Override
		public int compareTo(pair o1)
		{
			pair o=(pair)o1;
			if(ans>o.ans)
				return 1;
			if(ans<o.ans)
				return -1;
			if(q>o.q)
				return 1;
			if(q<o.q)
				return -1;
			return 0;
		}
		public String toString()
		{
			return ""+q;
		}
	}
	public static void main(String[] args)throws Throwable
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> arr=new ArrayList<>();
		while(true)
		{
			String s= br.readLine();
			if(s.equals("#"))
				break;
			else
				arr.add(s);
		}
		int n= Integer.parseInt(br.readLine());
		//TreeSet<pair> ts=new TreeSet<>();
		PriorityQueue<pair> ts= new PriorityQueue<>();
		for(int f=0;f<arr.size();f++)
		{
			String tmp=arr.get(f);
			String tmp1[]=tmp.split(" ");
			int q=Integer.parseInt(tmp1[1]);
			int k=Integer.parseInt(tmp1[2]);
			ts.add(new pair(q, k,k));			
		}		
		int n1=0;
		while(!ts.isEmpty())
		{
			pair j=ts.poll();
			System.out.println(j);
			pair y=new pair(j.q,j.k,j.ans+j.k);
			//ts.remove(j);
			ts.add(y);
			n1++;
			if(n1==n)
				break;
		}
	}
}
