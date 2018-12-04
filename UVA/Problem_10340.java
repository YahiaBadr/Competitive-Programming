package UVA;

import java.io.*;
import java.util.*;

public class Problem_10340 {
	public static boolean check(String s,String t)
	{
		if(t.contains(s))
			return true;
		int j=0,i=0,c=0;;
		for(;i<s.length();i++)
		{
			char ch= s.charAt(i);
			while(j<t.length())
			{
				if(ch==t.charAt(j))
				{	j++;
					c++;
					break;
				}
				j++;
			}
			
		}
		if(c==s.length())
			return true;
		return false;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(sc.hasnext())
		{
			StringTokenizer st= new StringTokenizer(sc.nextLine());
			String s=st.nextToken();
//			if(s.equals("0"))
//				break;
			String t=st.nextToken();
			if(check(s,t))
			{
				pw.println("Yes");
			}
			else
				pw.println("No");
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
