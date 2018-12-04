package Tools;

public class DSU
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
	public void union(int x,int y)
	{
		x=findset(x);y=findset(y);
		if(y==x)
			return;
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
//		x=findset(x);y=findset(y);
	}
	public int getsize(int u)
	{
		return size[findset(u)];
	}
	public String toString()
	{
		String s="";
		for(int i=0;i<p.length;i++)
		{
			s+=i+": ";
			for(int j=0;j<p.length;j++)
			{
				if(findset(j)==i)
				{
					s+=j+" ";
				}
			}
			s+="\n";
		}
		return s;
	}
	public static void main(String[] args) 
	{
		DSU d=new DSU(5);
		d.union(1, 3);
		d.union(3, 2);
		System.out.println(d);
	}
}
