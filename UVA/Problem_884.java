package UVA;

import java.io.*;
import java.util.*;

public class Problem_884 {
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
			return 1;
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
		}
		if(x!=xx)
		{
			r*=2;
			np+=r-r+1;
		}
		return np;//r=number of divisors in x
	}
	public static int get_powers(int n, int p)//the power of the prime number p in n!
	{
	   int res = 0;
	   n/=p;
	   while(n>0)
	   {
		   res+=n;
		   n/=p;
	   }
	    return res;
	}
	static ArrayList<Integer>p;
	static HashSet<Integer>hs;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		hs=new HashSet<>();
		p=new ArrayList<>();
		seive();
		int[]a=new int[1000001];
		for(int i=2;i<a.length;i++)
			a[i]+=Nod(i)+a[i-1];
		while(sc.hasnext())
			pw.println(a[sc.nextInt()]);
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
