package Tools;

import java.util.*;

public class Graphs_SSSP
{
	
	static int n,grid[][];
	static ArrayList<Edge>[] adjList;
	static int adjMatrix[][];
	public static void floyd()
	{
		for(int k=0;k<n;k++)
			for(int u=0;u<n;u++)
				for(int v=0;v<n;v++)
					adjMatrix[u][v]=Math.min(adjMatrix[u][v], adjMatrix[u][k]+adjMatrix[k][v]);
	}
	public static boolean bellmanFord(int s)
	{
		int dist[]=new int[n];
		Arrays.fill(dist, (int)1e9);
		dist[s]=0;
		for(int i=0;i<n-1;i++)
			for(int u=0;u<n;u++)// these two loops run in O(E) in total
				for(Edge nxt:adjList[u])
						dist[nxt.node]=Math.min(dist[nxt.node],dist[u]+nxt.cost);
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
	
	public static boolean valid(int i,int j)
	{
		return i<n && i>=0 && j<n && j>=0;		
	}
	public static int dijkstra_grid(int i,int j,int end_i,int end_j)
	{
		Queue<Integer>qi=new LinkedList<>(),qj=new LinkedList<>();
		qi.add(i);qj.add(j);
		grid[i][j]='X';
		int[] dx= {-1,1,0,0};
		int[] dy= {0,0,-1,1};
		int dist[][]=new int[n][n];
		for(int []a:dist)
			Arrays.fill(a, (int)1e9);
		dist[i][j]=0;
		while(!qi.isEmpty())
		{
			int ci=qi.poll(),cj=qj.poll();
			for(int k=0;k<4;k++)
			{
				int x=ci+dx[k],y=cj+dy[k];
				if(valid(x,y)&& grid[x][y]!='X' && dist[ci][cj]+1<dist[x][y])//we are not checking about visited we check if it is block
				{
					qi.add(x);
					qj.add(y);
//					grid[x][y]='X';
					dist[x][y]=dist[ci][cj]+1;
				}
			}
		}
		return dist[end_i][end_j];
	}
	public int dijKstra(int S,int End)//O(E log E)
	{
		int dist[]=new int[n];
		Arrays.fill(dist, (int)1e9);
		Edge cur=new Edge(S, 0);
		dist[cur.node]=0;
		PriorityQueue<Edge>pq=new PriorityQueue<>();
		pq.add(cur);
		while(!pq.isEmpty())
		{
			cur=pq.remove();
			if(cur.node==End)
				return dist[End];
			if(cur.cost>dist[cur.node]) // it means that i visited this node before with less cost
				continue;
			for(Edge nxt:adjList[cur.node])
			{
				if(cur.cost+nxt.cost<dist[nxt.node])
				{
					pq.add(new Edge(nxt.node, cur.cost+nxt.cost));
					dist[nxt.node]=cur.cost+nxt.cost;
				}
			}
		}
		return -1;	
	}
	static int[]parent;
	static void print(int i)
	{
		if(i==-1)
			return;
		print(parent[i]);
//		pw.print(i+1+" ");
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
}
