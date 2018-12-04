package UVA;

import java.io.*;
import java.util.*;

public class Problem_332 {
	public static int gcd(int a,int b)
	{
		if(b==0)
			return a;
		return gcd(b, a%b);
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=1;
		while(true)
		{
			StringTokenizer st=new StringTokenizer(sc.nextLine());
			int j=Integer.parseInt(st.nextToken());
			if(j==-1)
				break;
			String s=st.nextToken();
			int smul=s.length()-2-j;
			int lmul=s.length()-2;
			double x=Double.parseDouble(s);
			int smalp=(int)Math.pow(10, smul);
			int largp=(int)Math.pow(10, lmul);
			int xsmall=(int)(x*smalp);
			int xlarge=(int)Math.round((x*largp));
//			pw.println(xsmall+" "+xlarge);
			int up=(xlarge-xsmall);
			int down=(largp-smalp);
			if(j==0)
			{
				up=xlarge;
				down=largp;
			}
			int gcd=gcd(up,down);
			pw.println("Case "+(t++)+": "+(up/gcd)+"/"+(down/gcd));
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
