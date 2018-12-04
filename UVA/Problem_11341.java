package UVA;

import java.io.*;
import java.util.*;

public class Problem_11341 {
	static int n,m;
	static int[][]a;
	static int[][][]dp;
	public static int bf(int c,int i,int sum)
	{
		int max=0;
		if(i==n && c>=0)
			return sum;
		if(c<=0)
			return (int)-1e9;
		if(dp[i][sum][c]!=-1)
			return dp[i][sum][c];
		boolean f=false;
		for(int j=0;c-j>=0 && j<m;j++)
		{
			if(a[i][j]>4)
			{
				max=Math.max(max,bf(c-j-1,i+1,sum+a[i][j]));
				f=true;
			}
		}
		if(f)
			return dp[i][sum][c]=max;
		return (int)-1e9;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();
		while(t-->0)
		{
			n=sc.nextInt();
			m=sc.nextInt();
			a=new int[n][m];
			dp=new int[n][200][m+1];
			for(int i=0;i<n;i++)
				for(int j=0;j<200;j++)
					Arrays.fill(dp[i][j], -1);
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					a[i][j]=sc.nextInt();
			double sol=bf(m,0,0)/(double)n;
			if(sol>=5)
				pw.printf("Maximal possible average mark - %.2f.\n",sol);
			else
				pw.printf("Peter, you shouldn't have played billiard that much.\n");
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