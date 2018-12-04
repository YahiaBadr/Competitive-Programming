package UVA;

import java.io.*;
import java.util.*;


public class Problem_558 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int c=sc.nextInt();
		while(c-->0)
		{
			n=sc.nextInt();m=sc.nextInt();
			adjList=new ArrayList[n];
			for(int i=0;i<n;i++)
				adjList[i]=new ArrayList<>();
			while(m-->0)
			{
				adjList[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
			}
			if(bellmanFord(0))
				pw.println("possible");
			else
				pw.println("not possible");
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
		for(int i=0;i<n-1;i++)
		{
			for(int u=0;u<n;u++)
				for(Edge nxt:adjList[u])
				{
					if(dist[u]+nxt.cost<dist[nxt.node])
						dist[nxt.node]=dist[u]+nxt.cost;
				}
		}
		boolean negCycle=false;
		for(int u=0;u<n;u++)
			for(Edge nxt:adjList[u])
			{
				if(dist[u]+nxt.cost<dist[nxt.node])
				{
					dist[nxt.node]=dist[u]+nxt.cost;
					negCycle=true;
				}
			}
		return negCycle;
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
