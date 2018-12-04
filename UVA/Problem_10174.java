package UVA;

import java.io.*;
import java.util.*;

public class Problem_10174 {
	public static String get(int n)
	{
		
		if(n==0)
			return "2 2";
		boolean neg=false;
		if(n<0)
		{
			neg=true;
			n=-n;
		}
		if(n%2==1)
		{
			if(!neg)
				return (int)Math.ceil(n/2.0)+" "+((int)Math.ceil(n/2.0)-1);
			else
				return ((int)Math.ceil(n/2.0)-1)+" "+(int)Math.ceil(n/2.0);
				
		}
		if(n%4==0)
		{
			int l=(n/4+1),r=(n/4-1);
			if(!neg)
				return l+" "+r;
			else
				return r+" "+l;
				
		}
		return "Bachelor Number.";
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
//		for(int i=0;i<1e9;i++);
		while(sc.hasnext())
		{
			StringTokenizer st=new StringTokenizer(sc.nextLine());
			if(st.countTokens()==1)
			{
				int n=Integer.parseInt(st.nextToken());
				pw.println(get(n));
			}
			else
			{
				int n1=Integer.parseInt(st.nextToken());
				int n2=Integer.parseInt(st.nextToken());
				int ans=0;
				for(int i=n1;i<=n2;i++)
					if(get(i).equals("Bachelor Number."))
						ans++;
				pw.println(ans);
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
