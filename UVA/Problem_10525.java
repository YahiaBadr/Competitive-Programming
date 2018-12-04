package UVA;

import java.io.*;
import java.util.*;


public class Problem_10525 {
	static ArrayList<Edge>[]adjList;
	static int x,y;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int c=sc.nextInt();
		while(c-->0)
		{
			x=sc.nextInt();y=sc.nextInt();
			Edge dist[][]=new Edge[x][x];
			for(int i=0;i<x;i++)
				for(int j=0;j<x;j++)
				{
					dist[i][j]=new Edge((int)1e9, (int) 1e9);
					dist[i][i]=new Edge(0, 0);
				}
			while(y-->0)
			{
				int u=sc.nextInt(),v=sc.nextInt(),t=sc.nextInt(),l=sc.nextInt();
				dist[u-1][v-1]=dist[v-1][u-1]=min(dist[u-1][v-1],new Edge(t, l));
//				dist[u-1][u-1]=dist[v-1][v-1]=new Edge(0, 0);
			}
			for(int k=0;k<x;k++)
				for(int u=0;u<x;u++)
					for(int v=0;v<x;v++)
					{
						Edge ukv=new Edge(dist[u][k].t+dist[k][v].t, dist[u][k].l+dist[k][v].l);
						dist[u][v]=min(dist[u][v],ukv);
					}
			int q=sc.nextInt();
			while(q-->0)
			{
				int u=sc.nextInt(),v=sc.nextInt();
				pw.println(dist[u-1][v-1]);
			}
			if(c>0)
				pw.println();
		}
		pw.close();
	}
	static Edge min(Edge e,Edge a)
	{
		if(e.t==a.t)
			return e.l<a.l?new Edge(e.t, e.l):new Edge(a.t, a.l);
		return e.t<a.t?new Edge(e.t, e.l):new Edge(a.t, a.l);		
	}
	static class Edge implements Comparable<Edge>
	{
		int t,l;
		public Edge(int t,int l)
		{
			this.t=t;this.l=l;
		}
		@Override
		public int compareTo(Edge o)
		{
			if(t==o.t)
				return l-o.l;
			return t-o.t;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			if(l<(int)1e9 && t<(int)1e9)
				return "Distance and time to reach destination is "+l+" & "+t+".";
			else
				return "No Path.";
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
