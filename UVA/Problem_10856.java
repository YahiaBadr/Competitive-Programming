package UVA;

import java.io.*;
import java.util.*;

public class Problem_10856 {
	public static int[] factors(HashMap<Integer, String>hm)
	{
		int[]a=new int[2703665];
		for(int i=2;i<a.length;i++)
		{
			if(a[i]==0)
				a[i]=1;
			for(int j=2,k=i*j;k<a.length && j<=i;j++,k=i*j)
				if(a[j]==1)	
					a[k]=a[i]+a[j];
		}
		//Array a contains the number of factors of each i
//		int j=2;
		for(int i=2;i<a.length;i++)
		{
			a[i]+=a[i-1];
			hm.put(a[i], i+"!");
		}
//		System.out.println(j);
		//here the number of factors of each i!
		return a;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
//		long start=System.currentTimeMillis();
		HashMap<Integer, String>hm=new HashMap<>();
		factors(hm);
		int n,c=1;
		hm.put(0, 0+"!");
		while((n=sc.nextInt())>=0)
			pw.println("Case "+(c++)+": "+hm.getOrDefault(n,"Not possible."));
//		System.out.println(System.currentTimeMillis()-start);
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
