package UVA;

import java.io.*;
import java.util.*;



public class Problem_12442 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt(),c=1;
		while(t-->0)
		{
			int size=sc.nextInt();
			Graph graph=new Graph(size+1);
			int s=size;
			while(s-->0)
				graph.add(sc.nextInt(),sc.nextInt());
			int max=0,ans=1;
			for(int i=1;i<=size;i++)
			{
				int tmp=-1;
				if(graph.connect[i]==-1)tmp=graph.dfs(i);
				if(tmp>max)
				{
					max=tmp;
					ans=i;
				}
			}
			pw.println("Case "+c+++": "+ans);
//			System.out.println(Arrays.toString(graph.connect));
		}
		pw.close();
	}
	static class Graph
	{
		int[]adjList;
		boolean[]visited;
		int[]connect;
		int size;
		public Graph(int size)
		{
			this.size=size;
			adjList=new int[size];
			visited=new boolean[size];
			connect=new int[size];
			Arrays.fill(connect, -1);
			Arrays.fill(adjList, -1);
		}
		public void add(int v,int u)
		{
			adjList[v]=u;
		}
		public int dfs(int n)
		{
			int res=0;
			visited[n]=true;
			if(adjList[n]!=-1 && !visited[adjList[n]])
			{
				res+=dfs(adjList[n])+1;
			}
			visited[n]=false;
			return connect[n]=res;
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
