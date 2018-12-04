package UVA;

import java.io.*;
import java.util.*;

public class Problem_12405 {
	public static int count(String s)
	{
		int count=0;
		for(int i=0;i<s.length()-2;i++)
		{
			if(s.charAt(i)=='.' && s.charAt(i+1)=='#' && s.charAt(i+2)=='.')
			{	count++;
				i+=2;
			}	
		}
		return count;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();int cs=1;
		while(t-->0)
		{
			int n=sc.nextInt();
			String s=sc.nextLine();
			int ans=0;
			int i=0;
			while(true)
			{
				if(i==n)
					break;
				if(i+1==n)
				{
					if(s.charAt(i)=='.')
						ans++;
					break;
				}
				if(i+2==n)
				{
					if(s.charAt(i)=='.' || s.charAt(i+1)=='.')
						ans++;
					break;
				}
				if(s.charAt(i)=='.' && s.charAt(i+2)=='.')
				{
					ans++;
					i+=3;
				}
				else if(s.charAt(i)=='.')
				{
					ans++;
					i+=2;
				}
				else
					i++;
			}
			pw.println("Case "+cs+": "+ans);
			cs++;
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
