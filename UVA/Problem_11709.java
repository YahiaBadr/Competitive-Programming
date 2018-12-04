package UVA;

import java.io.*;
import java.util.*;

public class Problem_11709 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		while(true)
		{
			n=sc.nextInt();int t=sc.nextInt();
			if(n==0 && t==0)
				break;
			HashMap<String, Integer>hm=new HashMap<>();
			adjList=new ArrayList[n];
			adjListR=new ArrayList[n];
			for(int i=0;i<n;i++)
			{
				hm.put(sc.nextLine(), i);
				adjList[i]=new ArrayList<>();
				adjListR[i]=new ArrayList<>();
			}
			while(t-->0)
			{
				String su=sc.nextLine();
				String sv=sc.nextLine();
				int u=hm.get(su),v=hm.get(sv);
				adjList[u].add(v);
				adjListR[v].add(u);
			}
			scc();
			pw.println(scc);
				
		}
		pw.close();
	}
	static ArrayList<Integer>[]adjList,adjListR,graph;
	static Stack<Integer>stack;
	static boolean[]visited;
	static int n,scc;
	static int[]findSCC;
//	static class SSC_Kosaraju
//	{	
		public static void dfs(int u)
		{
			visited[u]=true;
			for(int v:adjList[u])
				if(!visited[v])
					dfs(v);
			stack.push(u);
		}
		public static void dfs_r(int u)
		{
			visited[u]=true;
//			findSCC[u]=scc;
			for(int v:adjListR[u])
				if(!visited[v])
				{
					dfs_r(v);
				}
		}
		public static void scc()
		{
			scc=0;
			visited=new boolean[n];
			stack=new Stack<>();
			for(int u=0;u<n;u++)
				if(!visited[u])
					dfs(u);
			visited=new boolean[n];
			while(!stack.isEmpty())
			{
				int u=stack.pop();
				if(!visited[u])
				{
					dfs_r(u);
					scc++;
				}
			}
		}
//	}
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
