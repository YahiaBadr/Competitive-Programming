package UVA;

import java.io.*;
import java.util.*;

public class Problem_11520 {
	public static void insert(int i,int j)
	{
		for(int k=65;k<=90;k++)
		{
			boolean l=true,r=true,up=true,down=true;
			if(i-1>=0 && a[i-1][j]==(char)k)
				up=false;
			if(i+1<n && a[i+1][j]==(char)k)
				down=false;
			if(j+1<n && a[i][j+1]==(char)k)
				r=false;
			if(j-1>=0 && a[i][j-1]==(char)k)
				l=false;
			if(l&&r&&up&&down)
			{
				a[i][j]=(char)k;
				return;
			}
		}
	}
	static char[][]a;static int n;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();int c=1;
		while(t-->0)
		{
			n=sc.nextInt();
			a= new char[n][n];
			for(int i=0;i<n;i++)
			{	
				String s=sc.nextLine();
				for(int j=0;j<n;j++)
					a[i][j]=s.charAt(j);
			}
			for(int i=0;i<a.length;i++)
				for(int j=0;j<a[i].length;j++)
					if(a[i][j]=='.')
						insert(i,j);
			pw.println("Case "+c+":");
			c++;
			for(int i=0;i<n;i++)
			{	
				for(int j=0;j<n;j++)
					pw.print(a[i][j]);
				pw.println();
			}
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
