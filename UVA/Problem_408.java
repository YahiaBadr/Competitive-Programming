package UVA;

import java.io.*;
import java.util.*;

public class Problem_408 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(sc.hasnext())
		{
			int x=sc.nextInt(),mod=sc.nextInt();
			int tmp=x,sizex=0,sizemod=0;
			while(tmp>0)
			{	
				sizex++;
				tmp/=10;
			}
			tmp=mod;
			while(tmp>0)
			{
				sizemod++;
				tmp/=10;
			}
			if(x==0)
				break;
			HashSet<Integer>hs=new HashSet<>();
			for(int i=0;i<mod;i+=x,i%=mod)
			{
				if(hs.contains(i))
					break;
				hs.add(i);
			}
			for(int i=0;i<10-sizex;i++)
				pw.print(" ");
			pw.print(x);
			for(int i=0;i<10-sizemod;i++)
				pw.print(" ");
			pw.print(mod);
			for(int i=0;i<4;i++)				
				pw.print(" ");
			if(hs.size()!=mod)
				pw.print("Bad Choice");
			else
				pw.print("Good Choice");
			pw.println();
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
