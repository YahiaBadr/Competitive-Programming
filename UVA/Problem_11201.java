package UVA;

import java.io.*;
import java.util.*;

public class Problem_11201 {
	static double[] a={12.53,1.42,4.68,5.86,13.68,0.69,1.01,0.7,6.25,0.44,0,4.97,3.15,6.71,8.68,2.51,0.88,6.87,7.98,4.63,3.93,0.9,0.02,0.22,0.9,0.52};
	static char[] codd={'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
	static char[] ceve={'a','e','i','o','u'};
	static int  totalw;static double av,total;
	static int []f;
	static String or;
	public static double aver(String s)
	{
		double sum=0;
		for(int i=0;i<s.length();i++)
		{
			sum+=((i+1)*a[(s.charAt(i)-'a')]);
		}
		return sum;
	}
	public static void rec(String s,boolean eve)
	{
		if(s.length()==or.length())
		{
			//System.out.println(s);
			if(!s.equals(or))
			{	total+=aver(s);
				totalw++;
			}
			return;
		}
		if(eve)
		{
			for(int i=0;i<ceve.length;i++)
			{
				if(f[ceve[i]-'a']<2)
				{
					f[ceve[i]-'a']++;
					rec(s+ceve[i],!eve);
					f[ceve[i]-'a']--;
				}
			}
		}
		else
		{
			for(int i=0;i<codd.length;i++)
			{
				if(f[codd[i]-'a']<2)
				{
					f[codd[i]-'a']++;
					rec(s+codd[i],!eve);
					f[codd[i]-'a']--;
				}
			}
		}
		
	}
	public static void one(char c)
	{
		double sum;
		if(c=='a' || c=='e'||c=='i'||c=='o'|| c=='u')
		{
			sum=(45.07-a[c-'a'])/4;
		}
		else
		{
			sum=(100.13-45.07-a[c-'a']/20);
		}
		if(av<sum)
			System.out.println("below");
		else
			System.out.println("above or equal");
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();
		while(t-->0)
		{
			or= sc.nextLine();
			av=aver(or);
			total=0;totalw=0;
			f=new int[26];
			if(or.length()==1)
			{
				
			}
			f[(int)or.charAt(0)-'a']++;
			rec(or.charAt(0)+"",true);
			if(av<total/totalw)
				System.out.println("below");
			else
				System.out.println("above or equal");
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
