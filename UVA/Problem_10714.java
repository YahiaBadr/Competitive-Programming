package UVA;

import java.io.*;
import java.util.*;

public class Problem_10714 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();
		while(t-->0)
		{
			int l=sc.nextInt();
			int n=sc.nextInt();
			int []a= new int[n];
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
			Arrays.sort(a);
			int min=-1;
			int max=-1;
			for(int i=0;i<n;i++)
			{
				min=Math.max(min,Math.min(a[i], l-a[i]));
				max=Math.max(max,Math.max(a[i], l-a[i]));
			}
			pw.println(min+" "+max);
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
