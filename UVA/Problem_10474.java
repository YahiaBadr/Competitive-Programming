package UVA;

import java.io.*;
import java.util.*;

public class Problem_10474 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int c=1;
		while(true)
		{
			int n=sc.nextInt();
			int q=sc.nextInt();
			if(n==0)
				break;
			ArrayList<Integer> a= new ArrayList<>(n);
			while(n-->0)
				a.add(sc.nextInt());
			Collections.sort(a);
			pw.println("CASE# "+c+":");
			while(q-->0)
			{	int x=sc.nextInt();
				int i=a.indexOf(x)+1;
				if(i==0)
					pw.println(x+" not found");
				else	
					pw.println(x+" found at "+i);
			
			}
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
