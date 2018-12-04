package UVA;

import java.io.*;
import java.util.*;

class Pair
{
	String a,b;
	public Pair(String x,String y)
	{
		a=x;b=y;
	}
	public boolean check(String s)
	{
		return s.contains(a);
	}
	public String make(String s1)
	{
		return s1.replace(a, b);
	}
	@Override
	public String toString(){
		return " . "+a+" : "+b+" .";
	}
}
public class Problem_1251 {
	static String end;static Pair[]a;static int n,min=-1;
	public static void rec(String s,int sum)
	{
		if(s.length()>end.length())
			return;
		if(s.equals(end))
		{
			if(min==-1)
				min=sum;
			else
				min=Math.min(min, sum);
			return ;
		}
		for(int i=0;i<n;i++)
		{
			if(a[i].check(s))
			{
				rec(a[i].make(s),sum+1);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(true)
		{
			min=-1;
			n=sc.nextInt();
			if(n==0)
				break;
			a= new Pair[n];
			for(int i=0;i<n;i++)
			{
				StringTokenizer st= new StringTokenizer(sc.nextLine());
				a[i]=new Pair(st.nextToken(),st.nextToken());
			}
			String start=sc.nextLine();
			end=sc.nextLine();
			rec(start,0);
			System.out.println(min);
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
