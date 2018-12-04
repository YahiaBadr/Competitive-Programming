package Tools;
import java.awt.Point;
import java.io.*;
import java.util.*;



public class Imperical_Roads
{
	static int n;
	static ArrayList<Edge>[] adjList,MST;
	static ArrayList<Integer>[]idxs;
	static int log2[];
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		n=sc.nextInt();int m=sc.nextInt();
		adjList=new ArrayList[n];
		MST=new ArrayList[n];
		idxs=new ArrayList[n];
		log2=new int[100001];
		HashMap<Point, Integer>hm=new HashMap<>();
		int pow=-1,mul=1;
		for(int i=0;i<100001;i++)
		{
			if(mul==i)
			{
				pow++;
				mul*=2;
			}
			log2[i]=pow;
		}
		for(int i=0;i<n;i++)
		{
			adjList[i]=new ArrayList<>();
			MST[i]=new ArrayList<>();
			idxs[i]=new ArrayList<>();
		}
		while(m-->0)
		{
			int u=sc.nextInt()-1,v=sc.nextInt()-1,c=sc.nextInt();
			adjList[u].add(new Edge(v, c,u));
			adjList[v].add(new Edge(u, c,v));
			hm.put(new Point(u,v), c);
		}
		int mst=MST();
		visited=new boolean[n];
		L=new int[n];
		BL(0);
//		for(int i=0;i<n;i++)
//			System.out.println(i+1+" "+Arrays.toString(up[i]));	
//		System.out.println();
//		for(int i=0;i<n;i++)
//		{
//			System.out.println(i+1+" "+Arrays.toString(weight[i]));
//		}
		int q=sc.nextInt();
		while(q-->0)
		{
			int u=sc.nextInt()-1,v=sc.nextInt()-1;
			int lca=LCA_BL(u,v);
//			pw.println("lca "+lca);
//			int max=Math.max(fun(u,lca),fun(v,lca));
			int ans=mst-lca;
			ans+=hm.getOrDefault(new Point(u,v),hm.get(new Point(v,u)));
			pw.println(ans);
		}
		pw.close();    
	}
	static int fun(int u,int lca)
	{
		if(u==lca)
			return 0;
		int max=0;
		int lca_l=L[lca],u_l=L[u];
		while(true)
		{	
			u_l=L[u];
			int diff=u_l-lca_l;
			int log=log2[diff];
			if(diff==0)
				return max;
			if(log2[diff]==log2[diff-1] || diff==1)
				return Math.max(max, weight[u][log]);
			max=Math.max(max, weight[u][log]);
			u=up[u][log];
		}
	}
	static boolean visited[];
	public static int MST()
	{
		int mst=0;
		visited=new boolean[n];
		Edge e=new Edge(0, 0);
		PriorityQueue<Edge>pq=new PriorityQueue<>();
		pq.add(e);
		while(!pq.isEmpty())
		{
			e=pq.poll();
			if(visited[e.node])
				continue;
			visited[e.node]=true;
			mst+=e.cost;
			if(e.node!=e.from)
			{	
				MST[e.from].add(new Edge(e.node,e.cost));
				MST[e.node].add(new Edge(e.from,e.cost));
			}
			for(Edge nxt :adjList[e.node])
				if(!visited[nxt.node])
					pq.add(nxt);
		}
		return mst;
	}
	static class Edge implements Comparable<Edge>
	{
		int node,cost,from;
		public Edge(int n,int c,int f)
		{
			node=n;cost=c;from=f;
		}
		public Edge(int n,int c)
		{
			node=n;cost=c;
		}
			
		@Override
		public int compareTo(Edge o)
		{
			return cost-o.cost;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "---"+cost+"---"+(node+1);
		}
	}
	//Euler Walk
	static int[] L,up[];
	static void dfs_BL(int v,int p,int depth,int w)
	{
		up[v][0]=p;
		weight[v][0]=w;
		L[v]=depth;
		depth++;
		for(Edge u:MST[v])
			if(u.node!=p)
				dfs_BL(u.node,v,depth,u.cost);
	}
	static int weight[][];
	static void BL(int root)	// O(n log n)
	{
		int k = 0; while(1<<k+1 < n) ++k;		// max uparent = floor(log2(n - 1))
		
		up = new int[n][k + 1];
		weight=new int [n][ k+1 ];
		for(int i = 0; i < n; i++)
			Arrays.fill(up[i], -1);
		dfs_BL(root,-1,0,0);					// T[root] = -1						
		
		for(int j = 1; j <= k; j++)			
			for(int i = 0; i < n; i++)
			{	if(up[i][j-1] != -1)
				{
					up[i][j] = up[up[i][j-1]][j-1];
					if(up[i][j]!=-1)
						weight[i][j]=Math.max(weight[i][j-1], weight[up[i][j-1]][j-1]);
				}
			}
	}
	
	 static int LCA_BL(int a, int b)		// O(log n)
	 {
		  //if a is situated on a higher level than b, swaup them
		 int w=0;
		 if (L[a] < L[b]) { a ^= b; b ^= a; a ^= b; }
		 
		 //find largest k such that 2^k is a uparent of up
		 int k = 0;
		 while(1<<k+1 <= L[a])
			 ++k;
		 
		 //find the ancestor of a situated on the same level with b
		 for (int i = k; i >= 0; --i)
		 {
//			 System.out.println(up[a][i]+" "+L[up[a][i]]);
			 if (L[a] - (1<<i) >= L[b])
			 {
				 w = Math.max(weight[a][i],w);
				 a = up[a][i];
			 }
//			 System.out.println(L[a]+" "+a+" b: "+L[b]+" "+b +" "+(1<<i));
		 }
		 if (a == b)
		 {	
//			 return a;
			 return w;
		 }
		 
		 //go up to lowest (non-common) ancestors for a and b
//		 System.out.println(a+" "+b);
		 for (int i = k; i >= 0; --i)
			 if (up[a][i] != -1 && up[a][i] != up[b][i])
			 {
				 w=Math.max(w, Math.max(weight[a][i], weight[b][i]));
				 a = up[a][i]; b = up[b][i];
//				 System.out.println(a+" "+b);
			 }
		 w=Math.max(w, Math.max(weight[a][0], weight[b][0]));
//		 System.out.println(w);
//		 return up[a][0];
		 return w;
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
		boolean hasnext() throws IOException{
			return br.ready();
		}
		
	}
}
//11 10
//1 2 10
//2 3 15
//3 5 8
//3 6 7
//2 4 20
//4 10 100
//4 7 5
//7 8 4 
//7 9 2
//11 10 1
//0


