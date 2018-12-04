package UVA;

import java.io.*;
import java.util.*;

public class Problem_10892 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(true)
		{
			int x=sc.nextInt(),ans=0;
			ArrayList<Integer>div=new ArrayList<>();
			if(x==0)
				break;
			for(int i=1;i*i<=x;i++)
				if(x%i==0)
				{
					div.add(i);
					if(i!=x/i)
						div.add(x/i);
				}
			for(int i=0;i<div.size();i++)
				for(int j=i;j<div.size();j++)
					if(lcm(div.get(i),div.get(j))==x)
						ans++;
			pw.println(x+" "+(ans));
		}
		pw.close();
	}
	public static int gcd(int a,int b)
	{
		if(b==0)
			return a;
		return gcd(b, a%b);
	}
	public static int lcm(int a,int b)
	{
		//a*b=gcd(a,b)*lcm(a,b)
		int gcd=gcd(a, b);
		return a*(b/gcd);
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
