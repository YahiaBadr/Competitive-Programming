package UVA;

import java.io.*;
import java.util.*;

public class Problem_610 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=1;
		while(true)
		{
			n=sc.nextInt();m=sc.nextInt();
			if(n==0 && n==m)
				break;
			System.out.println(t++);
			System.out.println();
			adjList=new ArrayList[n];
			for(int i=0;i<n;i++)
				adjList[i]=new ArrayList<>();
			while(m-->0)
			{
				int u=sc.nextInt()-1,v= sc.nextInt()-1;
				adjList[u].add(v);
				adjList[v].add(u);				
			}
			for(int i = 0; i < n; i++)
				Collections.sort(adjList[i]);
			edges=new int[n][n];
			find_AP();
			for(int i = 0; i < edges.length; i++)
				for(int j = 0; j < edges.length; j++)
					if(edges[i][j]==1)
						System.out.println((i+1)+" "+(j+1));
			System.out.println("#");
		}
		pw.close();
	}
	static ArrayList<Integer>[]adjList;
	static int[]num,low,parent;
	static boolean[] AP,visited;
	static int count,root,child,ap,n,m,edges[][];
	public static void find_AP()
	{
		num=new int[n];
		low=new int[n];
		parent=new int[n];
		AP=new boolean[n];
		visited=new boolean[n];
		count=0;
		ap=0;
		root=0;
		child=0;
		AP_dfs(0);
	}
	public static void AP_dfs(int u)//Articalation Point and Bridge
	{
		visited[u]=true;
		num[u]=low[u]= ++count;
		for(int i=0;i<adjList[u].size();i++)
		{
			int n=adjList[u].get(i);
			if(!visited[n])
			{
				parent[n]=u;
				edges[u][n] = 1;
				
				AP_dfs(n);
				if(low[n]>num[u])
					edges[n][u] = 1;
				low[u]=Math.min(low[n],low[u]);
					
			}
			else
			{
				if(parent[u]!=n)
				{
					low[u]=Math.min(low[u], num[n]);
					edges[u][n] = 1;
					if(adjList[n].contains(u))
						adjList[n].remove(adjList[n].indexOf(u));
				}
			}
			
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
