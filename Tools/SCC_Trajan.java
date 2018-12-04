package Tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SCC_Trajan
{
	static ArrayList<Integer>[]adjList;
	static int[] num,low;
	static boolean[] onstack,visited;
	static Stack<Integer>stack;
	static int scc,id,n;
	public static void scc()
	{
		num=new int[n];
		low=new int[n];
		onstack=new boolean[n];
		visited=new boolean[n];
		scc=0;id=0;
		for(int i=0;i<n;i++)
			if(!visited[i])
			{
				stack=new Stack<>();
				dfs(i);
			}
	}
	public static void dfs(int u)
	{
		num[u]=low[u]=++id;
		visited[u]=true;
		stack.push(u);
		onstack[u]=true;
		for(int v:adjList[u])
		{
			if(!visited[v])
			{
				dfs(v);
				low[u]=Math.min(low[u], low[v]);
			}
			else if(onstack[v])
				low[u]=Math.min(low[u], low[v]);
		}
		if(low[u]==num[u])
		{
			scc++;
			while(true)
			{
				int v=stack.pop();
				System.out.print(v+" ");
				onstack[v]=false;
				if(v==u)
					break;
			}
			System.out.println();
		}
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		n=8;
		adjList=new ArrayList[n];
		for(int i=0;i<n;i++)
			adjList[i]=new ArrayList<>();
		adjList[0].add(1);
		adjList[1].add(2);
		adjList[2].add(0);
		adjList[5].add(0);
		adjList[6].add(0);
		adjList[5].add(6);
		adjList[6].add(4);
		adjList[6].add(2);
		adjList[4].add(5);
		adjList[3].add(4);
		adjList[3].add(7);
		adjList[7].add(3);
		adjList[7].add(5);
////		------------------
//		adjList[1].add(0);
//		adjList[0].add(2);
//		adjList[2].add(1);
//		adjList[0].add(2);
//		adjList[3].add(4);
		
		scc();
		System.out.println("SCC_Groups= "+scc);
		System.out.println(Arrays.toString(low));
//		System.out.println(Arrays.toString(num));
	}
}
