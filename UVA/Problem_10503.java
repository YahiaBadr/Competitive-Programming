package UVA;

import java.io.*;
import java.util.*;

class Poin
{
	int a,b;
	public Poin(int a,int b)
	{
		this.a=a;this.b=b;
	}
	public Poin rev()
	{
		return new Poin(b, a);
	}
	public boolean valid(Poin y)
	{
		return b==y.a;
	}
	@Override
	public String toString()
	{
		return "( "+a+", "+b+" )";
	}
}
public class Problem_10503 {
	static Poin[]a;static int n,m;static Poin[] sol;static boolean f[];
	static Poin right,left;
	public static boolean rec(int i,int s)
	{
		if(i==n+1)
		{
			if(sol[i-1].valid(right))
				return true;
			return false;	
		}
		boolean tmp1=false,tmp2=false;
		if(i==0)
		{
			sol[0]=left;
			tmp1=rec(i+1,s);
			//System.out.println(Arrays.toString(sol));
//			sol[0]=left.rev();
//			tmp2=rec(i+1,s);
			return tmp1;
		}
		else if(s<m)
		{
			for(int j=0;j<a.length;j++)
			{
				if(!f[j])
				{
					if(sol[i-1].valid(a[j]))
					{
						sol[i]=a[j];
						f[j]=true;
						tmp1=rec(i+1,s+1);
						f[j]=false;
					}
					if(sol[i-1].valid(a[j].rev()))
					{
						f[j]=true;
						sol[i]=a[j].rev();
						tmp2=rec(i+1,s+1);
						f[j]=false;
					}
					if(tmp1==true || tmp2==true)
						return true;
				}
			}
		}
		return false;
		
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(true)
		{
			n=sc.nextInt();
			if(n==0)
				break;
			m=sc.nextInt();
			sol=new Poin[m+2];
			f=new boolean[m];
			left=new Poin(sc.nextInt(), sc.nextInt());
			right=new Poin(sc.nextInt(), sc.nextInt());
			a=new Poin[m];
			for(int i=0;i<m;i++)
				a[i]=new Poin(sc.nextInt(), sc.nextInt());
			//System.out.println(Arrays.toString(a));
			if(rec(0,0))
				pw.println("YES");
			else
				pw.println("NO");
			//pw.println(Arrays.toString(sol));
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
