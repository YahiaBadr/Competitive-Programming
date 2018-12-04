package UVA;
import java.io.*;
import java.util.*;

public class Problem_12086 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		long t=1;
		while(true)
		{
			int n=sc.nextInt();
			if(n==0)
				break;
			if(t!=1)
				pw.println();
			pw.println("Case "+(t++)+":");
			long[]a=new long[n];
			for(int i=0;i<n;i++)a[i]=sc.nextLong();
			FenwickTree ft=new FenwickTree(a);
			while(true)
			{
				StringTokenizer st=new StringTokenizer(sc.nextLine());
				String mission=st.nextToken();
				if(mission.equals("END"))
					break;
				else if(mission.equals("M"))
					pw.println(ft.query(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1));
				else
					ft.update(Integer.parseInt(st.nextToken())-1, Long.parseLong(st.nextToken()));
			}
		}
		pw.close();
	}

	static class FenwickTree
	{
		long[]a;
		long[]ft;
		public FenwickTree(long[]a)
		{
			this.a=a;
			ft=new long[a.length+1];
			build();
		}
		public void build()
		{
			for(int i=0;i<a.length;i++)
				increment(i,a[i]);//since all values are zeros
		}
		public void increment(int i,long v)
		{
			i++;//since ft is index 1 based;
			while(i<ft.length)
			{
				ft[i]+=v;
				i+=(i&(-i));
			}
		}
		public void update(int i,long v)
		{
			long diff=v-a[i];
			a[i]=v;
			increment(i,diff);
		}
		public long query(int l,int r)
		{
			l++;r++;
			return prefix(r)-prefix(l-1);
		}
		public long prefix(int n)
		{
			long x=0;
			while(n>0)
			{
//				System.out.prlongln(n);
				x+=ft[n];
				n^=(n&(-n));
			}
			return x;
		}
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
