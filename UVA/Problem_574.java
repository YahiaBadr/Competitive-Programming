package UVA;

import java.io.*;
import java.util.*;

public class Problem_574
{
	static int a[];static int t;static TreeSet<String> ts;
	public static void get(int i,String s,int sum)
	{
		if(sum==t)
			ts.add(s.substring(0,s.length()-1));
		if(i==a.length || sum==t)
			return;
		get(i+1,s,sum);
		get(i+1,s+a[i]+"+",sum+a[i]);
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(true)
		{	
			t=sc.nextInt();
			int n=sc.nextInt();
			if(t==0 && n==0)
				break;
			a=new int[n];
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
			ts=new TreeSet<>(Collections.reverseOrder());
			get(0,"",0);
			System.out.println("Sums of "+t+":");
			if(ts.isEmpty())
			{	
				System.out.println("NONE");
				continue;
			}
			Iterator<String> j=ts.iterator();
			while(j.hasNext())
				System.out.println(j.next());
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
