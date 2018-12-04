package UVA;

import java.io.*;
import java.util.*;



public class Problem_10816 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
//		while(sc.hasnext())
		while(true)
		{
			int n=sc.nextInt(),m=sc.nextInt();
			if(n==0)
				break;
			int start=sc.nextInt()-1,end=sc.nextInt()-1;
			Graph g= new Graph(n);
			while(m-->0)
			{
				g.add(sc.nextInt()-1, sc.nextInt()-1, sc.nextDouble(), sc.nextDouble());
			}
			double low=0,high=50,dis_ans=0,temp_ans=0;String path="";
			for(int i=0;i<100;i++)
			{
				double mid=(high+low)/2;
				String[] value=g.dijKstra(start, end,mid);
				if(value[0].equals("-1"))
					low=mid+1;
				else
				{
					temp_ans=mid;
					dis_ans=Double.parseDouble(value[0]);
					path=value[1];
					high=mid-1;
				}
			}
			pw.println(path);
			pw.println(round(dis_ans)+" "+round(temp_ans));
			
		}
		pw.close();
	}
	private static double round (double value) {
	    return (double) Math.round(value * 10) / 10;
	}
	static class Graph
	{
		ArrayList<Edge>[]wightedgraph;
		boolean[]visited;
		int size;
		@SuppressWarnings("unchecked")
		public Graph(int size)
		{
			this.size=size;
			wightedgraph=new ArrayList[size];
			visited=new boolean[size];
			for(int i=0;i<size;i++)
				wightedgraph[i]=new ArrayList<>();
		}
		public void add(int v,int u,double t,double d)
		{
			wightedgraph[v].add(new Edge(u, t,d,(u+1)+""));
			wightedgraph[u].add(new Edge(v, t,d,(v+1)+""));
		}
		public String[] dijKstra(int S,int End,double maxt)
		{
			double dist[]=new double[size];
			Arrays.fill(dist, (int)1e9);
			Edge cur=new Edge(S, 0,0,(S+1)+"");
			dist[cur.node]=0;
			PriorityQueue<Edge>pq=new PriorityQueue<>();
			pq.add(cur);
			while(!pq.isEmpty())
			{
				cur=pq.remove();
				if(cur.node==End && cur.tem<=maxt)
					return new String[] {""+dist[End],cur.path};
				if(cur.dis>dist[cur.node] || cur.tem>maxt) // it means that i visited this node before with less cost
					continue;
				for(Edge nxt:wightedgraph[cur.node])
				{
					if(cur.dis+nxt.dis<dist[nxt.node] && cur.tem<maxt && nxt.tem<maxt)
					{
						pq.add(new Edge(nxt.node,Math.max(cur.tem, nxt.tem) ,cur.dis+nxt.dis,cur.path+" "+nxt.path));
						dist[nxt.node]=cur.dis+nxt.dis;
					}
				}
			}
			return new String[] {"-1",""};	
		}
		static class Edge implements Comparable<Edge>
		{
			int node;double dis,tem;String path;
			public Edge(int n,double t,double d,String p)
			{
				node=n;dis=d;tem=t;path=p;
			}
			@Override
			public int compareTo(Edge o)
			{
				if(dis>o.dis)
					return 1;
				if(dis==o.dis)
				{
					if(tem==o.tem)
						return 0;
					if(tem>o.tem)
						return 1;
					return -1;
				}
				return -1;
			}
			@Override
			public String toString() {
				return ""+node;
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
