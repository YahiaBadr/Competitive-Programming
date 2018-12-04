package UVA;

import java.io.*;
import java.util.*;

public class Problem_10199 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t=1;
		while(true)
		{
			n=sc.nextInt();
			if(n==0)
				break;
			if(t!=1)
				pw.println();
			adjList=new ArrayList[n];
			HashMap<String, Integer>hm=new HashMap<>();
			HashMap<Integer, String>hm2=new HashMap<>();
			for(int i=0;i<n;i++)
			{
				String s=sc.nextLine();
				hm.put(s, i);
				hm2.put(i, s);
				adjList[i]=new ArrayList<>();
			}
			int r=sc.nextInt();
			while(r-->0)
			{
				StringTokenizer st=new StringTokenizer(sc.nextLine());
				int u=hm.get(st.nextToken()),v=hm.get(st.nextToken());
				adjList[u].add(v);
				adjList[v].add(u);
			}
			ts=new TreeSet<>();
			find_AP();
			for(int i=0;i<n;i++)
				if(AP[i])
					ts.add(hm2.get(i));
			pw.println("City map #"+t+": "+ts.size()+" camera(s) found");
			Iterator<String>i=ts.iterator();
			while(i.hasNext())
				pw.println(i.next());
			t++;
		}
		pw.close();
	}
	static ArrayList<Integer>[]adjList;
	static int[]num,low,parent;
	static boolean[] AP;
	static int count,root,child,ap,n;
	static TreeSet<String>ts;
	public static void find_AP()
	{
		count=0;
		ap=0;
		num=new int[n];
		AP=new boolean[n];
		low=new int[n];
		parent=new int[n];
		for(int i=0;i<adjList.length;i++)
			if(num[i]==0)
			{
				root=i;
				child=0;
				AP_dfs(i);
				if(child<=1)
					AP[i]=false;
			}
	}
	public static void AP_dfs(int s)//Articalation Point and Bridge
	{
		num[s]=low[s]= ++count;
		for(int n:adjList[s])
		{
			if(num[n]==0)
			{
				parent[n]=s;
				if(s==root)
					child++;
				AP_dfs(n);
				if(low[n]>=num[s])
				{
					AP[s]=true;
				}
//				if(low[n]>num[s])
//					System.out.println("Bride Between "+s+" and "+n);
				low[s]=Math.min(low[n],low[s]);
					
			}
			else
			{
				if(parent[n]!=s)
					low[s]=Math.min(low[s], num[n]);
			}
			
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
