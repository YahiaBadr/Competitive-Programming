package UVA;

import java.io.*;
import java.util.*;

public class Problem_12346 {
	static int[]f ,c;static int n;static int r;
	public static int sol(int i,int cost, int rsum)
	{
		if(rsum>=r)
		{
//			System.out.println(cost);
			return cost;
		}
		if(i==n)
			return -1;
		int take=sol(i+1,cost+c[i],rsum+f[i]);
		int leave=sol(i+1,cost,rsum);
		if(take==-1 && leave==-1)
			return -1;
		if(take==-1)
			return leave;
		if(leave==-1)
			return take;
		return Math.min(take, leave);
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		n=sc.nextInt();
		f=new int[n];
		c= new int[n];
		for(int i=0;i<n;i++)
		{
			f[i]=sc.nextInt();
			c[i]=sc.nextInt();
		}
		int t=sc.nextInt();int i=1;
		while(t-->0)
		{
			int v=sc.nextInt();
			int h=sc.nextInt();
			r=v/h;
			int sol=sol(0,0,0);
			String s=sol+"";
			if(sol==-1)
				s="IMPOSSIBLE";
			System.out.println("Case "+(i++)+": "+s);
		}
		pw.close();
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
