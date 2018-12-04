package UVA;

import java.io.*;
import java.util.*;

public class Problem_10855 {
	static char[][]a1,a2;
	public static void transpose(char[][] m) {

        for (int i = 0; i < m.length; i++) {
            for (int j = i; j < m[0].length; j++) {
                char x = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = x;
            }
        }
    }


    public static void rotateByNinetyToLeft(char[][] m) {
        // transpose
        transpose(m);

        //  swap rows
        for (int  i = 0; i < m.length/2; i++) {
            for (int j = 0; j < m[0].length; j++) {
                char x = m[i][j];
                m[i][j] = m[m.length -1 -i][j]; 
                m[m.length -1 -i][j] = x;
            }
        }
    }


    public static void rotate(char[][] m) {
        // transpose
        transpose(m);

        // swap columns
        for (int  j = 0; j < m[0].length/2; j++) {
            for (int i = 0; i < m.length; i++) {
                char x = m[i][j];
                m[i][j] = m[i][m[0].length -1 -j]; 
                m[i][m[0].length -1 -j] = x;
            }
        }
    }
	public static int contains(char[][] a,char[][]b)
	{
		int r=0;
		for(int i=0;i<=a.length-b.length;i++)
		{
			for(int j=0;j<=a.length-b.length;j++)
			{
				boolean f=true;
				big:for(int i1=0,i2=i;i1<b.length;i1++,i2++)
				{	
					for(int j1=0,j2=j;j1<b.length;j1++,j2++)
					{
						if(a[i2][j2]!=b[i1][j1])
						{
							f=false;
							break big;
						}
					}	
				}
				if(f)
					r++;
			}
		}
		return r;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(true)
		{
			int n1=sc.nextInt();
			int n2=sc.nextInt();
			if(n1==0)
				break;
			a1=new char[n1][n1];
			a2=new char[n2][n2];
			for(int i=0;i<n1;i++)
			{
				String s=sc.nextLine();
				for(int j=0;j<n1;j++)
					a1[i][j]=s.charAt(j);
			}
			for(int i=0;i<n2;i++)
			{
				String s=sc.nextLine();
				for(int j=0;j<n2;j++)
					a2[i][j]=s.charAt(j);
			}
			int ans=0;
			if(n1>n2)
			{	
				ans=contains(a1,a2);
			}
			else
			{
				ans=contains(a2,a1);
			}
			pw.print(ans+" ");
			for(int i=0;i<3;i++)
			{
				if(n1>n2)
				{	
					rotate(a2);
					ans=contains(a1,a2);
				}
				else
				{
					rotate(a1);
					ans=contains(a2,a1);
				}
				if(i!=2)
					pw.print(ans+" ");
				else
					pw.print(ans);
			}
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
