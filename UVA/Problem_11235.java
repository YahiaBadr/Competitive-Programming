package UVA;

import java.io.*;
import java.util.*;

public class Problem_11235
{	
	public static void SparseTable()
	{
		int n=a.length;
		for(int i=0;i<n;i++)
			st[i][0]=fre[i];
		for(int j=1;(1<<j)<=n;j++)
			for(int i=0;i+(1<<j)<=n;i++)
				st[i][j]=Math.max(st[i][j-1], st[i+(1<<j-1)][j-1]);
	}
	public static int query(int l,int r)
	{
		int length=r-l+1;
		int log=(int)(Math.log(length)/Math.log(2));//which column
		return Math.max(st[l][log],st[r-(1<<log)+1][log]);
	}
	
	
	static int[]fre,a;
	static int st[][]=new int[100005][30];
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(true)
		{
			int n=sc.nextInt();
			if(n==0)
				break;
			int q=sc.nextInt();
			a=new int[n];
			fre=new int[n];
			int[]lastindx=new int[200002],firstindx=new int[200002];
			a[0]=sc.nextInt();int c=1;int s=0;
			firstindx[a[0]+100000]=0;
			for(int i=1;i<n;i++)
			{
				a[i]=sc.nextInt();
				if(a[i]!=a[i-1])
				{
					Arrays.fill(fre, s, i, c);
					c=0;
					s=i;
					lastindx[a[i-1]+100000]=i-1;
					firstindx[a[i]+100000]=i;
				}
				c++;
			}
			lastindx[a[n-1]+100000]=n-1;
			Arrays.fill(fre, s,n,c);
			SparseTable();
			while(q-->0)
			{
				int i=sc.nextInt()-1,j=sc.nextInt()-1;
				int stt= a[i],e=a[j];
				int stindx=firstindx[stt+100000],eindx=lastindx[e+100000];
				int l=lastindx[stt+100000]+1;
				int r=firstindx[e+100000]-1;
				int max=Math.max(st[i][0]-(i-stindx),st[j][0]-(eindx-j));
				if(a[i]==a[j])
					max=j-i+1;
				else if(r>=l)
					max=Math.max(max,query(l,r));
				System.out.println(max);
			}
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
