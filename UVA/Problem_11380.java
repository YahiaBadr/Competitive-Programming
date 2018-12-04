package UVA;

import java.io.*;
import java.util.*;

public class Problem_11380 {
	static int x,y,max;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		for(int i=0;i<(int)2*1e9;i++);
		while(sc.hasnext())
		{
			x=sc.nextInt();y=sc.nextInt();max=sc.nextInt();
			s=x*y*2;
			t=x*y*2+1;
			adjList=new ArrayList[t+1];
			for(int i=0;i<=t;i++)
				adjList[i]=new ArrayList<>();
			res=new int[t+1][t+1];
			int id=0;
			char input[][]=new char[x][y];
			for(int i=0;i<x;i++)
			{
				input[i]=sc.nextLine().toCharArray();
				for(int j=0;j<y;j++,id++)
				{
					int vin=Vin(id),vout=Vout(id);
					adjList[vin].add(vout);
					adjList[vout].add(vin);
					switch (input[i][j])
					{
						case '*':
							res[s][vin]=Inf;
							res[vin][vout]=1;
							adjList[s].add(vin);
							break;
						case '~':
							res[vin][vout]=0;break;
						case '.':
							res[vin][vout]=1;break;
						case '@':
							res[vin][vout]=Inf;break;
						case '#':
							res[vin][vout]=Inf;
							res[vout][t]=max;
							adjList[vout].add(t);
							break;
					}
					for(int k=0;k<4;k++)
					{
						int xx=i+dx[k],yy=j+dy[k];
						if(valid(xx,yy))
						{
							int tmpid=xx*y+yy;
							int v=Vin(tmpid);
							res[vout][v]=Inf;
							adjList[vout].add(v);
							adjList[v].add(vout);
						}
					}
				}
			}
//			for(int i=0;i<=t;i++)
//				pw.println(i+" "+adjList[i]);
			pw.println(edmondKarp());
//			pw.println();
		}
		pw.close();
	}
	public static boolean valid(int i,int j)
	{
		return i<x && i>=0 && j<y && j>=0;		
	}
	static int Vin(int id)
	{
		return id*2;
	}
	static int Vout(int id)
	{
		return id*2+1;
	}
	static int n,s,t,Inf=(int)1e9;
	static int res[][],p[];
	static ArrayList<Integer> adjList[];
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	public static int edmondKarp()
	{
		int maxf=0;
		while(true)
		{
			Queue<Integer>q=new LinkedList<>();
			p=new int[t+1];
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
			aug(t);
			maxf++;
		}
		return maxf;
	}
	public static int aug(int v)
	{
		if(p[v]==s)
			return (int)1e9;
		int flow= Math.min(res[p[v]][v], aug(p[v]));
		res[p[v]][v]--;
		res[v][p[v]]++;
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
