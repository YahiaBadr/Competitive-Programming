package UVA;

import java.io.*;
import java.util.*;

public class Problem_11045 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int c=sc.nextInt();
		while(c-->0)
		{
			//from n+1-->>n+6 xs-->xxl
			m=sc.nextInt()/6;n=sc.nextInt();
			s=0;t=n+7;
			adjList=new ArrayList[n+8];
			for(int i=0;i<n+8;i++)
				adjList[i]=new ArrayList<>();
			res=new int[n+8][n+8];
			for(int i=n+1;i<=n+6;i++)
			{
				adjList[i].add(t);
				res[i][t]=m;
			}
			for(int i=1;i<=n;i++)
			{
				StringTokenizer st=new StringTokenizer(sc.nextLine());
				String s1=st.nextToken(),s2=st.nextToken();
				adjList[s].add(i);
				res[s][i]=1;
				switch(s1)
				{
				case"XS":add(i,n+1,1);break;
				case"S":add(i,n+2,1);break;
				case"M":add(i,n+3,1);break;
				case"L":add(i,n+4,1);break;
				case"XL":add(i,n+5,1);break;
				case"XXL":add(i,n+6,1);
				}
				switch(s2)
				{
				case"XS":add(i,n+1,1);break;
				case"S":add(i,n+2,1);break;
				case"M":add(i,n+3,1);break;
				case"L":add(i,n+4,1);break;
				case"XL":add(i,n+5,1);break;
				case"XXL":add(i,n+6,1);
				}
			}
			if(edmondKarp()>=n)
				pw.println("YES");
			else
				pw.println("NO");
			pw.flush();
		}
		pw.close();
	}
	static int n,m,s,t,INF=(int)1e9;
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
			p=new int[n+8];
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
