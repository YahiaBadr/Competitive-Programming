package UVA;

import java.io.*;
import java.util.*;

public class Problem_12043 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		p=new ArrayList<>();
		hs=new HashSet<>();
		pf=new HashSet[100001];
		long[]d=new long[100001];
		long[]sig=new long[100001];
		for(int i=0;i<100001;i++)
			pf[i]=new HashSet<>();
		modified_seive();
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
			d[i]=num;
			sig[i]=sum;
		}
		int t=sc.nextInt();
		while(t-->0)
		{
			int s=sc.nextInt(),e=sc.nextInt(),mod=sc.nextInt();
			long g=0,h=0;
			for(int i=s;i<=e;i++)
			{
				if(i%mod==0)
				{
					g+=d[i];
					h+=sig[i];
				}
			}
			pw.println(g+" "+h);
		}
		pw.close();
	}
	public static long pow(long b,long p)
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
	public static void modified_seive()
	{
		boolean f[]=new boolean[100001];
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
					pf[j].add(i);//the only add to be modified
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
