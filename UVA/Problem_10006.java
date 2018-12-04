package UVA;

import java.io.*;
import java.util.*;

public class Problem_10006 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		hs=new HashSet<>();
		modified_seive(65001);
		HashSet<Integer>carm=new HashSet<>();
		for(int i=1;i<65000;i++)
			if(!hs.contains(i)&&check(i))
				carm.add(i);
		while(true)
		{
			int n=sc.nextInt();
			if(n==0)
				break;
			if(carm.contains(n))
				pw.println("The number "+n+" is a Carmichael number.");
			else
				pw.println(n+" is normal.");
		}
		pw.close();
	}
	public static boolean check(int n)
	{
		for(int i=2;i<n;i++)
			if(pow_mod(i,n,n)%n!=i)
				return false;
		return true;
	}
	public static long pow_mod(long b,long p,long m)
	{
		long res=1;
		while(p>0)
		{
			if(p%2==1)
				res=res*b%m;
			b=b*b%m;
			p/=2;
		}
		return res;
	}
	static HashSet<Integer>hs;
	public static void modified_seive(int size)
	{
		boolean f[]=new boolean[size];
		f[0]=true;
		f[1]=true;
		for(int i=2;i<f.length;i++)
		{	
			if(!f[i])
			{
				hs.add(i);
				for(int j=i+i;j<f.length;j+=i)
				{
					f[j]=true;
				}
			}
		}
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
