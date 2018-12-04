package Tools;

import java.util.ArrayList;

public class Articalation_Point
{
	static ArrayList<Integer>[]adjList;
	static int[]num,low,parent;
	static boolean[] AP;
	static int count,root,child,ap;
	public static void find_AP()
	{
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
					AP[s]=true;
				if(low[n]>num[s])
					System.out.println("Bride Between "+s+" and "+n);
				low[s]=Math.min(low[n],low[s]);
					
			}
			else
			{
				if(parent[n]!=s)					// it is bidirected graph so that it won't get wrong data.
					low[s]=Math.min(low[s], num[n]);// 1---2---3 so that i does't say that the low of 2 is 1.
			}
			
		}
	}
}
