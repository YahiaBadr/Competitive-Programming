package UVA;

import java.io.*;
import java.util.*;

public class Problem_10200 {
	public static boolean prime(long x)
	{
		int sqrt=(int)Math.ceil(Math.sqrt(x));
		for(int i=0;i<p.size()&&p.get(i)<=sqrt;i++)
			if(x%p.get(i)==0)
				return false;
		return true;
	}
	static ArrayList<Integer>p;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		p=new ArrayList<>();
		boolean f[]=new boolean[10000001];
		f[0]=true;
		f[1]=true;
		for(int i=2;i<f.length;i++)
			if(!f[i])
			{
				p.add(i);
				for(int j=i+i;j<f.length;j+=i)
					f[j]=true;
			}
		int[]total=new int[10001];
		total[0]=1;
		for(int i=1;i<=10000;i++)
		{
			long x=1l*i;
			x=(x*x)+x+41;
			if(x<f.length)
			{
				if(!f[(int)x])
					total[i]=total[i-1]+1;
				else
					total[i]=total[i-1];
					
			}
			else
			{
				if(prime(x))
					total[i]=total[i-1]+1;
				else
					total[i]=total[i-1];
			}
		}
//		while(true)
		while(sc.hasnext())
		{
			int l=sc.nextInt(),r=sc.nextInt();
			if(l==-1)
				break;
			double diff=r-l+1;
			int n;
			if(l==0)
				n=total[r];
			else
				n=total[r]-total[l-1];	
			pw.printf("%.2f",100*n/diff);
			pw.println();
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
