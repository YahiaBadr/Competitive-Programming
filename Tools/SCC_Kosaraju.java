package Tools;

import java.util.ArrayList;
import java.util.Stack;


public class SCC_Kosaraju
{	
	static ArrayList<Integer>[]adjList,adjListR,graph;
	static Stack<Integer>stack;
	static int n,scc,findSCC[];
	static boolean[]visited;
	public static void scc()
	{
		visited=new boolean[n];
		stack=new Stack<>();
		for(int u=0;u<n;u++)
			if(!visited[u])
				dfs(u);
		visited=new boolean[n];
		while(!stack.isEmpty())
		{
			int u=stack.pop();
			if(!visited[u])
			{
				dfs_r(u);
				scc++;
			}
		}
	}
	public static void dfs(int u)
	{
		visited[u]=true;
		for(int v:adjList[u])
			if(!visited[v])
				dfs(v);
		stack.push(u);
	}
	public static void dfs_r(int u)
	{
		visited[u]=true;
		findSCC[u]=scc;
		for(int v:adjListR[u])
			if(!visited[v])
				dfs_r(v);
	}
}
