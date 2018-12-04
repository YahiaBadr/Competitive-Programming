package UVA;

import java.io.*;
import java.util.*;

public class Problem_10092 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(true)
		{
			n=sc.nextInt();np=sc.nextInt();
			if(n==0 && np==0)break;
			adjList=new ArrayList[n+np+2];
			res=new int[n+np+2][n+np+2];
			ans=new HashSet[n+np+2];
			s=0;t=n+np+1;
			for(int i=0;i<n+np+2;i++)
			{
				adjList[i]=new ArrayList<>();
				ans[i]=new HashSet<>();
			}
			for(int i=1;i<=np;i++)
			{
				adjList[s].add(i+n);
				res[s][i+n]=1;
			}
			int problems=0;
			for(int i=1;i<=n;i++)
			{
				adjList[i].add(t);
				res[i][t]=sc.nextInt();
				problems+=res[i][t];
			}
			int prob=n+1;
			int tmp=np;
			while(tmp-->0)
			{
				int count=sc.nextInt();
				while(count-->0)
				{
					add(prob, sc.nextInt(), 1);
				}
				prob++;
			}
			if(problems==edmondKarp())
			{
				pw.println(1);
				for(int i=1;i<=n;i++)
				{
					StringBuilder sb=new StringBuilder();
					for(int k:ans[i])
						sb.append(k+" ");
					sb.deleteCharAt(sb.length()-1);
					pw.println(sb.toString());
				}
			}
			else
				pw.println(0);
		}
		pw.close();
	}
	static int n,s,t,np,INF=(int)1e9;
	static int res[][],p[];
	static ArrayList<Integer>adjList[];
	static HashSet<Integer>ans[];
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
			p=new int[n+np+2];
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
		if(p[v]>v)
			ans[v].add(p[v]-n);
		if(p[v]<v)
			ans[p[v]].remove(v-n);
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
