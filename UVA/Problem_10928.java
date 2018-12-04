package UVA;

import java.io.*;
import java.util.*;


public class Problem_10928 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		//TreeMap<Integer, Integer>tm= new TreeMap<>();
		int t=sc.nextInt();
		while(t-->0)
		{
			TreeSet<pair> ts= new TreeSet<>();
			int p=sc.nextInt();
			int i=1;
			while(p-->0)
			{
				StringTokenizer s= new StringTokenizer(sc.nextLine());
				int n=0;
				while(s.hasMoreTokens())
				{
					s.nextToken();
					n++;
				}
				ts.add(new pair(i++,n));
			}
			pair tmp=ts.first();
			int n=tmp.n;
			boolean f=true;
			Iterator<pair> j=ts.iterator();
			while(j.hasNext())
			{
				pair tm=(pair)j.next();
				if(tm.n>n)
					break;
				if(f)
				{
					pw.print(tm.i);
					f=false;
				}
				else	
					pw.print(" "+tm.i);
			}
			pw.println();
		}
		pw.close();
	}
	static class pair implements Comparable<pair>
	{
		int i,n;
		public pair(int i,int n)
		{
			this.i=i;this.n=n;
		}
		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			if(n==o.n)
			{
				return i-o.i;
			}
			return n-o.n;
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
