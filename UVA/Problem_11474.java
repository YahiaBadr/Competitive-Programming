package UVA;

import java.io.*;
import java.util.*;

public class Problem_11474 {
	static Scanner sc = new Scanner();static int k,d;
	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();
		big:while(t-->0)
		{
			int n=sc.nextInt(),m=sc.nextInt();
			k=sc.nextInt();d=sc.nextInt();
			Pair[]doct=new Pair[m];
			ArrayList<Pair>trees=new ArrayList<>();
			int c=1;
			for(int i=0;i<m;i++)
			{
				doct[i]=new Pair(sc.nextInt(), sc.nextInt(), i, -1);
			}
			int i=0;
			while(c<=n)
			{
				int b=sc.nextInt();
				while(b-->0)
					trees.add(new Pair(sc.nextInt(), sc.nextInt(), i++,c));
				c++;
			}
			for(int j=0;j<m;j++)
			{
				doct[j].i=i++;
				trees.add(doct[j]);
			}
			DSU dsu=new DSU(trees);
//			System.out.println(dsu);
			dsu.makeunion();
//			System.out.println(
//			dsu.union(trees.get(trees.size()-2), trees.get(trees.size()-1));
//			System.out.println(dsu);
			for(int j=0;true;j++)
			{
				if(trees.get(j).t!=1)
					break;
				for(int k=0;k<m;k++)
					if(dsu.issameset(trees.get(j), doct[k]))
					{
						System.out.println("Tree can be saved :)");
						continue big;
					}
			}
			System.out.println("Tree can't be saved :(");
		}
		pw.close();
	}
	static class Pair
	{
		int x,y,i,t;
		public Pair(int xx,int yy,int ii,int tt)
		{
			x=xx;y=yy;i=ii;t=tt;
		}
		public Pair(int xx,int yy,int ii) {
			x=xx;y=yy;i=ii;
		}
		public double distance(Pair p)
		{
			int xx=x-p.x,yy=y-p.y;
			xx*=xx;yy*=yy;
			return Math.sqrt(xx+yy);
		}
		public boolean equals(Object o)
		{
			Pair x=(Pair)o;
			return x.x==this.x && x.y==this.y;
		}
		public String toString()
		{
			return "("+x+","+y+","+i+","+t+")";
		}
	}
	static class DSU
	{
		Pair[]p;
		int[]size;
		public DSU(ArrayList<Pair>a)
		{
			size=new int[a.size()];
			p=new Pair[a.size()];
			Arrays.fill(size, 1);
			a.toArray(p);
//			System.out.println(Arrays.toString(p));
		}
		public DSU(int n) throws IOException
		{
			p=new Pair[n];size=new int[n];
			for(int i=0;i<n;i++)
			{	
				p[i]=new Pair(sc.nextInt(),sc.nextInt(),i);
				size[i]=1;
			}
		}
		public int findset(Pair x)
		{
			return x.i==p[x.i].i?x.i:(x.i=findset(p[x.i]));
		}
		public boolean issameset(Pair x,Pair y)
		{
			return findset(x)==findset(y);
		}
		public void makeunion()
		{
			for(int i=0;i<p.length;i++)
				for(int j=0;j<p.length;j++)
					union(p[i],p[j]);
		}
		public void union(Pair xx,Pair yy)
		{
			int x=findset(xx),y=findset(yy);
			if(y==x)
				return;
			if(xx.t!=yy.t && xx.t!=-1 && yy.t!=-1 && xx.distance(yy)>k)
				return;
			if((xx.t==-1 || yy.t==-1)&& xx.distance(yy)>d)
				return;
			if(size[y]>=size[x])
			{
				p[x].i=y;
				size[y]+=size[x];
			}
			else
			{
				p[y].i=x;
				size[x]+=size[y];
			}
		}
		public String toString()
		{
			String s="";
			for(int i=0;i<p.length;i++)
			{
				s+=i+": ";
				for(int j=0;j<p.length;j++)
				{
					if(findset(p[j])==i)
					{
						s+=p[j].toString()+" ";
					}
				}
				s+="\n";
			}
			return s;
		}
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
