package UVA;

import java.io.*;
import java.util.*;

public class Problem_133 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(true)
		{
			int n=sc.nextInt(),k=sc.nextInt(),m=sc.nextInt();
			if(n==0&&k==0&&m==0)
				break;
			int check=0;
			boolean[]f=new boolean[n];
			for(int i=0,j=n-1;check<n;)
			{
				int tmp_k=k-1,tmp_m=m-1;
				while(tmp_k>0)
				{
					if(!f[i])
						tmp_k--;
					i++;
					i%=n;
				}
				while(f[i])
				{
					i++;
					i%=n;
				}
				while(tmp_m>0)
				{
					if(!f[j])
						tmp_m--;
					j--;
					j+=n;
					j%=n;
				}
				while(f[j])
				{
					j--;
					j+=n;
					j%=n;
				}
				f[i]=true;
				f[j]=true;
				if(i==j)
				{
					check++;
					pw.printf("%3d", (i+1));
				}
				else
				{
					check+=2;
					pw.printf("%3d"+"%3d", (i+1),(j+1));
				}
				if(check<n)
					pw.print(",");
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
