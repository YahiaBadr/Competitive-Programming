package UVA;

import java.io.*;
import java.util.*;

public class Problem_10130 {
	static int[][]a,dp;
	static int[]w;
	public static int sol(int cw,int id)
	{
		if(dp[id][cw]!=-1)
			return dp[id][cw];
		if(cw==0 || id==a[0].length)
			dp[id][cw]= 0;
		else if(cw>=a[1][id])
			dp[id][cw]= Math.max(sol(cw-a[1][id],id+1)+a[0][id], sol(cw,id+1));
		else if(cw<a[1][id])
			dp[id][cw]=sol(cw,id+1);
		return dp[id][cw];
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();
		while(t-->0)
		{
			int items=sc.nextInt();
			a=new int[3][items];
			for(int i=0;i<items;i++)
			{
				a[0][i]=sc.nextInt();
				a[1][i]=sc.nextInt();
			}
			int m=sc.nextInt();
			w=new int[m];
			int maxW=0;
			for(int i=0;i<m;i++)
			{
				w[i]=sc.nextInt();
				maxW=Math.max(maxW, w[i]);
			}
			dp=new int[items+1][maxW+1];
			for(int i=0;i<dp.length;i++)
				Arrays.fill(dp[i], -1);
			int max=0;
			for(int i=0;i<w.length;i++)
				max+=sol(w[i],0);
			pw.println(max);
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
