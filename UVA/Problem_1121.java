package UVA;

import java.io.*;
import java.util.*;

public class Problem_1121 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
//		while(sc.hasnext())
		while(true)
		{
			int n=sc.nextInt();
			if(n==0)
				break;
			long s=sc.nextLong();
			long[]a=new long[n];
			for(int i=0;i<n;i++)
				a[i]=sc.nextLong();
			long sum=0;
			int ans=1000000;int tmp=0;
			int j=0;
			for(int i=0;i<n;i++)
			{
				sum+=a[i];
				tmp++;
				if(sum>=s)
				{
					int tmp2=tmp;
					for(;j<=i && sum>=s;j++)
					{
						sum-=a[j];
						tmp--;
						if(sum>=s)
							tmp2--;
					}
					ans=Math.min(ans, tmp2);
				}
			}
			if(sum>=s)
			{
				for(;j<=n && sum>=s;j++)
				{
					sum-=a[j];
					if(sum>=s)
						tmp--;
				}
				ans=Math.min(ans, tmp);
			}
			pw.println(ans==1000000?0:ans);
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
