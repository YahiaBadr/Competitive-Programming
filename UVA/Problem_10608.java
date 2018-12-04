package UVA;

import java.io.*;
import java.util.*;

public class Problem_10608 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();int p=sc.nextInt();
			DSU dsu=new DSU(n+1);
			while(p-->0)
			{
				dsu.union(sc.nextInt(), sc.nextInt());
			}
			int max=1;
			for(int i=0;i<n;i++)
				max=Math.max(dsu.size[i], max);
			System.out.println(max);
		}
		pw.close();
	}

	static class DSU
	{
		int[]p;
		int[]size;
		public DSU(int n)
		{
			p=new int[n];size=new int[n];
			for(int i=0;i<n;i++)
			{	
				p[i]=i;
				size[i]=1;
			}
		}
		public int findset(int x)
		{
			return x==p[x]?x:(p[x]=findset(p[x]));
		}
		public boolean issameset(int x,int y)
		{
			return findset(x)==findset(y);
		}
		public void union(int x,int y)
		{
			x=findset(x);y=findset(y);
			if(y==x)
				return;
			if(size[y]>=size[x])
			{
				p[x]=y;
				size[y]+=size[x];
			}
			else
			{
				p[y]=x;
				size[x]+=size[y];
			}
		}
		public String toString()
		{
			String s="";
			for(int i=0;i<p.length;i++)
			{
				s+=i+": ";
				for(int j=0;j<p.length;j++)
				{
					if(findset(j)==i)
					{
						s+=j+" ";
					}
				}
				s+="\n";
			}
			return s;
		}
	}
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		boolean hasnext() throws IOException {
			return br.ready();
		}

	}
}
