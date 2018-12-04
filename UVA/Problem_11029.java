package UVA;

import java.io.*;
import java.util.*;

public class Problem_11029 {
	public static long first(long x)
	{
		long first=x;
		while(first>9999)
		{
			first/=10;
		}
		return first;
	}
	public static int last(int x)
	{
		int last=x,c=0;
		if(x>9999)
		{
			last=0;
			while(c<4)
			{
				last+=((int)Math.pow(10,c++)*(x%10));
				x/=10;
			}
		}
		return last;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();
		while(t-->0)
		{
			int x=sc.nextInt(),p=sc.nextInt();
			int last=last(x);
			double first= Math.log10(x)*p;
			first=Math.pow(10, first-(int)first)*100;
			pw.println((int)first+"..."+fun(powl(last,p)));
		}
		pw.close();
	}
	public static String fun(long x)
	{
		int res=(int)x%1000;
		if(res<10)
			return "00"+res;
		if(res<100)
			return "0"+res;
		return res+"";
	}
	public static long powl(long b,long p)
	{
		//(b^2p)=(b^2)^p  ----> p=2p/2;
		//(b^2p+1)=b*((b^2)^p)
		long res=1;
		while(p>0)
		{
			if(p%2==1)
			{
				res*=b;
				res=last((int)res);
				p--;
			}
			else
			{
				b*=b;
				b=last((int)b);
				p/=2;
			}
			//Modification
//			if(p%2==1)
//				res*=b;
//			b*=b;
//			p/=2;
		}
		return res;
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
