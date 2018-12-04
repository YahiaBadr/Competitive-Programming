package UVA;

import java.io.*;
import java.util.*;

public class Problem_11550 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();
		big:while(t-->0)
		{
			int n=sc.nextInt();
			int m=sc.nextInt();
			int[][] mat=new int[n][m];
			for(int i=0;i<n;i++)
			{	
				for(int j=0;j<m;j++)
				{
					mat[i][j]=sc.nextInt();
				}
			}
			boolean [][]f=new boolean[n][n];
			for(int i=0;i<m;i++)
			{
				int c=0;int x=0;int y=0;
				for(int j=0;j<n;j++)
				{
					if(mat[j][i]==1)
					{	
						c++;
						if(c==1)
							x=j;
						else
							y=j;
					}	
				}
				if(c!=2 || (f[x][y]) )
				{
					System.out.println("No");
					continue big;
				}
				f[x][y]=true;
					
			}
			System.out.println("Yes");
		}
		pw.close();
	}
	static class Pair implements Comparable<Pair>
	{
			int x;
			int y;
			public Pair(int v,int o)
			{
				x=v;y=o;
			}
			public  Pair() {
				// TODO Auto-generated constructor stub
				x=-1;
				y=-1;
			}
			public void add(int x)
			{
				if(this.x==-1)
					this.x=x;
				else y=x;
			}
			@Override
			public int compareTo(Pair o) {
				// TODO Auto-generated method stub
				if(y==o.y)
				{	if(o.x==x)
						return 0;
					return o.x>x?1:-1;
				}	
				return y-o.y;
			}
			
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
