package UVA;

import java.io.*;
import java.util.*;

public class Problem_11900 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();int cs=1;
		while(t-->0)
		{
			int n=sc.nextInt();
			int p=sc.nextInt();
			int q=sc.nextInt();
			int a[]= new int[n];
			int ans=0,wei=0;
			for(int i=0;i<n;i++)
			{	
				a[i]=sc.nextInt();
				if(a[i]+wei<=q && ans<p)
				{
					wei+=a[i];
					ans++;
				}
			}
			pw.println("Case "+cs+": "+ans);
			cs++;
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
