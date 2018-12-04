package UVA;

import java.io.*;
import java.util.*;


public class Problem_590 {
	static int graph[][][];
	static int n,k;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=1;
		while(true)
		{
			n=sc.nextInt();k=sc.nextInt();
			if(n==0 && k==0)break;
			graph=new int[n][n][];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(j==i)
						continue;
					int d=sc.nextInt();
					graph[i][j]=new int[d];
					for(int k=0;k<d;k++)
						graph[i][j][k]=sc.nextInt();
				}
			}
//			for(int i=0;i<n;i++)
//				pw.println(Arrays.deepToString(graph[i]));
			dp=new int[n][k+1];
			for(int i=0;i<n;i++)
				Arrays.fill(dp[i], (int)1e9);
			int ans=dp(0,0);
			pw.println("Scenario #"+(t++));
			if(ans==(int)1e9)
				pw.println("No flight possible.");
			else
				pw.println("The best flight costs "+ans+".");
			pw.println();
		}
		pw.close();
	}
	static int dp[][];
	public static int dp(int d,int city)
	{
		if(d==k)
		{	if(city==n-1)
				return dp[city][d]=0;
			else
				return (int)1e9;
		}
		if(dp[city][d]!=(int)1e9)
			return dp[city][d];
		int min=(int)1e9;
		for(int i=0;i<n;i++)
		{
			if(city==i)continue;
			int s=graph[city][i].length;
			if(graph[city][i][d%s]==0)continue;
			min=Math.min(min, graph[city][i][d%s]+dp(d+1,i));
		}
		return dp[city][d]=min;
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
