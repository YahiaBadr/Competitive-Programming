package UVA;

import java.io.*;
import java.util.*;

public class Problem_11536 {
	public static void remove(long x)
	{
		int occ=hm.get(x);
		if(occ==1)
			hm.remove(x);
		else
			hm.put(x, occ-1);
	}
	static HashMap<Long, Integer>hm;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();int c1=0;
		while(t-->0)
		{
			c1++;
			int n=sc.nextInt();
			int m=sc.nextInt();
			int k=sc.nextInt();
			long[]a=new long[n];a[0]=1;a[1]=2;a[2]=3;
			for(int i=3;i<n;i++)
				a[i]=(a[i-1]+a[i-2]+a[i-3])%m +1;
			hm= new HashMap<>();
			int c=0;int ans=1000003;int j=0;
			for(int i=0;i<n;i++)
			{
				while(c>=k && hm.size()==k)
				{
					ans=Math.min(ans,i-j);
					if(a[j]<=k)
						remove(a[j]);
					j++;
					c--;
				}
				if(a[i]<=k && hm.containsKey(a[i]))
					hm.put(a[i], hm.get(a[i])+1);
				else if(a[i]<=k)
					hm.put(a[i],1);
				c++;
			}
			pw.println(ans==1000003?"Case "+c1+": sequence nai":"Case "+c1+": "+ans);
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
