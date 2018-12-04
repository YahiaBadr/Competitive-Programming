package UVA;

import java.io.*;
import java.util.*;

public class Problem_820 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int count=1;
		while(true)
		{
			n=sc.nextInt();
			if(n==0)break;
			s=sc.nextInt()-1;t=sc.nextInt()-1;int c=sc.nextInt();
			adjList=new ArrayList[n];
			for(int i=0;i<n;i++)
				adjList[i]=new ArrayList<>();
			res=new int[n][n];
			while(c-->0)
			{
				int u=sc.nextInt()-1,v=sc.nextInt()-1,w=sc.nextInt();
				add(u,v,w);
			}
			pw.println("Network "+(count++));
			pw.println("The bandwidth is "+edmondKarp()+".");
			pw.println();
		}
		pw.close();
	}
	static int n,s,t,INF=(int)1e9;
	static int res[][],p[];
	static ArrayList<Integer>adjList[];
	public static void add(int u,int v,int c)
	{
		adjList[u].add(v);
		adjList[v].add(u);
		res[u][v]+=c;
		res[v][u]+=c;//backward edge
	}
	static int Vin(int id)
	{
		return id*2;
	}
	static int Vout(int id)
	{
		return id*2+1;
	}
	public static int edmondKarp()
	{
		int maxf=0;
		while(true)
		{
			Queue<Integer>q=new LinkedList<>();
			p=new int[n];
			Arrays.fill(p, -1);
			p[s]=s;
			q.add(s);
			while(!q.isEmpty())
			{
				int u=q.poll();
				if(u==t)
					break;
				for(int v:adjList[u])
				{
					if(res[u][v]>0 && p[v]==-1)
					{
						p[v]=u;
						q.add(v);
					}
				}
			}
			if(p[t]==-1)
				break;
			maxf+=aug(t,INF);
		}
		return maxf;
	}
	public static int aug(int v,int flow)
	{
		if(v==s)
			return flow;
		flow= aug(p[v],Math.min(res[p[v]][v],flow));
		res[p[v]][v]-=flow;
		res[v][p[v]]+=flow;
		return flow;
	}
	public static int aug(int v,int flow,String s1)
	{
		if(v==s)
		{
			System.out.println(s1);
			return flow;
		}
		flow= aug(p[v],Math.min(res[p[v]][v],flow),p[v]+"-->"+s1);
		res[p[v]][v]-=flow;
		res[v][p[v]]+=flow;
		return flow;
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
