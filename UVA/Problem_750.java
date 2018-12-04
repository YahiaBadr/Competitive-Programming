package UVA;

import java.io.*;
import java.util.*;

public class Problem_750 {
	static int n;
	static int[] sol;
	static boolean queens[];
	static boolean[] diar;
	static boolean[] dial;
	static int c=0;
	public static boolean safe(int row,int col)
	{
		return !diar[row+col] && !dial[row-col+n-1];
	}
	public static void queen(int row)
	{
		if(row==r)
			queen(row+1);
		if(row==n)
		{
			print(sol);
			return;
		}
		for(int col=0;col<n;col++)
		{
			if(!queens[col] && safe(row,col))
			{
				queens[col]=true;
				diar[row+col]=true;
				dial[row-col+n-1]=true;
				sol[col]=row+1;
				queen(row+1);
				queens[col]=false;
				diar[row+col]=false;
				dial[row-col+n-1]=false;
			}
		}
	}
	public static void print(int[] a)
	{
		StringBuilder s=new StringBuilder("");
		for(int i=0;i<a.length;i++)
		{
			if(i==a.length-1)
				s.append(a[i]);
			else
				s.append(a[i]+" ");
		}
		pq.add(s.toString());
	}
	public static void print()
	{
		while(!pq.isEmpty())
		{	
			if(count<10)
				pw.print(" ");
			pw.print(count+"      ");
			pw.print(pq.poll());
			count++;
			pw.println();
		}	
	}
	static int r,count;static PriorityQueue<String>pq;
	static PrintWriter pw = new PrintWriter(System.out);
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		int t=sc.nextInt();
		while(t-->0)
		{	
			pq=new PriorityQueue<>();
			count=1;
			n=8;
			r=sc.nextInt()-1;
			int c=sc.nextInt()-1;
			pw.println("SOLN       COLUMN");
			pw.println(" #      1 2 3 4 5 6 7 8");
			pw.println();
			queens=new boolean[n];
			diar=new boolean[(2*n)];
			dial=new boolean[(2*n)];
			sol=new int[n];
			queens[c]=true;
			diar[r+c]=true;
			dial[r-c+n-1]=true;
			sol[c]=r+1;
			queen(0);
			print();
			if(t!=0)
				pw.println();
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
