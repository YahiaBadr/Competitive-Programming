package UVA;

import java.io.*;
import java.util.*;

public class Problem_10622 {
	public static int gcd(int a,int b)
	{
		if(b==0)
			return a;
		return gcd(b, a%b);
	}
	public static void seive()
	{
		boolean f[]=new boolean[1000001];
		f[0]=true;
		f[1]=true;
		for(int i=2;i<f.length;i++)
			if(!f[i])
			{
				p.add(i);
				hs.add((long)i);
				for(int j=i+i;j<f.length;j+=i)
					f[j]=true;
			}
	}
	static int div(int x)
	{
		for(int i=x;i>0;i--)
			if(x%i==0 && i%2==1)
				return i;
		return 1;
	}
	public static int Nod(long x,HashMap<Long, Integer>hm)
	{
		
		if(hs.contains(x))
		{	
			max=1;
			hm.put(x, 1);
			return 2;
		}
		int i=0;int r=1;long xx=1;
		while(i<p.size() && p.get(i)<=Math.sqrt(x))
		{
			long n=x,pr=p.get(i++),tmp=1;
			while(n%pr==0 && n>=pr)
			{
				n/=pr;
				tmp++;
				xx*=pr;
			}
			r*=tmp;
			if(tmp>1)
				hm.put((long)pr, (int)tmp-1);
		}
		if(x!=xx)
		{	
			r*=2;
			max=Math.max(max, 1);
			hm.put(x/xx, 1);
		}
		return r;//r=number of divisors in x
	}
	static ArrayList<Integer>p;
	static HashSet<Long>hs;
	static int max;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		p=new ArrayList<>();
		hs=new HashSet<>();
		seive();
		while(true)
		{
			long x=sc.nextInt();
			HashMap<Long, Integer>hm=new HashMap<>();
			if(x==0)
				break;
			max=0;
			boolean neg=false;
			if(x<0)
			{
				neg=true;
				x=-x;
			}
			Nod(x,hm);
			ArrayList<Integer>arr=new ArrayList<Integer>(hm.values());
			int r=arr.get(0);
			for(int i=1;i<arr.size();i++)
				r=gcd(r,arr.get(i));
//			System.out.println(hm);
			if(neg)
				r=div(r);
			
			pw.println(r);
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
