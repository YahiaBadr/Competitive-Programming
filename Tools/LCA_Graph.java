package Tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LCA_Graph {

	//Euler Walk
	static ArrayList<Integer> euler_walk,depth,adjList[];
	static int firtappearedIndex[],level[];
//	Arrays.fill(firtappearedIndex, -1);
	static boolean visited[];
	static int idx;
	public static void dfs_E(int u,int d)
	{
		visited[u]=true;
		euler_walk.add(u);
		depth.add(d);
		level[u]=d;
		if(firtappearedIndex[u]==-1)
			firtappearedIndex[u]=idx;
		idx++;
		for(int v:adjList[u])
			if(!visited[v])
			{
				dfs_E(v,d+1);
				idx++;
				euler_walk.add(u);
				depth.add(d);
			}
	}
	//LCA Query
	public static int LCA(int x,int y)
	{
		int startx=firtappearedIndex[x];
		int starty=firtappearedIndex[y];
		int min=(int)1e9;
		int ans=-1;
		if(startx>starty)
		{
			int tmp=startx;
			startx=starty;
			starty=tmp;
		}
		while(startx<=starty)
		{
			if(depth.get(startx)<min)
			{
				min=depth.get(startx);
				ans=euler_walk.get(startx);
			}
			startx++;
		}
		return ans;
	}
	//LCA Query Using SparseTable after dfs_e
	static int st[][];
	public static void SparseTable()
	{
		int n=depth.size();
		st=new int[n][30];
		for(int i=0;i<n;i++)
			st[i][0]=euler_walk.get(i);
		for(int j=1;(1<<j)<=n;j++)
			for(int i=0;i+(1<<j)<=n;i++)
			{
				if(level[st[i][j-1]]<level[st[i+(1<<j-1)][j-1]])
					st[i][j]=st[i][j-1];
				else
					st[i][j]=st[i+(1<<j-1)][j-1];
			}
	}
	static int[]log2;
	public static int LCA_2(int l,int r)//getting the LCA between l r
	{
		int ll=Math.min(firtappearedIndex[l], firtappearedIndex[r]);
		int rr=Math.max(firtappearedIndex[l] ,firtappearedIndex[r]);
		int length=rr-ll+1;
		int log=log2[length];//which column
		if(level[st[ll][log]]<level[st[rr-(1<<log)+1][log]])
			return st[ll][log];
		else
			return st[rr-(1<<log)+1][log];
	}
	//Binary-Lifting or Binary Ascent preprocessing can be done in O (N log N) .
	//each request will be answered for O (log N).
	static int[] up[],L;
	static int timer,n,logN;
	static void dfs_BL(int v,int p,int depth)
	{
		up[v][0]=p;
		L[v]=depth;
		depth++;
		for(int u:adjList[v])
			if(u!=p)
				dfs_BL(u,v,depth);
	}
	static void BL(int root)	// O(n log n)
	{
		int k = 0; while(1<<k+1 < n) ++k;		// max uparent = floor(log2(n - 1))
		
		up = new int[n][k + 1];
		
		for(int i = 0; i < n; i++)
			Arrays.fill(up[i], -1);
		dfs_BL(root,-1,0);					// T[root] = -1						
		
		for(int j = 1; j <= k; j++)			
			for(int i = 0; i < n; i++)
				if(up[i][j-1] != -1)
					up[i][j] = up[up[i][j-1]][j-1];
	}
	
	 static int LCA_BL(int a, int b)		// O(log n)
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
		up=new int[n][logN+1];L=new int[n];
		BL(2);
//		for(int i=0;i<n;i++)
//			System.out.println(Arrays.toString(up[i]));
		System.out.println(LCA_BL(9-1, 6-1)+1);
	
		log2=new int[1000001];
		int start=0;
		long two=2;
		for(int i=2;i<log2.length;i++)
		{
			if(i==two)
			{
				start++;
				two*=2;
			}
			log2[i]=start;
		}
		sc.close();
	}
}
//[-1, -1, -1, -1]
//[0, -1, -1, -1]
//[1, 0, -1, -1]
//[1, 0, -1, -1]
//[3, 1, -1, -1]
//[4, 3, 0, -1]
//[3, 1, -1, -1]
//[4, 3, 0, -1]
//[-1, -1, -1, -1]

//[0, 0, 0, 0, 0]
//[0, 0, 0, 0, 0]
//[1, 0, 0, 0, 0]
//[1, 0, 0, 0, 0]
//[3, 1, 0, 0, 0]
//[4, 3, 0, 0, 0]
//[3, 1, 0, 0, 0]
//[4, 3, 0, 0, 0]
//[0, 0, 0, 0, 0]

//1 2
//2 3
//2 4
//4 5
//4 7
//5 6
//5 8
//4 9