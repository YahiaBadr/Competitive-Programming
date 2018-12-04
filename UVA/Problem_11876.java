package UVA;

import java.io.*;
import java.util.*;
public class Problem_11876 {
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
		}
		if(x!=xx)
			r*=2;
		return r;
	}
	static ArrayList<Integer>p;
	static HashSet<Integer>hs;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int n=1,j=2;
		p=new ArrayList<>();
		hs=new HashSet<>();
		seive();
		int[]a=new int[1000001];
		a[1]=1;
		while(j<1000001)
		{
			n=n+Nod(n);
			while(j<n && j<1000001)
				a[j]=a[-1+j++];
			if(n<1000001)
				a[n]=a[n-1]+1;
			j=n+1;
		}
		int t=sc.nextInt(),c=1;
		while(t-->0)
		{
			int l=sc.nextInt()-1,r=sc.nextInt();
			pw.println("Case "+(c++)+": "+(a[r]-a[l]));
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
