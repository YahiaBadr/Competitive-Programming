package UVA;

import java.io.*;
import java.util.*;


public class Problem_10673 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();
		while(t-->0)
		{
			int x=sc.nextInt(),k=sc.nextInt();
			int floor=x/k,ceil=(int)Math.ceil(x/(1d*k));
//			pw.println(floor+" "+ceil);
			Triple egcd=egcd(floor,ceil);
			int g=egcd.g;
			pw.println((egcd.x*x)/g+" "+(egcd.y*x)/g);
		}
		pw.close();
	}
	public static Triple egcd(int n,int m)
	{
		if(m==0)
			return new Triple(1, 0, n);
		Triple t=egcd(m,n%m);//m',r',g
		int mm=t.x;
		int r=t.y;
		t.y=mm-n/m*r;
		t.x=r;
		return t;
	}
	static class Triple
	{
		int x,y,g;
		public Triple(int xx,int yy,int gg)
		{
			x=xx;y=yy;g=gg;
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
