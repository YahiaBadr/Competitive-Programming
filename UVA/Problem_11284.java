package UVA;

import java.io.*;
import java.util.*;

public class Problem_11284 {
	static double dp(int u)
	{
		if(u==0 && vis[0]==1)
			return dp[u][vis[u]]=0;
//		if(dp[u][vis[u]]!=0)
//			return dp[u][vis[u]];
		double max=-inf;
		for(int v=0;v<=n;v++)
		{
			if(f[u][v] && vis[v]<2)
			{
				vis[v]++;
				if(fp[v])
				{
					fp[v]=false;
					max=Math.max(max,dp(v)-a[u][v]+p[v]);
					fp[v]=true;
				}
				else
					max=Math.max(max,dp(v)-a[u][v]);
				vis[v]--;
			}
		}
		return dp[u][vis[u]]=max;
	}
	static double inf=(int)1e9;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();
		while(t-->0)
		{
			n=sc.nextInt();m=sc.nextInt();
			a=new double[n+1][n+1];
			f=new boolean[n+1][n+1];
			p=new double[n+1];
			fp=new boolean[n+1];
			vis=new int[n+1];
			dp=new double[n+1][3];
			dpf=new boolean[n+1][3];
			double dist[][]=new double[n+1][n+1]; 
			for(int i=0;i<=n;i++)
				Arrays.fill(dp[i], 0);
			while(m-->0)
			{
				int u=sc.nextInt(),v=sc.nextInt();
				double c=sc.nextDouble();
				a[u][v]=a[v][u]=c;
				f[u][v]=f[v][u]=true;
			}
			for(int i=0;i<=n;i++)
				for(int j=i+1;j<=n;j++)
					dist[i][j]=dist[j][i]=dijKstra(i,j);
			cd=sc.nextInt();
			int q=cd;
			while(q-->0)
			{
				int x=sc.nextInt();
				p[x]=sc.nextDouble();
				fp[x]=true;
			}
			double ans=dp(0);
			if(ans>0)
				pw.printf("Daniel can save $%.2f\n",ans);
			else
				pw.println("Don't leave the house");
		}
		pw.close();
	}
	public static double dijKstra(int S,int End)
	{
		double dist[]=new double[n];
		Arrays.fill(dist, (int)1e9);
		Edge cur=new Edge(S, 0);
		dist[cur.node]=0;
		PriorityQueue<Edge>pq=new PriorityQueue<>();
		pq.add(cur);
		while(!pq.isEmpty())
		{
			cur=pq.remove();
			if(cur.cost>dist[cur.node]) // it means that i visited this node before with less cost
				continue;
//			for(Edge nxt:adjList[cur.node])
			for(int v=0;v<=n;v++)
			{
				if(f[cur.node][v])
				{	
					if(cur.cost+a[cur.node][v]<dist[v])
					{
						pq.add(new Edge(v, cur.cost+a[cur.node][v]));
						dist[v]=cur.cost+a[cur.node][v];
					}
				}
			}
		}
		return dist[End];
	}
	static class Edge implements Comparable<Edge>
	{
		int node;double cost;
		public Edge(int n,double c)
		{
			node=n;cost=c;
		}
		@Override
		public int compareTo(Edge o)
		{
			if(cost>o.cost)
				return 1;
			if(cost==o.cost)
				return 0;
			return -1;
		}
		
	}
	static int n,m,cd,vis[];
	static double a[][],p[],dp[][];
	static boolean f[][],fp[],dpf[][];
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
