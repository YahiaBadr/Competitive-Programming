package Tools;

import java.io.*;
import java.util.*;

public class Modulus {
	public static long pow_mod(long b,long p,long m)//O(log(p))
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
	public static long pow(long b,long p)//O(log(p))
	{
		//(b^2p)=(b^2)^p  ----> p=2p/2;
		//(b^2p+1)=b*((b^2)^p)
		long res=1;
		while(p>0)
		{
			if(p%2==1)
			{
				res*=b;
				p--;
			}
			else
			{
				b*=b;
				p/=2;
			}
			//Modification
//			if(p%2==1)
//				res*=b;
//			b*=b;
//			p/=2;
		}
		return res;
	}
	static ArrayList<Integer>p;
	static HashSet<Integer>hs;
	static HashSet<Integer>[]pf;
	static int[]phi;
	public static void modified_seive(int size)
	{
		boolean f[]=new boolean[size];
		f[0]=true;
		f[1]=true;
		for(int i=2;i<f.length;i++)
		{	
			if(!f[i])
			{
				p.add(i);
				hs.add(i);
				for(int j=i+i;j<f.length;j+=i)
				{
					f[j]=true;
					pf[j].add(i);
				}
			}
		}
	}
	public static void phi(int size)
	{
		phi=new int[size];
		for(int i=1;i<50001;i++)
		{
			int num=i;
			for(int k:pf[i])
				num*=(1-1.0/k);
			phi[i]=num;
			if(hs.contains(i))
				phi[i]=i-1;
		}
	}
	static long[]sum_div,num_div;
	public static void sum_number_ofdivi()//after modified sieve
	{
		for(int i=1;i<100001;i++)
		{
			long num=1,sum=1;int tmp=i;
			for(int k:pf[i])
			{
				int power=1,sump=1;
				while(tmp%k==0)
				{
					sump+=pow(k,power);
					power++;
					tmp/=k;
					
				}
				num*=power;
				sum*=sump;
			}
			if(hs.contains(i))
			{
				sum=1+i;
				num=2;
			}
			num_div[i]=num;
			sum_div[i]=sum;
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int x=sc.nextInt();
		pw.print(x);
		pw.println(pow(2,4));
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
