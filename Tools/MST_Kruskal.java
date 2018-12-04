package Tools;

import java.util.Arrays;

public class MST_Kruskal
{
	Edge[]edgeList;
	int size;
	public int MST()
	{
		DSU dsu=new DSU(size);
		int mst = 0;
		Arrays.sort(edgeList);
		for(Edge e:edgeList)
			if(dsu.union(e.u, e.v))
				mst+=e.c;
		return mst;
	}
	static class Edge implements Comparable<Edge>
	{
		int u,v,c;
		public Edge(int u,int v,int c)
		{
			this.u=u;
			this.v=v;
			this.c=c;
		}
			
		@Override
		public int compareTo(Edge o)
		{
			return c-o.c;
		}
		
	}
	static class DSU
	{
		int[]p;
		int[]size;
		public DSU(int n)
		{
			p=new int[n];size=new int[n];
			for(int i=0;i<n;i++)
			{	
				p[i]=i;
				size[i]=1;
			}
		}
		public int findset(int x)
		{
			return x==p[x]?x:(p[x]=findset(p[x]));
		}
		public boolean issameset(int x,int y)
		{
			return findset(x)==findset(y);
		}
		public boolean union(int x,int y)
		{
			x=findset(x);y=findset(y);
			if(y==x)
				return false;
			if(size[y]>=size[x])
			{
				p[x]=y;
				size[y]+=size[x];
			}
			else
			{
				p[y]=x;
				size[x]+=size[y];
			}
			return true;
		}
	}
}
