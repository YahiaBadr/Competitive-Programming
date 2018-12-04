package UVA;

import java.io.*;
import java.util.*;

public class Problem_12347 {
	static ArrayList<Integer>a,ans;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
//		for(int i=0;i<1e9;i++);
		a=new ArrayList<>();
		while(sc.hasnext())
		{
			int x=sc.nextInt();
			a.add(x);
		}
		ans=new ArrayList<>();
		rec(0,a.size()-1);
		for(int i=0;i<ans.size();i++)
			pw.println(ans.get(i));
		pw.close();
	}
	public static void rec(int s,int e)
	{
		if(s>e)
			return;
		if(s==e)
		{
			ans.add(a.get(s));
			return;
		}
		int i=s+1;
		while(i<a.size() && a.get(i)<a.get(s))i++;
		//left
		rec(s+1,i-1);
		//right
		rec(i,e);
		ans.add(a.get(s));
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
