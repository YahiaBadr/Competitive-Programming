package UVA;

import java.io.*;
import java.util.*;



public class Problem_1112 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt(),exit_cell=sc.nextInt()-1,max_time=sc.nextInt();
			int m=sc.nextInt();
			Graph g=new Graph(n);
			while(m-->0)
			{
				int v=sc.nextInt()-1,u=sc.nextInt()-1,w=sc.nextInt();
				g.add(v, u, w);
			}
			int ans=0;
			for(int i=0;i<n;i++)
				ans+=g.dijKstra(i, exit_cell, max_time);
			pw.println(ans);
			if(t!=0)
				pw.println();
		}
		pw.close();
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
	static class Graph
	{
		ArrayList<Edge>[]wightedgraph;
		boolean[]visited;
		int size;
		@SuppressWarnings("unchecked")
		public Graph(int size)
		{
			this.size=size;
			wightedgraph=new ArrayList[size];
			visited=new boolean[size];
			for(int i=0;i<size;i++)
				wightedgraph[i]=new ArrayList<>();
		}
		public void add(int v,int u,int c)
		{
			wightedgraph[v].add(new Edge(u, c));
		}
		public int dijKstra(int S,int End,int max)
		{
			int dist[]=new int[size];
			Arrays.fill(dist, (int)1e9);
			Edge cur=new Edge(S, 0);
			dist[cur.node]=0;
			PriorityQueue<Edge>pq=new PriorityQueue<>();
			pq.add(cur);
			while(!pq.isEmpty())
			{
				cur=pq.remove();
				if(cur.node==End && cur.cost<=max)
					return 1;
				if(cur.cost>dist[cur.node] || cur.cost>max) // it means that i visited this node before with less cost
					continue;
				for(Edge nxt:wightedgraph[cur.node])
				{
					if(cur.cost+nxt.cost<dist[nxt.node])
					{
						pq.add(new Edge(nxt.node, cur.cost+nxt.cost));
						dist[nxt.node]=cur.cost+nxt.cost;
					}
				}
			}
			return 0;	
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
