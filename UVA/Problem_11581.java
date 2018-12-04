package UVA;

import java.io.*;
import java.util.*;

public class Problem_11581 {
	public static int[][] fun(int[][]a)
	{
		int[][]tmp=new int[3][3];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				int sum=0;
				if(j-1>=0)
					sum+=a[i][j-1];
				if(j+1<3)
					sum+=a[i][j+1];
				if(i-1>=0)
					sum+=a[i-1][j];
				if(i+1<3)
					sum+=a[i+1][j];
				tmp[i][j]=sum%2;
			}
		}
		return tmp;
	}
	public static boolean not(int[][]a)
	{
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				if(a[i][j]!=0)
					return false;
		return true;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int n= sc.nextInt();
		while(n-->0)
		{
			sc.nextLine();
			int[][]a= new int[3][3];
			String s1=sc.nextLine();
			String s2=sc.nextLine();
			String s3= sc.nextLine();
			for(int i=0;i<3;i++)
				a[0][i]=Integer.parseInt(s1.charAt(i)+"");
			for(int i=0;i<3;i++)
				a[1][i]=Integer.parseInt(s2.charAt(i)+"");
			for(int i=0;i<3;i++)
				a[2][i]=Integer.parseInt(s3.charAt(i)+"");
			int c=-1;
			while(!not(a))
			{
				c++;
				a=fun(a);
			}
			pw.println(c);
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
