package UVA;

import java.io.*;
import java.util.*;

public class Problem_10820 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		p=new ArrayList<>();
		hs=new HashSet<>();
		pf=new HashSet[50001];
		for(int i=0;i<50001;i++)
			pf[i]=new HashSet<>();
		modified_seive();
		int[]phi=new int[50001];
		long[]ans=new long[50001];
		long sum=0;
		for(int i=1;i<50001;i++)
		{
			int num=i;
			for(int k:pf[i])
				num*=(1-1.0/k);
			phi[i]=num;
			if(hs.contains(i))
				phi[i]=i-1;
			sum+=1l*phi[i];
			ans[i]=(sum-1)*2+1;
		}
		while(true)
		{
			int n=sc.nextInt();
			if(n==0)
				break;
			pw.println(ans[n]);
		}
		pw.close();
	}
	static ArrayList<Integer>p;
	static HashSet<Integer>hs;
	static HashSet<Integer>[]pf;
	public static void modified_seive()
	{
		boolean f[]=new boolean[50001];
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
