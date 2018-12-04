package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class Problem_11504
{	
	static ArrayList<Integer>[]adjList,adjListR,graph;
	static Stack<Integer>stack;
	static boolean[]visited;
	static int n,scc;
	static int[]findSCC;
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
//		System.out.print(u+1+" ");
		findSCC[u]=scc;
		for(int v:adjListR[u])
			if(!visited[v])
			{
				dfs_r(v);
			}
	}
	public static void scc()
	{
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
//				System.out.println();
			}
		}
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=sc.nextInt();
		while(t-->0)
		{
			n=sc.nextInt();int m=sc.nextInt();
			adjList=new ArrayList[n];
			adjListR=new ArrayList[n];
			findSCC=new int[n];
			for(int i=0;i<n;i++)
			{
				adjList[i]=new ArrayList<>();
				adjListR[i]=new ArrayList<>();
			}
			while(m-->0)
			{
				int u=sc.nextInt()-1,v=sc.nextInt()-1;
				adjList[u].add(v);
				adjListR[v].add(u);
			}
			scc=0;
			scc();
			boolean[] root = new boolean[scc];
			Arrays.fill(root, true);
			for(int i=0;i<n;i++)
			{
				for(int j:adjList[i])
				{
					if(findSCC[i]!=findSCC[j])
						root[findSCC[j]]=false;
				}
			}
			int ans=0;
			for(int i=0;i<scc;i++)
				ans+=(root[i]?1:0);
			pw.println(ans);
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
