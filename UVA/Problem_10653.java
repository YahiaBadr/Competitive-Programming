package UVA;

import java.io.*;
import java.util.*;

public class Problem_10653 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(true)
		{
			int r=sc.nextInt(),c=sc.nextInt();
			if(r==0 && c==0)
				break;
			Graph g=new Graph(r, c);
			int b=sc.nextInt();
			while(b-->0)
			{
				int rr=sc.nextInt();
				int num=sc.nextInt();
				while(num-->0)
				{
					g.add(rr,sc.nextInt());
				}
			}
			int startR=sc.nextInt(),startC=sc.nextInt();
			int destR=sc.nextInt(),destC=sc.nextInt();
			pw.println(g.bfs(startR, startC,destR,destC));
		}
		pw.close();
	}
	static class Graph
	{
		char[][]grid;
		boolean[]visited;
		int size;
		int r,c;
		public Graph(int r,int c)
		{
			this.r=r;this.c=c;
			grid=new char[r][c];
			visited=new boolean[size];
		}
		public void add(int r,int c)
		{
			grid[r][c]='X';
		}
		public int bfs(int i,int j,int end_i,int end_j)
		{
			Queue<Integer>qi=new LinkedList<>(),qj=new LinkedList<>();
			qi.add(i);qj.add(j);
			grid[i][j]='X';
			int[] dx= {-1,1,0,0};
			int[] dy= {0,0,-1,1};
			int dist[][]=new int[r][c];
			for(int []a:dist)
				Arrays.fill(a, (int)1e9);
			dist[i][j]=0;
			while(!qi.isEmpty())
			{
				int ci=qi.poll(),cj=qj.poll();
				for(int k=0;k<4;k++)
				{
					int x=ci+dx[k],y=cj+dy[k];
					if(valid(x,y)&& grid[x][y]!='X' && dist[ci][cj]+1<dist[x][y])
					{
						qi.add(x);
						qj.add(y);
						grid[x][y]='X';
						dist[x][y]=dist[ci][cj]+1;
					}
				}
			}
			return dist[end_i][end_j];
//			for(int[]a:dist)
////				System.out.println(Arrays.toString(a));
//				printRow(a);
		}
		public static void printRow(int[] row) {
	        for (int i : row) {
	            System.out.print(i);
	            System.out.print("\t");
	        }
	        System.out.println();
	    }
		public boolean valid(int i,int j)
		{
			return i<r && i>=0 && j<c && j>=0;		
		}
		//Float_Fill
		public void print()
		{
			for(int i=0;i<grid.length;i++)
				System.out.println(Arrays.toString(grid[i]));
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
