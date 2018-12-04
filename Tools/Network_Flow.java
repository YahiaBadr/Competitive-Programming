package Tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Network_Flow
{
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
	
}
