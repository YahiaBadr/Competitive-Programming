package UVA;

import java.io.*;
import java.util.*;

public class Problem_10036 {
	public static int dp(int i,int sum)
	{
		if(i==n)
		{
			return sum%k==0?1:0;
		}
		try
		{
			if(dp[i][sum]!=-1)
			return dp[i][sum];
		}
		catch(Exception e)
		{
			System.out.println();
			System.out.println("here "+ sum);
		}
		int pos=dp(i+1,fix(sum+a[i]));
		int neg=dp(i+1,fix(sum-a[i]));
		dp[i][sum]=pos|neg;
		return dp[i][sum];
	}
	public static int fix(int x)
	{
		return (x%k+k)%k;
	}
	static int n,k;static int[]a;static int[][]dp;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();
		while(t-->0)
		{
			n=sc.nextInt();
			k=sc.nextInt();
			a=new int[n];
			dp=new int[n][k];
			for(int i=0;i<n;i++)a[i]=sc.nextInt();
			for(int i=0;i<n;i++)Arrays.fill(dp[i], -1);
			pw.println(dp(1,fix(a[0]))==1?"Divisible":"Not divisible");
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
