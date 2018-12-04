package UVA;

import java.io.*;
import java.util.*;

public class Problem_11506 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(true)
		{
			n=sc.nextInt();w=sc.nextInt();
			if(n==0 && w==0)break;
			s=1;t=Vin(n);
			adjList=new ArrayList[2*n+2];
			res=new int[2*n+2][2*n+2];
			for(int i=0;i<2*n+2;i++)
				adjList[i]=new ArrayList<>();
			for(int i=2;i<=n-1;i++)
			{
				int x=sc.nextInt(),c=sc.nextInt();
				add(Vin(x),Vout(x),c);
			}
			for(int i=0;i<w;i++)
			{
				int u=sc.nextInt(),v=sc.nextInt(),c=sc.nextInt();
				if((u==1 || v==1)&&(v==n || u==n))
				{
					adjList[1].add(Vin(n));
					res[1][Vin(n)]+=c;
				}
				else if(u==1 || v==1)
				{
					v=Math.max(u, v);
					u=1;
					adjList[1].add(Vin(v));
					res[1][Vin(v)]+=c;
				}
				else if(v==n || u==n)
				{
					u=Math.min(u, v);
					v=n;
					adjList[Vout(u)].add(Vin(n));
					res[Vout(u)][Vin(n)]+=c;
				}
				else
				{
					add(Vout(u),Vin(v),c);
					add(Vout(v),Vin(u),c);
				}
			}
			pw.println(edmondKarp());
		}
		pw.close();
	}
	static int n,s,t,w,INF=(int)1e9;
	static int res[][],p[];
	static ArrayList<Integer>adjList[];
	public static void add(int u,int v,int c)
	{
		adjList[u].add(v);
		adjList[v].add(u);
		res[u][v]+=c;
		res[v][u]+=0;//backward edge
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
			p=new int[2*n+2];
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
