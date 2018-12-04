package UVA;

import java.io.*;
import java.util.*;


public class Problem_280 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(true)
		{
			int size=sc.nextInt();
			if(size==0)
				break;
			Graph graph=new Graph(size+1);
			while(true)
			{
				int v=sc.nextInt();
				if(v==0)break;
				while(true)
				{
					int u=sc.nextInt();
					if(u==0)break;
					graph.add(v, u);
				}
			}
			int queries=sc.nextInt();
			while(queries-->0)
			{
				int x=sc.nextInt();
				graph.bfs(x);
				int count=0;
				StringBuilder sb=new StringBuilder();
				for(int i=1;i<graph.visited.length;i++)
					if(!graph.visited[i])
					{
						count++;
						sb.append(" "+i);
					}
				pw.println(count+sb.toString());
				
			}
		}
		pw.close();
	}
	static class Graph
	{
		ArrayList<Integer>[]adjList;
		boolean[]visited;
		int size;
		@SuppressWarnings("unchecked")
		public Graph(int size)
		{
			this.size=size;
			adjList=new ArrayList[size];
			visited=new boolean[size];
			for(int i=0;i<size;i++)
				adjList[i]=new ArrayList<>();
		}
		public void add(int v,int u)
		{
			adjList[v].add(u);
		}
		public void bfs(int start)
		{
			visited=new boolean[size];
			Queue<Integer>q=new LinkedList<>();
			q.add(start);
//			visited[start]=true;
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
				if(!visited[n])
					dfs(v);
		}
		public void print() {
			
			for(int i=1;i<size;i++)
				System.out.println(adjList[i]);
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
