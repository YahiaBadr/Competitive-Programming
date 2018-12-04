package UVA;

import java.io.*;
import java.util.*;

public class Problem_11388 {
	public static int GCD(int a,int b)
	{
		if(b==0)
			return a;
		return GCD(b, a%b);
	}
	public static int LCM(int a,int b,int gcd)
	{
		//a*b=gcd(a,b)*lcm(a,b)
		int mul=a*b;
		return mul/gcd;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();
		while(t-->0)
		{
			int gcd=sc.nextInt(),lcm=sc.nextInt();
			pw.println(lcm%gcd==0?gcd+" "+lcm:-1);
			//a*b=gcd*lcm;
//			long m=1l*gcd*lcm;
//			for(int i=gcd;i<=Math.sqrt(m);i++)
//			{
//				double x=(double)m/i;
//				if((int)x==x)
//				{
////					System.out.println(i+" "+x);
//					int gcd2=GCD((int)Math.max(i, x),(int)Math.min(i, x));
//					if(gcd2==gcd &&LCM((int)Math.max(i, x),(int)Math.min(i, x),gcd2)==lcm)
//					{
//						pw.println((int)Math.min(i, x)+" "+(int)Math.max(i, x));
//						continue big;
//					}
//				}
//			}
//			pw.println(-1);
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
