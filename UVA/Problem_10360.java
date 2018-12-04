package UVA;

import java.io.*;
import java.util.*;
public class Problem_10360 {
	static int max,d,maxx,maxy;static int[][] a,sol;
	public static void sol(int x,int y)
	{
		int sx=x-d,sy=y-d;
		for(int i=sx;i<=sx+(d*2);i++)
			for(int j=sy;j<=sy+(d*2);j++)
			{
				if(i>=0&&j>=0 && i<=1024 && j<=1024)	
				{	sol[i][j]+=a[x][y];
					if(max<sol[i][j])
					{	max=sol[i][j];
						maxx=i;
						maxy=j;
					}
					else if(max==sol[i][j])
					{
						if(maxx>i)
						{
							maxx=i;
							maxy=j;
						}	
						else if(maxx==i && maxy>j)
						{
							maxy=j;
						}
					}
				}	
			}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();
		while(t-->0)
		{
			max=0;
			d=sc.nextInt();
			int n=sc.nextInt();
			a= new int[1026][1026];
			sol=new int[1026][1026];
			for(int i=0;i<1026;i++)
				for(int j=0;j<1026;j++)
					sol[i][j]=0;
			for(int i=0;i<n;i++)
			{
				int x=sc.nextInt();
				int y=sc.nextInt();
				a[x][y]=sc.nextInt();
				sol(x,y);
			}
			//System.out.println(sol[65][40]);
			pw.println(maxx+" "+maxy+" "+max);
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
