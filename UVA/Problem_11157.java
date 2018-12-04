package UVA;

import java.io.*;
import java.util.*;

class rock
{
	char s;int d;
	public rock(char size,int d)
	{
		s=size;this.d=d;
	}
}
public class Problem_11157 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();int c=1;
		while(t-->0)
		{
			int n=sc.nextInt();
			int d=sc.nextInt();
			rock[]a= new rock[n+2];
			a[0]=new rock('B', 0);
			a[n+1]=new rock('B', d);
			StringTokenizer st= new StringTokenizer(sc.nextLine());
			for(int i=1;i<n+1;i++)
			{
			//	String s=sc.nextLine();
				String s=st.nextToken();
				a[i]=new rock(s.charAt(0),Integer.parseInt(s.substring(2)));
			}
			int max=0;
			if(n==1)
			{
				if(a[1].s=='S')
					max=d;
				else
					max=Math.max(d-a[1].d, a[1].d);
			}
			else
			{	
				for(int i=0;i<a.length-1;i++)
				{
					if(a[i+1].s=='S')
					{
						if(i+2==a.length)
							max=Math.max(max, d-a[i].d);
						else
							max=Math.max(max, a[i+2].d-a[i].d);
					}
					else
						max=Math.max(max, a[i+1].d-a[i].d);
				}
			}
			pw.println("Case "+c+": "+max);
			c++;
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
