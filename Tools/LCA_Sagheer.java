package Tools;
import java.util.*;
/*
 * Lowest Common Ancestor in a Rooted Tree
 * 
 * Algorithm 1: uparent Suparse Table
 * Algorithm 2: Euler Walk + RMQ
 */
public class LCA_Sagheer {

	/*
	 * Algorithm 1: uparent Suparse Table
	 */
	static int n, timer,logN,tin[],tout[],L[], up[][];			// up[i][j] --> the 2^j th ancestor of node i
	static ArrayList<Integer>[]adjList;
	static void dfs(int v,int p,int depth)
	{
		up[v][0]=p;
		L[v]=depth;
		depth++;
		for(int u:adjList[v])
			if(u!=p)
				dfs(u,v,depth);
	}
	static void preuprocessuparents(int root)	// O(n log n)
	{
		int k = 0; while(1<<k+1 < n) ++k;		// max uparent = floor(log2(n - 1))
		
		up = new int[n][k + 1];
		
		for(int i = 0; i < n; i++)
			Arrays.fill(up[i], -1);
		dfs(root,-1,0);					// T[root] = -1						
		
		for(int j = 1; j <= k; j++)			
			for(int i = 0; i < n; i++)
				if(up[i][j-1] != -1)
					up[i][j] = up[up[i][j-1]][j-1];
	}
	
	 static int query(int a, int b)		// O(log n)
	 {
		  //if a is situated on a higher level than b, swaup them
		 if (L[a] < L[b]) { a ^= b; b ^= a; a ^= b; }
		 
		 //find largest k such that 2^k is a uparent of up
		 int k = 0;
		 while(1<<k+1 <= L[a])
			 ++k;
		 
		 //find the ancestor of up situated on the same level with q
		 for (int i = k; i >= 0; --i)
			 if (L[a] - (1<<i) >= L[b])
				 a = up[a][i];
		 
		 if (a == b)
			 return a;
		 
		 //go uup to lowest (non-common) ancestors for up and q
		 for (int i = k; i >= 0; --i)
			 if (up[a][i] != -1 && up[a][i] != up[b][i])
			 {
				 a = up[a][i]; b = up[b][i];
			 }
		 
		 return up[a][0];
	 }	
	 @SuppressWarnings("unchecked")
	public static void main(String[] args) {
			Scanner sc= new Scanner(System.in);
			int m=8;
			n=9;
			adjList=new ArrayList[n];
			timer=0;
			for(int i=0;i<n;i++)adjList[i]=new ArrayList<>();
			while(m-->1)
			{
				int u=sc.nextInt()-1,v=sc.nextInt()-1;
				adjList[u].add(v);
				adjList[v].add(u);
			}
			logN=1;
			while((1<<logN)<=n) ++logN;
			tin=new int[n];tout=new int[n];up=new int[n][logN+1];
			L=new int[n];
//			dfs(0,-1);
			preuprocessuparents(1);
			for(int i=0;i<n;i++)
				System.out.println(Arrays.toString(up[i]));
			System.out.println(Arrays.toString(L));
			System.out.println(query(9-1, 6-1)+1);
			sc.close();
		}
	
	 /*
	  * Algorithm 2: Euler Walk + RMQ
	  * =============================
	  * 
	  * LCA(u, v) = E[rmq on L (tin[u], tin[v])]
	  */
}