package UVA;

import java.io.*;
import java.util.*;


public class Problem_11721 {
	static int t;
	static PrintWriter pw = new PrintWriter(System.out);
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		int c=sc.nextInt();
		t=1;
		while(c-->0)
		{
			n=sc.nextInt();m=sc.nextInt();
			adjList=new ArrayList[n];
			for(int i=0;i<n;i++)
				adjList[i]=new ArrayList<>();
			while(m-->0)
			{
				int u=sc.nextInt(),v=sc.nextInt(),cost=sc.nextInt();
				adjList[v].add(new Edge(u, cost));//work on rev
			}
			if(!bellmanFord(0))
				pw.println("Case "+(t++)+": impossible");
		}
		pw.close();
	}
	static int n,m;
	static ArrayList<Edge>[] adjList;
	public static boolean bellmanFord(int s)
	{
		int dist[]=new int[n];
		Arrays.fill(dist, (int)1e9);
		dist[s]=0;
		ts=new TreeSet<>();
		hs=new HashSet<>();
		for(int i=0;i<n-1;i++)
		{
			for(int u=0;u<n;u++)
				for(Edge nxt:adjList[u])
				{
					if(dist[u]+nxt.cost<dist[nxt.node])
					{
						dist[nxt.node]=dist[u]+nxt.cost;
					}
				}
		}
		vis=new boolean[n];
		boolean negCycle=false;
		for(int u=0;u<n;u++)
			for(Edge nxt:adjList[u])
			{
				if(dist[u]+nxt.cost<dist[nxt.node])
				{
					dist[nxt.node]=dist[u]+nxt.cost;
					negCycle=true;
					if(!vis[u] && !hs.contains(u))
						dfs(u);
				}
			}
		if(negCycle)
		{
			StringBuilder sb=new StringBuilder("Case "+(t++)+":");
			for(int k:ts)
				sb.append(" "+k);
			pw.println(sb.toString());
		}
		return negCycle;
	}
	static boolean vis[];
	static TreeSet<Integer>ts;
	static HashSet<Integer>hs;
	public static void dfs(int s)
	{
		vis[s]=true;
		hs.add(s);
		ts.add(s);
		for(Edge nxt:adjList[s])
		{
			if(!vis[nxt.node])
				dfs(nxt.node);
		}
	}
	static class Edge implements Comparable<Edge>
	{
		int node,cost;
		public Edge(int n,int c)
		{
			node=n;cost=c;
		}
		@Override
		public int compareTo(Edge o)
		{
			return cost-o.cost;
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
//1
//6 11
//2 1 -6
//0 4 -24
//4 1 -12
//4 2 13
//0 3 -4
//3 5 -16
//1 5 22
//0 1 -10
//4 3 4
//1 0 -12
//1 4 -7
