package UVA;

import java.io.*;
import java.util.*;

public class Problem_11413 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(true)
		//while(sc.hasnext())
		{
			int n=sc.nextInt();
			if(n==0)
				break;
			long t=sc.nextLong(),start=0,end=0;
			long[] a= new long[n];
			for(int i=0;i<n;i++)
			{	
				a[i]=sc.nextLong();
				start=Math.max(start, a[i]);
				end+=a[i];
			}
			long c=0;long tmp=0,mid=(start+end)/2,ans=(long)Math.pow(2, 31);
			while(end>=start)
			{
				
				tmp=0;c=1;
				for(int i=0;i<n;i++)
				{
					if(tmp+a[i]>mid)
					{	
						tmp=a[i];
						c++;
					}
					else
						tmp+=a[i];
				}
				if(c>t)
				{
					start=mid+1;
					mid=(start+end)/2;
				}
				else
				{
					ans=Math.min(ans, mid);
					end=mid-1;
					mid=(start+end)/2;
				}
			}
			pw.println(ans);
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
