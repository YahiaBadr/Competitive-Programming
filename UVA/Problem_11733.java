package UVA;

import java.io.*;
import java.util.*;

public class Problem_11733 {
	static int n,m,a,count;
	static ArrayList<Edge>[]adjList;
	static boolean visited[];
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();int ca=1;
		while(t-->0)
		{
			n=sc.nextInt();m=sc.nextInt();a=sc.nextInt();
			adjList=new ArrayList[n];
			visited=new boolean[n];
			for(int i=0;i<n;i++)
				adjList[i]=new ArrayList<>();
			while(m-->0)
			{
				int u=sc.nextInt()-1,v=sc.nextInt()-1,c=sc.nextInt();
				adjList[u].add(new Edge(v, c));
				adjList[v].add(new Edge(u, c));
			}
			long ans=0;count=0;
			for(int i=0;i<n;i++)
			{
				if(!visited[i])
				{
					ans+=bfs(i)+a;
					count++;
				}
			}
			pw.println("Case #"+ca+": "+ans+" "+count);
			ca++;
		}
		pw.close();
	}
	public static long bfs(int u)
	{
		PriorityQueue<Edge>pq=new PriorityQueue<>();
		pq.add(new Edge(u, 0));
		long ans=0;
		while(!pq.isEmpty())
		{
			Edge cur=pq.poll();
			if(!visited[cur.node])
			{
				visited[cur.node]=true;
				if(cur.cost<a)
					ans+=cur.cost;
				else
				{
					ans+=a;
					count++;
				}
				for(Edge e:adjList[cur.node])
					if(!visited[e.node])
						pq.add(e);
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
