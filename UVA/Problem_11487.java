package UVA;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class Problem_11487 {
	static int n,grid[][];
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(true)
		{
			n=sc.nextInt();
			if(n==0)break;
			grid=new int[n][n];
			pq=new PriorityQueue<>();
			for(int i=0;i<n;i++)
			{
				String line=sc.nextLine();
				for(int j=0;j<n;j++)
				{
					grid[i][j]=line.charAt(j)-'A';//#-->-39 .-->-19
					if(line.charAt(j)>='A' && line.charAt(j)<='Z')
						pq.add(new Pair(line.charAt(j)-'A',i, j));
				}
			}
			bfs();
						
		}
		pw.close();
	}
	static int c=1;
	static PriorityQueue<Pair>pq;
	public static void bfs()
	{
		Pair start=pq.remove();
		int i=start.i;
		int j=start.j;
		int dx[]= {1,-1,0,0};
		int dy[]= {0,0,1,-1};
		int count[][]=new int[n][n];
		int dist[][]=new int[n][n];
		for(int ii=0;ii<n;ii++)
			Arrays.fill(dist[ii], (int)1e9);
		dist[i][j]=0;
		grid[i][j]=-19;
		count[i][j]=1;
		Queue<Point>q=new LinkedList<>();
		q.add(new Point(i, j));
		if(pq.isEmpty())
		{
			System.out.println("Case "+(c++)+": "+0+" "+1);
			return;
		}
		int searching =pq.peek().v,pathes=1,d=0;
		while(!q.isEmpty())
		{
			Point cu=q.poll();
			int ci=cu.x,cj=cu.y;
			if(grid[ci][cj]==searching)
			{
				pathes=pathes*(count[ci][cj]%20437);
				pathes%=20437;
				d+=dist[ci][cj];
				dist=new int[n][n];
				for(int ii=0;ii<n;ii++)
					Arrays.fill(dist[ii], (int)1e9);
				dist[ci][cj]=0;
				count=new int[n][n];
				count[ci][cj]=1;
				grid[ci][cj]=-19;
				pq.remove();
				if(pq.isEmpty())
				{
					System.out.println("Case "+(c++)+": "+d+" "+pathes);
					return ;
				}
				searching=pq.peek().v;
				q=new LinkedList<>();
			}
			for(int k=0;k<4;k++)
			{
				int x=ci+dx[k],y=cj+dy[k];
				if(valid(x,y)&& (grid[x][y]==-19 || grid[x][y]==searching) && dist[ci][cj]+1<=dist[x][y])//we are not checking about visited we check if it is block
				{
					if(dist[ci][cj]+1==dist[x][y])
					{
						count[x][y]+=count[ci][cj];
					}
					else
					{
						q.add(new Point(x, y));
						dist[x][y]=dist[ci][cj]+1;
						count[x][y]=count[ci][cj];
					}
				}
			}
		}
		System.out.println("Case "+(c++)+":"+" Impossible");
	}
	public static boolean valid(int i,int j)
	{
		return i<n && i>=0 && j<n && j>=0;		
	}
	static class Pair implements Comparable<Pair>
	{
		int v,i,j;
		public Pair(int v,int i,int j) {
			// TODO Auto-generated constructor stub
			this.v=v;this.i=i;this.j=j;
		}
		@Override
		public int compareTo(Pair p) {
			// TODO Auto-generated method stub
			return v-p.v;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "( "+v+": "+i+","+j+" )";
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
