package UVA;

import java.io.*;
import java.util.*;

public class Problem_11292 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(true)
		{	
			int h=sc.nextInt();
			int k=sc.nextInt();
			if(h==0)
				break;
			int ah[]=new int[h];
			int ak[]=new int[k];
//			int sumh=0;
			for(int i=0;i<h;i++)
			{
				ah[i]=sc.nextInt();
//				sumh+=ah[i];
			}
			for(int i=0;i<k;i++)
			{
				ak[i]=sc.nextInt();
			}
			if(k<h)
			{
				pw.println("Loowater is doomed!");
				continue;
			}
			Arrays.sort(ak);Arrays.sort(ah);
			int ans=0;int i=0,j=0;
			while(true)
			{
				if(i==k || j==h)
					break;
				if(ak[i]>=ah[j])
				{
					ans+=ak[i];
					i++;j++;
				}
				else
					i++;
			}
			if(j==h)
				pw.println(ans);
			else
				pw.println("Loowater is doomed!");
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
