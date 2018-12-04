package Tools;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST_Prim
{
	ArrayList<Edge>[]adjList;
	public MST_Prim(ArrayList<Edge>[]adjList)
	{
		this.adjList=adjList;
	}
	public int MST()
	{
		int mst=0;
		boolean[]visited=new boolean[adjList.length];
		Edge e=new Edge(0, 0);
		PriorityQueue<Edge>pq=new PriorityQueue<>();
		pq.add(e);
//		visited[0]=true;
		while(!pq.isEmpty())
		{
			e=pq.poll();
			if(visited[e.node])
				continue;
			visited[e.node]=true;
			mst+=e.cost;
			for(Edge nxt :adjList[e.node])
				if(!visited[nxt.node])
					pq.add(nxt);
		}
		return mst;
	}
	static class Edge implements Comparable<Edge>
	{
		int node,cost;
		public Edge(int n,int c)
		{
			node=n;cost=c;		}
			
		@Override
		public int compareTo(Edge o)
		{
			return cost-o.cost;
		}
		
	}
}
