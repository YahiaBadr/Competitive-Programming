package UVA;

import java.io.*;
import java.util.*;



public class Problem_11631 {
	static ArrayList<Edge>[]adjList;
	static int n,m;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(true)
		{
			n=sc.nextInt();m=sc.nextInt();
			if(n==0 && m==0)
				break;
			adjList=new ArrayList[n];
			for(int i=0;i<n;i++)
				adjList[i]=new ArrayList<>();
			int total=0;
			while(m-->0)
			{
				int u=sc.nextInt(),v=sc.nextInt(),c=sc.nextInt();
				adjList[u].add(new Edge(v, c));
				adjList[v].add(new Edge(u, c));
				total+=c;
			}
			pw.println(total-bfs(0));
		}
		pw.close();
	}
	public static int bfs(int u)
	{
		boolean visited[]=new boolean[n];
		PriorityQueue<Edge>pq=new PriorityQueue<>();
		Edge cur=new Edge(u, 0);
		pq.add(cur);
		int ans=0;
		while(!pq.isEmpty())
		{
			cur=pq.poll();
			if(!visited[cur.node])
			{	ans+=cur.cost;
				visited[cur.node]=true;
				for(Edge e:adjList[cur.node])
				{
					if(!visited[e.node])
					{
						pq.add(e);
					}
				}
			}
		}
		return ans;
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
