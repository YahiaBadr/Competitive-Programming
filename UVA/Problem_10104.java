package UVA;

import java.io.*;
import java.util.*;


public class Problem_10104 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
//		while(true)
		while(sc.hasnext())
		{
			int n=sc.nextInt();
//			if(n==-1)
//				break;
			int m=sc.nextInt();
			pw.println(egcd(n,m));
		}
		pw.close();
	}
	static class Triple
	{
		int x,y,g;
		public Triple(int xx,int yy,int gg)
		{
			x=xx;y=yy;g=gg;
		}
		public String toString() {
			// TODO Auto-generated method stub
			return x+" "+y+" "+g;
		}
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
