package UVA;

import java.io.*;
import java.util.*;

public class Problem_10533 {
	public static int sum(int i)
	{
		int r=0;
		while(i>0)
		{
			r+=i%10;
			i/=10;
		}
		return r;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		ArrayList<Integer>p=new ArrayList<>();
		boolean f[]=new boolean[1000001];
		boolean dp[]=new boolean[1000001];
		int[]sum=new int[1000001];
		f[0]=true;
		f[1]=true;
		for(int i=2;i<f.length;i++)
		{	
			if(!f[i])
			{
				p.add(i);
				int x=sum(i);
				dp[i]=!f[x];
				for(int j=i+i;j<f.length;j+=i)
					f[j]=true;
			}
		}
		for(int i=1;i<dp.length;i++)
		{
			if(dp[i])
				sum[i]=sum[i-1]+1;
			else
				sum[i]=sum[i-1];
		}
//		System.out.println(Arrays.toString(sum));
		int t=sc.nextInt();
		while(t-->0)
		{
			int s=sc.nextInt(),e=sc.nextInt();
			pw.println(sum[e]-sum[s-1]);
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
