package Tools;

import java.util.*;
public class Graph
{
	ArrayList<Integer> adjList[];
	ArrayList<Edge>[]wightedgraph;
	int[][]adjMatrix;
	char[][]grid;
	boolean[]visited;
	int n,idx;
	@SuppressWarnings("unchecked")
	public Graph(int size)
	{
		this.n=size;
		wightedgraph=new ArrayList[n];
		adjList=new ArrayList[n];
		adjMatrix=new int[n][n];
		grid=new char[n][n];
		visited=new boolean[n];		
		for(int i=0;i<n;i++)
			adjList[i]=new ArrayList<>();
	}
	public void add(int v,int u)
	{
		adjList[v].add(u);
	}
	static Stack<Integer>topo;
	public void topo()
	{
		topo=new Stack<>();
		for(int i=0;i<n;i++)
			if(!visited[i])
				topo_dfs(i);
	}
	public void topo_dfs(int u)
	{
		visited[u]=true;
		for(int v:adjList[u])
			if(!visited[v])
				topo_dfs(v);
		topo.push(u);
	}
	public void bfs(int start)
	{
		Queue<Integer>q=new LinkedList<>();
		q.add(start);
		visited[start]=true;
		while(!q.isEmpty())
		{
			int n=q.remove();
			for(int v:adjList[n])
				if(!visited[v])
				{	
					q.add(v);
					visited[v]=true;
				}
		}
	}
	public void dfs(int n)
	{
		visited[n]=true;
		for(int v:adjList[n])
			if(!visited[v])
				dfs(v);
	}
	
	//Float_Fill
	public void dfs2(int i,int j)
	{ 
		int[] dx= {-1,1,0,0};
		int[] dy= {0,0,-1,1};
		grid[i][j]='X';// Visited
		for(int k=0;k<4;k++)
		{
			int x=i+dx[k],y=j+dy[k];
			if(valid(x,y)&&grid[x][y]!='X')
				dfs2(x,y);
		}
			
	}
	public boolean valid(int i,int j)
	{
		return i<n && i>=0 && j<n && j>=0;		
	}
	
	public void print() {
		
		for(int i=1;i<n;i++)
			System.out.println(adjList[i]);
	}
	public static void printRow(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");//adding space of 6 char
        }
        System.out.println();
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
	public static void main(String[] args)
	{
		Graph g= new Graph(9);
		g.add(1,2); 
		g.add(1,3); 
		g.add(2,4); 
		g.add(2,5); 
		g.add(2,6); 
		g.add(3,7); 
		g.add(3,8);
//		for(int i=0;i<9;i++)
//			System.out.println(g.adjList[i]);
	}
}
