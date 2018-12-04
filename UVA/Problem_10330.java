package UVA;

import java.io.*;
import java.util.*;

public class Problem_10330 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
//		int ya=sc.nextInt();
		while(sc.hasnext())
		{
			n=sc.nextInt();
			int[]a=new int[n];
			res=new int[n*2+2][n*2+2];
			adjList=new ArrayList[n*2+2];
			for(int i=0;i<2*n+2;i++)
				adjList[i]=new ArrayList<>();
			s=0;t=1;
			for(int i=1;i<=n;i++)
			{
				a[i-1]=sc.nextInt();
				int vin=Vin(i),vout=Vout(i);
				adjList[vin].add(vout);
				adjList[vout].add(vin);
				res[vin][vout]=a[i-1];
			}
			int m=sc.nextInt();
			while(m-->0)
			{
				int i=sc.nextInt(),j=sc.nextInt(),c=sc.nextInt();
				
				adjList[Vout(i)].add(Vin(j));
				adjList[Vin(j)].add(Vout(i));
				res[Vout(i)][Vin(j)]+=c;
			}
			int B=sc.nextInt(),D=sc.nextInt();
			while(B-->0)
			{
				int vin=Vin(sc.nextInt());
				adjList[0].add(vin);
				res[0][vin]=INF;
			}
			while(D-->0)
			{
				int vout=Vout(sc.nextInt());
				adjList[vout].add(1);
				res[vout][1]=INF;
			}
			pw.println(edmondKarp());
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
		if(p[v]==s)
			return flow;
		flow= aug(p[v],Math.min(res[p[v]][v],flow));
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
//1
//4
//10 20 30 40
//6
//1 2 5
//1 3 10
//1 4 13
//2 3 5
//2 4 7
//3 4 20
//3 1
//1 2 3 4
//2
//50 100
//1
//1 2 100
//1 1
//1 2
