package UVA;

import java.io.*;
import java.util.*;

public class Problem_516 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		hs=new HashSet<>();
		p=new ArrayList<>();
		modified_seive(100000);
		while(true)
		{
			StringTokenizer st=new StringTokenizer(sc.nextLine());
			if(st.countTokens()==1)
				break;
			long x=1;
			while(st.hasMoreTokens())
				x*=pow(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			x--;
			StringBuilder sb=new StringBuilder();
			for(int i=p.size()-1;i>=0;i--)
			{
				int c=0;
				while(x%p.get(i)==0)
				{
					c++;
					x/=p.get(i);
				}
				if(c>0)
					sb.append(p.get(i)+" "+c+" ");
			}
			sb.deleteCharAt(sb.length()-1);
			pw.println(sb.toString());
		}
		pw.close();
	}
	static ArrayList<Integer>p;
	static HashSet<Integer>hs;
	public static void modified_seive(int size)
	{
		boolean f[]=new boolean[size];
		f[0]=true;
		f[1]=true;
		for(int i=2;i<f.length;i++)
		{	
			if(!f[i])
			{
				p.add(i);
				hs.add(i);
				for(int j=i;j<f.length;j+=i)
				{
					f[j]=true;
//					pf[j]++;//the only add to be modified
				}
			}
		}
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
