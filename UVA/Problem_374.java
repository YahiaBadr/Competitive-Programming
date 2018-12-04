package UVA;

import java.io.*;
import java.util.*;

public class Problem_374 {
	public static long pow(long b,long p,int m)
	{
		long res=1;
		while(p>0)
		{
			if(p%2==1)
				res=res*b%m;
			b=b*b%m;
			p/=2;
		}
		return res;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		for(int i=0;i<1e9;i++);
		while(sc.hasnext())
		{
			long b=sc.nextLong(),p=sc.nextLong(),m=sc.nextInt();
			pw.println(pow(b,p,(int)m));
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
