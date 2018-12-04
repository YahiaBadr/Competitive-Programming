package UVA;

import java.io.*;
import java.util.*;

public class Problem_11991 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(sc.hasnext())
		{	
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] a=new ArrayList[1000000];
		int n=sc.nextInt();
		int t=sc.nextInt();
		for(int i=1;i<=n;i++)
		{
			int x=sc.nextInt();
			if(a[x]==null)
			{
				a[x]=new ArrayList<>();
			}
			a[x].add(i);
		}
		while(t-->0)
		{
			int i=sc.nextInt();
			int x=sc.nextInt();
			if(a[x]==null || a[x].size()<i)
				pw.println(0);
			else
				pw.println(a[x].get(i-1));
		}
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
