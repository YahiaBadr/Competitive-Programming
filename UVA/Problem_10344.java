package UVA;

import java.io.*;
import java.util.*;

public class Problem_10344 {
	static int[]a;static boolean f[];static HashSet<Integer>hs;static boolean flag;
	public static void sol(int i,int sum)
	{
		if(i==a.length)
		{
			if(sum==23)
				flag=true;
			return ;
		}
		for(int j=0;j<5;j++)
		{
			if(flag)
				return;
			if(i==0)
			{	
				f[j]=true;
				sol(i+1,a[j]);
				f[j]=false;
			}
			if(i!=0 && !f[j])
			{
				f[j]=true;
				sol(i+1,sum+a[j]);
				if(flag)
					return;
				sol(i+1,sum*a[j]);
				if(flag)
					return;
				sol(i+1,sum-a[j]);
				if(flag)
					return;
				f[j]=false;
			}
		}
	}
	public static void sol(int i,int sum,String s)
	{
		if(i==a.length)
		{
			if(sum==23)
			{	
				flag=true;
				System.out.println(s);
			}
			return ;
		}
		for(int j=0;j<5;j++)
		{
			if(flag)
				return;
			if(i==0)
			{	
				f[j]=true;
				sol(i+1,sum+a[j],s+a[j]);
				f[j]=false;
			}
			if(i!=0 && !f[j])
			{
				f[j]=true;
				sol(i+1,sum+a[j],s+"+"+a[j]);
				if(flag)
					return;
				sol(i+1,sum*a[j],s+"*"+a[j]);
				if(flag)
					return;
				sol(i+1,sum-a[j],s+"-"+a[j]);
				if(flag)
					return;
				f[j]=false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(true)
		{
			a=new int[5];
			a[0]=sc.nextInt();
			a[1]=sc.nextInt();
			a[2]=sc.nextInt();
			a[3]=sc.nextInt();
			a[4]=sc.nextInt();
			if(a[0]==0)
				break;
			hs=new HashSet<>();
			f=new boolean[5];
			flag=false;
			sol(0,0);
			if(flag)
				pw.println("Possible");
			else
				pw.println("Impossible");
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
