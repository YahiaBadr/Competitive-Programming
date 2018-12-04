package UVA;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class Problem_825 {
	static int w,n,grid[][];static Point dp[][];
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();int c=1;
		while(t-->0)
		{
			if(c++>1)
				pw.println();
			w=sc.nextInt();n=sc.nextInt();
			grid=new int[w][n];
			dp=new Point[w][n];
			for(int i=1;i<=w;i++)
			{
				StringTokenizer st=new StringTokenizer(sc.nextLine());
				int row=Integer.parseInt(st.nextToken());
				while(st.hasMoreTokens())
				{
					int col=Integer.parseInt(st.nextToken());
					grid[row-1][col-1]=1;	
					dp[row-1][col-1]=new Point(0,(int)1e9);	
				}
			}
			pw.println((int)dfs(0,0).getX());
//			for(int i=0;i<w;i++)
//				System.out.println(Arrays.toString(dp[i]));
		}
		pw.close();
	}
	public static Point dfs(int i,int j)
	{
		if(i==w-1 && j==n-1)
			return dp[i][j]=new Point(1,0);
		int[] dx= {1,0};
		int[] dy= {0,1};
		int min=(int)1e9;
		int ans=0;
		for(int k=0;k<2;k++)
		{
			int x=i+dx[k],y=j+dy[k];
			if(valid(x,y))
			{
				if(dp[x][y]==null)
				{
					Point tmp=dfs(x,y);
					int dfs=tmp.y;
					if(min==dfs)
						ans+=tmp.x;
					else if(dfs<min)
					{
						ans=tmp.x;
						min=dfs;
					}
				}
				else
				{
					Point tmp=dp[x][y];
					int dfs=tmp.y;
					if(min==dfs)
						ans+=tmp.x;
					else if(dfs<min)
					{
						ans=tmp.x;
						min=dfs;
					}
				}
			}
		}
		return dp[i][j]=new Point(ans, min+1);
	}
	public static boolean valid(int i,int j)
	{
		return i<w && i>=0 && j<n && j>=0;		
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
