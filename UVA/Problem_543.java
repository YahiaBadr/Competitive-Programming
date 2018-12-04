package UVA;

import java.io.*;
import java.util.*;

public class Problem_543 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		ArrayList<Integer>p=new ArrayList<>();
		boolean f[]=new boolean[1000001];
		for(int i=2;i<f.length;i++)
		{
			if(!f[i])
			{
				p.add(i);
				for(int j=i+i;j<f.length;j+=i)
				{
					f[j]=true;
				}
			}
		}
//		System.out.println(p);
		big:while(true)
		{
			int n=sc.nextInt();
			if(n==0)
				break;
			for(int i=0;p.get(i)<n;i++)
			{
				if(!f[n-p.get(i)])
				{
					pw.println(n+" = "+p.get(i)+" + "+(n-p.get(i)));
					continue big;
				}
			}
			pw.println("Goldbach's conjecture is wrong.");
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
