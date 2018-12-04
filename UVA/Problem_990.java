package UVA;

import java.io.*;
import java.util.*;

public class Problem_990 {
	public static Sol dp(int i,int sum,int consumed,StringBuilder sb,int c)
	{
		if(consumed>t)
			return new Sol(sb, -1, -1);
		if(i==n)
			return new Sol(sb, sum, c);
		Sol take=dp(i+1,sum+a[i].v,consumed+(3*w*a[i].d),new StringBuilder(sb.toString()+"\n"+a[i].d+" "+a[i].v),c+1);
		Sol leave=dp(i+1,sum,consumed,new StringBuilder(sb.toString()),c);
		if(take.total>leave.total)
			return take;
		return leave;
	}
	static int n,t,w;
	static Pair[]a;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		for(int i=0;i<1e9;i++);
		int f=1;
		while(sc.hasnext())
		{
			if(f++>1)
				pw.println();
			t=sc.nextInt();w=sc.nextInt();
			n=sc.nextInt();
			a=new Pair[n];
			for(int i=0;i<n;i++)
			{
				a[i]=new Pair(sc.nextInt(), sc.nextInt());
			}
			pw.println(dp(0,0,0,new StringBuilder(),0));
		}
		pw.close();
	}
	static class Pair
	{
		int d,v;
		public Pair(int dd,int vv) {
			// TODO Auto-generated constructor stub
			d=dd;v=vv;
		}
	}
	static class Sol
	{
		StringBuilder sb;int total,c;
		public Sol(StringBuilder sb,int t,int count) {
			// TODO Auto-generated constructor stub
			this.sb=sb;total=t;c=count;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return total+"\n"+c+sb.toString();
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
