package UVA;

import java.io.*;
import java.util.*;

public class Problem_11730 {
	static ArrayList<Integer>p;
	static HashSet<Integer>hs;
	public static void seive()
	{
		boolean f[]=new boolean[1001];
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
		pf[x]=new ArrayList<>();
		if(hs.contains(x))
			return 2;
		int i=0;int r=1,xx=1,np=0;
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
			np+=tmp-1;
			if(tmp>1)
				pf[x].add(pr);
		}
		if(x!=xx)
		{
			r*=2;
			np++;
			r+=np-np;
			pf[x].add(x/xx);
		}
//		return np;//np=number of primefactors in x
		return r;//r=number of divisors in x
	}
	public static int sol(int s)
	{
		Queue<Integer>q=new LinkedList<>(),steps=new LinkedList<>();
		q.add(s);
		steps.add(0);
		boolean vis[]=new boolean[t+1];
		while(!q.isEmpty())
		{
			int x=q.poll();
			int step=steps.poll();
			if(x==t)
				return step;
			for(int i=0;i<pf[x].size();i++)
			{
				int x1=pf[x].get(i)+x;
				if(x1<=t && !vis[x1] && !hs.contains(x1))
				{
					q.add(x1);
					steps.add(step+1);
					vis[x1]=true;
					if(x1==t)
						return step+1;
				}
			}
		}
		return -1;
	}
	static ArrayList<Integer>[]pf;
	static int[]dp;
	static int t;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		p=new ArrayList<>();
		hs=new HashSet<>();
		pf=new ArrayList[1001];
		seive();
		for(int i=1;i<1001;i++)
			Nod(i);
		int c=1;
		while(true)
		{
			int s=sc.nextInt();t=sc.nextInt();
			if(s==0 && t==0)
				break;
			if(s==t)
			{				
				pw.println("Case "+(c++)+": 0");
				continue;
			}
			if(hs.contains(s) || hs.contains(t)|| s>t)
			{	
				pw.println("Case "+(c++)+": -1");
				continue;
			}
			int ans=sol(s);
			pw.println("Case "+(c++)+": "+ans);
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
