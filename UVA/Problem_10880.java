package UVA;

import java.io.*;
import java.util.*;

public class Problem_10880 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();int cu=1;
		Stack<Integer>st=new Stack<>();
		while(t-->0)
		{
			pw.print("Case #"+(cu++)+":");
			int c=sc.nextInt(),r=sc.nextInt();
			int gq=c-r;
			if(gq==0)
			{
				pw.print(" 0");
				pw.println();
				continue;
			}
//			System.out.println(gq);
			for(int i=1;i<=Math.sqrt(gq);i++)
			{	
				if(gq%i==0)
				{
					if(i>r)
						pw.print(" "+i);
					if(gq/i>r && gq/i != i)
						st.push(gq/i);
				}
			}
			while(!st.isEmpty())
				pw.print(" "+st.pop());
			pw.println();
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
