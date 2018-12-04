package UVA;

import java.io.*;
import java.util.*;

public class Problem_599 {
	public static void dfs(int u)
	{
		f[u] = true;
		for (int i=0;i<ar[u].size();i++)
		{
			int v=ar[u].get(i);
			if (!f[v])
				dfs(v);
		}
	}
	static ArrayList<Integer>[]ar;
	static boolean[ ] f;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();
		while(t-->0)
		{
			String s;
			int c=0, tr=0;int check=0;
			ar=new ArrayList[26];
			f=new boolean[26];
			TreeSet<Integer>ts= new TreeSet<>();
			while(true)
			{
				
				s= sc.nextLine();;
				if(s.contains("*"))
				{
					s=sc.nextLine();
					check=s.length()/2 +1;
					for(int i=0;i<s.length();i+=2)
						ts.add(s.charAt(i)-'A');
					break;
				}
				char A=s.charAt(1);
				char B=s.charAt(3);
				int a=(int)A-'A';
				int b=(int)B-'A';
				if(ar[a]==null)
					ar[a]= new ArrayList<Integer>();
				if(ar[b]==null)
					ar[b]=new ArrayList<Integer>();
				ar[b].add(a);
				ar[a].add(b);
			}
			//System.out.println(Arrays.toString(ar));
			for(int i=0;i<check;i++)
			{
				if(!ts.contains(i))
				{
					check++;
					continue;
				}
				if(ar[i]==null)
				{
					c++;
				}
				else if(!f[i])
				{
					tr++;
					dfs(i);
				}
			}
			pw.println("There are "+tr+" tree(s) and "+c+" acorn(s).");
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
