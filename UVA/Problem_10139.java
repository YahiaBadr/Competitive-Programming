package UVA;

import java.io.*;
import java.util.*;

public class Problem_10139 {
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
	public static int Nod(int x,HashMap<Integer, Integer>hm)
	{
		if(hs.contains(x))
		{
			hm.put(x, 1);
			return 2;
		}
		int i=0;int r=1,xx=1;
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
			if(tmp!=1)
				hm.put(pr, tmp-1);
		}
		if(x!=xx)
		{
			r*=2;
			hm.put(x/xx, 1);
		}
		return r;//r=number of divisors in x
	}
	public static int get_powers(int n, int p)
	{
	    int result = 0;
	    n /= p;
	    do {
	        result += n;
	        n /= p;
	    }while(n > 0);
	    return result;
	}
	static ArrayList<Integer>p;
	static HashSet<Integer>hs;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		p=new ArrayList<>();
		hs=new HashSet<>();
		seive();
		while(true)
//		while (sc.hasnext())
		{
			int n=sc.nextInt(),m=sc.nextInt();
			if(n==-1)
				break;
			if(m==0 || (n==0 && m!=1))
			{
				pw.println(m+" does not divide "+n+"!");
				continue;
			}
			if((n==0 && m==1)|| m==1 || m<=n)
			{
				pw.println(m+" divides "+n+"!");
				continue;
			}
			HashMap<Integer, Integer>powers=new HashMap<>();
			Nod(m,powers);
			boolean f=true;
			for(int i: powers.keySet())
			{
				if(powers.get(i)==0)
					continue;
				int p=powers.get(i)-get_powers(n,i);
				if(p>0)
				{
					f=false;
					break;
				}
			}
			if(!f)
				pw.println(m+" does not divide "+n+"!");
			else
				pw.println(m+" divides "+n+"!");
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
