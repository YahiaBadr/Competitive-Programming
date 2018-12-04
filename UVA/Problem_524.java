package UVA;

import java.io.*;
import java.util.*;

public class Problem_524
{
	static boolean[] f;static int n;
	public static boolean prime(int x)
	{
		for(int i=2;i<x;i++)
			if(x%i==0)
				return false;
		return true;
	}
	public static void rec(int c,String s, int last)
	{
		if(n==c && prime(1+last))
		{
			
			pw.println(s);
			return;
		}
		for(int i=2;i<=n;i++)
		{
			if(!f[i] && prime(i+last))
			{
				f[i]=true;
				rec(c+1,s+" "+i,i);
				f[i]=false;
				
			}
		}
		
	}
	static PrintWriter pw = new PrintWriter(System.out);
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		int c=1;
		while(sc.hasnext())
		{
			n=sc.nextInt();
			if(n==0)
				break;
			f=new boolean[n+1];
			pw.println("Case "+c+":");
			c++;
			rec(1,"1",1);
			if(sc.hasnext())
				pw.println();
			
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
