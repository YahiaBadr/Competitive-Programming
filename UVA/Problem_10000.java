package UVA;

import java.awt.Point;
import java.io.*;
import java.util.*;


public class Problem_10000 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=1;
		while(true)
		{
			n=sc.nextInt();
			if(n==0)break;
			adjList=new ArrayList[n];
			for(int i=0;i<n;i++)
				adjList[i]=new ArrayList<>();
			s=sc.nextInt()-1;
			while(true)
			{
				int u=sc.nextInt()-1,v=sc.nextInt()-1;
				if(u==-1 && v==-1)break;
				adjList[u].add(v);
//				adjList[v].add(u);
			}
			f=new boolean[n];
			dp=new Point[n];
			Point ans=dfs(s);
			pw.println("Case "+(t++)+": The longest path from "+(s+1)+" has length "+(ans.x)+", finishing at "+ans.y+".");
			pw.println();
		}
		pw.close();
	}
	static int n,s;
	static ArrayList<Integer>[] adjList;
	static boolean f[];
	static Point dp[];
	static Point dfs(int s)
	{
		f[s]=true;
		int max=0,min=1000000000;
		boolean leaf=true;
		for(int v:adjList[s])
		{	
			leaf=false;
			if(!f[v])
			{
				f[v]=true;
				Point tmp=dfs(v);
				if(tmp.x+1>max)
				{
					max=tmp.x+1;
					min=tmp.y;
				}
				else if(tmp.x+1==max)
					min=Math.min(min, tmp.y);
			}
			else
			{
				Point tmp=dp[v];
				if(tmp.x+1>max)
				{
					max=tmp.x+1;
					min=tmp.y;
				}
				else if(tmp.x+1==max)
					min=Math.min(min, tmp.y);
			}
		}
		if(leaf) {
			min=s+1;
			max=0;
		}
		return dp[s]=new Point(max, min);
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
