package UVA;

import java.io.*;
import java.util.*;

public class Problem_11960 {
	public static void seive()
	{
		boolean f[]=new boolean[1000001];
		f[0]=true;
		f[1]=true;
		for(int i=2;i<f.length;i++)
			if(!f[i])
			{
				p.add(i);
				hs.add(i);
				for(int j=i+i;j<f.length;j+=i)
					f[j]=true;
			}
	}
	public static int Nod(int x)
	{
		if(hs.contains(x))
			return 2;
		int i=0;int r=1,xx=1;//int np=0;
		while(i<p.size() && p.get(i)<=Math.sqrt(x))
		{
			int n=x,pr=p.get(i++),tmp=1;
			while(n%pr==0 && n>=pr)
			{
				n/=pr;
				tmp++;
				xx*=pr;
			}
			r*=tmp;
//			np+=tmp-1;
		}
		if(x!=xx)
		{
			r*=2;
//			np++;
		}
//		return np;//np=number of primefactors in x
		return r;//r=number of divisors in x
	}
	static ArrayList<Integer>p;
	static HashSet<Integer>hs;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		p=new ArrayList<>();
		hs=new HashSet<>();
		seive();
		int[]sol=new int[1000001];
		int max=0;
		for(int i=1;i<sol.length;i++)
		{
			int d=Nod(i);
			if(max<=d)
			{
				sol[i]=i;
				max=d;
			}
			else
				sol[i]=sol[i-1];
		}
		int t=sc.nextInt();
		while(t-->0)
		{
			pw.println(sol[sc.nextInt()]);
		}
		pw.close();
	}
	static class Pair implements Comparable<Pair>
	{
		int x,d;
		public Pair(int x,int y) {
		
			this.x=x;;this.d=y;
		}
		@Override
		public int compareTo(Pair p) {
				return d-this.d;
//			return p.x-x;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "("+x+","+d+")";
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
