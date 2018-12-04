package UVA;

import java.io.*;
import java.util.*;

class Gas implements Comparable<Gas>
{
	long s,p,e,a;
	public Gas(long p,long i, long l)
	{
		this.p=p;
		e=p+i;
		s=p-i;
		a=i*2;
		if(p==0)
		{
			s=0;
			a=i;
		}
		if(p==l)
		{
			e=l;
			a=i;
		}
	}
	@Override
	public int compareTo(Gas o) {
		if(s>o.s)
			return 1;
		if(s==o.s)
			return 0;
		return -1;	
	}
	@Override
	public String toString()
	{
		return s+" , "+e+".";
	}
	
}
public class Problem_12321 {
	static long l;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(true)
		{
			l=sc.nextLong();
			int g=sc.nextInt();
			if(l==0)
				break;
			Gas[] a= new Gas[g];
			for(int i=0;i<g;i++)
				a[i]=new Gas(sc.nextLong(), sc.nextLong(), l);
			Arrays.sort(a);
			//pw.println(Arrays.toString(a));
			if(a[0].s>0)
			{
				pw.println(-1);
				continue;
			}
			long tmpe=0;
			int ans=g;int j=0;
			while(tmpe<l)
			{
				long maxe=tmpe;
				for(;j<g;j++)
				{
					if(a[j].s<=tmpe)
					{
						maxe=Math.max(maxe, a[j].e);
					}
					else
					{
						break;
					}
				}
				if(tmpe==maxe)
					break;
				ans--;
				tmpe=maxe;
			}
			pw.println(tmpe>=l?ans:-1);
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
