package UVA;

import java.io.*;
import java.util.*;

public class Problem_10611 {
	public static long sol1(int s,int e,long ans)
	{
		if(s>e)
			return ans;
		int mid=(s+e)/2;
		if(a[mid]<h)
			return sol1(mid+1,e,ans);
		else
			return sol1(s,mid-1,ans);
	}
	static long h;static long[] a;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int n=sc.nextInt();
		a= new long[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextLong();
		int q=sc.nextInt();
		long q1[]=new long[q];
		for(int i=0;i<q;i++)
			q1[i]=sc.nextLong();
		for(int i=0;i<q;i++)
		{
			h=q1[i];
			int s=0;
			int e=n-1;long ans1=(long)Math.pow(2, 33);
			long f=(long)Math.pow(2, 33);
			while(e>=s)
			{
				int mid=(s+e)/2;
				//System.out.println(s+" + "+e+" = "+mid);
				if(a[mid]>h)
				{	
					ans1=Math.min(ans1, a[mid]);
					e=mid-1;
				}
				else
				{
					s=mid+1;
				}
			}
			s=0;e=n-1;long ans=-1;
			while(e>=s)
			{
				int mid=(s+e)/2;
				if(a[mid]<h)
				{	
					ans=Math.max(ans, a[mid]);
					s=mid+1;
				}
				else
				{
					e=mid-1;
				}
			}
			pw.println((ans==-1?"X":ans) +" "+(ans1==f?"X":ans1));
//			long shor=sol1(0,a.length,-1);
//			long tall=sol2(0,a.length);
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
