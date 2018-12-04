package UVA;

import java.io.*;
import java.util.*;


public class Problem_929 {
//	static int rows,col;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();
		while(t-->0)
		{
			int r=sc.nextInt(),c=sc.nextInt();
			Graph g=new Graph(r,c);
//			rows=r;col=c;
			for(int i=0;i<r;i++)
				for(int j=0;j<c;j++)
					g.add(i, j, sc.nextInt());
			pw.println(g.dijkstra_grid(0, 0, r-1, c-1));
		}
		pw.close();
	}
	static class Graph
	{
		int[][]grid;
		boolean[][]visited;
		int size,r,c;
		public Graph(int r,int c)
		{
			this.r=r;this.c=c;
			grid=new int[r][c];
			visited=new boolean[r][c];
		}
		public void add(int i,int j,int cost)
		{
			grid[i][j]=cost;
		}
		//Float_Fill
		public void dfs2(int i,int j)
		{ 
			int[] dx= {-1,1,0,0};
			int[] dy= {0,0,-1,1};
			grid[i][j]='X';// Visited
			for(int k=0;k<4;k++)
			{
				int x=i+dx[k],y=j+dy[k];
				if(valid(x,y)&&grid[x][y]!='X')
					dfs2(x,y);
			}
				
		}
		public boolean valid(int i,int j)
		{
			return i<r && i>=0 && j<c && j>=0;		
		}
		public int dijkstra_grid(int i,int j,int end_i,int end_j)
		{
			PriorityQueue<Triple>pq=new PriorityQueue<>();
			pq.add(new Triple(i, j, grid[i][j]));
			visited[i][j]=true;
			int[] dx= {-1,1,0,0};
			int[] dy= {0,0,-1,1};
			int dist[][]=new int[r][c];
			for(int []a:dist)
				Arrays.fill(a, (int)1e9);
			dist[i][j]=grid[i][j];
			while(!pq.isEmpty())
			{
				Triple t=pq.poll();
				int ci=t.i,cj=t.j;
				for(int k=0;k<4;k++)
				{
					int x=ci+dx[k],y=cj+dy[k];
					if(valid(x,y) && dist[ci][cj]+grid[x][y]<dist[x][y])
					{
						pq.add(new Triple(x, y, dist[ci][cj]+grid[x][y]));
						visited[x][y]=true;
						dist[x][y]=dist[ci][cj]+grid[x][y];
					}
				}
			}
//			for(int[]a:dist)
//				printRow(a);
			return dist[end_i][end_j];
		}
	}
	public static void printRow(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");//adding space of 6 char
        }
        System.out.println();
    }
	static class Triple implements Comparable<Triple>
	{
		int i,j,c;
		public Triple(int i,int j,int c)
		{
			this.i=i;this.j=j;this.c=c;
		}
		@Override
		public int compareTo(Triple o) {
			return c-o.c;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return ""+c;
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
