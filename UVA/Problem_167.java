package UVA;

import java.io.*;
import java.util.*;

public class Problem_167 {
	static int n;
	static int[] sol;
	static boolean queens[];
	static boolean[] diar;
	static boolean[] dial;
	static int c=0;
	static PriorityQueue<Integer>pq;
	static int num[][];
	public static boolean safe(int row,int col)
	{
		return !diar[row+col] && !dial[row-col+n-1];
	}
	public static void queen(int row,int s)
	{
		if(row==n)
		{
			pq.add(s);
			return;
		}
		for(int col=0;col<n;col++)
		{
			if(!queens[col] && safe(row,col))
			{
				queens[col]=true;
				diar[row+col]=true;
				dial[row-col+n-1]=true;
				sol[row]=col;
				queen(row+1,s+num[row][col]);
				queens[col]=false;
				diar[row+col]=false;
				dial[row-col+n-1]=false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		n=8;
		int k=sc.nextInt();
		while(k-->0)
		{	
			queens=new boolean[n];
			diar=new boolean[(2*n)];
			dial=new boolean[(2*n)];
			sol=new int[n];
			num=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					num[i][j]=sc.nextInt();
			pq= new PriorityQueue<>(Collections.reverseOrder());
			queen(0,0);
			String s=""+pq.peek();
			for(int i=s.length();i<5;i++)
				pw.print(" ");
			pw.print(s);
			pw.println("");
		}		
		pw.close();
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
